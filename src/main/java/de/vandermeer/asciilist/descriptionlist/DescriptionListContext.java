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

import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.asciilist.AbstractAsciiListContext;
import de.vandermeer.asciilist.AsciiListContext;
import de.vandermeer.asciilist.AsciiListItem;

/**
 * Context for a description list.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4 build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.1.0
 */
public class DescriptionListContext extends AbstractAsciiListContext {

	/** The indentation for the description. */
	protected int descriptionIndent;

	/** Flag directing the lists render behavior, true for single line, false for multiline, default is single line. */
	protected boolean useSameLine;

	/**
	 * Creates a new context object for a description lists.
	 */
	public DescriptionListContext(){
		this.init();
	}

	@Override
	public DescriptionListContext copySettings(AsciiListContext ctx) {
		super.copySettings(ctx);
		if(ctx instanceof DescriptionListContext){
			this.useSameLine = ((DescriptionListContext) ctx).useSameLine;
			this.descriptionIndent = ((DescriptionListContext) ctx).descriptionIndent;
		}
		return this;
	}

	@Override
	public StrBuilder getCalculatedItemString(){
		StrBuilder ret = new StrBuilder(20);
		ret
			.appendPadding(this.getDescriptionIndent(), this.getLabelLeftChar())
		;
		return ret;
	}

	/**
	 * Returns the description indentation.
	 * @return description indentation
	 */
	public int getDescriptionIndent() {
		return this.descriptionIndent;
	}

	@Override
	public <LI extends AsciiListItem> StrBuilder getItemString(LI item, int index) {
		StrBuilder ret = new StrBuilder(20);
		ret
			.appendPadding(this.getItemMargin(), this.getItemChar())
			.append(this.getLeftLabelString())
			.appendPadding(this.getLabelLeftMargin(), this.getLabelLeftChar())
		;

		if(item instanceof DescriptionListItem){
			ret.append(((DescriptionListItem) item).getKey());
		}

		ret
			.appendPadding(this.getLabelRightMargin(), this.getLabelRightChar())
			.append(this.getRightLabelString())
		;

		if(item instanceof DescriptionListItem){
			ret.appendPadding(this.getTextLeftMargin(), this.getTextLeftChar());
		}

		return ret;
	}

	/**
	 * Returns the same line flag.
	 * @return true if same line (key and description on same line), false otherwise
	 */
	public boolean getUseSameLine() {
		return this.useSameLine;
	}

	@Override
	public DescriptionListContext inheritSettings(AsciiListContext ctx) {
		if(ctx instanceof DescriptionListContext){
		}
		return this;
	}

	@Override
	public void init(){
		super.init();
		this.useSameLine = false;
		this.descriptionIndent = 4;
	}

	/**
	 * Sets the description indentation.
	 * @param descriptionIndent new indentation
	 * @return this to allow chaining
	 */
	public DescriptionListContext setDescriptionIndent(int descriptionIndent) {
		if(descriptionIndent>-1){
			this.descriptionIndent = descriptionIndent;
		}
		return this;
	}

	/**
	 * Sets the same line flag.
	 * @param useSameLine true if same line (key and description on same line), false otherwise
	 * @return this to allow chaining
	 */
	public DescriptionListContext setUseSameLine(boolean useSameLine) {
		this.useSameLine = useSameLine;
		return this;
	}

}
