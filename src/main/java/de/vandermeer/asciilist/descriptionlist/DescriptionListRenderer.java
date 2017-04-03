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

package de.vandermeer.asciilist.descriptionlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.asciilist.AbstractAsciiListRenderer;
import de.vandermeer.skb.interfaces.transformers.textformat.Text_To_FormattedText;

/**
 * An description list renderer.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 170331 (31-Mar-17) for Java 1.8
 * @since      v0.1.0
 */
public class DescriptionListRenderer extends AbstractAsciiListRenderer<DescriptionListItem, DescriptionListContext> {

	/**
	 * Creates a new renderer.
	 * @return new renderer
	 */
	static DescriptionListRenderer create(){
		return new DescriptionListRenderer() {};
	}

	@Override
	public Collection<StrBuilder> render(Set<DescriptionListItem> items, DescriptionListContext ctx, int width){
		Validate.notNull(items);
		Validate.notNull(ctx);

		Collection<StrBuilder> ret = new ArrayList<>();
		if(ctx.getListStart()!=null){
			Validate.validState(ctx.getListStart().length()<=width, "list start string longer than list width");
			ret.add(new StrBuilder().append(ctx.getListStart()).appendPadding(width-ctx.getListStart().length(), ctx.getTextRightChar()));
		}

		int index = 1;
		for(DescriptionListItem item : items){
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
			Collection<StrBuilder> itList = null;
			if(ctx.getUseSameLine()==true){
				//render for key/text on same line
				itList = Text_To_FormattedText.create(
						width, ctx.getAlignment().getMapping(), Text_To_FormattedText.FORMAT_FIRSTLINE_AND_HANGINGPARAGRAPH,
						null, null, null,
						0, itemString.length(), null, 0, 0, null)
				.transform(text);
			}
			else{
				//render for key on first line, text on following lines
				itList = Text_To_FormattedText.create(
						width-ctx.getDescriptionIndent(), ctx.getAlignment().getMapping(), Text_To_FormattedText.FORMAT_NONE,
						null, null, null,
						0, 0, null, 0, 0, null)
				.transform(text);
			}

			if(ctx.getUseSameLine()==false){
				ret.add(new StrBuilder().append(itemString).appendPadding(width-itemString.size(), ctx.getTextRightChar()));
			}

			int count = 0;
			for(StrBuilder sb : itList){
				if(count==0 && ctx.getUseSameLine()){
					sb.replace(0, itemString.length(), itemString.toString());
				}
				else if(ctx.getUseSameLine()==false){
					sb.insert(0, new StrBuilder().appendPadding(ctx.getDescriptionIndent(), ' '));
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
