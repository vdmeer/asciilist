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

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.skb.interfaces.document.IsDocumentElement;
import de.vandermeer.skb.interfaces.transformers.Object_To_StrBuilder;

/**
 * Fully functional abstract implementation of {@link AsciiListItem}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.5 build 170502 (02-May-17) for Java 1.8
 * @since      v0.1.0
 */
public abstract class AbstractAsciiListItem implements AsciiListItem {

	/** The item text if it is not another list. */
	protected StrBuilder text;

	/** The item list, if it is not text. */
	protected AsciiList<?, ?, ?> list;

	/**
	 * Creates a new item with text.
	 * @param text item text
	 * @throws NullPointerException if the argument was null or was a collection with null elements
	 * @throws IllegalArgumentException if any text to be added was blank
	 */
	public AbstractAsciiListItem(Object text){
		Validate.notNull(text);
		this.text = new StrBuilder();
		this.setText(text);
		this.list = null;
	}

	/**
	 * Creates a new item with text and a child list.
	 * @param text item text
	 * @param list another list
	 * @throws NullPointerException if the argument was null or had null elements
	 */
	public AbstractAsciiListItem(Object text, AsciiList<?, ?, ?> list){
		this(text);
		Validate.notNull(list);
		this.list = list;
	}

	/**
	 * Returns the item list.
	 * @return item list, null if not set
	 */
	public AsciiList<?, ?, ?> getList(){
		return this.list;
	}

	/**
	 * Returns the raw text of the item, excessive white spaces removed
	 * @return raw text
	 */
	public String getRawText(){
		return this.text.toString().replaceAll("\\s+", " ");
	}

	/**
	 * Returns the item text.
	 * @return item text, null if not set
	 */
	public StrBuilder getText(){
		return this.text;
	}

	/**
	 * Tests if the item contains another list.
	 * @return true if the item contains another list, false otherwise
	 */
	public boolean hasList(){
		return (this.list==null)?false:true;
	}

	/**
	 * Adds text to the list using {@link Object_To_StrBuilder}.
	 * The method works as follows:
	 * 
	 * - test object for being a {@link IsDocumentElement}, throw illegal argument exception if that's the case,
	 * - otherwise use {@link Object_To_StrBuilder}.
	 * 
	 * Null objects in clusters are silently ignored.
	 * Blank strings are processed like any other string (they do not impact the text anyway).
	 * 
	 * The method is recursive for iterators, iterables, and arrays.
	 * Care needs to be taken that the provided clusters do not lead to endless loops.
	 * 
	 * @param obj object with text for the list
	 * @throws NullPointerException if the argument was null
	 * @throws IllegalArgumentException if the argument was blank
	 */
	protected void setText(Object obj){
		Validate.notNull(obj);
		if((obj instanceof IsDocumentElement)){
			throw new IllegalArgumentException("cannot add " + obj.getClass().getSimpleName() + " as text to a list");
		}

		this.text.appendSeparator(' ').append(Object_To_StrBuilder.convert(obj));
	}

	@Override
	public StrBuilder toLog() {
		StrBuilder ret = new StrBuilder();
		if(this.hasList()){
			ret
				.append("List item: [")
				.append(this.list.getClass().getSimpleName())
				.append('/')
				.append(this.list.getContext().getLevel())
				.append("] - text == ")
				.append(this.getRawText())
			;
			for(AsciiListItem i : this.list.getItems()){
				ret
					.appendNewLine()
					.appendPadding(this.list.getContext().getLevel() * 2, ' ')
					.append("- ")
					.append(i.toLog())
				;
			}
		}
		else{
			ret
				.append("Text item: ")
				.append(this.getRawText())
			;
		}
		return ret;
	}
}
