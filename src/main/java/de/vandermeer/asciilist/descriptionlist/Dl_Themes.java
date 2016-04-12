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

package de.vandermeer.asciilist.descriptionlist;

import de.vandermeer.asciilist.AL_Alignment;
import de.vandermeer.translation.targets.Text2Latex;

/**
 * Collection of themes for an {@link DescriptionList}.
 * Simply use the {@link DescriptionList#applyTheme(DescriptionListTheme)} method and render it.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public interface Dl_Themes {

	/**
	 * A theme for LaTeX target.
	 * @return the theme
	 */
	static DescriptionListTheme latex(){
		return new DescriptionListTheme() {
			@Override
			public void apply(DescriptionListContext ctx) {
				ctx.setTargetTranslator(new Text2Latex());
				ctx.setListStart("\\begin{description}");
				ctx.setListEnd("\\end{description}");
				ctx.setLeftLabelString("\\item[");
				ctx.setRightLabelString("]");
				ctx.setItemMargin(4);
				ctx.setLabelRightMargin(0);
				ctx.setTextLeftMargin(1);
				ctx.setAlignment(AL_Alignment.LEFT);
				ctx.setUseSameLine(true);
			}
		};
	}

}
