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

import org.apache.commons.lang3.NotImplementedException;


/**
 * Utilities to convert numbers (integers) into arabic number literals with several supported representations using ASCII-7 and UTF characters.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160306 (06-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public abstract class ArabicLiteralUtils {

	/**
	 * Returns an Arabic literal representation of the given number using ASCII-7 characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 */
	public final static String toAscii(int number){
		return Integer.toString(number);
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using UTF Circled Digit/Number characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 20)
	 */
	public final static String toCircledDigit(int number){
		if(number<1 || number>20){
			throw new NotImplementedException("Arabic literals - UTF Circled Digit/Number - supported 0<number<21 - number was: " + number);
		}
		return new String(Character.toChars(number+9311));
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using UTF Double Circled Digit/Number characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 10)
	 */
	public final static String toDoubleCircledDigit(int number){
		if(number<1 || number>20){
			throw new NotImplementedException("Arabic literals - UTF Double Circled Digit/Number - supported 0<number<10 - number was: " + number);
		}
		return new String(Character.toChars(number+9460));
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using UTF Dingbat Negative Circled Digit characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 10)
	 */
	public final static String toDingbatNegativeCircledDigit(int number){
		if(number<1 || number>10){
			throw new NotImplementedException("Arabic literals - UTF Dingbat Negative Circled - supported 0<number<11 - number was: " + number);
		}
		return new String(Character.toChars(number+10101));
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using UTF Dingbat Negative Sanserif Circled Digit characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 10)
	 */
	public final static String toDingbatNegativeSanserifCircledDigit(int number){
		if(number<1 || number>10){
			throw new NotImplementedException("Arabic literals - UTF Dingbat Negative Sanserif Circled - supported 0<number<11 - number was: " + number);
		}
		return new String(Character.toChars(number+10121));
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using UTF Dingbat Sanserif Circled Digit characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 10)
	 */
	public final static String toDingbatSanserifCircledDigit(int number){
		if(number<1 || number>10){
			throw new NotImplementedException("Arabic literals - UTF Dingbat Sanserif Circled Digit - supported 0<number<11 - number was: " + number);
		}
		return new String(Character.toChars(number+10111));
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using UTF Superscript Latin Small Letter characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 9)
	 */
	public final static String toSuperscript(int number){
		if(number<1 || number>9){
			throw new NotImplementedException("Arabic literals - UTF Superscript Latin Small Letter - supported 0<number<10 - number was: " + number);
		}
		if(number==1 || number>3){
			//1, 4-10
			return new String(Character.toChars(number+8304));
		}
		else{
			//2, 3
			return new String(Character.toChars(number+176));
		}
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using UTF Subscript characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 9)
	 */
	public final static String toSubscript(int number){
		if(number<1 || number>9){
			throw new NotImplementedException("Arabic literals - UTF Subscript - supported 0<number<10 - number was: " + number);
		}
		return new String(Character.toChars(number+8320));
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using UTF Full Stop characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 20)
	 */
	public final static String toFullStop(int number){
		if(number<1 || number>20){
			throw new NotImplementedException("Arabic literals - UTF Full Stop - supported 0<number<21 - number was: " + number);
		}
		return new String(Character.toChars(number+9351));
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using UTF Parenthesized Digit/Number characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 20)
	 */
	public final static String toParenthesized(int number){
		if(number<1 || number>20){
			throw new NotImplementedException("Arabic literals - UTF Parenthesized Digit/Number - supported 0<number<21 - number was: " + number);
		}
		return new String(Character.toChars(number+9331));
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using UTF Fullwidth characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 9)
	 */
	public final static String toFullwidth(int number){
		if(number<1 || number>9){
			throw new NotImplementedException("Arabic literals - UTF Fullwidth - supported 0<number<10 - number was: " + number);
		}
		return new String(Character.toChars(number+65296));
	}

//	/**
//	 * Returns an alphanumeric literal representation of the given number using UTF Mathematical Monospace Digit characters.
//	 * @param number to convert
//	 * @return alphanumeric literal representation
//	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 9)
//	 */
//	public final static String toMathematicalMonospace(int number){
//		if(number<1 || number>9){
//			throw new NotImplementedException("Arabic literals - UTF Mathematical Monospace - supported 0<number<10 - number was: " + number);
//		}
//		return new String(Character.toChars(number+120822));
//	}

//	/**
//	 * Returns an alphanumeric literal representation of the given number using UTF Mathematical Sans-Serif Bold Digit characters.
//	 * @param number to convert
//	 * @return alphanumeric literal representation
//	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 9)
//	 */
//	public final static String toMathematicalSansSerifBold(int number){
//		if(number<1 || number>9){
//			throw new NotImplementedException("Arabic literals - UTF Mathematical Sans-Serif Bold - supported 0<number<10 - number was: " + number);
//		}
//		return new String(Character.toChars(number+120822));
//	}

}
