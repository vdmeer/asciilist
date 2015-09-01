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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.asciilist.styles.ListStyle;

/**
 * Abstract implementation as base for the {@link AsciiList} hierarchy.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 150901 (01-Sep-15) for Java 1.7
 * @since      v0.0.1
 */
public abstract class AbstractAsciiList implements AsciiList {

	/** The items of a list. */
	protected List<Object> items;

	/** The indentation before the label (and the pre-label string), default is 1. */
	protected int preLabelIndent = 1;

	/** The indentation after the label (and the post-label string), default is 1. */
	protected int postLabelIndent = 1;

	/** A string printed directly before the label, other than indentation, default is empty string. */
	protected String preLabelStr = "";

	/** A string printed directly after the label, other than indentation, default is empty string. */
	protected String postLabelStr = "";

	/** The level of the list, default is 1. */
	protected int level = 1;

	/** Flag indicating if the list is continued from a previous list of the same type or not. */
	protected final boolean isContinued;

	/**
	 * Creates a new list.
	 */
	public AbstractAsciiList(){
		this(true);
	}

	/**
	 * Creates a new list.
	 * @param isContinued true if the list is continued from a previous list of the same type, false otherwise
	 */
	public AbstractAsciiList(boolean isContinued){
		this.items = new ArrayList<>();
		this.isContinued = isContinued;
	}

	/**
	 * Creates a new list.
	 * @param list original list
	 */
	public AbstractAsciiList(AbstractAsciiList list){
		this(list.isContinued);

		this.preLabelIndent = list.preLabelIndent;
		this.postLabelIndent = list.postLabelIndent;
		this.preLabelStr = list.preLabelStr;
		this.postLabelStr = list.postLabelStr;
		this.level = list.level;

		this.items.addAll(list.items);
	}

	@Override
	public AsciiList addItem(AsciiList list) {
		Validate.notEmpty(list.getItems());
		AsciiList add = list.copy();
		this.items.add(add);
		return add;
	}

	@Override
	public AsciiList addItem(String item){
		if(!StringUtils.isBlank(item)){
			this.items.add(new AbstractAsciiListItem(item));
		}
		return this;
	}

	@Override
	public List<Object> getItems() {
		return this.items;
	}

	@Override
	public int getLevel(){
		return this.level;
	}

	@Override
	public String render(){
		StrBuilder ret = new StrBuilder(100);
		int position = 0;
		for(int i=0; i<this.items.size(); i++){
			if(this.items.get(i) instanceof AsciiListItem){
				position++;
				ret.appendSeparator("\n").append(this.renderItem((AsciiListItem)this.items.get(i), position));
			}
			else if(this.items.get(i) instanceof AsciiList){
				AsciiList l = (AsciiList)this.items.get(i);
				//TODO 1 was label, needs to be calculated label width now
				int indent = this.preLabelIndent + this.postLabelIndent + 1 + this.preLabelStr.length() + this.postLabelStr.length();
				l.setPreLabelIndent(indent);
				ret.appendSeparator("\n").append(l.render());
			}
			else{
				throw new NotImplementedException("not yet implemented, only AsciiListItem supported");//TODO
			}
		}
		return ret.toString();
	}

	@Override
	public AsciiList setLevel(int level){
		if(level>1){
			this.level = level;
		}
		return this;
	}

	@Override
	public AsciiList setListStyle(ListStyle style) {
		for(Object obj : this.items){
			if(obj instanceof AsciiList){
				((AsciiList)obj).setListStyle(style);
			}
		}
		return this;
	}

	@Override
	public AsciiList setPreLabelIndent(int indent) {
		if(indent>-1){
			this.preLabelIndent = indent;
		}
		return this;
	}

	@Override
	public AsciiList setPreLabelString(String str) {
		this.preLabelStr = str;
		return this;
	}

	@Override
	public AsciiList setPostLabelString(String str) {
		this.postLabelStr = str;
		return this;
	}

	@Override
	public AsciiList setPostLabelIndent(int indent) {
		if(indent>-1){
			this.postLabelIndent = indent;
		}
		return this;
	}

	@Override
	public int getPreLabelIndent() {
		return this.preLabelIndent;
	}

	@Override
	public String getPreLabelString() {
		return this.preLabelStr;
	}

	@Override
	public String getPostLabelString() {
		return this.postLabelStr;
	}

	@Override
	public int getPostLabelIndent() {
		return this.postLabelIndent;
	}

	@Override
	public boolean isContinuedList(){
		return this.isContinued;
	}
}