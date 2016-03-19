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
 * The interface covers all generic functionality for ASCII lists:
 * <ul>
 * 		<li>Set/get all label related formatting options (pre-label indentation and string, post-label indentation and string)</li>
 * 		<li>Set list style (based on the style interface</li>
 * 		<li>Render the list</li>
 * 		<li>Retrieve list items for processing</li>
 * </ul>
 * 
 * Some methods a more for internal use (by an abstract implementation supporting specific lists):
 * <ul>
 * 		<li>Set/get level (of nested lists)</li>
 * 		<li>Calculation methods (e.g. for maximum indentation)</li>
 * 		<li>Render and individual items</li>
 * </ul>
 * 
 * The interface does not define any method to add content to a list.
 * The reason for that is that list content is very specific for a particular list.
 * For instance, a description will need a term and a description as content for an item,
 * while an itemize list requires only text for the item.
 * In addition: some lists allow for adding other lists (e.g. enumerate, itemize) while other lists do not support that (e.g. checklist).
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v1.0.0 build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public interface AsciiList {

	/**
	 * A string representing an implicit new line for item rendering or internal processing such as word wrapping.
	 */
	String IMPLICIT_NEWLINE = "@@@@";

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
	 * @throws IllegalArgumentException if a set width is too small for any list item being rendered intelligibly
	 */
	String render();

	/**
	 * Prepares a list to be rendered.
	 * This method should be automatically called by the list before starting the rendering.
	 */
	void prepareRender();

	/**
	 * Calculates indentation for each element of the list and returns the maximum value.
	 * The max value contains the pre-label indent, the pre-label string, the actual label, the post-label string and the post-label indent.
	 * This maximum indentation can then be used in the rendering process to indent all items and sub-lists, even with different length labels.
	 * @return maximum indentation calculated over all list items
	 */
	int calculateMaxIndentation();

	/**
	 * Calculates indentation for a list item.
	 * @param item the item to be used for calculation
	 * @param position the position of the item in the item list
	 * @return item indentation
	 */
	int calculateMaxIndentation(AsciiListItem item, int position);

	/**
	 * Sets the (maximum) width a list (and all items and sub-lists) can have when being rendered.
	 * @param width maximum width
	 * @return self to allow chaining
	 */
	AsciiList setWidth(int width);

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

	/**
	 * Sets the values for pre/post paramters of labels back to their default values.
	 * @return self to allow for chaining
	 */
	AsciiList setLabelDefaults();

}
