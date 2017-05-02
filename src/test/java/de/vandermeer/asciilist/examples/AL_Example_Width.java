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

package de.vandermeer.asciilist.examples;

import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.asciilist.enumerate.EnumerateList;
import de.vandermeer.asciilist.itemize.ItemizeList;
import de.vandermeer.asciithemes.a7.A7_EnumerateLists;
import de.vandermeer.asciithemes.a7.A7_ItemizeLists;
import de.vandermeer.skb.interfaces.StandardExampleAsCmd;

/**
 * AsciiList example with different width.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.5 build 170502 (02-May-17) for Java 1.8
 * @since      v0.0.4
 */
public class AL_Example_Width implements StandardExampleAsCmd {

	@Override
	public void showOutput(){
		// tag::example[]
		ItemizeList itemize = new ItemizeList()
				.addItem("il 1 item 1 some text")
				.addItem("il 1 item 2 some text")
		;
		ItemizeList il2 = new ItemizeList()
			.addItem("il 2 item 1 text")
			.addItem("il 2 item 2 text")
		;
		itemize.addItem("il 1 item 3 some text", il2);

		itemize.getContext().setLabelLeftMargin(0);
		itemize.getContext().setStyle(A7_ItemizeLists.allStarIncremental());

		EnumerateList enumerate = new EnumerateList()
				.addItem("el 1 item 1 some text")
				.addItem("el 1 item 2 some text")
		;
		EnumerateList e2 = new EnumerateList()
			.addItem("el 2 item 1 text")
			.addItem("el 2 item 2 text")
		;
		enumerate.addItem("el 1 item 3 some text", e2);
		enumerate.getContext().setLabelLeftMargin(0);
		enumerate.getContext().setStyle(A7_EnumerateLists.arabic_Alpha_alpha_Roman_roman());

		System.out.println(itemize.render() + "\n");
		System.out.println(enumerate.render() + "\n");

		System.out.println(itemize.render(15) + "\n");
		System.out.println(enumerate.render(15));
		// end::example[]
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"AsciiList itemize = new ItemizeList()",
				".addItem(\"il 1 item 1 some text\")",
				".addItem(\"il 1 item 2 some text\")",
				".addItem(new ItemizeList()",
				"	.addItem(\"il 2 item 1 text\")",
				"	.addItem(\"il 2 item 2 text\")",
				")",
				".setPreLabelIndent(0)",
				".setListStyle(NestedItemizeStyles.ALL_STAR_INCREMENTAL);",

				"",
				"AsciiList enumerate = new EnumerateList()",
				".addItem(\"el 1 item 1 some text\")",
				".addItem(\"el 1 item 2 some text\")",
				".addItem(new EnumerateList()",
				"	.addItem(\"el 2 item 1 text\")",
				"	.addItem(\"el 2 item 2 text\")",
				")",
				".setPreLabelIndent(0)",
				".setListStyle(NestedEnumerateStyles.arabic_Alpha_alpha_Roman_roman);",

				"",
				"System.out.println(itemize.render() + \"\\n\");",
				"System.out.println(enumerate.render() + \"\\n\");",

				"",
				"itemize.setWidth(19);",
				"enumerate.setWidth(19);",
				"System.out.println(itemize.render() + \"\\n\");",
				"System.out.println(enumerate.render());",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}

	@Override
	public String getDescription() {
		return "setting the width of lists";
	}

	@Override
	public String getID() {
		return "width";
	}
}
