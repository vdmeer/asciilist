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

package de.vandermeer.asciilist.enumerate;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.asciilist.AbstractAsciiListContext;
import de.vandermeer.asciilist.AsciiListContext;
import de.vandermeer.asciilist.AsciiListItem;
import de.vandermeer.asciithemes.TA_EnumerateList;
import de.vandermeer.asciithemes.a7.A7_EnumerateLists;

/**
 * Context for an enumerate list.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.1.0
 */
public class EnumerateListContext extends AbstractAsciiListContext {

	/** A string to separate numbers, default is dot "'.'". */
	protected String numberingSeparator = ".";

	/** The style for list items. */
	protected TA_EnumerateList style = A7_EnumerateLists.number();

	/** Flag controls the behavior for using numbering string after last number, default is true. */
	protected boolean useSeparatorAfterLastNumber = true;

	/** Flag for inhering style from another itemize list if this list is a child, default is true. */
	protected boolean inheritStyle = true;

	/**
	 * Creates a new context object for an enumerate lists.
	 */
	public EnumerateListContext(){
		this.init();
	}

	@Override
	public EnumerateListContext copySettings(AsciiListContext ctx) {
		super.copySettings(ctx);
		if(ctx instanceof EnumerateListContext){
			this.style = ((EnumerateListContext)ctx).style;
			this.inheritStyle = ((EnumerateListContext)ctx).inheritStyle;
			this.useSeparatorAfterLastNumber = ((EnumerateListContext)ctx).useSeparatorAfterLastNumber;
			this.numberingSeparator = ((EnumerateListContext)ctx).numberingSeparator;
		}
		return this;
	}

	@Override
	public <LI extends AsciiListItem> StrBuilder getItemString(LI item, int index) {
		StrBuilder ret = new StrBuilder(20);
		ret
			.appendPadding(this.getItemMargin(), this.getItemChar())
			.append(this.getLeftLabelString())
			.appendPadding(this.getLabelLeftMargin(), this.getLabelLeftChar())
		;

		if(this.parentIndex!=null && index>0){
			int[] levels = ArrayUtils.add(this.parentIndex, index);
			ret.append(this.getStyle().getLabel(levels, this.numberingSeparator, this.useSeparatorAfterLastNumber));
		}
		else if(index>0){
			ret.append(this.getStyle().getLabel(index));
			if(this.useSeparatorAfterLastNumber){
				ret.append(this.numberingSeparator);
			}
		}
		else{
			ret.append(this.getStyle().getLabel(this.getLevel()));
		}

		ret.appendPadding(this.getLabelRightMargin(), this.getLabelRightChar())
			.append(this.getRightLabelString())
			.appendPadding(this.getTextLeftMargin(), this.getTextLeftChar())
		;
		return ret;
	}

	/**
	 * Returns the label separator string.
	 * @return label separator string
	 */
	public String getNumberingSeparator() {
		return this.numberingSeparator;
	}

	/**
	 * Returns the flag controls the behavior for using numbering string after last number.
	 * @return flag true to use string, false if not
	 */
	public boolean getSeparatorAfterLastNumber(){
		return this.useSeparatorAfterLastNumber;
	}

	/**
	 * Returns the list style.
	 * @return list style
	 */
	public TA_EnumerateList getStyle() {
		return this.style;
	}

	@Override
	public EnumerateListContext inheritSettings(AsciiListContext ctx) {
		if(ctx instanceof EnumerateListContext){
			if(this.inheritStyle){
				this.style = ((EnumerateListContext)ctx).style;
			}
		}
		return this;
	}

	@Override
	public void init(){
		super.init();
		this.numberingSeparator = ".";
	}

	/**
	 * Sets the inherit-style flag.
	 * @param flag true if this list should inherit style (if it is a child list), false otherwise
	 * @return this to allow chaining
	 */
	public EnumerateListContext setInheritStyle(boolean flag){
		this.inheritStyle = flag;
		return this;
	}

	/**
	 * Sets the numbering separator string.
	 * @param numberingSeparator numbering separator string
	 * @return this to allow chaining
	 */
	public EnumerateListContext setNumberingSeparator(String numberingSeparator) {
		this.numberingSeparator = numberingSeparator;
		return this;
	}

	/**
	 * Sets the flag controls the behavior for using numbering string after last number.
	 * @param flag true to use string, false if not
	 * @return this to allow chaining
	 */
	public EnumerateListContext setSeparatorAfterLastNumber(boolean flag){
		this.useSeparatorAfterLastNumber = flag;
		return this;
	}

	/**
	 * Sets the list style.
	 * @param style new style
	 * @return this to allow chaining
	 * @throws NullPointerException if style was null
	 */
	public EnumerateListContext setStyle(TA_EnumerateList style) {
		Validate.notNull(style);
		this.style = style;
		return this;
	}
}
