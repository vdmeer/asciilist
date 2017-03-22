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
import de.vandermeer.asciithemes.TA_FrameOptions;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import de.vandermeer.skb.interfaces.translators.CharacterTranslator;
import de.vandermeer.skb.interfaces.translators.HtmlElementTranslator;
import de.vandermeer.skb.interfaces.translators.TargetTranslator;

/**
 * Fully functional abstract implementation of {@link AsciiListContext}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public abstract class AbstractAsciiListContext implements AsciiListContext {

	/** List alignment, default is {@link AL_Alignment#JUSTIFIED_LEFT}. */
	protected TextAlignment alignment;

	/** A simple character translator. */
	protected CharacterTranslator charTranslator;

	/** The theme for a frame. */
	protected TA_Frame frame;

	/** The mode for a frame. */
	protected int frameMode;

	/** A translator for HTML elements. */
	protected HtmlElementTranslator htmlElementTranslator;

	/** Item margin character. */
	protected Character itemChar;

	/** Item margin. */
	protected int itemMargin;

	/** Left label margin character. */
	protected Character labelLeftChar;

	/** Left label margin. */
	protected int labelLeftMargin;

	/** Right label margin character. */
	protected Character labelRightChar;

	/** Right label margin. */
	protected int labelRightMargin;

	/** Left label string. */
	protected String leftLabelString;

	/** The level of this list in the context of other lists, default is 1, cannot be smaller than 1. */
	protected int level;

	/** A string to be put after the list ends, on a separate line. */
	protected String listEndString;

	/** A string to be put before the list starts, on a separate line. */
	protected String listStartString;

	/** The index of all parents for a nested list. */
	protected int[] parentIndex;

	/** Left label string. */
	protected String rightLabelString;

	/** A translator for a particular target. */
	protected TargetTranslator targetTranslator;

	/** Left text margin character. */
	protected Character textLeftChar;

	/** Left text margin. */
	protected int textLeftMargin;

	/** Right text margin character. */
	protected Character textRightChar;

	/** Right text margin. */
	protected int textRightMargin;

	/** The width of the paragraph, actual width depends on padding settings, default is `80`. */
	protected int width;

	/**
	 * Creates a new paragraph context with default settings.
	 */
	public AbstractAsciiListContext(){
		this.init();
	}

	/**
	 * Copies all settings from the given object.
	 * @param ctx the object to copy settings from
	 * @return this to allow chaining
	 */
	public AbstractAsciiListContext copySettings(AsciiListContext ctx){
		this.alignment = ctx.getAlignment();
		this.width = ctx.getWidth();
		this.frame = ctx.getFrame();
		this.frameMode = ctx.getFrameMode();
		this.level = ctx.getLevel();
		this.parentIndex = ArrayUtils.clone(ctx.getParentIndex());

		//strings
		this.leftLabelString = ctx.getLeftLabelString();
		this.rightLabelString = ctx.getRightLabelString();
		this.listStartString = ctx.getListStart();
		this.listEndString = ctx.getListEnd();

		//converters
		this.charTranslator = ctx.getCharTranslator();
		this.htmlElementTranslator = ctx.getHtmlElementTranslator();
		this.targetTranslator = ctx.getTargetTranslator();

		//characters
		this.itemChar = ctx.getItemChar();
		this.labelLeftChar = ctx.getLabelLeftChar();
		this.labelRightChar = ctx.getLabelRightChar();
		this.textLeftChar = ctx.getTextLeftChar();
		this.textRightChar = ctx.getTextRightChar();

		//margins
		this.itemMargin = ctx.getItemMargin();
		this.labelLeftMargin = ctx.getLabelLeftMargin();
		this.labelRightMargin = ctx.getLabelRightMargin();
		this.textLeftMargin = ctx.getTextLeftMargin();
		this.textRightMargin = ctx.getTextRightMargin();

		return this;
	}

	@Override
	public TextAlignment getAlignment(){
		return this.alignment;
	}

	@Override
	public StrBuilder getCalculatedItemString(){
		return this.getItemString(null, 0);
	}

	@Override
	public CharacterTranslator getCharTranslator() {
		return this.charTranslator;
	}

	@Override
	public TA_Frame getFrame() {
		return this.frame;
	}

	@Override
	public int getFrameMode() {
		return frameMode;
	}

	@Override
	public HtmlElementTranslator getHtmlElementTranslator() {
		return this.htmlElementTranslator;
	}

	@Override
	public Character getItemChar() {
		return this.itemChar;
	}

	@Override
	public int getItemMargin() {
		return this.itemMargin;
	}

	@Override
	public Character getLabelLeftChar() {
		return this.labelLeftChar;
	}

	@Override
	public int getLabelLeftMargin() {
		return this.labelLeftMargin;
	}

	@Override
	public Character getLabelRightChar() {
		return this.labelRightChar;
	}

	@Override
	public int getLabelRightMargin() {
		return this.labelRightMargin;
	}

	@Override
	public String getLeftLabelString() {
		return this.leftLabelString;
	}

	@Override
	public int getLevel(){
		return this.level;
	}

	@Override
	public String getListEnd() {
		return this.listEndString;
	}

	@Override
	public String getListStart() {
		return this.listStartString;
	}

	@Override
	public int[] getParentIndex(){
		return this.parentIndex;
	}

	@Override
	public String getRightLabelString() {
		return this.rightLabelString;
	}

	@Override
	public TargetTranslator getTargetTranslator() {
		return this.targetTranslator;
	}

	@Override
	public Character getTextLeftChar() {
		return this.textLeftChar;
	}

	@Override
	public int getTextLeftMargin() {
		return this.textLeftMargin;
	}

	@Override
	public Character getTextRightChar() {
		return this.textRightChar;
	}

	@Override
	public int getTextRightMargin() {
		return this.textRightMargin;
	}

	@Override
	public int getTextWidth(){
		return this.getTextWidth(this.width);
	}

	@Override
	public int getTextWidth(int width){
		return (width - this.getCalculatedItemString().length());
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	/**
	 * Inherit settings from another context.
	 * @param ctx the context to inherit settings from
	 * @return self to allow chaining
	 */
	public abstract AbstractAsciiListContext inheritSettings(AsciiListContext ctx);

	@Override
	public void init(){
		this.alignment = TextAlignment.JUSTIFIED_LEFT;
		this.width = 80;
		this.frame = null;
		this.frameMode = TA_FrameOptions.THEME_FULL_FRAME;
		this.level = 1;
		this.parentIndex = null;

		this.leftLabelString = null;
		this.rightLabelString = null;
		this.listStartString = null;
		this.listEndString = null;

		this.charTranslator = null;
		this.htmlElementTranslator = null;
		this.targetTranslator = null;

		this.textLeftChar = ' ';
		this.textRightChar = ' ';
		this.labelLeftChar = ' ';
		this.labelRightChar = ' ';
		this.itemChar = ' ';

		this.textLeftMargin = 1;
		this.textRightMargin = 0;
		this.labelLeftMargin = 0;
		this.labelRightMargin = 0;
		this.itemMargin = 0;
	}

	@Override
	public AsciiListContext setAlignment(TextAlignment alignment){
		Validate.notNull(alignment);
		this.alignment = alignment;
		return this;
	}

	@Override
	public AsciiListContext setCharTranslator(CharacterTranslator charTranslator) {
		if(charTranslator!=null){
			this.charTranslator = charTranslator;
			this.htmlElementTranslator = null;
			this.targetTranslator = null;
		}
		return this;
	}

	@Override
	public AsciiListContext setFrame(TA_Frame frame) {
		this.frame = frame;
		return this;
	}

	@Override
	public AsciiListContext setFrameMode(int frameMode) {
		if(frameMode>=0){
			this.frameMode = frameMode;
		}
		return this;
	}

	@Override
	public AsciiListContext setHtmlElementTranslator(HtmlElementTranslator htmlElementTranslator) {
		if(htmlElementTranslator!=null){
			this.htmlElementTranslator = htmlElementTranslator;
			this.charTranslator = null;
			this.targetTranslator = null;
		}
		return this;
	}

	@Override
	public AsciiListContext setItemChar(Character c) {
		if(c!=null){
			this.itemChar = c;
		}
		return this;
	}

	@Override
	public AsciiListContext setItemMargin(int margin) {
		if(margin>-1){
			this.itemMargin = margin;
		}
		return this;
	}

	@Override
	public AsciiListContext setLabelLeftChar(Character c) {
		if(c!=null){
			this.labelLeftChar = c;
		}
		return this;
	}

	@Override
	public AsciiListContext setLabelLeftMargin(int margin) {
		if(margin>-1){
			this.labelLeftMargin = margin;
		}
		return this;
	}

	@Override
	public AsciiListContext setLabelRightChar(Character c) {
		if(c!=null){
			this.labelRightChar = c;
		}
		return this;
	}

	@Override
	public AsciiListContext setLabelRightMargin(int margin) {
		if(margin>-1){
			this.labelRightMargin = margin;
		}
		return this;
	}

	@Override
	public AsciiListContext setLeftLabelString(String leftLabel) {
		this.leftLabelString = leftLabel;
		return this;
	}

	@Override
	public AsciiListContext setLevel(int level){
		if(level>1){
			this.level = level;
		}
		return this;
	}

	@Override
	public AsciiListContext setListEnd(String listEnd) {
		this.listEndString = listEnd;
		return this;
	}

	@Override
	public AsciiListContext setListStart(String listStart) {
		this.listStartString = listStart;
		return this;
	}

	@Override
	public AsciiListContext setParents(int[] parentIndex){
		Validate.notNull(parentIndex);
		this.parentIndex = parentIndex;
		return this;
	}

	@Override
	public AsciiListContext setRightLabelString(String rightLabel) {
		this.rightLabelString = rightLabel;
		return this;
	}

	@Override
	public AsciiListContext setTargetTranslator(TargetTranslator targetTranslator) {
		if(targetTranslator!=null){
			this.targetTranslator = targetTranslator;
			this.charTranslator = null;
			this.htmlElementTranslator = null;
		}
		return this;
	}

	@Override
	public AsciiListContext setTextLeftChar(Character c) {
		if(c!=null){
			this.textLeftChar = c;
		}
		return this;
	}

	@Override
	public AsciiListContext setTextLeftMargin(int margin) {
		if(margin>-1){
			this.textLeftMargin = margin;
		}
		return this;
	}

	@Override
	public AsciiListContext setTextRightChar(Character c) {
		if(c!=null){
			this.textRightChar = c;
		}
		return this;
	}

	@Override
	public AsciiListContext setTextRightMargin(int margin) {
		if(margin>-1){
			this.textRightMargin = margin;
		}
		return this;
	}

	@Override
	public AsciiListContext setWidth(int width) {
		this.width = width;
		return this;
	}
}
