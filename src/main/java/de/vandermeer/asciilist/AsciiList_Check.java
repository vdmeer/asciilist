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

import java.util.Collection;

/**
 * A list - called option (list) in HTML, checklist in ASCII Doc.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public interface AsciiList_Check extends AsciiList {

	/**
	 * Sets a string to be printed before an item label (and after the pre-label indentation).
	 * @param preLabel string for pre-label
	 * @return self to allow chaining
	 */
	AsciiList_Check setPreLabel (String preLabel);

	/**
	 * Sets a string to be printed after an item label (and before the post-label indentation).
	 * @param postLabel string for post label
	 * @return self to allow chaining
	 */
	AsciiList_Check setPostLabel(String postLabel);

	/**
	 * Sets the indentation to be used for an item after the label (and before the post-label string).
	 * @param indent post-label indentation, negative integer will use default
	 * @return self to allow chaining
	 */
	AsciiList_Check setPostIndent(int indent);

	/**
	 * Adds a new item which is set to "unchecked".
	 * @param item new item, only added if not blank
	 * @return self to allow chaining
	 */
	AsciiList_Check addItem(String item);

	/**
	 * Adds a collection of new items to the list, all set to "unchecked".
	 * @param items collection of items, individual items only added if not blank
	 * @return self to allow chaining
	 */
	AsciiList_Check addAllItems(Collection<String> items);

	/**
	 * Adds a new item which is set to "checked".
	 * @param item content for the checked item
	 * @return self to allow chaining
	 */
	AsciiList_Check addItemChecked(String item);
}
