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

package de.vandermeer.asciilist.examples;

import de.vandermeer.asciilist.AsciiList;
import de.vandermeer.asciilist.EnumerateList;
import de.vandermeer.asciilist.styles.NestedEnumerateStyles;

/**
 * AsciiList example for an enumerate list with subscripts.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160306 (06-Mar-16) for Java 1.7
 * @since      v0.0.4
 */
public class AL_Example_EnumerateSubscript {

	/**
	 * Show the examples.
	 */
	public void show(){
		AsciiList enumerate = new EnumerateList()
				.addItem("item 1")
				.addItem("item 2")
				.addItem("item 3")
				.setPreLabelString("E")
				.setListStyle(NestedEnumerateStyles.all_utf_arabic_subscript)
		;
		System.out.println(enumerate.render());
	}

	/**
	 * Show the code for the examples.
	 * @return example Java code
	 */
	public String getCode(){
		String code =
				"	AsciiList enumerate = new EnumerateList()\n" +
				"			.addItem(\"item 1\")\n" +
				"			.addItem(\"item 2\")\n" +
				"			.addItem(\"item 3\")\n" +
				"			.setPreLabelString(\"E\")\n" +
				"			.setListStyle(NestedEnumerateStyles.all_utf_arabic_subscript)\n" +
				"	;\n" +

				"\n" +
				"	System.out.println(enumerate.render());\n"
		;
		return code;
	}
}
