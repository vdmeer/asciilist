/* Copyright 2016 Sven van der Meer <vdmeer.sven@mykolab.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.vandermeer.asciilist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.skb.interfaces.document.IsListRenderer;
import de.vandermeer.skb.interfaces.transformers.textformat.Text_To_FormattedText;

/**
 * List renderer interface.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public interface AL_Renderer<I extends ListItem, C extends AL_Context<?, ?, ?, ?>> extends IsListRenderer {

	/**
	 * Renders an {@link AsciiList}.
	 * Each line will have text according to width.
	 * Any padding (left or right) and start/end strings will add to the line width.
	 * To use a calculated width for rendering use one of the other render methods.
	 * @param items the set of items to render
	 * @param ctx context of the original list with relevant settings
	 * @return collection of lines, each as a {@link StrBuilder}
	 */
	default Collection<StrBuilder> render(Set<I> items, C ctx){
		Validate.notNull(items);
		Validate.notNull(ctx);
		return this.render(items, ctx, ctx.getWidth());
	}

	/**
	 * Renders an {@link AsciiList}.
	 * Each line will have text according to width.
	 * Any padding (left or right) and start/end strings will add to the line width.
	 * To use a calculated width for rendering use one of the other render methods.
	 * @param items the set of items to render
	 * @param ctx context of the original list with relevant settings
	 * @param width maximum line width, excluding any extra strings and paddings
	 * @return collection of lines, each as a {@link StrBuilder}
	 */
	default Collection<StrBuilder> render(Set<I> items, C ctx, int width){
		Validate.notNull(items);
		Validate.notNull(ctx);

		Collection<StrBuilder> ret = new ArrayList<>();
		if(ctx.getListStart()!=null){
			Validate.validState(ctx.getListStart().length()<=width, "list start string longer than list width");
			ret.add(new StrBuilder().append(ctx.getListStart()).appendPadding(width-ctx.getListStart().length(), ctx.getTextRightChar()));
		}

		int index = 1;
		for(I item : items){
			String text = item.getText().toString().replaceAll("\\s+", " ");
			//check for translators, use what is available
			if(ctx.getTargetTranslator()!=null){
				if(ctx.getTargetTranslator().getCombinedTranslator()!=null){
					text = ctx.getTargetTranslator().getCombinedTranslator().translate(text);
				}
			}
			else if(ctx.getHtmlElementTranslator()!=null){
				text = ctx.getHtmlElementTranslator().translateHtmlElements(text);
			}
			else if(ctx.getCharTranslator()!=null){
				text = ctx.getCharTranslator().translateCharacters(text);
			}

			StrBuilder itemString = ctx.getItemString(item, index);
			Collection<StrBuilder> itList = Text_To_FormattedText.create(
					width, ctx.getAlignment().getMappingToTransformer(), Text_To_FormattedText.FORMAT_NONE,
					null, null, null,
					0, 0, null, 0, 0, null)
			.transform(text);

			int count = 0;
			for(StrBuilder sb : itList){
				if(count==0){
					sb.insert(0, itemString);
				}
				else if(count>0){
					sb.insert(0, new StrBuilder().appendPadding(itemString.toString().length(), ' '));
				}
				sb.appendPadding(ctx.getTextRightMargin(), ctx.getTextRightChar());
				ret.add(sb);
				count++;
			}

			if(item.hasList()){
				for(StrBuilder sb : item.getList().renderAsChild(ctx, itemString.toString().length(), index)){
					ret.add(sb);
				}
			}
			index++;
		}

		if(ctx.getListEnd()!=null){
			Validate.validState(ctx.getListEnd().length()<=width, "list end string longer than list width");
			ret.add(new StrBuilder().append(ctx.getListEnd()).appendPadding(width-ctx.getListEnd().length(), ctx.getTextRightChar()));
		}

		return ret;
	}
}
