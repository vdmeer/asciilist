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

package de.vandermeer.asciilist;

import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.skb.interfaces.categories.has.HasToLog;
import de.vandermeer.skb.interfaces.document.IsList;

/**
 * Standard list item.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 170331 (31-Mar-17) for Java 1.8
 * @since      v0.1.0
 */
public interface AsciiListItem extends HasToLog {

	/**
	 * Returns the item list.
	 * @return item list, null if not set
	 */
	IsList getList();

	/**
	 * Returns the raw text of the item, excessive white spaces removed
	 * @return raw text
	 */
	default String getRawText(){
		return this.getText().toString().replaceAll("\\s+", " ");
	}

	/**
	 * Returns the item text.
	 * @return item text, null if not set
	 */
	StrBuilder getText();

	/**
	 * Tests if the item contains another list.
	 * @return true if the item contains another list, false otherwise
	 */
	default boolean hasList(){
		return (this.getList()==null)?false:true;
	}
}
