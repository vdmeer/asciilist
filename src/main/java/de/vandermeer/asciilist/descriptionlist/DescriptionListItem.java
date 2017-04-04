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

package de.vandermeer.asciilist.descriptionlist;

import org.apache.commons.lang3.Validate;

import de.vandermeer.asciilist.AbstractAsciiListItem;
import de.vandermeer.asciilist.AsciiList;

/**
 * Description list item.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.1.0
 */
public class DescriptionListItem extends AbstractAsciiListItem implements Comparable<DescriptionListItem> {

	/** The description key. */
	protected String key;

	/**
	 * Creates a new item with text.
	 * @param key item key
	 * @param text item text
	 * @throws NullPointerException if the argument was null or was a collection with null elements
	 * @throws IllegalArgumentException if any text to be added was blank
	 */
	public DescriptionListItem(String key, Object text){
		super(text);
		Validate.notBlank(key);
		this.key = key;
	}

	/**
	 * Creates a new item with text and a child list.
	 * @param key item key
	 * @param text item text
	 * @param list another list
	 * @throws NullPointerException if the argument was null or had null elements
	 */
	public DescriptionListItem(String key, Object text, AsciiList<?, ?, ?> list){
		super(text, list);
		Validate.notBlank(key);
		this.key = key;
	}

	@Override
	public int compareTo(DescriptionListItem o) {
		return this.key.compareTo(o.key);
	}

	/**
	 * Returns the description key.
	 * @return description key
	 */
	public String getKey(){
		return this.key;
	}
}
