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

import de.vandermeer.asciithemes.a7.A7_ItemizeLists;
import de.vandermeer.skb.interfaces.translators.target.Text2Latex;

/**
 * Collection of themes for an {@link ItemizeList}.
 * Simply use the {@link ItemizeList#applyTheme(ItemizeListTheme)} method and render it.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.5 build 170502 (02-May-17) for Java 1.8
 * @since      v0.1.0
 */
public interface Il_Themes {

	/**
	 * A theme for LaTeX target.
	 * @return the theme
	 */
	static ItemizeListTheme latex(){
		return new ItemizeListTheme() {
			@Override
			public void apply(ItemizeListContext ctx) {
				ctx.setTargetTranslator(Text2Latex.create());
				ctx.setListStart("\\begin{itemize}");
				ctx.setListEnd("\\end{itemize}");
				ctx.setStyle(A7_ItemizeLists.allBlank());
				ctx.setLeftLabelString("\\item");
				ctx.setItemMargin(4);
				ctx.setLabelRightMargin(0);
				ctx.setTextLeftMargin(0);
			}
		};
	}

}
