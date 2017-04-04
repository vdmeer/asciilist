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

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import de.vandermeer.asciilist.styles.ListStyle;
import de.vandermeer.asciilist.styles.ListStyle_EnumerateNested;
import de.vandermeer.asciilist.styles.NestedEnumerateStyles;


/**
 * Abstract implementation of an enumerate list {@link AsciiList_Enumerate}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v1.0.0 build 170331 (31-Mar-17) for Java 1.7
 * @since      v0.0.1
 */
public class EnumerateList extends AbstractAsciiList implements AsciiList_Enumerate {

	/** The style for list items. */
	protected ListStyle_EnumerateNested style;

	/** The levels of the parents for nested enumerate lists 1. - 1.1. - 1.1.1. */
	protected int[] parents;

	/** Flag stating if the list is fully prepared for rendering. */
	protected boolean isPrepared = false;

	/** The real position that is the position number an item belongs to, allowing for sub-lists belonging to an item here. */
	protected int realPosition = 0;

	/** A string to separate labels, default is dot. */
	protected String labelSeparator;

	/** Flag for the use-label-separator-after-last-item behavior. */
	protected boolean useLabelSeparatorAfterLastItem;

	/**
	 * Creates a new enumerate list.
	 */
	public EnumerateList(){
		this(true);
	}

	/**
	 * Creates a new enumerate list.
	 * @param isContinued true if continued from previous list of same type, false otherwise
	 */
	public EnumerateList(boolean isContinued){
		super(isContinued);
		this.style = NestedEnumerateStyles.aLL_arabic_ascii;
		this.labelSeparator = ".";
		this.useLabelSeparatorAfterLastItem = false;
	}

	/**
	 * Creates a new enumerate list as a copy of the original list.
	 * @param list original list
	 */
	public EnumerateList(EnumerateList list){
		super(list);
		this.style = list.style;
		this.realPosition = list.realPosition;
		this.useLabelSeparatorAfterLastItem = list.useLabelSeparatorAfterLastItem;
		this.labelSeparator = list.labelSeparator;
		this.parents = ArrayUtils.clone(list.parents);
	}

	@Override
	public AsciiList_Enumerate addItem(AsciiList list) {
		Validate.notEmpty(list.getItems());
		AsciiList add = list.copy();
		this.items.add(add);
		return this;
	}

	@Override
	public void prepareRender() {
		super.prepareRender();
		for(Object obj : this.items){
			if(obj instanceof AsciiList_Enumerate){
				if(((AsciiList_Enumerate) obj).isContinuedList()){
					if(((AsciiList_Enumerate) obj).isPrepared()==false){
						this.realPosition++;
						((AsciiList_Enumerate) obj).setListStyle(this.style);
						if(this.parents==null){
							((AsciiList_Enumerate) obj).setParents(new int[]{this.items.size()-this.realPosition});
						}
						else{
							((AsciiList_Enumerate) obj).setParents(ArrayUtils.add(this.parents, this.items.size()-this.realPosition));
						}
						((AsciiList_Enumerate) obj).setPrepared();
					}
				}
			}
		}
	}

	/**
	 * Calculates and returns the label for a list item.
	 * @param position the position of the item in the list
	 * @return calculated label
	 */
	protected String calculateItemLabel(int position){
		String label = this.style.getStyle(this.level).getLabel(position);
		if(this.parents!=null){
			label = "";
			for(int i=0; i<this.parents.length; i++){
				label += this.style.getStyle(i+1).getLabel(parents[i]) + this.labelSeparator;
			}
			label += this.style.getStyle(this.level).getLabel(position);
		}
		if(this.useLabelSeparatorAfterLastItem==true){
			label += this.labelSeparator;
		}
		return label;
	}

	@Override
	public String renderItem(AsciiListItem item, int position) {
		return item.render(this.preLabelIndent, this.preLabelStr, this.calculateItemLabel(position), this.postLabelStr, this.postLabelIndent);
	}

	@Override
	public AsciiList_Enumerate setParents(int[] parents) {
		this.parents = parents;
		return this;
	}

	@Override
	public int[] getParents() {
		return this.parents;
	}

	@Override
	public AsciiList_Enumerate setListStyle(ListStyle style) {
		if(style instanceof ListStyle_EnumerateNested){
			this.style = (ListStyle_EnumerateNested)style;
		}
		return this;
	}

	@Override
	public AsciiList copy() {
		return new EnumerateList(this);
	}

	@Override
	public AsciiList_Enumerate setLabelSeparator(String separator) {
		this.labelSeparator = separator;
		return this;
	}

	@Override
	public String getLabelSeparator() {
		return this.labelSeparator;
	}

	@Override
	public AsciiList_Enumerate useLabelSeparatorAfterLastItem(boolean flag) {
		this.useLabelSeparatorAfterLastItem = flag;
		return this;
	}

	@Override
	public int calculateMaxIndentation(AsciiListItem item, int position) {
		return this.preLabelIndent + this.preLabelStr.length() + this.calculateItemLabel(position).length() + this.postLabelStr.length() + this.postLabelIndent;
	}

	@Override
	public AsciiList_Enumerate addItem(String item){
		if(!StringUtils.isBlank(item)){
			this.items.add(new AbstractAsciiListItem(item));
		}
		return this;
	}

	@Override
	public AsciiList_Enumerate addAllItems(Collection<String> items){
		if(items!=null){
			for(String s : items){
				this.addItem(s);
			}
		}
		return this;
	}

	@Override
	public boolean isPrepared(){
		return this.isPrepared;
	}

	@Override
	public void setPrepared() {
		this.isPrepared = true;
	}

}
