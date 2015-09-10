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

import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.asciilist.AsciiList_Enumerate;

/**
 * Customizable style for enumerate (ordered) lists - {@link AsciiList_Enumerate}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.2 build 150910 (10-Sep-15) for Java 1.7
 * @since      v0.0.1
 */
public interface ListStyle_Enumerate {

	/**
	 * Returns the label according to the style for a particular position in an enumerate list.
	 * @param position the position in the list (1 or greater)
	 * @return the calculated label
	 * @throws IllegalArgumentException if position is out of band (i.e. cannot be calculated)
	 */
	String getLabel(int position);

	/**
	 * Returns a representation of the list style useful for documentation
	 * @return documentation representation of the list style
	 */
	StrBuilder toDoc();

}
