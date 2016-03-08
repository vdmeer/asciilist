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

import de.vandermeer.asciilist.ItemizeList;
import de.vandermeer.asciilist.styles.NestedItemizeStyles;

/**
 * AsciiList example for simple itemize lists.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160306 (06-Mar-16) for Java 1.7
 * @since      v0.0.4
 */
public class AL_Example_SimpleItemize {

	/**
	 * Show the examples.
	 */
	public void show(){
		ItemizeList list = new ItemizeList();
		list.addItem("item 1");
		list.addItem("item 2");
		list.addItem("item 3");

		String rend = list.render();
		System.out.println(rend);

		list.setPreLabelIndent(5);
		System.out.println();
		System.out.println(list.render());

		list.setLabelDefaults();
		list.setPostLabelIndent(5);
		System.out.println();
		System.out.println(list.render());

		list.setLabelDefaults();
		list.setPreLabelString(">>");
		list.setPostLabelString("<<");
		System.out.println();
		System.out.println(list.render());

		list.setLabelDefaults();
		list.setListStyle(NestedItemizeStyles.HTML_LIKE);
		System.out.println();
		System.out.println(list.render());
	}

	/**
	 * Show the code for the examples.
	 * @return example Java code
	 */
	public String getCode(){
		String code =
				"	ItemizeList list = new ItemizeList();\n" +
				"	list.addItem(\"item 1\");\n" +
				"	list.addItem(\"item 2\");\n" +
				"	list.addItem(\"item 3\");\n" +

				"\n" +
				"	String rend = list.render();\n" +
				"	System.out.println(rend);\n" +

				"\n" +
				"	list.setPreLabelIndent(5);\n" +
				"	System.out.println();\n" +
				"	System.out.println(list.render());\n" +

				"\n" +
				"	list.setLabelDefaults();\n" +
				"	list.setPostLabelIndent(5);\n" +
				"	System.out.println();\n" +
				"	System.out.println(list.render());\n" +

				"\n" +
				"	list.setLabelDefaults();\n" +
				"	list.setPreLabelString(\">>\");\n" +
				"	list.setPostLabelString(\"<<\");\n" +
				"	System.out.println();\n" +
				"	System.out.println(list.render());\n" +

				"\n" +
				"	list.setLabelDefaults();\n" +
				"	list.setListStyle(NestedItemizeStyles.HTML_LIKE);\n" +
				"	System.out.println();\n" +
				"	System.out.println(list.render());\n"
		;
		return code;
	}
}
