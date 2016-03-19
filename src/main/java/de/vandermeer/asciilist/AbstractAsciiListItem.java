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

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;

/**
 * Abstract (fully featured) implementation of {@link AsciiListItem}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v1.0.0 build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public class AbstractAsciiListItem implements AsciiListItem {

	/** The actual content of the list item. */
	protected final Object content;

	/**
	 * Creates a new list item
	 * @param content the content for the new list item
	 * @throws IllegalArgumentException if the content or the content toString was empty
	 * @throws NullPointerException if the content toString was null
	 */
	public AbstractAsciiListItem(final Object content){
		if(content==null){
			throw new IllegalArgumentException("content cannot be null");
		}
		Validate.notBlank(content.toString());
		this.content = content;
	}

	@Override
	public String render(int preLabelIndent, String preLabelStr, String label, String postLabelStr, int postLabelIndent) {
		StrBuilder ret = new StrBuilder(50);

		ret.appendPadding(preLabelIndent, ' ').append(preLabelStr);
		ret.append(label);
		ret.append(postLabelStr).appendPadding(postLabelIndent, ' ');
		ret.append(this.content);

		return ret.toString();
	}

	@Override
	public Object getContent() {
		return this.content;
	}

}
