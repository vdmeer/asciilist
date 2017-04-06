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

import org.apache.commons.lang3.StringUtils;

import de.vandermeer.asciilist.styles.ListStyle;

/**
 * Abstract implementation of a description list {@link AsciiList_Description}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v1.0.0 build 170404 (04-Apr-17) for Java 1.7
 * @since      v0.0.2
 */
public class DescriptionList extends AbstractAsciiList implements AsciiList_Description {

	/** Flag directing the lists render behavior, true for single line, false for multiline, default is single line. */
	protected boolean useSingleLine;

	/** The indentation to be used if lines of the description need to be wrapped, default is 5. */
	protected int wrappedLineIndentation;

	public DescriptionList(){
		this.useSingleLine = true;
		this.preLabelIndent = 0;
		this.postLabelStr = ":";
		this.wrappedLineIndentation = 3;
	}

	@Override
	public AsciiList copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calculateMaxIndentation(AsciiListItem item, int position) {
		return this.wrappedLineIndentation;
	}

	@Override
	public String renderItem(AsciiListItem item, int position) {
		if(item instanceof DescriptionListItem){
			return ((DescriptionListItem)item).render(this.preLabelIndent, this.preLabelStr, this.postLabelStr, this.postLabelIndent, this.useSingleLine);
		}
		return null;
	}

	@Override
	public AsciiList_Description useSingleLine(boolean flag) {
		this.useSingleLine = flag;
		return this;
	}

	@Override
	public AsciiList_Description addItem(String term, String description) {
		if(!StringUtils.isBlank(term) && !StringUtils.isBlank(description)){
			this.items.add(new DescriptionListItem(term, description));
		}
		return this;
	}

	@Override
	public AsciiList_Description setWrappedLineIndentation(int indentation) {
		this.wrappedLineIndentation = indentation;
		return this;
	}

	@Override
	public int getWrappedLineIndentation() {
		return this.wrappedLineIndentation;
	}

	@Override
	public AsciiList setListStyle(ListStyle style) {
		// TODO Auto-generated method stub
		return null;
	}

}
