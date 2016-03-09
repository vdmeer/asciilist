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

package de.vandermeer.asciilist.commons;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.NotImplementedException;

/**
 * Utilities to convert numbers (integers) into Roman number literals with several supported representations using ASCII-7 and UTF characters.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160306 (06-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public enum RomanNumberLiterals {

	I		(1,    "I",    "i",    "Ⅰ",   "ⅰ",		"Ⓘ",		"ⓘ"			),
	II		(2,    "II",   "ii",   "Ⅱ",   "ⅱ",		"ⒾⒾ",		"ⓘⓘ"		),
	III		(3,    "III",  "iii",  "Ⅲ",   "ⅲ",		"ⒾⒾⒾ",	"ⓘⓘⓘ"		),
	IV		(4,    "IV",   "iv",   "Ⅳ",   "ⅳ",		"ⒾⓋ",		"ⓘⓥ"		),
	V		(5,    "V",    "v",    "Ⅴ",   "ⅴ",		"Ⓥ",		"ⓥ"			),
	VI		(6,    "VI",   "vi",   "Ⅵ",   "ⅵ",		"ⓋⒾ",		"ⓥⓘ"		),
	VII		(7,    "VII",  "vii",  "Ⅶ",   "ⅶ",		"ⓋⒾⒾ",	"ⓥⓘⓘ"		),
	VIII	(8,    "VIII", "viii", "Ⅷ",   "ⅷ",		"ⓋⒾⒾⒾ",	"ⓥⓘⓘⓘ"	),
	IX		(9,    "IX",   "ix",   "Ⅸ",   "ⅸ",		"ⒾⓍ",		"ⓘⓧ"		),
	X		(10,   "X",    "x",    "Ⅹ",   "ⅹ",		"Ⓧ",		"ⓧ"			),
	XI		(11,   "XI",   "xi",   "Ⅺ",   "ⅺ",		"ⓍⒾ",		"ⓧⓘ"		),
	XII		(12,   "XII",  "xii",  "Ⅻ",   "ⅻ",		"ⓍⒾⒾ",	"ⓧⓘⓘ"		),
//	XL		(40,   "XL",   "xl",   "ⅩⅬ", "ⅹⅼ",	"ⓍⓁ",		"ⓧⓛ"		),
	L		(50,   "L",    "l",    "Ⅼ",   "ⅼ",		"Ⓛ",		"ⓛ"			),
//	XC		(90,   "XC",   "xc",   "ⅩⅭ", "ⅹⅽ",	"ⓍⒸ",		"ⓧⓒ"		),
	C		(100,  "C",    "c",    "Ⅽ",   "ⅽ",		"Ⓒ",		"ⓒ"			),
//	CD		(400,  "CD",   "cd",   "ⅭⅮ", "ⅽⅾ",	"ⒸⒹ",		"ⓒⓓ"		),
	D		(500,  "D",    "d",    "Ⅾ",   "ⅾ",		"Ⓓ",		"ⓓ"			),
	M		(1000, "M",    "m",    "Ⅿ",   "ⅿ",		"Ⓜ",		"ⓜ"			),

	;

	/** The number the literal represents. */
	int number;

	/** An upper case ASCII-7 representation of the literal. */
	String ascii7;

	/** A lower case ASCII-7 representation of the literal. */
	String ascii7_LC;

	/** An upper case UTF Number Forms representation of the literal. */
	String numberForms;

	/** A lower case UTF Number Forms representation of the literal. */
	String numberForms_LC;

	/** A UTF Circled Latin Capital representation of the literal. */
	String circledLatinCapital;

	/** A UTF Circled Latin Small representation of the literal. */
	String circledLatinSmall;

	/**
	 * Creates a new Roman literal enum.
	 * @param number the number it represents
	 * @param ascii7 ASCII-7 representation
	 * @param ascii7_LC ASCII-7 lower case representation
	 * @param numberForms UTF Number Forms representation
	 * @param numberForms_LC UTF Number Forms lower case representation
	 * @param circledLatinCapital UTF Circled Latin Capital representation
	 * @param circledLatinSmall UTF Circled Latin Small representation
	 */
	RomanNumberLiterals(int number, String ascii7, String ascii7_LC, String numberForms, String numberForms_LC, String circledLatinCapital, String circledLatinSmall){
		this.number = number;
		this.ascii7 = ascii7;
		this.ascii7_LC = ascii7_LC;
		this.numberForms = numberForms;
		this.numberForms_LC = numberForms_LC;
		this.circledLatinCapital = circledLatinCapital;
		this.circledLatinSmall = circledLatinSmall;
	}


	/** Array to convert numbers. */
	public final static int[] NUMBERS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

	/** Array of Roman number literals. */
	public final static String[] LETTERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

	/**
	 * Converts an integer into a Roman number.
	 * @param number integer to be converted
	 * @return Roman number using upper case letters
	 * @throws NotImplementedException if the number is smaller than 1 or greater than 3999
	 */
	public final static String INTEGER_2_ROMAN(int number){
		if(number<1 || number>3999){
			throw new NotImplementedException("Roman literals supported 0<number<4000 - number was: " + number);
		}

		String ret = "";
		for(int i=0; i<NUMBERS.length; i++){
			while(number>=NUMBERS[i]){
				ret += LETTERS[i];
				number -= NUMBERS[i];
			}
		}
		return ret;
	}

	/**
	 * Converts a string of Roman literals into an array of enumerates for further character conversion.
	 * @param roman string with Roman literals
	 * @return enumerate array for further character conversion
	 */
	public final static RomanNumberLiterals[] ROMAN_2_ENUM(String roman){
		RomanNumberLiterals[] ret = new RomanNumberLiterals[0];

		try{
			RomanNumberLiterals rnl = RomanNumberLiterals.valueOf(roman);
			if(rnl!=null){
				return ArrayUtils.add(ret, rnl);
			}
		}
		catch(Exception ignore){
			//this exception happens when no direct mapping is available
			//ignore and continue to find a manual mapping
		}

		for(Character c : roman.toCharArray()){
			RomanNumberLiterals rnl = RomanNumberLiterals.valueOf(c.toString());
			ret = ArrayUtils.add(ret, rnl);
		}

		return ret;
	}

	/**
	 * Returns a Roman literal representation of the given number using ASCII-7 upper case characters.
	 * @param number to convert
	 * @return Roman literal representation, see {link {@link #INTEGER_2_ROMAN(int)} for requirements in the number
	 * @throws NotImplementedException see {link {@link #INTEGER_2_ROMAN(int)}
	 */
	public final static String toAscii(int number){
		return INTEGER_2_ROMAN(number);
	}

	/**
	 * Returns a Roman literal representation of the given number using ASCII-7 lower case characters.
	 * @param number to convert
	 * @return Roman literal representation, see {link {@link #INTEGER_2_ROMAN(int)} for requirements in the number
	 * @throws NotImplementedException see {link {@link #INTEGER_2_ROMAN(int)}
	 */
	public final static String toAsciiLC(int number){
		return INTEGER_2_ROMAN(number).toLowerCase();
	}

	/**
	 * Returns a Roman literal representation of the given number using UTF Number Forms upper case characters.
	 * @param number to convert
	 * @return Roman literal representation, see {link {@link #INTEGER_2_ROMAN(int)} for requirements in the number
	 * @throws NotImplementedException see {link {@link #INTEGER_2_ROMAN(int)}
	 */
	public final static String toNumberForms(int number){
		RomanNumberLiterals[] ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(number));
		String ret = "";
		for(RomanNumberLiterals enumerate : ar){
			ret += enumerate.numberForms;
		}
		return ret;
	}

	/**
	 * Returns a Roman literal representation of the given number using UTF Number Forms lower case characters.
	 * @param number to convert
	 * @return Roman literal representation, see {link {@link #INTEGER_2_ROMAN(int)} for requirements in the number
	 * @throws NotImplementedException see {link {@link #INTEGER_2_ROMAN(int)}
	 */
	public final static String toNumberFormsLC(int number){
		RomanNumberLiterals[] ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(number));
		String ret = "";
		for(RomanNumberLiterals enumerate : ar){
			ret += enumerate.numberForms_LC;
		}
		return ret;
	}

	/**
	 * Returns a Roman literal representation of the given number using UTF Circled Latin Captial (upper case) characters.
	 * @param number to convert
	 * @return Roman literal representation, see {link {@link #INTEGER_2_ROMAN(int)} for requirements in the number
	 * @throws NotImplementedException see {link {@link #INTEGER_2_ROMAN(int)}
	 */
	public final static String toCircledLatinCaptial(int number){
		RomanNumberLiterals[] ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(number));
		String ret = "";
		for(RomanNumberLiterals enumerate : ar){
			ret += enumerate.circledLatinCapital;
		}
		return ret;
	}

	/**
	 * Returns a Roman literal representation of the given number using UTF Circled Latin Small (lower case) characters.
	 * @param number to convert
	 * @return Roman literal representation, see {link {@link #INTEGER_2_ROMAN(int)} for requirements in the number
	 * @throws NotImplementedException see {link {@link #INTEGER_2_ROMAN(int)}
	 */
	public final static String toCircledLatinSmall(int number){
		RomanNumberLiterals[] ar = RomanNumberLiterals.ROMAN_2_ENUM(RomanNumberLiterals.INTEGER_2_ROMAN(number));
		String ret = "";
		for(RomanNumberLiterals enumerate : ar){
			ret += enumerate.circledLatinSmall;
		}
		return ret;
	}
}
