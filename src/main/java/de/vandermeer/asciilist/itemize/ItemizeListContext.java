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

package de.vandermeer.asciilist.itemize;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.asciilist.AbstractAsciiListContext;
import de.vandermeer.asciilist.AsciiListContext;
import de.vandermeer.asciilist.AsciiListItem;
import de.vandermeer.asciithemes.TA_ItemizeList;
import de.vandermeer.asciithemes.a7.A7_ItemizeLists;

/**
 * Context for an itemize list.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public class ItemizeListContext extends AbstractAsciiListContext{

	/** The style for list items. */
	protected TA_ItemizeList style = A7_ItemizeLists.allStarIncremental();

	/** Flag for inhering style from another itemize list if this list is a child, default is true. */
	protected boolean inheritStyle = true;

	/**
	 * Creates a new context object for an itemize lists.
	 */
	public ItemizeListContext(){
		this.init();
	}

	@Override
	public ItemizeListContext copySettings(AsciiListContext ctx) {
		super.copySettings(ctx);
		if(ctx instanceof ItemizeListContext){
			this.style = ((ItemizeListContext)ctx).style;
			this.inheritStyle = ((ItemizeListContext)ctx).inheritStyle;
		}
		return this;
	}

	@Override
	public <LI extends AsciiListItem> StrBuilder getItemString(LI item, int index) {
		StrBuilder ret = new StrBuilder(20);
		ret
			.appendPadding(this.getItemMargin(), this.getItemChar())
			.append(this.getLeftLabelString())
			.appendPadding(this.getLabelLeftMargin(), this.getLabelLeftChar())
			.append(this.getStyle().getLabel(this.getLevel()))
			.appendPadding(this.getLabelRightMargin(), this.getLabelRightChar())
			.append(this.getRightLabelString())
			.appendPadding(this.getTextLeftMargin(), this.getTextLeftChar())
		;
		return ret;
	}

	/**
	 * Returns the list style.
	 * @return list style
	 */
	public TA_ItemizeList getStyle() {
		return this.style;
	}

	@Override
	public AbstractAsciiListContext inheritSettings(AsciiListContext ctx) {
		if(ctx instanceof ItemizeListContext){
			if(this.inheritStyle){
				this.style = ((ItemizeListContext)ctx).style;
			}
		}
		return this;
	}

	@Override
	public void init(){
		super.init();
	}

	/**
	 * Sets the inherit-style flag.
	 * @param flag true if this list should inherit style (if it is a child list), false otherwise
	 * @return this to allow chaining
	 */
	public ItemizeListContext setInheritStyle(boolean flag){
		this.inheritStyle = flag;
		return this;
	}

	/**
	 * Sets the list style.
	 * @param style new style
	 * @return this to allow chaining
	 * @throws NullPointerException if style was null
	 */
	public ItemizeListContext setStyle(TA_ItemizeList style) {
		Validate.notNull(style);
		this.style = style;
		return this;
	}
}
