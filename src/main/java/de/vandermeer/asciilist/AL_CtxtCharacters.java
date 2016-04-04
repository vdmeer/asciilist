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

/**
 * Characters object for an {@link AL_Context}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public class AL_CtxtCharacters {

	/** Left text margin character. */
	protected Character textLeft = ' ';

	/** Right text margin character. */
	protected Character textRight = ' ';

	/** Left label margin character. */
	protected Character labelLeft = ' ';

	/** Right label margin character. */
	protected Character labelRight = ' ';

	/** Item margin character. */
	protected Character item = ' ';

	/**
	 * Creates a new object with all characters set to `' '`.
	 */
	public AL_CtxtCharacters(){}

	/**
	 * Returns the left text margin character.
	 * @return left text margin character
	 */
	public Character getTextLeft() {
		return textLeft;
	}

	/**
	 * Sets the left text margin character.
	 * @param c new left text margin character, ignored if null
	 * @return this to allow chaining
	 */
	public AL_CtxtCharacters setTextLeft(Character c) {
		if(c!=null){
			this.textLeft = c;
		}
		return this;
	}

	/**
	 * Returns the right text margin character.
	 * @return right text margin character
	 */
	public Character getTextRight() {
		return textRight;
	}

	/**
	 * Sets the right text margin character.
	 * @param c new right text margin character, ignored if null
	 * @return this to allow chaining
	 */
	public AL_CtxtCharacters setTextRight(Character c) {
		if(c!=null){
			this.textRight = c;
		}
		return this;
	}

	/**
	 * Returns the left label margin character.
	 * @return left label margin character
	 */
	public Character getLabelLeft() {
		return this.labelLeft;
	}

	/**
	 * Sets the left label margin character.
	 * @param c new left label margin character, ignored if null
	 * @return this to allow chaining
	 */
	public AL_CtxtCharacters setLabelLeft(Character c) {
		if(c!=null){
			this.labelLeft = c;
		}
		return this;
	}

	/**
	 * Returns the right label margin character.
	 * @return right label margin character
	 */
	public Character getLabelRight() {
		return this.labelRight;
	}

	/**
	 * Sets the right label margin character.
	 * @param c new right label margin character, ignored if null
	 * @return this to allow chaining
	 */
	public AL_CtxtCharacters setLabelRight(Character c) {
		if(c!=null){
			this.labelRight = c;
		}
		return this;
	}

	/**
	 * Returns the item margin character.
	 * @return item margin character
	 */
	public Character getItem() {
		return this.item;
	}

	/**
	 * Sets the item margin character.
	 * @param c new item margin character, ignored if null
	 *@return this to allow chaining
	 */
	public AL_CtxtCharacters setItem(Character c) {
		if(c!=null){
			this.item = c;
		}
		return this;
	}

	/**
	 * Copies all settings from the given object.
	 * @param object the object to copy settings from
	 */
	public void copySettings(AL_CtxtCharacters chars){
		this.item = chars.item;
		this.labelLeft = chars.labelLeft;
		this.labelRight = chars.labelRight;
		this.textLeft = chars.textLeft;
		this.textRight = chars.textRight;
	}

}
