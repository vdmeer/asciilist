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
 * Strings object for an {@link AL_Context}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public class AL_CtxtStrings {

	/** Left label string. */
	protected String leftLabel = null;

	/** Left label string. */
	protected String rightLabel = null;

	/**
	 * Creates a new object with all strings set to null.
	 */
	public AL_CtxtStrings(){}

	/**
	 * Returns the left label string.
	 * @return left label string, null if not set
	 */
	public String getLeftLabel() {
		return this.leftLabel;
	}

	/**
	 * Sets the left label string.
	 * @param leftLabel left label string, null is ok
	 * @return this to allow chaining
	 */
	public AL_CtxtStrings setLeftLabel(String leftLabel) {
		this.leftLabel = leftLabel;
		return this;
	}

	/**
	 * Returns the right label string.
	 * @return right label string, null if not set
	 */
	public String getRightLabel() {
		return this.rightLabel;
	}

	/**
	 * Sets the right label string.
	 * @param rightLabel right label string, null is ok
	 * @return this to allow chaining
	 */
	public AL_CtxtStrings setRightLabel(String rightLabel) {
		this.rightLabel = rightLabel;
		return this;
	}

	/**
	 * Returns a copy of the object with all current settings.
	 * @return copy with all current settings
	 */
	public AL_CtxtStrings getCopy(){
		return new AL_CtxtStrings()
				
		;
	}

	/**
	 * Copies all settings from the given object.
	 * @param object the object to copy settings from
	 */
	public void copySettings(AL_CtxtStrings strings){
		this.leftLabel = strings.leftLabel;
		this.rightLabel = strings.rightLabel;
	}
}
