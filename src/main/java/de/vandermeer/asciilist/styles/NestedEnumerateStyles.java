/* Copyright 2015 Sven van der Meer <vdmeer.sven@mykolab.com>
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

package de.vandermeer.asciilist.styles;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.text.StrBuilder;

/**
 * Standard styles for enumerate (ordered) lists implementing {@link ListStyle_EnumerateNested} for 6 levels.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160304 (04-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public enum NestedEnumerateStyles implements ListStyle_EnumerateNested {

	aLL_Alpha_ascii (EnumerateStyles.Alpha_ascii),

	aLL_alpha_ascii (EnumerateStyles.alpha_ascii),

	aLL_arabic_ascii (EnumerateStyles.arabic_ascii),

	aLL_Roman_ascii (EnumerateStyles.Roman_ascii),

	aLL_roman_ascii (EnumerateStyles.roman_ascii),

	all_utf_arabic_subscript (EnumerateStyles.arabic_utf_subscript),

	arabic_Alpha_alpha_Roman_roman (
			EnumerateStyles.arabic_ascii,
			EnumerateStyles.Alpha_ascii,
			EnumerateStyles.alpha_ascii,
			EnumerateStyles.Roman_ascii,
			EnumerateStyles.roman_ascii,
			null
	),

	arabic_utf_circled (
			EnumerateStyles.arabic_utf_double_circle,
			EnumerateStyles.arabic_utf_circle,
			EnumerateStyles.arabic_utf_circle_dingbat_sanserif,
			EnumerateStyles.arabic_utf_circle_dingbat_negative_sanserif,
			EnumerateStyles.arabic_utf_circle_dingbat_negative_sanserif,
			null
	),

	;

	/** Style for all levels. */
	ListStyle_Enumerate all;

	/** Level 1 style. */
	ListStyle_Enumerate l1;

	/** Level 2 style. */
	ListStyle_Enumerate l2;

	/** Level 3 style. */
	ListStyle_Enumerate l3;

	/** Level 4 style. */
	ListStyle_Enumerate l4;

	/** Level 5 style. */
	ListStyle_Enumerate l5;

	/** Level 6 style. */
	ListStyle_Enumerate l6;

	/**
	 * Returns a new itemize style using same string for all levels.
	 * @param all level style
	 */
	NestedEnumerateStyles(ListStyle_Enumerate all){
		this.all = all;
	}

	/**
	 * Returns a new enumerate style for 6 levels.
	 * @param l1 style
	 * @param l2 style
	 * @param l3 style
	 * @param l4 style
	 * @param l5 style
	 * @param l6 style
	 */
	NestedEnumerateStyles(ListStyle_Enumerate l1, ListStyle_Enumerate l2, ListStyle_Enumerate l3, ListStyle_Enumerate l4, ListStyle_Enumerate l5, ListStyle_Enumerate l6){
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.l4 = l4;
		this.l5 = l5;
		this.l6 = l6;
	}

	@Override
	public ListStyle_Enumerate getStyle(int level) {
		if(this.all!=null){
			return this.all;
		}
		else{
			switch(level){
				case 1:
					if(this.l1==null){
						throw new NotImplementedException("this style for nested enumerate lists does not support depth (level) of 1");
					}
					return this.l1;
				case 2:
					if(this.l2==null){
						throw new NotImplementedException("this style for nested enumerate lists does not support depth (level) of 1");
					}
					return this.l2;
				case 3:
					if(this.l3==null){
						throw new NotImplementedException("this style for nested enumerate lists does not support depth (level) of 1");
					}
					return this.l3;
				case 4:
					if(this.l4==null){
						throw new NotImplementedException("this style for nested enumerate lists does not support depth (level) of 1");
					}
					return this.l4;
				case 5:
					if(this.l5==null){
						throw new NotImplementedException("this style for nested enumerate lists does not support depth (level) of 1");
					}
					return this.l5;
				case 6:
					if(this.l6==null){
						throw new NotImplementedException("this style for nested enumerate lists does not support depth (level) of 1");
					}
					return l6;
			}
		}
		throw new NotImplementedException("nested enumerate style for lists deeper than 6 not supported");
	}

	@Override
	public StrBuilder toDoc() {
		StrBuilder ret = new StrBuilder(30);
		ret.append(this.getStyle(1).getLabel(1)).append(". item 1").appendNewLine();
		ret.append(this.getStyle(1).getLabel(2)).append(". item 2").appendNewLine();

		if(this.all!=null || this.l2!=null){
			ret.append("   ").append(this.getStyle(2).getLabel(1)).append(". item 1").appendNewLine();
			ret.append("   ").append(this.getStyle(2).getLabel(2)).append(". item 2").appendNewLine();
		}

		if(this.all!=null || this.l3!=null){
			ret.append("   ").append("   ").append(this.getStyle(3).getLabel(1)).append(". item 1").appendNewLine();
			ret.append("   ").append("   ").append(this.getStyle(3).getLabel(2)).append(". item 2").appendNewLine();
		}

		if(this.all!=null || this.l4!=null){
			ret.append("   ").append("   ").append("   ").append(this.getStyle(4).getLabel(1)).append(". item 1").appendNewLine();
			ret.append("   ").append("   ").append("   ").append(this.getStyle(4).getLabel(2)).append(". item 2").appendNewLine();
		}

		if(this.all!=null || this.l5!=null){
			ret.append("   ").append("   ").append("   ").append("   ").append(this.getStyle(5).getLabel(1)).append(". item 1").appendNewLine();
			ret.append("   ").append("   ").append("   ").append("   ").append(this.getStyle(5).getLabel(2)).append(". item 2").appendNewLine();
		}

		if(this.all!=null || this.l6!=null){
			ret.append("   ").append("   ").append("   ").append("   ").append("   ").append(this.getStyle(6).getLabel(1)).append(". item 1").appendNewLine();
			ret.append("   ").append("   ").append("   ").append("   ").append("   ").append(this.getStyle(6).getLabel(2)).append(". item 2").appendNewLine();
		}
		return ret;
	}

}
