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

import org.apache.commons.lang3.text.StrBuilder;

/**
 * Implementation of {@link AsciiListItem} for a description list.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160306 (06-Mar-16) for Java 1.7
 * @since      v0.0.2
 */
public class DescriptionListItem extends AbstractAsciiListItem {

	/** The term of a description. */
	protected final Object term;

	/**
	 * Creates a new list item
	 * @param content the content for the new list item
	 * @param checked flag to indicate if the item is checked (true) or not (false)
	 * @throws IllegalArgumentException if the content or the content toString was empty
	 * @throws NullPointerException if the content toString was null
	 */

	/**
	 * Creates a new description item with term and description.
	 * @param term the description term
	 * @param description the term description
	 */
	public DescriptionListItem(final Object term, final Object description){
		super(description);
		this.term = term;
	}

	/**
	 * Renders the list item, generates a string representation of it.
	 * @param preLabelIndent indentation before the label (and before the pre-label string)
	 * @param preLabelStr a string to be printed after pre-indentation but before the label
	 * @param postLabelStr a string to be printed right after the label but before the post-indentation
	 * @param postLabelIndent indentation after the post-label string (before the actual item content)
	 * @param singleLine flag to render for single line (true) or multiline (false)
	 * @return rendered list item
	 */
	public String render(int preLabelIndent, String preLabelStr, String postLabelStr, int postLabelIndent, boolean singleLine) {
		StrBuilder ret = new StrBuilder(50);

		ret.appendPadding(preLabelIndent, ' ').append(preLabelStr);
		ret.append(this.term);
		ret.append(postLabelStr);

		if(singleLine==false){
			ret.append(AsciiList.IMPLICIT_NEWLINE);
		}

		ret.appendPadding(postLabelIndent, ' ');
		ret.append(this.content);

		return ret.toString();
	}

	/**
	 * Returns the term of the description item.
	 * @return term
	 */
	public Object getTerm(){
		return this.term;
	}

}
