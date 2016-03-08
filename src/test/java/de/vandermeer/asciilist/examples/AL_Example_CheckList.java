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

import de.vandermeer.asciilist.CheckList;
import de.vandermeer.asciilist.styles.NestedCheckStyles;

/**
 * AsciiList example for checklists.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160306 (06-Mar-16) for Java 1.7
 * @since      v0.0.4
 */
public class AL_Example_CheckList {

	/**
	 * Show the examples.
	 */
	public void show(){
		CheckList list = new CheckList();
		list.addItem("item unchecked");
		list.addItemChecked("item checked");
		System.out.println(list.render() + "\n");

		list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX);
		System.out.println(list.render() + "\n");

		list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX_X);
		System.out.println(list.render() + "\n");
	}

	/**
	 * Show the code for the examples.
	 * @return example Java code
	 */
	public String getCode(){
		String code =
				"	CheckList list = new CheckList();\n" +
				"	list.addItem(\"item unchecked\");\n" +
				"	list.addItemChecked(\"item checked\");\n" +
				"	System.out.println(list.render() + \"\\n\");\n" +

				"\n" +
				"	list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX);\n" +
				"	System.out.println(list.render() + \"\\n\");\n" +

				"\n" +
				"	list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX_X);\n" +
				"	System.out.println(list.render() + \"\\n\");\n"
		;
		return code;
	}
}
