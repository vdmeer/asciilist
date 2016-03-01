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
 * A list - called enumerate in LaTeX, ordered in HTML and ASCII Doc.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160301 (01-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public interface AsciiList_Enumerate extends AsciiList {

	/**
	 * Adds a new list to the list.
	 * If the list is an enumerate list, then continuation behavior will be as follows:
	 * If the list is not continued, then no style information will be copied and the list level will be 1.
	 * If the list is a continued list, then all style information will be copied from the parent list and the level of the added list will be set accordingly.
	 * A list is continued if {@link #isContinuedList()} returns true, not continued if it returns false.
	 * @param list the new list
	 * @throws NullPointerException - if the list is null
	 * @throws IllegalArgumentException - if the list is empty
	 * @return self to allow chaining
	 */
	AsciiList_Enumerate addItem(AsciiList list);

	/**
	 * Adds a new item to the list.
	 * @param item new item, only added if not blank
	 * @return self to allow chaining
	 */
	AsciiList_Enumerate addItem(String item);

	/**
	 * Adds a collection of new items to the list.
	 * @param items collection of items, individual items only added if not blank
	 * @return self to allow chaining
	 */
	AsciiList_Enumerate addAllItems(Collection<String> items);

	/**
	 * Sets the parents (enumerations of all parent items) to generate for instance 1. - 1.1. - 1.1.1.
	 * @param parents nested level, each entry in the array marks the position of a parent
	 * @return self to allow chaining
	 */
	AsciiList_Enumerate setParents(int[] parents);

	/**
	 * Returns the parents of nested enumerate lists.
	 * @return levels of nested enumerate lists, null for the top one
	 */
	int[] getParents();

	/**
	 * Sets the label separator, default is dot.
	 * @param separator new label separator, blank can be used
	 * @return self to allow chaining
	 */
	AsciiList_Enumerate setLabelSeparator(String separator);

	/**
	 * Returns the label separator, default is dot.
	 * @return separator new label separator, blank can be used
	 */
	String getLabelSeparator();

	/**
	 * Sets the behavior for using the label separator after the last item when rendering a list item.
	 * The default behavior is false, i.e. do not use the label separator after the last item.
	 * @param flag true if the separator should be used after the last item, false otherwise
	 * @return self to allow chaining
	 */
	AsciiList_Enumerate useLabelSeparatorAfterLastItem(boolean flag);

	/**
	 * Returns a flag stating if the list is prepared for rendering.
	 * @return true if prepared for rendering, false otherwise
	 */
	boolean isPrepared();

	/**
	 * Sets the list as being prepared for rendering.
	 */
	void setPrepared();
}
