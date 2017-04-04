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

import de.vandermeer.asciilist.AbstractAsciiList;
import de.vandermeer.asciilist.AsciiList;
import de.vandermeer.skb.interfaces.strategies.collections.IsSetStrategy;
import de.vandermeer.skb.interfaces.strategies.collections.sortedset.TreeSetStrategy;

/**
 * A description list.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.1.0
 */
public class DescriptionList extends AbstractAsciiList<DescriptionListContext, DescriptionListItem, DescriptionListRenderer> {

	/**
	 * Creates a new description list with a sorted set for the list items.
	 */
	public DescriptionList(){
		this(null, null);
	}

	/**
	 * Creates a new description list with a sorted set for the list items.
	 * @param ctx list context, using default if null
	 */
	public DescriptionList(DescriptionListContext ctx){
		this(ctx, TreeSetStrategy.create());
	}

	/**
	 * Creates a new description list.
	 * @param strategy the list strategy to be used for the list of items
	 */
	public DescriptionList(IsSetStrategy<?, DescriptionListItem> strategy){
		this(null, strategy);
	}

	/**
	 * Creates a new description list.
	 * @param ctx list context, using default if null
	 * @param strategy the list strategy to be used for the list of items
	 */
	public DescriptionList(DescriptionListContext ctx, IsSetStrategy<?, DescriptionListItem> strategy){
		super(ctx, strategy);
		this.renderer = new DescriptionListRenderer();
	}

	/**
	 * Adds a new item to the list.
	 * @param key the key of the description
	 * @param text description text
	 * @return this to allow chaining
	 */
	public DescriptionList addItem(String key, Object text){
		this.getItems().add(new DescriptionListItem(key, text));
		return this;
	}

	/**
	 * Adds a new item to the list.
	 * @param key the key of the description
	 * @param text description text
	 * @param list a child list
	 * @return this to allow chaining
	 */
	public DescriptionList addItem(String key, Object text, AsciiList<?, ?, ?> list){
		this.getItems().add(new DescriptionListItem(key, text, list));
		return this;
	}

	@Override
	public DescriptionListContext getNewContext() {
		return new DescriptionListContext();
	}

	/**
	 * Applies the theme by setting parameters in the given context.
	 * @param theme the theme to apply
	 * @return this to allow chaining
	 */
	public DescriptionList applyTheme(DescriptionListTheme theme){
		if(theme!=null){
			theme.apply(this.ctx);
		}
		return this;
	}
}
