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

import de.vandermeer.asciilist.AL_Context;
import de.vandermeer.asciilist.AL_CtxtCharacters;
import de.vandermeer.asciilist.AL_CtxtMargins;
import de.vandermeer.asciilist.AL_CtxtStrings;
import de.vandermeer.asciilist.ListItem;

/**
 * Context for a description list.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public class Dl_Context extends AL_Context<AL_CtxtCharacters, Dl_CtxtIndents, AL_CtxtMargins, AL_CtxtStrings>{

	/** Flag directing the lists render behavior, true for single line, false for multiline, default is single line. */
	protected boolean useSameLine;

	/**
	 * Creates a new context object for a description lists.
	 */
	public Dl_Context(){
		this.init();
	}

	@Override
	public Dl_Context copySettings(AL_Context<?, ?, ?, ?> ctx) {
		super.copySettings(ctx);
		if(ctx instanceof Dl_Context){
			this.useSameLine = ((Dl_Context) ctx).useSameLine;
			this.indents.copySettings(((Dl_Context)ctx).indents);
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
		return this.indents.descriptionIndent;
	}

	@Override
	public <LI extends ListItem> StrBuilder getItemString(LI item, int index) {
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
	public AL_Context<?, ?, ?, ?> inheritSettings(AL_Context<?, ?, ?, ?> ctx) {
		if(ctx instanceof Dl_Context){
		}
		return this;
	}

	@Override
	public void init(){
		super.init();
		this.characters = new AL_CtxtCharacters();
		this.indents = new Dl_CtxtIndents();
		this.margins = new AL_CtxtMargins();
		this.strings = new AL_CtxtStrings();
	}

	/**
	 * Sets the description indentation.
	 * @param descriptionIndent new indentation
	 * @return this to allow chaining
	 */
	public Dl_Context setDescriptionIndent(int descriptionIndent) {
		this.indents.setDescriptionIndent(descriptionIndent);
		return this;
	}

	/**
	 * Sets the same line flag.
	 * @param useSameLine true if same line (key and description on same line), false otherwise
	 * @return this to allow chaining
	 */
	public Dl_Context setUseSameLine(boolean useSameLine) {
		this.useSameLine = useSameLine;
		return this;
	}

}
