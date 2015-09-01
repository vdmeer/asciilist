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
 * A list item.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 150901 (01-Sep-15) for Java 1.7
 * @since      v0.0.1
 */
public interface AsciiListItem {

	/**
	 * Renders the list item, generates a string representation of it.
	 * @param preLabelIndent indentation before the label (and before the pre-label string)
	 * @param preLabelStr a string to be printed after pre-indentation but before the label
	 * @param label the actual item label (for instance "*" for an itemize list)
	 * @param postLabelStr a string to be printed right after the label but before the post-indentation
	 * @param postLabelIndent indentation after the post-label string (before the actual item content)
	 * @return rendered list item
	 */
	String render(int preLabelIndent, String preLabelStr, String label, String postLabelStr, int postLabelIndent);

	/**
	 * Returns the content of the list item.
	 * @return list item content
	 */
	Object getContent();

}
