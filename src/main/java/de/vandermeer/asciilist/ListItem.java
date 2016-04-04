package de.vandermeer.asciilist;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.skb.interfaces.categories.has.HasToLog;
import de.vandermeer.skb.interfaces.document.IsDocumentElement;
import de.vandermeer.skb.interfaces.transformers.ObjectToStrBuilder;

public class ListItem implements HasToLog {

	/** The item text if it is not another list. */
	protected StrBuilder text;

	/** Width being used for width-sensitive objects to be added as text. */
	protected int defaultWidth = 80;

	/** The item list, if it is not text. */
	protected AsciiList<?, ?, ?> list;

	/**
	 * Creates a new item with text and a child list.
	 * @param text item text
	 * @param list another list
	 * @param parentClass the class of the parent list
	 * @param parentLevel the level of the parent list
	 * @param itemMargin the current lists item margin
	 * @throws NullPointerException if the argument was null or had null elements
	 */
	public ListItem(Object text, AsciiList<?, ?, ?> list){
		this(text);
		Validate.notNull(list);
		this.list = list;
	}

	/**
	 * Creates a new item with text.
	 * @param text item text
	 * @throws NullPointerException if the argument was null or was a collection with null elements
	 * @throws IllegalArgumentException if any text to be added was blank
	 */
	public ListItem(Object text){
		Validate.notNull(text);
		this.text = new StrBuilder();
		this.setText(text);
		this.list = null;
	}

	/**
	 * Adds text to the paragraph using {@link ObjectToStrBuilder}.
	 * The method works as follows:
	 * 
	 * - test object for being a {@link IsDocumentElement}, throw illegal argument exception if that's the case,
	 * - otherwise use {@link ObjectToStrBuilder}.
	 * 
	 * Null objects in clusters are silently ignored.
	 * Blank strings are processed like any other string (they do not impact the text anyway).
	 * 
	 * The method is recursive for iterators, iterables, and arrays.
	 * Care needs to be taken that the provided clusters do not lead to endless loops.
	 * 
	 * @param obj object with text for the paragraph
	 * @return this to allow chaining
	 * @throws NullPointerException if the argument was null
	 * @throws IllegalArgumentException if the argument was blank
	 */
	public void setText(Object obj){
		Validate.notNull(obj);
		if((obj instanceof IsDocumentElement)){
			throw new IllegalArgumentException("cannot add " + obj.getClass().getSimpleName() + " as text to a paragraph");
		}

		this.text.appendSeparator(' ').append(ObjectToStrBuilder.convert(obj));
	}

	/**
	 * Returns the item list.
	 * @return item list, null if not set
	 */
	public AsciiList<?, ?, ?> getList(){
		return this.list;
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

	@Override
	public StrBuilder toLog() {
		StrBuilder ret = new StrBuilder();
		if(this.hasList()){
			ret
				.append("List item: [")
				.append(this.list.getClass().getSimpleName())
				.append('/')
				.append(this.list.getContext().getLevel())
//				.append("/child=")
//				.append(this.list.getContext().isChild())
//				.append("/parent-same=")
//				.append(this.list.getContext().parentIsSameType())
				.append("] - text == ")
				.append(this.getRawText())
			;
			for(ListItem i : this.list.getItems()){
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

	/**
	 * Returns the raw text of the item, excessive white spaces removed
	 * @return raw text
	 */
	public String getRawText(){
		return this.text.toString().replaceAll("\\s+", " ");
	}
}
