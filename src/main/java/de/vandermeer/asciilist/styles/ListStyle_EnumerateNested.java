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

package de.vandermeer.asciilist.styles;

import org.apache.commons.lang3.NotImplementedException;

import de.vandermeer.asciilist.AsciiList_Enumerate;

/**
 * Customizable style for nested enumerate (ordered) lists - {@link AsciiList_Enumerate}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v1.0.0 build 170404 (04-Apr-17) for Java 1.7
 * @since      v0.0.1
 */
public interface ListStyle_EnumerateNested extends ListStyle {

	/**
	 * Returns the style for a given level.
	 * @param level the level for the requested style
	 * @return enumerate lists style for a given level
	 * @throws NotImplementedException if requested level is not supported
	 */
	ListStyle_Enumerate getStyle(int level);

}
