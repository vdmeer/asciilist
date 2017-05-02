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

import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.asciilist.itemize.ItemizeList;
import de.vandermeer.asciithemes.u8.U8_ItemizeLists;
import de.vandermeer.skb.interfaces.StandardExampleAsCmd;

/**
 * AsciiList example for simple itemize lists.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.5 build 170502 (02-May-17) for Java 1.8
 * @since      v0.0.4
 */
public class AL_Example_SimpleItemize implements StandardExampleAsCmd {

	@Override
	public void showOutput(){
		// tag::example[]
		ItemizeList list = new ItemizeList();
		list.addItem("item 1");
		list.addItem("item 2");
		list.addItem("item 3");

		String rend = list.render();
		System.out.println(rend);

		list.getContext().setLabelLeftMargin(5);
		System.out.println("\n" + list.render());

		list.getContext().init();
		list.getContext().setLabelRightMargin(5);
		System.out.println("\n" + list.render());

		list.getContext().init();
		list.getContext().setLeftLabelString(">>");
		list.getContext().setRightLabelString("<<");
		System.out.println("\n" + list.render());

		list.getContext().init();
		list.getContext().setStyle(U8_ItemizeLists.htmlLike());
		System.out.println("\n" + list.render());
		// end::example[]
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"ItemizeList list = new ItemizeList();",
				"list.addItem(\"item 1\");",
				"list.addItem(\"item 2\");",
				"list.addItem(\"item 3\");",

				"",
				"String rend = list.render();",
				"System.out.println(rend);",

				"",
				"list.setPreLabelIndent(5);",
				"System.out.println(\"\\n\" + list.render());",

				"",
				"list.setLabelDefaults();",
				"list.setPostLabelIndent(5);",
				"System.out.println(\"\\n\" + list.render());",

				"",
				"list.setLabelDefaults();",
				"list.setPreLabelString(\">>\");",
				"list.setPostLabelString(\"<<\");",
				"System.out.println(\"\\n\" + list.render());",

				"",
				"list.setLabelDefaults();",
				"list.setListStyle(NestedItemizeStyles.HTML_LIKE);",
				"System.out.println(\"\\n\" + list.render());",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}

	@Override
	public String getDescription() {
		return "simple itemize list";
	}

	@Override
	public String getID() {
		return "itemize";
	}
}
