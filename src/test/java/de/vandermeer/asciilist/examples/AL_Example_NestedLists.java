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
import de.vandermeer.asciilist.AsciiList_Enumerate;
import de.vandermeer.asciilist.EnumerateList;
import de.vandermeer.asciilist.ItemizeList;
import de.vandermeer.asciilist.styles.NestedItemizeStyles;

/**
 * AsciiList example for nested lists.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160306 (06-Mar-16) for Java 1.7
 * @since      v0.0.4
 */
public class AL_Example_NestedLists {

	/**
	 * Show the examples.
	 */
	public void show(){
		AsciiList itemize = new ItemizeList()
		.addItem("item 1")
		.addItem(new ItemizeList().addItem("item 2")
				.addItem(new ItemizeList().addItem("item 3")
						.addItem(new ItemizeList().addItem("item 4")
								.addItem(new ItemizeList().addItem("item 5")
										.addItem(new ItemizeList().addItem("item 6"))
								)
						)
				)
		).setListStyle(NestedItemizeStyles.ALL_STAR_INCREMENTAL);

		AsciiList_Enumerate enumerate = new EnumerateList()
		.addItem("item 1")
		.addItem(new EnumerateList().addItem("item 2")
				.addItem(new EnumerateList().addItem("item 3")
						.addItem(new EnumerateList().addItem("item 4")
								.addItem(new EnumerateList().addItem("item 5")
										.addItem(new EnumerateList().addItem("item 6"))
								)
						)
				)
		);

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
				"	.addItem(\"item 1\")\n" +
				"	.addItem(new ItemizeList().addItem(\"item 2\")\n" +
				"			.addItem(new ItemizeList().addItem(\"item 3\")\n" +
				"					.addItem(new ItemizeList().addItem(\"item 4\")\n" +
				"							.addItem(new ItemizeList().addItem(\"item 5\")\n" +
				"									.addItem(new ItemizeList().addItem(\"item 6\"))\n" +
				"							)\n" +
				"					)\n" +
				"			)\n" +
				"	).setListStyle(NestedItemizeStyles.ALL_STAR_INCREMENTAL);\n" +

				"\n" +
				"	AsciiList_Enumerate enumerate = new EnumerateList()\n" +
				"	.addItem(\"item 1\")\n" +
				"	.addItem(new EnumerateList().addItem(\"item 2\")\n" +
				"			.addItem(new EnumerateList().addItem(\"item 3\")\n" +
				"					.addItem(new EnumerateList().addItem(\"item 4\")\n" +
				"							.addItem(new EnumerateList().addItem(\"item 5\")\n" +
				"									.addItem(new EnumerateList().addItem(\"item 6\"))\n" +
				"							)\n" +
				"					)\n" +
				"			)\n" +
				"	);\n" +

				"\n" +
				"	System.out.println(itemize.render());\n" +
				"	System.out.println(enumerate.render());\n"
		;
		return code;
	}
}
