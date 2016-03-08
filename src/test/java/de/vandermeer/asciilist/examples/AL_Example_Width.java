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
import de.vandermeer.asciilist.ItemizeList;
import de.vandermeer.asciilist.styles.NestedEnumerateStyles;
import de.vandermeer.asciilist.styles.NestedItemizeStyles;

/**
 * AsciiList example with different width.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160306 (06-Mar-16) for Java 1.7
 * @since      v0.0.4
 */
public class AL_Example_Width {

	/**
	 * Show the examples.
	 */
	public void show(){
		AsciiList itemize = new ItemizeList()
				.addItem("il 1 item 1 some text")
				.addItem("il 1 item 2 some text")
				.addItem(new ItemizeList()
					.addItem("il 2 item 1 text")
					.addItem("il 2 item 2 text")
				)
				.setPreLabelIndent(0)
				.setListStyle(NestedItemizeStyles.ALL_STAR_INCREMENTAL);

		AsciiList enumerate = new EnumerateList()
				.addItem("el 1 item 1 some text")
				.addItem("el 1 item 2 some text")
				.addItem(new EnumerateList()
					.addItem("el 2 item 1 text")
					.addItem("el 2 item 2 text")
				)
				.setPreLabelIndent(0)
				.setListStyle(NestedEnumerateStyles.arabic_Alpha_alpha_Roman_roman);

		System.out.println(itemize.render());
		System.out.println(enumerate.render());

		itemize.setWidth(19);
		enumerate.setWidth(19);
		System.out.println(itemize.render());
		System.out.println(enumerate.render());
	}

	/**
	 * Show the code for the examples.
	 * @return example Java code
	 */
	public String getCode(){
		String code =
			"	AsciiList itemize = new ItemizeList()\n" +
			"			.addItem(\"il 1 item 1 some text\")\n" +
			"			.addItem(\"il 1 item 2 some text\")\n" +
			"			.addItem(new ItemizeList()\n" +
			"				.addItem(\"il 2 item 1 text\")\n" +
			"				.addItem(\"il 2 item 2 text\")\n" +
			"			)\n" +
			"			.setPreLabelIndent(0)\n" +
			"			.setListStyle(NestedItemizeStyles.ALL_STAR_INCREMENTAL);\n" +

			"\n" +
			"	AsciiList enumerate = new EnumerateList()\n" +
			"			.addItem(\"el 1 item 1 some text\")\n" +
			"			.addItem(\"el 1 item 2 some text\")\n" +
			"			.addItem(new EnumerateList()\n" +
			"				.addItem(\"el 2 item 1 text\")\n" +
			"				.addItem(\"el 2 item 2 text\")\n" +
			"			)\n" +
			"			.setPreLabelIndent(0)\n" +
			"			.setListStyle(NestedEnumerateStyles.arabic_Alpha_alpha_Roman_roman);\n" +

			"\n" +
			"	System.out.println(itemize.render());\n" +
			"	System.out.println(enumerate.render());\n" +

			"\n" +
			"	itemize.setWidth(19);\n" +
			"	enumerate.setWidth(19);\n" +
			"	System.out.println(itemize.render());\n" +
			"	System.out.println(enumerate.render());\n"
		;
		return code;
	}
}
