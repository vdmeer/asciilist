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

import de.vandermeer.asciilist.styles.ListStyle;
import de.vandermeer.asciilist.styles.ListStyle_CheckNested;
import de.vandermeer.asciilist.styles.NestedCheckStyles;

/**
 * Abstract implementation of a checklist {@link AsciiList_Check}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3 build 160301 (01-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public class CheckList extends AbstractAsciiList implements AsciiList_Check {

	/** The style for list items. */
	protected ListStyle_CheckNested style;

	/**
	 * Creates a new check list.
	 */
	public CheckList(){
		this(true);
	}

	/**
	 * Creates a new check list with continue flag.
	 * @param isContinued true if continued from previous list of same type, false otherwise
	 */
	public CheckList(boolean isContinued){
		super(isContinued);
		this.style = NestedCheckStyles.ALL_SQUARE_BRACKET_BLANK_X;
	}

	/**
	 * Creates a new check list as a copy of the original list.
	 * @param list original list
	 */
	public CheckList(CheckList list){
		super(list);
		this.style = list.style;
	}

	@Override
	public AsciiList_Check addItem(String item){
		if(!StringUtils.isBlank(item)){
			this.items.add(new CheckListItem(item, false));
		}
		return this;
	}

	@Override
	public AsciiList_Check addItemChecked(String item){
		if(!StringUtils.isBlank(item)){
			this.items.add(new CheckListItem(item, true));
		}
		return this;
	}

	@Override
	public AsciiList_Check setPreLabel(String preLabel) {
		if(!StringUtils.isBlank(preLabel)){
			this.preLabelStr = preLabel;
		}
		return this;
	}

	@Override
	public AsciiList_Check setPostLabel(String postLabel) {
		if(!StringUtils.isBlank(postLabel)){
			this.postLabelStr = postLabel;
		}
		return this;
	}

	@Override
	public AsciiList_Check setPostIndent(int indent) {
		if(indent>=0){
			this.postLabelIndent = indent;
		}
		return this;
	}

	/**
	 * Calculates and returns the label for a list item.
	 * @param item list item for calculation
	 * @return calculated label
	 */
	protected String calculateItemLabel(AsciiListItem item){
		String label = this.style.getStyle(this.level).getLabelUnchecked();
		if(item instanceof CheckListItem){
			if(((CheckListItem)item).isChecked()){
				label = this.style.getStyle(this.level).getLabelChecked();
			}
		}
		return label;
	}

	@Override
	public String renderItem(AsciiListItem item, int position) {
		return item.render(this.preLabelIndent, this.preLabelStr, this.calculateItemLabel(item), this.postLabelStr, this.postLabelIndent);
	}

	@Override
	public AsciiList_Check setListStyle(ListStyle style) {
		if(style instanceof ListStyle_CheckNested){
			this.style = (ListStyle_CheckNested)style;
		}
		return this;
	}

	@Override
	public AsciiList copy() {
		return new CheckList(this);
	}

	@Override
	public int calculateMaxIndentation(AsciiListItem item, int position) {
		return this.preLabelIndent + this.preLabelStr.length() + this.calculateItemLabel(item).length() + this.postLabelStr.length() + this.postLabelIndent;
	}

	@Override
	public AsciiList_Check addAllItems(Collection<String> items){
		if(items!=null){
			for(String s : items){
				this.addItem(s);
			}
		}
		return this;
	}
}
