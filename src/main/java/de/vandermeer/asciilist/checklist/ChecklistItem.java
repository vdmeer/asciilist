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

package de.vandermeer.asciilist.checklist;

import de.vandermeer.asciilist.AbstractAsciiListItem;
import de.vandermeer.asciilist.AsciiList;

/**
 * Checklist item.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.1.0
 */
public class ChecklistItem extends AbstractAsciiListItem implements Comparable<ChecklistItem> {

	/** Flag for the checked status, true if checked, false otherwise, default is false. */
	protected boolean isChecked = false;

	/**
	 * Creates a new item with text.
	 * @param text item text
	 * @param isChecked the checked status, true if checked, false otherwise
	 * @throws NullPointerException if the argument was null or was a collection with null elements
	 * @throws IllegalArgumentException if any text to be added was blank
	 */
	public ChecklistItem(Object text, boolean isChecked){
		super(text);
		this.isChecked = isChecked;
	}

	/**
	 * Creates a new item with text and a child list.
	 * @param text item text
	 * @param isChecked the checked status, true if checked, false otherwise
	 * @param list another list
	 * @throws NullPointerException if the argument was null or had null elements
	 */
	public ChecklistItem(Object text, boolean isChecked, AsciiList<?, ?, ?> list){
		super(text, list);
		this.isChecked = isChecked;
	}


	/**
	 * Returns the checked status
	 * @return true if checked, false otherwise
	 */
	public boolean isChecked() {
		return this.isChecked;
	}

	@Override
	public int compareTo(ChecklistItem o) {
		return this.text.toString().compareTo(o.text.toString());
	}
}
