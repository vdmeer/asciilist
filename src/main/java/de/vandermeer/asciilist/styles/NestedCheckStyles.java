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
 * Standard styles for check lists implementing {@link ListStyle_CheckNested} for 6 levels.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v1.0.0 build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public enum NestedCheckStyles implements ListStyle_CheckNested {

	/**
	 * Style that uses {@link CheckListStyles#ASCII_SQUARE_BRACKET_BLANK_X} for unlimited levels.
	 * For example:
	 * <pre>
	[ ] unchecked item
	[X] checked item
	   [ ] unchecked item
	   [X] checked item
	      [ ] unchecked item
	      [X] checked item
	         [ ] unchecked item
	         [X] checked item
	            [ ] unchecked item
	            [X] checked item
	               [ ] unchecked item
	               [X] checked item
	 * </pre>
	 */
	ALL_SQUARE_BRACKET_BLANK_X (CheckListStyles.ASCII_SQUARE_BRACKET_BLANK_X),

	/**
	 * Style that uses {@link CheckListStyles#UTF_BALLOT_BOX} for unlimited levels.
	 * For example:
	 * <pre>
	☐ unchecked item
	☑ checked item
	   ☐ unchecked item
	   ☑ checked item
	      ☐ unchecked item
	      ☑ checked item
	         ☐ unchecked item
	         ☑ checked item
	            ☐ unchecked item
	            ☑ checked item
	               ☐ unchecked item
	               ☑ checked item
	 * </pre>
	 */
	ALL_UTF_BALLOT_BOX (CheckListStyles.UTF_BALLOT_BOX),

	/**
	 * Style that uses {@link CheckListStyles#UTF_BALLOT_BOX_X} for unlimited levels.
	 * For example:
	 * <pre>
	☐ unchecked item
	☒ checked item
	   ☐ unchecked item
	   ☒ checked item
	      ☐ unchecked item
	      ☒ checked item
	         ☐ unchecked item
	         ☒ checked item
	            ☐ unchecked item
	            ☒ checked item
	               ☐ unchecked item
	               ☒ checked item
	 * </pre>
	 */
	ALL_UTF_BALLOT_BOX_X (CheckListStyles.UTF_BALLOT_BOX_X),

	;

	/** Style for all levels. */
	ListStyle_Check all;

	/** Level 1 style. */
	ListStyle_Check l1;

	/** Level 2 style. */
	ListStyle_Check l2;

	/** Level 3 style. */
	ListStyle_Check l3;

	/** Level 4 style. */
	ListStyle_Check l4;

	/** Level 5 style. */
	ListStyle_Check l5;

	/** Level 6 style. */
	ListStyle_Check l6;

	/**
	 * Returns a new itemize style using same string for all levels.
	 * @param all level style
	 */
	NestedCheckStyles(ListStyle_Check all){
		this.all = all;
	}

	/**
	 * Returns a new check style for 6 levels.
	 * @param l1 style
	 * @param l2 style
	 * @param l3 style
	 * @param l4 style
	 * @param l5 style
	 * @param l6 style
	 */
	NestedCheckStyles(ListStyle_Check l1, ListStyle_Check l2, ListStyle_Check l3, ListStyle_Check l4, ListStyle_Check l5, ListStyle_Check l6){
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.l4 = l4;
		this.l5 = l5;
		this.l6 = l6;
	}

	@Override
	public StrBuilder toDoc() {
		StrBuilder ret = new StrBuilder(30);
		ret.append(this.getStyle(1).getLabelUnchecked()).append(" unchecked item").appendNewLine();
		ret.append(this.getStyle(1).getLabelChecked()).append(" checked item").appendNewLine();

		if(this.all!=null || this.l2!=null){
			ret.append("   ").append(this.getStyle(2).getLabelUnchecked()).append(" unchecked item").appendNewLine();
			ret.append("   ").append(this.getStyle(2).getLabelChecked()).append(" checked item").appendNewLine();
		}

		if(this.all!=null || this.l3!=null){
			ret.append("   ").append("   ").append(this.getStyle(3).getLabelUnchecked()).append(" unchecked item").appendNewLine();
			ret.append("   ").append("   ").append(this.getStyle(3).getLabelChecked()).append(" checked item").appendNewLine();
		}

		if(this.all!=null || this.l4!=null){
			ret.append("   ").append("   ").append("   ").append(this.getStyle(4).getLabelUnchecked()).append(" unchecked item").appendNewLine();
			ret.append("   ").append("   ").append("   ").append(this.getStyle(4).getLabelChecked()).append(" checked item").appendNewLine();
		}

		if(this.all!=null || this.l5!=null){
			ret.append("   ").append("   ").append("   ").append("   ").append(this.getStyle(5).getLabelUnchecked()).append(" unchecked item").appendNewLine();
			ret.append("   ").append("   ").append("   ").append("   ").append(this.getStyle(5).getLabelChecked()).append(" checked item").appendNewLine();
		}

		if(this.all!=null || this.l6!=null){
			ret.append("   ").append("   ").append("   ").append("   ").append("   ").append(this.getStyle(6).getLabelUnchecked()).append(" unchecked item").appendNewLine();
			ret.append("   ").append("   ").append("   ").append("   ").append("   ").append(this.getStyle(6).getLabelChecked()).append(" checked item").appendNewLine();
		}
		return ret;
	}

	@Override
	public ListStyle_Check getStyle(int level) {
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

}
