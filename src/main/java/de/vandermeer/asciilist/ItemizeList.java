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

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import de.vandermeer.asciilist.styles.ListStyle;
import de.vandermeer.asciilist.styles.ListStyle_ItemizeNested;
import de.vandermeer.asciilist.styles.NestedItemizeStyles;

/**
 * Abstract implementation of an itemize list {@link AsciiList_Itemize}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160306 (06-Mar-16) for Java 1.7
 * @since      v0.2.2
 */
public class ItemizeList extends AbstractAsciiList implements AsciiList_Itemize {

	/** The style for list items. */
	protected ListStyle_ItemizeNested style;

	/**
	 * Creates a new itemize list.
	 */
	public ItemizeList(){
		this(true);
	}

	/**
	 * Creates a new itemize list.
	 * @param isContinued true if continued from previous list of same type, false otherwise
	 */
	public ItemizeList(boolean isContinued){
		super(isContinued);
		this.style = NestedItemizeStyles.ALL_STAR;
	}

	/**
	 * Creates a new itemize list.
	 * @param list original list
	 */
	public ItemizeList(ItemizeList list){
		super(list);
		this.style = list.style;
	}

	@Override
	public AsciiList_Itemize addItem(AsciiList list) {
		Validate.notEmpty(list.getItems());
		AsciiList add = list.copy();
		this.items.add(add);
		return this;
	}

	@Override
	public void prepareRender() {
		super.prepareRender();
		for(Object obj : this.items){
			if(obj instanceof AsciiList_Itemize){
				if(((AsciiList_Itemize) obj).isContinuedList()){
					((AsciiList_Itemize) obj).setListStyle(this.style);
				}
			}
		}
	}

	@Override
	public String renderItem(AsciiListItem item, int position) {
		return item.render(this.preLabelIndent, this.preLabelStr, this.style.getLabel(this.level), this.postLabelStr, this.postLabelIndent);
	}

	@Override
	public AsciiList_Itemize setListStyle(ListStyle style) {
		if(style instanceof ListStyle_ItemizeNested){
			this.style = (ListStyle_ItemizeNested)style;
		}
		return this;
	}

	@Override
	public AsciiList copy() {
		return new ItemizeList(this);
	}

	@Override
	public int calculateMaxIndentation(AsciiListItem item, int position) {
		return this.preLabelIndent + this.preLabelStr.length() + this.style.getLabel(this.level).length() + this.postLabelStr.length() + this.postLabelIndent;
	}

	@Override
	public AsciiList_Itemize addItem(String item){
		if(!StringUtils.isBlank(item)){
			this.items.add(new AbstractAsciiListItem(item));
		}
		return this;
	}

	@Override
	public AsciiList_Itemize addAllItems(Collection<String> items){
		if(items!=null){
			for(String s : items){
				this.addItem(s);
			}
		}
		return this;
	}
}
