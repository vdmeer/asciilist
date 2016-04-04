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

package de.vandermeer.asciilist.old;

import java.util.Collection;

/**
 * A list - called itemize in LaTeX, unordered in HTML and ASCII Doc.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public interface AsciiList_Itemize extends AsciiList {

	/**
	 * Adds a new item to the list.
	 * @param item new item, only added if not blank
	 * @return self to allow chaining
	 */
	AsciiList_Itemize addItem(String item);

	/**
	 * Adds a collection of new items to the list.
	 * @param items collection of items, individual items only added if not blank
	 * @return self to allow chaining
	 */
	AsciiList_Itemize addAllItems(Collection<String> items);

	/**
	 * Adds a new list to the list.
	 * If the list is an itemize list, then continuation behavior will be as follows:
	 * If the list is not continued, then no style information will be copied and the list level will be 1.
	 * If the list is a continued list, then all style information will be copied from the parent list and the level of the added list will be set accordingly.
	 * A list is continued if {@link #isContinuedList()} returns true, not continued if it returns false.
	 * @param list the new list
	 * @throws NullPointerException - if the list is null
	 * @throws IllegalArgumentException - if the list is empty
	 * @return self to allow chaining
	 */
	AsciiList_Itemize addItem(AsciiList list);

}
