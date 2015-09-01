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

import java.util.List;

import de.vandermeer.asciilist.styles.ListStyle;

/**
 * Base of the ASCII list hierarchy - standard interface.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 150901 (01-Sep-15) for Java 1.7
 * @since      v0.0.1
 */
public interface AsciiList {

	/**
	 * Adds a new list to the list.
	 * If the list is not continued, then no style information will be copied and the list level will be 1.
	 * If the list is a continued list, then all style information will be copied from the parent list and the level of the added list will be set accordingly.
	 * A list is continued if {@link #isContinuedList()} returns true, not continued if it returns false.
	 * @param list the new list
	 * @throws NullPointerException - if the list is null
	 * @throws IllegalArgumentException - if the list is empty
	 * @return the new created list, which has been added to the current list
	 */
	AsciiList addItem(AsciiList list);

	/**
	 * Adds a new item to the list.
	 * @param item new item, only added if not blank
	 * @return self to allow chaining
	 */
	AsciiList addItem(String item);

	/**
	 * Returns a copy of the list.
	 * @return copy of the list
	 */
	AsciiList copy();

	/**
	 * Returns the items of the list.
	 * @return items of the list
	 */
	List<Object> getItems();

	/**
	 * Returns the level of the list.
	 * @return list level, one if top list, greater than one if it is a nested list
	 */
	int getLevel();

	/**
	 * Sets the indentation to be used for an item after the label (and before the post-label string).
	 * @return indent post-label indentation
	 */
	int getPostLabelIndent();

	/**
	 * Sets a string to be printed after an item label (and before the post-label indentation).
	 * @return postLabel string for post label
	 */
	String getPostLabelString();

	/**
	 * Gets the indentation to be used for an item before the label (and after the pre-label string).
	 * @return indent pre-label indentation
	 */
	int getPreLabelIndent();

	/**
	 * Sets a string to be printed before an item label (and after the pre-label indentation).
	 * @return preLabel string for pre-label
	 */
	String getPreLabelString();

	/**
	 * Returns a flag indicating if the list is continued from a previous list of the same type or not.
	 * @return true if is continued, false otherwise
	 */
	boolean isContinuedList();

	/**
	 * Renders the list, generates a string representation of it.
	 * @return rendered list
	 */
	String render();

//	/**
//	 * Renders the list, generates a string representation of it.
//	 * @param width maximum width of each line in the rendered string
//	 * @return rendered list
//	 */
//	String render(int width);

	/**
	 * Renders a particular item of a list.
	 * @param item the item to be rendered
	 * @param position the position of the item in the item list
	 * @return rendered item
	 */
	String renderItem(AsciiListItem item, int position);

	/**
	 * Sets the level of the list.
	 * @param level new list level, should only be used if 2 or larger (nested list) using 1 as default
	 * @return self to allow chaining
	 */
	AsciiList setLevel(int level);

	/**
	 * Sets the style of a list.
	 * The style is specific to the list type.
	 * To set a style the list will go through all list items and set the style if the item class supports the given style.
	 * @param style new list style
	 * @return self to allow chaining
	 */
	AsciiList setListStyle(ListStyle style);

	/**
	 * Sets the indentation to be used for an item after the label (and before the post-label string).
	 * @param indent post-label indentation, negative integer will use default
	 * @return self to allow chaining
	 */
	AsciiList setPostLabelIndent(int indent);

	/**
	 * Sets a string to be printed after an item label (and before the post-label indentation).
	 * @param str string for post label
	 * @return self to allow chaining
	 */
	AsciiList setPostLabelString(String str);

	/**
	 * Sets the indentation to be used for an item before the label (and after the pre-label string).
	 * @param indent pre-label indentation, negative integer will use default
	 * @return self to allow chaining
	 */
	AsciiList setPreLabelIndent(int indent);

	/**
	 * Sets a string to be printed before an item label (and after the pre-label indentation).
	 * @param str string for pre-label
	 * @return self to allow chaining
	 */
	AsciiList setPreLabelString(String str);
}
