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

package de.vandermeer.asciilist.builder;

import de.vandermeer.asciilist.itemize.ItemizeList;
import de.vandermeer.asciilist.itemize.ItemizeListContext;
import de.vandermeer.asciilist.itemize.ItemizeListItem;
import de.vandermeer.skb.interfaces.strategies.collections.IsSetStrategy;

/**
 * The itemize list builder.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.1.0
 */
public class ItemizeListBuilder extends Lb<ItemizeList> {

	public ItemizeListBuilder(){
		this(null, null);
	}

	public ItemizeListBuilder(ItemizeListContext ctx){
		this(ctx, null);
	}

	public ItemizeListBuilder(IsSetStrategy<?, ItemizeListItem> strategy){
		this(null, strategy);
	}

	public ItemizeListBuilder(ItemizeListContext ctx, IsSetStrategy<?, ItemizeListItem> strategy){
		this.list = new ItemizeList(ctx, strategy);
	}

	protected ItemizeListBuilder(Lb<?> builder){
		this();
		this.parrentBuilder = builder;
	}

	public ItemizeListBuilder item(Object text){
		if(this.currentItem!=null && this.currentBuilder==null){
			this.list.addItem(this.currentItem);
		}
		else if(this.currentItem!=null && this.currentBuilder!=null){
			this.list.addItem(this.currentItem, this.currentBuilder.get());
			this.currentBuilder = null;
		}
		this.currentItem = text;
		return this;
	}

	public ItemizeListBuilder withItemizeList(){
		this.currentBuilder = new ItemizeListBuilder(this);
		return (ItemizeListBuilder)this.currentBuilder;
	}

	public ItemizeListBuilder endItemize(){
		this.item(null);
		if(this.parrentBuilder!=null && (this.parrentBuilder instanceof ItemizeListBuilder)){
			return (ItemizeListBuilder)this.parrentBuilder;
		}
		else if(this.parrentBuilder!=null){
			throw new IllegalThreadStateException("end itemize called without a start itemze");
		}
		return this;
	}

	@Override
	public ItemizeList get(){
		if(this.currentBuilder!=null || this.currentItem !=null){
			this.endItemize();
		}
		return this.list;
	}
}
