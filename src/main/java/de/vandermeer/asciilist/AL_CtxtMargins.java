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
 * Margins object for an {@link AL_Context}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public class AL_CtxtMargins {

	/** Left text margin. */
	protected int textLeft = 1;

	/** Right text margin. */
	protected int textRight = 0;

	/** Left label margin. */
	protected int labelLeft = 0;

	/** Right label margin. */
	protected int labelRight = 0;

	/** Item margin. */
	protected int item = 0;

	/**
	 * Creates a new margin object with text left set to 1 and all other margins set to 0.
	 */
	public AL_CtxtMargins(){
		
	}

	/**
	 * Returns the left text margin.
	 * @return left text margin
	 */
	public int getTextLeft() {
		return this.textLeft;
	}

	/**
	 * Sets the left text margin.
	 * @param margin new left text margin, ignored if negative
	 * @return this to allow chaining
	 */
	public AL_CtxtMargins setTextLeft(int margin) {
		if(margin>-1){
			this.textLeft = margin;
		}
		return this;
	}

	/**
	 * Returns the right text margin.
	 * @return right text margin
	 */
	public int getTextRight() {
		return this.textRight;
	}

	/**
	 * Sets the right text margin.
	 * @param margin new right text margin, ignored if negative
	 * @return this to allow chaining
	 */
	public AL_CtxtMargins setTextRight(int margin) {
		if(margin>-1){
			this.textRight = margin;
		}
		return this;
	}

	/**
	 * Returns the left label margin.
	 * @return left label margin
	 */
	public int getLabelLeft() {
		return this.labelLeft;
	}

	/**
	 * Sets the left label margin.
	 * @param margin new left label margin, ignored if negative
	 * @return this to allow chaining
	 */
	public AL_CtxtMargins setLabelLeft(int margin) {
		if(margin>-1){
			this.labelLeft = margin;
		}
		return this;
	}

	/**
	 * Returns the right label margin.
	 * @return right label margin
	 */
	public int getLabelRight() {
		return this.labelRight;
	}

	/**
	 * Sets the right label margin.
	 * @param margin new right label margin, ignored if negative
	 * @return this to allow chaining
	 */
	public AL_CtxtMargins setLabelRight(int margin) {
		if(margin>-1){
			this.labelRight = margin;
		}
		return this;
	}

	/**
	 * Returns the item margin.
	 * @return item margin
	 */
	public int getItem() {
		return this.item;
	}

	/**
	 * Sets the item margin.
	 * @param margin new item margin, ignored if negative
	 * @return this to allow chaining
	 */
	public AL_CtxtMargins setItem(int margin) {
		if(margin>-1){
			this.item = margin;
		}
		return this;
	}

	/**
	 * Copies all settings from the given object.
	 * @param object the object to copy settings from
	 */
	public void copySettings(AL_CtxtMargins margins){
		this.item = margins.item;
		this.labelLeft = margins.labelLeft;
		this.labelRight = margins.labelRight;
		this.textLeft = margins.textLeft;
		this.textRight = margins.textRight;
	}
}
