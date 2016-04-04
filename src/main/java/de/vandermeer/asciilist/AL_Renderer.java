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
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.skb.interfaces.document.IsListRenderer;
import de.vandermeer.skb.interfaces.strategies.IsCollectionStrategy;
import de.vandermeer.skb.interfaces.strategies.collections.list.ArrayListStrategy;
import de.vandermeer.skb.interfaces.transformers.Object_To_ColumnContentArray;
import de.vandermeer.skb.interfaces.transformers.stringformats.StringAr_To_Centered;
import de.vandermeer.skb.interfaces.transformers.stringformats.StringAr_To_Justified;
import de.vandermeer.skb.interfaces.transformers.stringformats.StringAr_To_LeftPadded;
import de.vandermeer.skb.interfaces.transformers.stringformats.StringAr_To_RightPadded;

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
	 * @param list the list to render
	 * @return collection of lines, each as a {@link StrBuilder}
	 */
	default Collection<StrBuilder> render(List<I> list, C ctx){
		Validate.notNull(list);
		Validate.notNull(ctx);
		return this.render(list, ctx, ctx.getWidth());
	}

	/**
	 * Renders an {@link AsciiList}.
	 * Each line will have text according to width.
	 * Any padding (left or right) and start/end strings will add to the line width.
	 * To use a calculated width for rendering use one of the other render methods.
	 * @param list the list to render
	 * @param width maximum line width, excluding any extra strings and paddings
	 * @return collection of lines, each as a {@link StrBuilder}
	 */
	default Collection<StrBuilder> render(List<I> items, C ctx, int width){
		Validate.notNull(items);
		Validate.notNull(ctx);

		Collection<StrBuilder> ret = new ArrayList<>();
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

			StrBuilder itemString = ctx.getItemString();
			String[] textAr = Object_To_ColumnContentArray.convert(text, width);

			Collection<StrBuilder> itList = null;
			IsCollectionStrategy<?, StrBuilder> collStrat = ArrayListStrategy.create();
			switch(ctx.getAlignment()){
				case CENTER:
					itList = StringAr_To_Centered.convert(textAr, width, collStrat);
					break;
				case LEFT:
					itList = StringAr_To_LeftPadded.convert(textAr, width, collStrat);
					break;
				case RIGHT:
					itList = StringAr_To_RightPadded.convert(textAr, width, collStrat);
					break;
				case JUSTIFIED:
					itList = StringAr_To_Justified.convert(textAr, width, collStrat);
					break;
				case JUSTIFIED_RIGHT:
					itList = StringAr_To_Justified.convertLastRight(textAr, width, collStrat);
					break;
				case JUSTIFIED_LEFT:
					itList = StringAr_To_Justified.convertLastLeft(textAr, width, '-', collStrat);
					break;
			}

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
				for(StrBuilder sb : item.getList().renderAsChild(ctx, itemString.toString().length())){
					ret.add(sb);
				}
			}
		}


//		int calcW = 0;
//		for(StrBuilder sb : ret){
//			//add text margins left and right
//			sb.insert(0, new StrBuilder().appendPadding(ctx.getTextLeftMargin(), ctx.getTextLeftChar()));
//			sb.appendPadding(ctx.getTextRightMargin(), ctx.getTextRightChar());
//
//			// we changed drop cap blanks, so remove the temporary ws here as well
//			if(ctx.getFormat()!=AP_Format.NONE){
//				sb.replaceAll(TMP_PADING, ctx.getPaddingLeftChar());
//			}
//
//			//now add a line start if set and margins
//			if(ctx.getStartString()!=null){
//				sb.insert(0, ctx.getStartString());
//			}
//			sb.insert(0, new StrBuilder().appendPadding(ctx.getStringLeftMargin(), ctx.getStringLeftChar()));
//
//			//now add a line end if set and margins
//			if(ctx.getEndString()!=null){
//				sb.append(ctx.getEndString());
//			}
//			sb.appendPadding(ctx.getStringRightMargin(), ctx.getStringRightChar());
//			calcW = sb.length();
//		}
//
//		//add text margins margin
//		for(int i=0; i<ctx.getTextTopMargin(); i++){
//			((ArrayList<StrBuilder>)ret).add(0, new StrBuilder().appendPadding(calcW, ' '));
//		}
//		for(int i=0; i<ctx.getTextBottomMargin(); i++){
//			ret.add(new StrBuilder().appendPadding(calcW, ' '));
//		}
//
//		//add frame
//		if(ctx.getFrame()!=null){
//			ret = ctx.getFrame().addFrame(ret, ctx.getFrameMode());
//		}
//
//		//add frame margins
//		for(int i=0; i<ctx.getFrameTopMargin(); i++){
//			((ArrayList<StrBuilder>)ret).add(0, new StrBuilder().append(""));
//		}
//		for(int i=0; i<ctx.getFrameBottomMargin(); i++){
//			ret.add(new StrBuilder().append(""));
//		}
//
//		//finally, add horizontal frame margins
//		for(StrBuilder sb : ret){
//			sb.insert(0, new StrBuilder().appendPadding(ctx.getFrameLeftMargin(), ctx.getFrameLeftChar()));
//			sb.appendPadding(ctx.getFrameRightMargin(), ctx.getFrameRightChar());
//		}
//
		return ret;
	}

//	/**
//	 * Creates a new renderer.
//	 * @return new renderer
//	 */
//	static AL_Renderer create(){
//		return new AL_Renderer() {};
//	}
}
