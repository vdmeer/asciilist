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

package de.vandermeer.asciilist.old.examples;

import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.asciilist.old.CheckList;
import de.vandermeer.asciilist.old.styles.NestedCheckStyles;
import de.vandermeer.skb.interfaces.StandardExample;

/**
 * AsciiList example for checklists.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.0.4
 */
public class AL_Example_CheckList implements StandardExample {

	@Override
	public void showOutput(){
		// tag::example[]
		CheckList list = new CheckList();
		list.addItem("item unchecked");
		list.addItemChecked("item checked");
		System.out.println(list.render() + "\n");

		list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX);
		System.out.println(list.render() + "\n");

		list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX_X);
		System.out.println(list.render() + "\n");
		// end::example[]
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"CheckList list = new CheckList();",
				"list.addItem(\"item unchecked\");",
				"list.addItemChecked(\"item checked\");",
				"System.out.println(list.render() + \"\\n\");",

				"",
				"list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX);",
				"System.out.println(list.render() + \"\\n\");",

				"",
				"list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX_X);",
				"System.out.println(list.render() + \"\\n\");",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}
}
