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

import de.vandermeer.asciilist.AbstractAsciiList;
import de.vandermeer.asciilist.AsciiList;
import de.vandermeer.skb.interfaces.strategies.collections.IsSetStrategy;

/**
 * An enumerate list.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public class EnumerateList extends AbstractAsciiList<EnumerateListContext, EnumerateListItem, EnumerateListRenderer> {

	/**
	 * Creates a new enumerate list with a linked hash set for list items.
	 */
	public EnumerateList(){
		this(null, null);
	}

	/**
	 * Creates a new enumerate list with a linked hash set for list items.
	 * @param ctx list context, using default if null
	 */
	public EnumerateList(EnumerateListContext ctx){
		this(ctx, null);
	}

	/**
	 * Creates a new enumerate list with a sorted set for the list items.
	 * @param strategy the list strategy to be used for the list of items
	 */
	public EnumerateList(IsSetStrategy<?, EnumerateListItem> strategy){
		this(null, strategy);
	}

	/**
	 * Creates a new enumerate list.
	 * @param ctx list context, using default if null
	 * @param strategy the list strategy to be used for the list of items
	 */
	public EnumerateList(EnumerateListContext ctx, IsSetStrategy<?, EnumerateListItem> strategy){
		super(ctx, strategy);
		this.renderer = new EnumerateListRenderer();
	}

	/**
	 * Adds a new item to the list.
	 * @param text item text
	 * @return this. to allow chaining
	 */
	public EnumerateList addItem(Object text){
		this.getItems().add(new EnumerateListItem(text));
		return this;
	}

	/**
	 * Adds a new item to the list.
	 * @param text item text
	 * @param list a child list
	 * @return this. to allow chaining
	 */
	public EnumerateList addItem(Object text, AsciiList<?, ?, ?> list){
		this.getItems().add(new EnumerateListItem(text, list));
		return this;
	}

	@Override
	public EnumerateListContext getNewContext() {
		return new EnumerateListContext();
	}

	/**
	 * Applies the theme by setting parameters in the given context.
	 * @param theme the theme to apply
	 * @return this to allow chaining
	 */
	public EnumerateList applyTheme(EnumerateListTheme theme){
		if(theme!=null){
			theme.apply(this.ctx);
		}
		return this;
	}
}
