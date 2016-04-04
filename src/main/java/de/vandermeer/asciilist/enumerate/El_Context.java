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

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.asciilist.AL_Context;
import de.vandermeer.asciilist.AL_CtxtCharacters;
import de.vandermeer.asciilist.AL_CtxtIndents;
import de.vandermeer.asciilist.AL_CtxtMargins;
import de.vandermeer.asciilist.old.styles.ListStyle_EnumerateNested;
import de.vandermeer.asciilist.old.styles.NestedEnumerateStyles;

/**
 * Context for an enumerate list.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public class El_Context extends AL_Context<AL_CtxtCharacters, AL_CtxtIndents, AL_CtxtMargins, El_CtxtStrings>{

	/** The style for list items. */
	protected ListStyle_EnumerateNested style = NestedEnumerateStyles.all_utf_arabic_subscript;

	/** Flag controls the behavior for using numbering string after last number, default is true. */
	protected boolean useSeparatorAfterLastNumber = true;

	/** Flag for inhering style from another itemize list if this list is a child, default is true. */
	protected boolean inheritStyle = true;

	/**
	 * Creates a new context object for an enumerate lists.
	 */
	public El_Context(){
		this.init();
	}

	@Override
	public void init(){
		super.init();
		this.characters = new AL_CtxtCharacters();
		this.indents = new AL_CtxtIndents();
		this.margins = new AL_CtxtMargins();
		this.strings = new El_CtxtStrings();
	}

	/**
	 * Returns the list style.
	 * @return list style
	 */
	public ListStyle_EnumerateNested getStyle() {
		return this.style;
	}

	/**
	 * Sets the inherit-style flag.
	 * @param flag true if this list should inherit style (if it is a child list), false otherwise
	 * @return this to allow chaining
	 */
	public El_Context setInheritStyle(boolean flag){
		this.inheritStyle = flag;
		return this;
	}

	/**
	 * Sets the list style.
	 * @param style new style
	 * @return this to allow chaining
	 * @throws NullPointerException if style was null
	 */
	public El_Context setStyle(ListStyle_EnumerateNested style) {
		Validate.notNull(style);
		this.style = style;
		return this;
	}

	/**
	 * Returns the label separator string.
	 * @return label separator string
	 */
	public String getNumberingSeparator() {
		return this.strings.numberingSeparator;
	}

	/**
	 * Sets the numbering separator string.
	 * @param numberingSeparator numbering separator string
	 * @return this to allow chaining
	 */
	public El_Context setNumberingSeparator(String numberingSeparator) {
		this.strings.setNumberingSeparator(numberingSeparator);
		return this;
	}

	/**
	 * Sets the flag controls the behavior for using numbering string after last number.
	 * @param flag true to use string, false if not
	 * @return this to allow chaining
	 */
	public El_Context setSeparatorAfterLastNumber(boolean flag){
		this.useSeparatorAfterLastNumber = flag;
		return this;
	}

	/**
	 * Returns the flag controls the behavior for using numbering string after last number.
	 * @return flag true to use string, false if not
	 */
	public boolean getSeparatorAfterLastNumber(){
		return this.useSeparatorAfterLastNumber;
	}

	@Override
	public El_Context copySettings(AL_Context<?, ?, ?, ?> ctx) {
		super.copySettings(ctx);
		if(ctx instanceof El_Context){
			this.style = ((El_Context)ctx).style;
			this.inheritStyle = ((El_Context)ctx).inheritStyle;
			this.useSeparatorAfterLastNumber = ((El_Context)ctx).useSeparatorAfterLastNumber;
			this.strings.copySettings(((El_Context)ctx).strings);
		}
		return this;
	}

	@Override
	public AL_Context<?, ?, ?, ?> inheritSettings(AL_Context<?, ?, ?, ?> ctx) {
		if(ctx instanceof El_Context){
			if(this.inheritStyle){
				this.style = ((El_Context)ctx).style;
			}
		}
		return this;
	}

	@Override
	public StrBuilder getItemString() {
		StrBuilder ret = new StrBuilder(20);
		ret
			.appendPadding(this.getItemMargin(), this.getItemChar())
			.append(this.getLeftLabelString())
			.appendPadding(this.getLabelLeftMargin(), this.getLabelLeftChar())
			.append(this.getStyle().getStyle(this.getLevel()).getLabel(this.getLevel()))
			.appendPadding(this.getLabelRightMargin(), this.getLabelRightChar())
			.append(this.getRightLabelString())
			.appendPadding(this.getTextLeftMargin(), this.getTextLeftChar())
		;
		return ret;
	}
}
