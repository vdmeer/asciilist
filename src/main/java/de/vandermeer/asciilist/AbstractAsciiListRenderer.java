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

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.skb.interfaces.transformers.textformat.Text_To_FormattedText;

/**
 * Fully functional abstract implementation of {@link AsciiListRenderer}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public class AbstractAsciiListRenderer<I extends AsciiListItem, C extends AsciiListContext> implements AsciiListRenderer<I, C> {

	@Override
	public Collection<StrBuilder> render(Set<I> items, C ctx, int width){
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
					width, ctx.getAlignment().getMapping(), Text_To_FormattedText.FORMAT_NONE,
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
				if(item.getList() instanceof AsciiList){
					AsciiList<?, ?, ?> al = (AsciiList<?, ?, ?>) item.getList();
					for(StrBuilder sb : al.renderAsChild(ctx, itemString.toString().length(), index)){
						ret.add(sb);
					}
				}
				else{
					throw new NotImplementedException("can only render classic AsciiLists");
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
