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

package de.vandermeer.asciilist.enumerate;

import de.vandermeer.asciilist.AbstractAsciiListItem;
import de.vandermeer.asciilist.AsciiList;

/**
 * Enumerate list item.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public class EnumerateListItem extends AbstractAsciiListItem implements Comparable<EnumerateListItem> {

	/**
	 * Creates a new item with text.
	 * @param text item text
	 * @throws NullPointerException if the argument was null or was a collection with null elements
	 * @throws IllegalArgumentException if any text to be added was blank
	 */
	public EnumerateListItem(Object text){
		super(text);
	}

	/**
	 * Creates a new item with text and a child list.
	 * @param text item text
	 * @param list another list
	 * @throws NullPointerException if the argument was null or had null elements
	 */
	public EnumerateListItem(Object text, AsciiList<?, ?, ?> list){
		super(text, list);
	}

	@Override
	public int compareTo(EnumerateListItem o) {
		return this.text.toString().compareTo(o.text.toString());
	}

}
