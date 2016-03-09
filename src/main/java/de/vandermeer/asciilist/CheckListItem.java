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
 * Implementation of {@link AsciiListItem} for a checklist.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160306 (06-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public class CheckListItem extends AbstractAsciiListItem {

	/** Flag for checked (true) and unchecked (false) items in a checklist. */
	protected final boolean checked;

	/**
	 * Creates a new list item
	 * @param content the content for the new list item
	 * @param checked flag to indicate if the item is checked (true) or not (false)
	 * @throws IllegalArgumentException if the content or the content toString was empty
	 * @throws NullPointerException if the content toString was null
	 */
	public CheckListItem(final Object content, boolean checked){
		super(content);
		this.checked = checked;
	}

	/**
	 * Returns the checked flag of the item.
	 * @return true if the item is checked, false otherwise
	 */
	public boolean isChecked(){
		return this.checked;
	}

}
