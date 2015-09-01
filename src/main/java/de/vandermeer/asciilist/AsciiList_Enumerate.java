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
 * A list - called enumerate in LaTeX, ordered in HTML and ASCII Doc.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 150901 (01-Sep-15) for Java 1.7
 * @since      v0.0.1
 */
public interface AsciiList_Enumerate extends AsciiList {

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

}
