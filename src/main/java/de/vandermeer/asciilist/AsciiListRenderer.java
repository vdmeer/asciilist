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

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.skb.interfaces.document.IsListRenderer;

/**
 * List renderer interface.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 170331 (31-Mar-17) for Java 1.8
 * @since      v0.1.0
 */
public interface AsciiListRenderer<I extends AsciiListItem, C extends AsciiListContext> extends IsListRenderer {

	/**
	 * Renders an {@link AsciiList}.
	 * Each line will have text according to width.
	 * Any padding (left or right) and start/end strings will add to the line width.
	 * To use a calculated width for rendering use one of the other render methods.
	 * @param items the set of items to render
	 * @param ctx context of the original list with relevant settings
	 * @return collection of lines, each as a {@link StrBuilder}
	 */
	default Collection<StrBuilder> render(Set<I> items, C ctx){
		Validate.notNull(items);
		Validate.notNull(ctx);
		return this.render(items, ctx, ctx.getWidth());
	}

	/**
	 * Renders an {@link AsciiList}.
	 * Each line will have text according to width.
	 * Any padding (left or right) and start/end strings will add to the line width.
	 * To use a calculated width for rendering use one of the other render methods.
	 * @param items the set of items to render
	 * @param ctx context of the original list with relevant settings
	 * @param width maximum line width, excluding any extra strings and paddings
	 * @return collection of lines, each as a {@link StrBuilder}
	 */
	Collection<StrBuilder> render(Set<I> items, C ctx, int width);
}
