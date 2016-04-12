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

import de.vandermeer.asciilist.AbstractAsciiList;
import de.vandermeer.asciilist.AsciiList;
import de.vandermeer.skb.interfaces.strategies.collections.IsSetStrategy;

/**
 * An checklist.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public class Checklist extends AbstractAsciiList<ChecklistContext, ChecklistItem, ChecklistRenderer> {

	/**
	 * Creates a new checklist list with a linked hash set for list items.
	 */
	public Checklist(){
		this(null, null);
	}

	/**
	 * Creates a new checklist list with a linked hash set for list items.
	 * @param ctx list context, using default if null
	 */
	public Checklist(ChecklistContext ctx){
		this(ctx, null);
	}

	/**
	 * Creates a new checklist list with a sorted set for the list items.
	 * @param strategy the list strategy to be used for the list of items
	 */
	public Checklist(IsSetStrategy<?, ChecklistItem> strategy){
		this(null, strategy);
	}

	/**
	 * Creates a new checklist list.
	 * @param ctx list context, using default if null
	 * @param strategy the list strategy to be used for the list of items
	 */
	public Checklist(ChecklistContext ctx, IsSetStrategy<?, ChecklistItem> strategy){
		super(ctx, strategy);
		this.renderer = new ChecklistRenderer();
	}

	/**
	 * Adds a new item to the list.
	 * @param text item text
	 * @param isChecked the checked status, true if checked, false otherwise
	 * @return this to allow chaining
	 */
	public Checklist addItem(Object text, boolean isChecked){
		this.getItems().add(new ChecklistItem(text, isChecked));
		return this;
	}

	/**
	 * Adds a new item to the list and a child list.
	 * @param text item text
	 * @param isChecked the checked status, true if checked, false otherwise
	 * @param list another list
	 * @return this to allow chaining
	 */
	public Checklist addItem(Object text, boolean isChecked, AsciiList<?, ?, ?> list){
		this.getItems().add(new ChecklistItem(text, isChecked, list));
		return this;
	}

	@Override
	public ChecklistContext getNewContext() {
		return new ChecklistContext();
	}

}
