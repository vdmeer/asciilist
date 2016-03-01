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
 * Utilities to convert numbers (integers) into alphanumeric literals with several supported representations using ASCII-7 and UTF characters.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160301 (01-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public abstract class AlphaLiteralUtils {

	/**
	 * Returns an alphanumeric literal representation of the given number using ASCII-7 upper case characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 26)
	 */
	public final static String toAscii(int number){
		if(number<1 || number>26){
			throw new NotImplementedException("Alphanumeric literals supported 0<number<27 - number was: " + number);
		}
		return new String(Character.toChars(number+64));
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using ASCII-7 lower case characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 26)
	 */
	public final static String toAsciiLC(int number){
		if(number<1 || number>26){
			throw new NotImplementedException("Alphanumeric literals supported 0<number<27 - number was: " + number);
		}
		return new String(Character.toChars(number+96));
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using UTF Circled Latin Capital (upper case) characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 26)
	 */
	public final static String toCircledLatinCapital(int number){
		if(number<1 || number>26){
			throw new NotImplementedException("Alphanumeric literals supported 0<number<27 - number was: " + number);
		}
		return new String(Character.toChars(number+9397));
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using UTF Circled Latin Small (lower case) characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 26)
	 */
	public final static String toCircledLatinSmall(int number){
		if(number<1 || number>26){
			throw new NotImplementedException("Alphanumeric literals supported 0<number<27 - number was: " + number);
		}
		return new String(Character.toChars(number+9423));
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using UTF Parenthesized Latin Small Letter (lower case) characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 26)
	 */
	public final static String toParenthesizedLatinSmallLetter(int number){
		if(number<1 || number>26){
			throw new NotImplementedException("Alphanumeric literals supported 0<number<27 - number was: " + number);
		}
		return new String(Character.toChars(number+9371));
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using UTF Fullwidth Latin Capital Letter (upper case) characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 26)
	 */
	public final static String toFullwidthLatinCapital(int number){
		if(number<1 || number>26){
			throw new NotImplementedException("Alphanumeric literals supported 0<number<27 - number was: " + number);
		}
		return new String(Character.toChars(number+65312));
	}

	/**
	 * Returns an alphanumeric literal representation of the given number using UTF Fullwidth Latin Small Letter (lower case) characters.
	 * @param number to convert
	 * @return alphanumeric literal representation
	 * @throws NotImplementedException if the number is out of bounds (currently smaller than 1 and larger than 26)
	 */
	public final static String toFullwidthLatinSmall(int number){
		if(number<1 || number>26){
			throw new NotImplementedException("Alphanumeric literals supported 0<number<27 - number was: " + number);
		}
		return new String(Character.toChars(number+65344));
	}

}
