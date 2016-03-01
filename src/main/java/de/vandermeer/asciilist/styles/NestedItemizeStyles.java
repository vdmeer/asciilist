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
 * Standard styles for itemize (unordered) lists implementing {@link ListStyle_ItemizeNested} for 6 levels.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3 build 160301 (01-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public enum NestedItemizeStyles implements ListStyle_ItemizeNested {

	/**
	 * Style using the "*" character for unlimited levels.
	 * For example:
	 * <pre>
	&#42; item 1
	&#42; item 2
	   &#42; item 1
	   &#42; item 2
	      &#42; item 1
	      &#42; item 2
	         &#42; item 1
	         &#42; item 2
	            &#42; item 1
	            &#42; item 2
	               &#42; item 1
	               &#42; item 2
	 * </pre>
	 */
	ALL_STAR ("*"),


	/**
	 * Style using the "*" character, incremental for 6 levels.
	 * For example:
	 * <pre>
	&#42; item 1
	&#42; item 2
	   &#42;&#42; item 1
	   &#42;&#42; item 2
	      &#42;&#42;&#42; item 1
	      &#42;&#42;&#42; item 2
	         &#42;&#42;&#42;&#42; item 1
	         &#42;&#42;&#42;&#42; item 2
	            &#42;&#42;&#42;&#42;&#42; item 1
	            &#42;&#42;&#42;&#42;&#42; item 2
	               &#42;&#42;&#42;&#42;&#42;&#42; item 1
	               &#42;&#42;&#42;&#42;&#42;&#42; item 2
	 * </pre>
	 */
	ALL_STAR_INCREMENTAL ("*", "**", "***", "****", "*****", "******"),

	/**
	 * Style using the "-" character for unlimited levels.
	 * For example:
	 * <pre>
	- item 1
	- item 2
	   - item 1
	   - item 2
	      - item 1
	      - item 2
	         - item 1
	         - item 2
	            - item 1
	            - item 2
	               - item 1
	               - item 2
	 * </pre>
	 */
	ALL_HYPHEN ("-"),


	/**
	 * Style using the "-" character, incremental for 6 levels.
	 * For example:
	 * <pre>
	- item 1
	- item 2
	   -- item 1
	   -- item 2
	      --- item 1
	      --- item 2
	         ---- item 1
	         ---- item 2
	            ----- item 1
	            ----- item 2
	               ------ item 1
	               ------ item 2
	 * </pre>
	 */
	ALL_HYPHEN_INCREMENTAL ("-", "--", "---", "----", "-----", "------"),

	/**
	 * Style using the "+" character for unlimited levels.
	 * For example:
	 * <pre>
	+ item 1
	+ item 2
	   + item 1
	   + item 2
	      + item 1
	      + item 2
	         + item 1
	         + item 2
	            + item 1
	            + item 2
	               + item 1
	               + item 2
	 * </pre>
	 */
	ALL_PLUS ("+"),


	/**
	 * Style using the "+" character, incremental for 6 levels.
	 * For example:
	 * <pre>
	+ item 1
	+ item 2
	   ++ item 1
	   ++ item 2
	      +++ item 1
	      +++ item 2
	         ++++ item 1
	         ++++ item 2
	            +++++ item 1
	            +++++ item 2
	               ++++++ item 1
	               ++++++ item 2
	 * </pre>
	 */
	ALL_PLUS_INCREMENTAL ("+", "++", "+++", "++++", "+++++", "++++++"),

	/** An standard HTML like style using UTF-8 characters. */

	/**
	 * Style using standard HTML characters for 3 levels (bullet, circle, square).
	 * For example:
	 * <pre>
	• item 1
	• item 2
	   ○ item 1
	   ○ item 2
	      ▪ item 1
	      ▪ item 2
	 * </pre>
	 */
	HTML_LIKE ("•", "○", "▪", null, null, null),

	/**
	 * Style using several UTF-8 arrow characters.
	 * For example:
	 * <pre>
	➔ item 1
	➔ item 2
	   ➜ item 1
	   ➜ item 2
	      ➡ item 1
	      ➡ item 2
	         ➞ item 1
	         ➞ item 2
	            ➝ item 1
	            ➝ item 2
	               ➙ item 1
	               ➙ item 2
	 * </pre>
	 */
	UTF_ARROS ("➔", "➜", "➡", "➞", "➝", "➙"),

	/**
	 * Style using several UTF-8 star characters.
	 * For example:
	 * <pre>
	✳ item 1
	✳ item 2
	   ✴ item 1
	   ✴ item 2
	      ✵ item 1
	      ✵ item 2
	         ✷ item 1
	         ✷ item 2
	            ✹ item 1
	            ✹ item 2
	               ✺ item 1
	               ✺ item 2
	 * </pre>
	 */
	UTF_STARS ("✳", "✴", "✵" ,"✷" ,"✹" ,"✺"),

	/**
	 * Style using several UTF-8 star characters.
	 * For example:
	 * <pre>
	✧ item 1
	✧ item 2
	   ✩ item 1
	   ✩ item 2
	      ✫ item 1
	      ✫ item 2
	         ✬ item 1
	         ✬ item 2
	            ✭ item 1
	            ✭ item 2
	               ✯ item 1
	               ✯ item 2
	 * </pre>
	 */
	UTF_STARS_OUTLINE ("✧", "✩", "✫" ,"✬" ,"✭" ,"✯"),

	/**
	 * Style using several UTF-8 tear drop characters.
	 * For example:
	 * <pre>
	✻ item 1
	✻ item 2
	    ✼ item 1
	    ✼ item 2
	      ✾ item 1
	      ✾ item 2
	 * </pre>
	 */
	UTF_TEAR_DROP("✻", "✼", "✾", null, null, null),

	/**
	 * Style using several UTF-8 florette characters.
	 * For example:
	 * <pre>
	✿ item 1
	✿ item 2
	   ❀ item 1
	   ❀ item 2
	      ❁ item 1
	      ❁ item 2
	 * </pre>
	 */
	UTF_FLORETTE("✿", "❀", "❁", null, null, null),

	/**
	 * Style using several UTF-8 snowflake characters.
	 * For example:
	 * <pre>
	❄ item 1
	❄ item 2
	   ❅ item 1
	   ❅ item 2
	      ❆ item 1
	      ❆ item 2
	 * </pre>
	 */
	UTF_SNOWFLAKE("❄", "❅", "❆", null, null, null),

	/**
	 * Style using several UTF-8 sparkle characters.
	 * For example:
	 * <pre>
	❇ item 1
	❇ item 2
	   ❈ item 1
	   ❈ item 2
	 * </pre>
	 */
	UTF_SPARKLE("❇", "❈", null, null, null, null),

	;

	/** Label string for all levels. */
	String all;

	/** Level 1 label string. */
	String l1;

	/** Level 2 label string. */
	String l2;

	/** Level 3 label string. */
	String l3;

	/** Level 4 label string. */
	String l4;

	/** Level 5 label string. */
	String l5;

	/** Level 6 label string. */
	String l6;

	/**
	 * Returns a new itemize style using same string for all levels.
	 * @param all level label
	 */
	NestedItemizeStyles(String all){
		this.all = all;
	}

	/**
	 * Returns a new itemize style for 6 levels.
	 * @param l1 level 1 label
	 * @param l2 level 2 label
	 * @param l3 level 3 label
	 * @param l4 level 4 label
	 * @param l5 level 5 label
	 * @param l6 level 6 label
	 */
	NestedItemizeStyles(String l1, String l2, String l3, String l4, String l5, String l6){
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.l4 = l4;
		this.l5 = l5;
		this.l6 = l6;
	}

	@Override
	public String getLabel(int level) {
		if(this.all!=null){
			return this.all;
		}
		switch(level){
			case 1:
				if(this.l1==null){
					throw new NotImplementedException("this style for nested itemize lists does not support depth (level) of 1");
				}
				return this.l1;
			case 2:
				if(this.l2==null){
					throw new NotImplementedException("this style for nested itemize lists does not support depth (level) of 2");
				}
				return this.l2;
			case 3:
				if(this.l3==null){
					throw new NotImplementedException("this style for nested itemize lists does not support depth (level) of 3");
				}
				return this.l3;
			case 4:
				if(this.l4==null){
					throw new NotImplementedException("this style for nested itemize lists does not support depth (level) of 4");
				}
				return this.l4;
			case 5:
				if(this.l5==null){
					throw new NotImplementedException("this style for nested itemize lists does not support depth (level) of 5");
				}
				return this.l5;
			case 6:
				if(this.l6==null){
					throw new NotImplementedException("this style for nested itemize lists does not support depth (level) of 6");
				}
				return this.l6;
		}
		throw new NotImplementedException("nested itemize style for lists deeper than 6 not supported");
	}

	@Override
	public StrBuilder toDoc() {
		StrBuilder ret = new StrBuilder(30);
		ret.append(this.getLabel(1)).append(" item 1").appendNewLine();
		ret.append(this.getLabel(1)).append(" item 2").appendNewLine();

		if(this.all!=null || this.l2!=null){
			ret.append("   ").append(this.getLabel(2)).append(" item 1").appendNewLine();
			ret.append("   ").append(this.getLabel(2)).append(" item 2").appendNewLine();
		}

		if(this.all!=null || this.l3!=null){
			ret.append("   ").append("   ").append(this.getLabel(3)).append(" item 1").appendNewLine();
			ret.append("   ").append("   ").append(this.getLabel(3)).append(" item 2").appendNewLine();
		}

		if(this.all!=null || this.l4!=null){
			ret.append("   ").append("   ").append("   ").append(this.getLabel(4)).append(" item 1").appendNewLine();
			ret.append("   ").append("   ").append("   ").append(this.getLabel(4)).append(" item 2").appendNewLine();
		}

		if(this.all!=null || this.l5!=null){
			ret.append("   ").append("   ").append("   ").append("   ").append(this.getLabel(5)).append(" item 1").appendNewLine();
			ret.append("   ").append("   ").append("   ").append("   ").append(this.getLabel(5)).append(" item 2").appendNewLine();
		}

		if(this.all!=null || this.l6!=null){
			ret.append("   ").append("   ").append("   ").append("   ").append("   ").append(this.getLabel(6)).append(" item 1").appendNewLine();
			ret.append("   ").append("   ").append("   ").append("   ").append("   ").append(this.getLabel(6)).append(" item 2").appendNewLine();
		}
		return ret;
	}

}
