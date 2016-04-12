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

package de.vandermeer.asciilist;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.asciithemes.TA_Frame;
import de.vandermeer.skb.interfaces.document.IsListContext;
import de.vandermeer.skb.interfaces.translators.CharacterTranslator;
import de.vandermeer.skb.interfaces.translators.HtmlElementTranslator;
import de.vandermeer.skb.interfaces.translators.TargetTranslator;

/**
 * Context for an {@link AsciiList}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public abstract class AL_Context <C extends AL_CtxtCharacters, I extends AL_CtxtIndents, M extends AL_CtxtMargins, S extends AL_CtxtStrings> implements IsListContext {

	/** List margins. */
	protected M margins;

	/** List characters. */
	protected C characters;

	/** List indentations. */
	protected I indents;

	/** List strings. */
	protected S strings;

	/** List converters. */
	protected AL_CtxtConverters converters;

	/** List alignment, default is {@link AL_Alignment#JUSTIFIED_LEFT}. */
	protected AL_Alignment alignment = AL_Alignment.JUSTIFIED_LEFT;

	/** The width of the paragraph, actual width depends on padding settings, default is `80`. */
	protected int width = 80;

	/** The theme for a frame. */
	protected TA_Frame frame = null;

	/** The mode for a frame. */
	protected int frameMode = TA_Frame.THEME_FULL_FRAME;

	/** The level of this list in the context of other lists, default is 1, cannot be smaller than 1. */
	protected int level = 1;

	/** The index of all parents for a nested list. */
	protected int[] parentIndex;

	/**
	 * Creates a new paragraph context with default settings.
	 */
	public AL_Context(){
		this.init();
	}

	/**
	 * Copies all settings from the given object.
	 * @param ctx the object to copy settings from
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> copySettings(AL_Context<?, ?, ?, ?> ctx){
		this.alignment = ctx.alignment;
		this.width = ctx.width;
		this.frame = ctx.frame;
		this.frameMode = ctx.frameMode;
		this.level = ctx.level;
		this.parentIndex = ArrayUtils.clone(ctx.parentIndex);

		this.characters.copySettings(ctx.getCharacters());
		this.indents.copySettings(ctx.getIndents());
		this.margins.copySettings(ctx.getMargins());
		this.strings.copySettings(ctx.getStrings());
		this.converters = ctx.converters.getCopy();

		return this;
	}

	/**
	 * Returns the set alignment.
	 * @return paragraph alignment
	 */
	public AL_Alignment getAlignment(){
		return this.alignment;
	}

	/**
	 * Returns a calculated item label string, item label plus all margins and indentations.
	 * Calculated means that the returned item string is using default values.
	 * The return can be used to calculate nested indentations, but not as an actual item string.
	 * To get an actual item string, use {@link #getItemString(ListItem, int)}.
	 * @return calculated item label string
	 */
	public StrBuilder getCalculatedItemString(){
		return this.getItemString(null, 0);
	}

	/**
	 * Returns the context's characters object.
	 * @return characters object
	 */
	protected C getCharacters() {
		return this.characters;
	}

	/**
	 * Returns the character translator
	 * @return character translator
	 */
	public CharacterTranslator getCharTranslator() {
		return this.converters.charTranslator;
	}

	/**
	 * Returns the paragraph frame.
	 * @return frame, null if not set
	 */
	public TA_Frame getFrame() {
		return this.frame;
	}

	/**
	 * Returns the set frame mode.
	 * @return frame mode
	 */
	public int getFrameMode() {
		return frameMode;
	}

	/**
	 * Returns the HTML entity translator.
	 * @return HTML entity
	 */
	public HtmlElementTranslator getHtmlElementTranslator() {
		return this.converters.htmlElementTranslator;
	}

	/**
	 * Returns the context's indents object.
	 * @return indents object
	 */
	protected I getIndents() {
		return this.indents;
	}

	/**
	 * Returns the item margin character.
	 * @return item margin character
	 */
	public Character getItemChar() {
		return this.characters.getItem();
	}

	/**
	 * Returns the item margin.
	 * @return item margin
	 */
	public int getItemMargin() {
		return this.margins.getItem();
	}

	/**
	 * Returns the item label string, item label plus all margins and indentations.
	 * @param item the list item for which the string should be returned, can be null to use default settings
	 * @param index the index of the label in the item list, can be null to use default settings
	 * @param <LI> list item type
	 * @return item label string, default if no item is provided
	 */
	public abstract <LI extends ListItem> StrBuilder getItemString(LI item, int index);

	/**
	 * Returns the left label margin character.
	 * @return left label margin character
	 */
	public Character getLabelLeftChar() {
		return this.characters.getLabelLeft();
	}

	/**
	 * Returns the left label margin.
	 * @return left label margin
	 */
	public int getLabelLeftMargin() {
		return this.margins.getLabelLeft();
	}

	/**
	 * Returns the right label margin character.
	 * @return right label margin character
	 */
	public Character getLabelRightChar() {
		return this.characters.getLabelRight();
	}

	/**
	 * Returns the right label margin.
	 * @return right label margin
	 */
	public int getLabelRightMargin() {
		return this.margins.getLabelRight();
	}

	/**
	 * Returns the left label string.
	 * @return left label string, null if not set
	 */
	public String getLeftLabelString() {
		return this.strings.getLeftLabel();
	}

	/**
	 * Returns the level of the list.
	 * @return list level, one if top list, greater than one if it is a nested list
	 */
	public int getLevel(){
		return this.level;
	}

	/**
	 * Returns the list end string
	 * @return list end string
	 */
	public String getListEnd() {
		return this.strings.listEnd;
	}

	/**
	 * Returns the list start string
	 * @return list start string
	 */
	public String getListStart() {
		return this.strings.listStart;
	}

	/**
	 * Returns the context's margin object.
	 * @return margin object
	 */
	protected M getMargins() {
		return this.margins;
	}

	/**
	 * Returns the parent index array.
	 * @return parent index array
	 */
	public int[] getParentIndex(){
		return this.parentIndex;
	}

	/**
	 * Returns the right label string.
	 * @return right label string, null if not set
	 */
	public String getRightLabelString() {
		return this.strings.getRightLabel();
	}

	/**
	 * Returns the context's strings object.
	 * @return strings object
	 */
	protected S getStrings() {
		return this.strings;
	}

	/**
	 * Returns the target translator.
	 * @return target translator, null if not set
	 */
	public TargetTranslator getTargetTranslator() {
		return this.converters.targetTranslator;
	}

	/**
	 * Returns the left text margin character.
	 * @return left text margin character
	 */
	public Character getTextLeftChar() {
		return this.characters.getTextLeft();
	}

	/**
	 * Returns the left text margin.
	 * @return left text margin
	 */
	public int getTextLeftMargin() {
		return this.margins.getTextLeft();
	}

	/**
	 * Returns the right text margin character.
	 * @return right text margin character
	 */
	public Character getTextRightChar() {
		return this.characters.getTextRight();
	}

	/**
	 * Returns the right text margin.
	 * @return right text margin
	 */
	public int getTextRightMargin() {
		return this.margins.getTextRight();
	}

	/**
	 * Returns the width of item text calculated using the currently set width.
	 * @return text width
	 */
	public int getTextWidth(){
		return this.getTextWidth(this.width);
	}

	/**
	 * Returns the width of item text calculated for the given width.
	 * @param width the maximum width for the list
	 * @return text width
	 */
	public int getTextWidth(int width){
		return (width - this.getCalculatedItemString().length());
	}

	/**
	 * Returns the paragraph width.
	 * @return paragraph width
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Inherit settings from another context.
	 * @param ctx the context to inherit settings from
	 * @return self to allow chaining
	 */
	public abstract AL_Context<?, ?, ?, ?> inheritSettings(AL_Context<?, ?, ?, ?> ctx);

	/**
	 * Sets all converters, margins, characters, indentations, and strings to default values.
	 */
	public void init(){
		this.converters = new AL_CtxtConverters();
		this.parentIndex = null;
	}

	/**
	 * Sets the paragraph alignment.
	 * @param alignment set alignment
	 * @throws NullPointerException if the argument was null
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setAlignment(AL_Alignment alignment){
		Validate.notNull(alignment);
		this.alignment = alignment;
		return this;
	}

	/**
	 * Sets the character translator.
	 * It will also remove any other translator set.
	 * Nothing will happen if the argument is null.
	 * @param charTranslator translator
	 */
	public void setCharTranslator(CharacterTranslator charTranslator) {
		this.converters.setCharTranslator(charTranslator);
	}

	/**
	 * Sets the paragraph frame.
	 * @param frame new frame, null to reset
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setFrame(TA_Frame frame) {
		this.frame = frame;
		return this;
	}

	/**
	 * Sets the frame mode.
	 * @param frameMode new frame mode, only used if 0 or positive integer
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setFrameMode(int frameMode) {
		if(frameMode>=0){
			this.frameMode = frameMode;
		}
		return this;
	}

	/**
	 * Sets the HTML entity translator.
	 * It will also remove any other translator set.
	 * Nothing will happen if the argument is null.
	 * @param htmlElementTranslator translator
	 */
	public void setHtmlElementTranslator(HtmlElementTranslator htmlElementTranslator) {
		this.converters.setHtmlElementTranslator(htmlElementTranslator);
	}

	/**
	 * Sets the item margin character.
	 * @param c new item margin character, ignored if null
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setItemChar(Character c) {
		this.characters.setItem(c);
		return this;
	}

	/**
	 * Sets the item margin.
	 * @param margin new item margin, ignored if negative
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setItemMargin(int margin) {
		this.margins.setItem(margin);
		return this;
	}

	/**
	 * Sets the left label margin character.
	 * @param c new left label margin character, ignored if null
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setLabelLeftChar(Character c) {
		this.characters.setLabelLeft(c);
		return this;
	}

	/**
	 * Sets the left label margin.
	 * @param margin new left label margin, ignored if negative
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setLabelLeftMargin(int margin) {
		this.margins.setLabelLeft(margin);
		return this;
	}

	/**
	 * Sets the right label margin character.
	 * @param c new right label margin character, ignored if null
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setLabelRightChar(Character c) {
		this.characters.setLabelRight(c);
		return this;
	}

	/**
	 * Sets the right label margin.
	 * @param margin new right label margin, ignored if negative
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setLabelRightMargin(int margin) {
		this.margins.setLabelRight(margin);
		return this;
	}

	/**
	 * Sets the left label string.
	 * @param leftLabel left label string, null is ok
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setLeftLabelString(String leftLabel) {
		this.strings.setLeftLabel(leftLabel);
		return this;
	}

	/**
	 * Sets the level of the list.
	 * @param level new list level, should only be used if 2 or larger (nested list) using 1 as default
	 * @return self to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setLevel(int level){
		if(level>1){
			this.level = level;
		}
		return this;
	}

	/**
	 * Sets the list end string
	 * @param listEnd new list end string, null and blank are ok
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setListEnd(String listEnd) {
		this.strings.setListEnd(listEnd);
		return this;
	}

	/**
	 * Sets the list start string
	 * @param listStart new list start string, null and blank are ok
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setListStart(String listStart) {
		this.strings.setListStart(listStart);
		return this;
	}

	/**
	 * Sets the parent index array
	 * @param parentIndex parent index array
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setParents(int[] parentIndex){
		Validate.notNull(parentIndex);
		this.parentIndex = parentIndex;
		return this;
	}

	/**
	 * Sets the right label string.
	 * @param rightLabel right label string, null is ok
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setRightLabelString(String rightLabel) {
		this.strings.setRightLabel(rightLabel);
		return this;
	}

	/**
	 * Sets the target translator.
	 * It will also remove any other translator set.
	 * Nothing will happen if the argument is null.
	 * @param targetTranslator translator
	 */
	public void setTargetTranslator(TargetTranslator targetTranslator) {
		this.converters.setTargetTranslator(targetTranslator);
	}

	/**
	 * Sets the left text margin character.
	 * @param c new left text margin character, ignored if null
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setTextLeftChar(Character c) {
		this.characters.setTextLeft(c);
		return this;
	}

	/**
	 * Sets the left text margin.
	 * @param margin new left text margin, ignored if negative
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setTextLeftMargin(int margin) {
		this.margins.setTextLeft(margin);
		return this;
	}

	/**
	 * Sets the right text margin character.
	 * @param c new right text margin character, ignored if null
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setTextRightChar(Character c) {
		this.characters.setTextRight(c);
		return this;
	}

	/**
	 * Sets the right text margin.
	 * @param margin new right text margin, ignored if negative
	 * @return this to allow chaining
	 */
	public AL_Context<?, ?, ?, ?> setTextRightMargin(int margin) {
		this.margins.setTextRight(margin);
		return this;
	}

	/**
	 * Sets the paragraph width.
	 * @param width new width
	 * @return this to allow chaining
	 * @throws IllegalStateException if the resulting text width was smaller than 3
	 */
	public AL_Context<?, ?, ?, ?> setWidth(int width) {
		this.width = width;
		return this;
	}
}
