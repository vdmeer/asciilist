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

import de.vandermeer.asciilist.AsciiList_Enumerate;
import de.vandermeer.asciilist.commons.AlphaLiteralUtils;
import de.vandermeer.asciilist.commons.ArabicLiteralUtils;
import de.vandermeer.asciilist.commons.RomanNumberLiterals;

/**
 * Styles for an enumerate list /ordered list - {@link AsciiList_Enumerate}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 150901 (01-Sep-15) for Java 1.7
 * @since      v0.0.1
 */
public enum EnumerateStyles implements ListStyle_Enumerate {

	/**
	 * Enumerate style using upper case alphanumeric characters.
	 * For example:
	 * <pre>
	A item 1
	B item 2
	C item 3
	 * </pre>
	 */
	Alpha,

	/**
	 * Enumerate style using upper case alphanumeric circled (circled latin capital letters) characters.
	 * For example:
	 * <pre>
	Ⓐ item 1
	Ⓑ item 2
	Ⓒ item 3
	 * </pre>
	 */
	Alpha_circle,

	/**
	 * Enumerate style using upper case alphanumeric fullwidth (UTF Fullwidth Latin Capital) characters.
	 * For example:
	 * <pre>
	Ａ item 1
	Ｂ item 2
	Ｃ item 3
	 * </pre>
	 */
	Alpha_fullwidth,

	/**
	 * Enumerate style using lower case alphanumeric characters.
	 * For example:
	 * <pre>
	a item 1
	b item 2
	c item 3
	 * </pre>
	 */
	alpha,

	/**
	 * Enumerate style using upper case alphanumeric circled (circled latin small letters) characters.
	 * For example:
	 * <pre>
	ⓐ item 1
	ⓑ item 2
	ⓒ item 3
	 * </pre>
	 */
	alpha_circle,

	/**
	 * Enumerate style using upper case alphanumeric paranthesized (UTF Parenthesized Latin Small Letter) characters.
	 * For example:
	 * <pre>
	⒜ item 1
	⒝ item 2
	⒞ item 3
	 * </pre>
	 */
	alpha_parenthesized,

	/**
	 * Enumerate style using upper case alphanumeric fullwidth (UTF Fullwidth Latin Small) characters.
	 * For example:
	 * <pre>
	ａ item 1
	ｂ item 2
	ｃ item 3
	 * </pre>
	 */
	alpha_fullwidth,

	/**
	 * Enumerate style using Arabic numbers
	 * For example:
	 * <pre>
	1 item 1
	2 item 2
	3 item 3
	 * </pre>
	 */
	arabic,

	/**
	 * Enumerate style using Arabic circled (UTF circled digit) characters.
	 * For example:
	 * <pre>
	① item 1
	② item 2
	③ item 3
	 * </pre>
	 */
	arabic_circle,

	/**
	 * Enumerate style using Arabic double circled (UTF double circled digit) characters.
	 * For example:
	 * <pre>
	⓵ item 1
	⓶ item 2
	⓷ item 3
	 * </pre>
	 */
	arabic_double_circle,

	/**
	 * Enumerate style using Arabic circled dingbat negative (UTF dingbat negative circled digit) characters.
	 * For example:
	 * <pre>
	❶ item 1
	❷ item 2
	❸ item 3
	 * </pre>
	 */
	arabic_circle_dingbat_negative,

	/**
	 * Enumerate style using Arabic circled dingbat sanserif (UTF dingbat sanserif circled digit) characters.
	 * For example:
	 * <pre>
	➀ item 1
	➁ item 2
	➂ item 3
	 * </pre>
	 */
	arabic_circle_dingbat_sanserif,

	/**
	 * Enumerate style using Arabic circled dingbat negative sanserif (UTF dingbat negative sanserif circled digit) characters.
	 * For example:
	 * <pre>
	➊ item 1
	➋ item 2
	➌ item 3
	 * </pre>
	 */
	arabic_circle_dingbat_negative_sanserif,

	/**
	 * Enumerate style using Arabic superscript (UTF Superscript) characters.
	 * For example:
	 * <pre>
	ⁱ item 1
	² item 2
	³ item 3
	 * </pre>
	 */
	arabic_superscript,

	/**
	 * Enumerate style using Arabic subscript (UTF Subscript) characters.
	 * For example:
	 * <pre>
	₁ item 1
	₂ item 2
	₃ item 3
	 * </pre>
	 */
	arabic_subscript,

	/**
	 * Enumerate style using Arabic fullstop (UTF Fullstop) characters.
	 * For example:
	 * <pre>
	⒈ item 1
	⒉ item 2
	⒊ item 3
	 * </pre>
	 */
	arabic_full_stop,

	/**
	 * Enumerate style using Arabic paranthesized (UTF Parenthesized Digit) characters.
	 * For example:
	 * <pre>
	⑴ item 1
	⑵ item 2
	⑶ item 3
	 * </pre>
	 */
	arabic_parenthesized,

	/**
	 * Enumerate style using Arabic fullwidth (UTF Fullwidth Digit) characters.
	 * For example:
	 * <pre>
	１ item 1
	２ item 2
	３ item 3
	 * </pre>
	 */
	arabic_fullwidth,

	/**
	 * Enumerate style using upper case Roman number literals characters.
	 * For example:
	 * <pre>
	I item 1
	II item 2
	III item 3
	 * </pre>
	 */
	Roman,

	/**
	 * Enumerate style using upper case circled Roman number literals (UTF Circled Latin Capital) characters.
	 * For example:
	 * <pre>
	Ⓘ item 1
	ⒾⒾ item 2
	ⒾⒾⒾ item 3
	 * </pre>
	 */
	Roman_circled,

	/**
	 * Enumerate style using upper case Roman number literals (UTF Number Forms) characters.
	 * For example:
	 * <pre>
	Ⅰ item 1
	Ⅱ item 2
	Ⅲ item 3
	 * </pre>
	 */
	Roman_number_forms,

	/**
	 * Enumerate style using lower case Roman number literals characters.
	 * For example:
	 * <pre>
	i item 1
	ii item 2
	iii item 3
	 * </pre>
	 */
	roman,

	/**
	 * Enumerate style using lower case circled Roman number literals (UTF Circled Latin Small) characters.
	 * For example:
	 * <pre>
	ⓘ item 1
	ⓘⓘ item 2
	ⓘⓘⓘ item 3
	 * </pre>
	 */
	roman_circled,

	/**
	 * Enumerate style using lower case Roman number literals (UTF Number Forms) characters.
	 * For example:
	 * <pre>
	ⅰ item 1
	ⅱ item 2
	ⅲ item 3
	 * </pre>
	 */
	roman_number_forms,

	;

	@Override
	public String getLabel(int position){
		switch(this){
			case Alpha:
				return AlphaLiteralUtils.toAscii(position);
			case Alpha_circle:
				return AlphaLiteralUtils.toCircledLatinCapital(position);
			case Alpha_fullwidth:
				return AlphaLiteralUtils.toFullwidthLatinCapital(position);

			case alpha:
				return AlphaLiteralUtils.toAsciiLC(position);
			case alpha_circle:
				return AlphaLiteralUtils.toCircledLatinSmall(position);
			case alpha_parenthesized:
				return AlphaLiteralUtils.toParenthesizedLatinSmallLetter(position);
			case alpha_fullwidth:
				return AlphaLiteralUtils.toFullwidthLatinSmall(position);

			case arabic:
				return ArabicLiteralUtils.toAscii(position);
			case arabic_circle:
				return ArabicLiteralUtils.toCircledDigit(position);
			case arabic_double_circle:
				return ArabicLiteralUtils.toDoubleCircledDigit(position);
			case arabic_circle_dingbat_negative:
				return ArabicLiteralUtils.toDingbatNegativeCircledDigit(position);
			case arabic_circle_dingbat_sanserif:
				return ArabicLiteralUtils.toDingbatSanserifCircledDigit(position);
			case arabic_circle_dingbat_negative_sanserif:
				return ArabicLiteralUtils.toDingbatNegativeSanserifCircledDigit(position);
			case arabic_superscript:
				return ArabicLiteralUtils.toSuperscript(position);
			case arabic_subscript:
				return ArabicLiteralUtils.toSubscript(position);
			case arabic_full_stop:
				return ArabicLiteralUtils.toFullStop(position);
			case arabic_parenthesized:
				return ArabicLiteralUtils.toParenthesized(position);
			case arabic_fullwidth:
				return ArabicLiteralUtils.toFullwidth(position);

			case Roman:
				return RomanNumberLiterals.toAscii(position);
			case Roman_circled:
				return RomanNumberLiterals.toCircledLatinCaptial(position);
			case Roman_number_forms:
				return RomanNumberLiterals.toNumberForms(position);

			case roman:
				return RomanNumberLiterals.toAsciiLC(position);
			case roman_circled:
				return RomanNumberLiterals.toCircledLatinSmall(position);
			case roman_number_forms:
				return RomanNumberLiterals.toNumberFormsLC(position);

			default:
				throw new NotImplementedException("error in implementation, enum case not handled");
		}
	}

	@Override
	public StrBuilder toDoc() {
		StrBuilder ret = new StrBuilder(30);
		ret.append(this.getLabel(1)).append(" item 1").appendNewLine();
		ret.append(this.getLabel(2)).append(" item 2").appendNewLine();
		ret.append(this.getLabel(3)).append(" item 3").appendNewLine();
		return ret;
	}

}
