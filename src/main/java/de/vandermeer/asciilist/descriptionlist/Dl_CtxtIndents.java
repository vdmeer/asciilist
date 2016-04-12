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

package de.vandermeer.asciilist.descriptionlist;

import de.vandermeer.asciilist.AL_CtxtIndents;

/**
 * Indentation object for description lists.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public class Dl_CtxtIndents extends AL_CtxtIndents {

	/** The indentation for the description. */
	protected int descriptionIndent = 4;

	/**
	 * Creates a new object.
	 */
	public Dl_CtxtIndents(){}

	/**
	 * Copies all settings from the given object.
	 * @param indents the object to copy settings from
	 */
	public void copySettings(Dl_CtxtIndents indents){
		this.descriptionIndent = indents.descriptionIndent;
	}

	/**
	 * Returns the description indentation.
	 * @return description indentation
	 */
	public int getDescriptionIndent() {
		return descriptionIndent;
	}

	/**
	 * Sets the description indentation.
	 * @param descriptionIndent new indentation
	 * @return this to allow chaining
	 */
	public Dl_CtxtIndents setDescriptionIndent(int descriptionIndent) {
		this.descriptionIndent = descriptionIndent;
		return this;
	}

}
