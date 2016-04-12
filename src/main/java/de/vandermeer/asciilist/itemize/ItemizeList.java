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

package de.vandermeer.asciilist.itemize;

import de.vandermeer.asciilist.AbstractAsciiList;
import de.vandermeer.asciilist.AsciiList;
import de.vandermeer.skb.interfaces.strategies.collections.IsSetStrategy;

/**
 * An itemize list.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public class ItemizeList extends AbstractAsciiList<ItemizeListContext, ItemizeListItem, ItemizeListRenderer> {

	/**
	 * Creates a new itemize list with a linked hash set for list items.
	 */
	public ItemizeList(){
		this(null, null);
	}

	/**
	 * Creates a new itemize list with a linked hash set for list items.
	 * @param ctx list context, using default if null
	 */
	public ItemizeList(ItemizeListContext ctx){
		this(ctx, null);
	}

	/**
	 * Creates a new itemize list with a sorted set for the list items.
	 * @param strategy the list strategy to be used for the list of items
	 */
	public ItemizeList(IsSetStrategy<?, ItemizeListItem> strategy){
		this(null, strategy);
	}

	/**
	 * Creates a new itemize list.
	 * @param ctx list context, using default if null
	 * @param strategy the list strategy to be used for the list of items
	 */
	public ItemizeList(ItemizeListContext ctx, IsSetStrategy<?, ItemizeListItem> strategy){
		super(ctx, strategy);
		this.renderer = new ItemizeListRenderer();
	}

	/**
	 * Adds a new item to the list.
	 * @param text the item text
	 * @return this to allow chaining
	 */
	public ItemizeList addItem(Object text){
		this.getItems().add(new ItemizeListItem(text));
		return this;
	}

	/**
	 * Adds a new item to the list.
	 * @param text the item text
	 * @param list a child list
	 * @return this to allow chaining
	 */
	public ItemizeList addItem(Object text, AsciiList<?, ?, ?> list){
		this.getItems().add(new ItemizeListItem(text, list));
		return this;
	}

	@Override
	public ItemizeListContext getNewContext() {
		return new ItemizeListContext();
	}

	/**
	 * Applies the theme by setting parameters in the given context.
	 * @param theme the theme to apply
	 * @return this to allow chaining
	 */
	public ItemizeList applyTheme(ItemizeListTheme theme){
		if(theme!=null){
			theme.apply(this.ctx);
		}
		return this;
	}
}
