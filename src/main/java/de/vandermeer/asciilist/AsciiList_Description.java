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

package de.vandermeer.asciilist;

/**
 * A list - called description in LaTeX, definition list in HTML, labeled list in ASCII Doc.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3 build 160301 (01-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public interface AsciiList_Description extends AsciiList {

	/**
	 * Sets the indentation if lines need to be wrapped due to over length compared to a given width.
	 * @param indentation the indentation
	 * @return self to allow chaining
	 */
	AsciiList_Description setWrappedLineIndentation(int indentation);

	/**
	 * Returns the indentation if lines need to be wrapped due to over length compared to a given width.
	 * @return indentation the indentation
	 */
	int getWrappedLineIndentation();

	/**
	 * Adds a new item to the description list.
	 * Nothing will be added of the term or the description are blank.
	 * @param term the term of the item
	 * @param description the description of the term
	 * @return self to allow chaining
	 */
	AsciiList_Description addItem(String term, String description);

	/**
	 * Sets the list behavior for the descriptions to single line or multiline.
	 * @param flag true for single line (label and description in one line), false for multiline (separate lines for label and descriptions)
	 * @return self to allow chaining
	 */
	AsciiList_Description useSingleLine(boolean flag);

}
