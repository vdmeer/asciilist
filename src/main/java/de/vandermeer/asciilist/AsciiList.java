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

import java.util.Collection;
import java.util.Set;

import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.skb.interfaces.document.IsList;

/**
 * An ASCII list with some formatting options.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.5 build 170502 (02-May-17) for Java 1.8
 * @since      v0.0.1
 */
public interface AsciiList<C extends AsciiListContext, I extends AsciiListItem, R extends AsciiListRenderer<I, C>> extends IsList {

	/**
	 * Returns the list context.
	 * @return context, null if not set
	 */
	C getContext();

	/**
	 * Returns the items of the list.
	 * @return items of the list
	 */
	public Set<I> getItems();

	/**
	 * Returns a new context for the list
	 * @return new context, cannot be null
	 */
	C getNewContext();

	/**
	 * Renders the list as a child list of another list.
	 * This methods creates a new context object for the rendering process, based on the original context.
	 * @param parentCtx the parent list context
	 * @param parentIndent the parent list indentation
	 * @param parentIndex the index of the parent list item
	 * @return rendered list
	 */
	Collection<StrBuilder> renderAsChild(AsciiListContext parentCtx, int parentIndent, int parentIndex);

	/**
	 * Sets the renderer for the context.
	 * @param renderer new renderer, only set if not null
	 * @return this to allow chaining
	 */
	AsciiList<?, ?, ?> setRenderer(R renderer);
}
