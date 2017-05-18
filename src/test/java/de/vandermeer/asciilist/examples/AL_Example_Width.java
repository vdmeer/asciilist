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

import de.vandermeer.asciilist.enumerate.EnumerateList;
import de.vandermeer.asciilist.itemize.ItemizeList;
import de.vandermeer.asciithemes.a7.A7_EnumerateLists;
import de.vandermeer.asciithemes.a7.A7_ItemizeLists;
import de.vandermeer.skb.interfaces.examples.StandardExampleAsCmd;

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
	public String getSource(){
		return
				"ItemizeList itemize = new ItemizeList()\r\n" + 
				"		.addItem(\"il 1 item 1 some text\")\r\n" + 
				"		.addItem(\"il 1 item 2 some text\")\r\n" + 
				";\r\n" + 
				"ItemizeList il2 = new ItemizeList()\r\n" + 
				"	.addItem(\"il 2 item 1 text\")\r\n" + 
				"	.addItem(\"il 2 item 2 text\")\r\n" + 
				";\r\n" + 
				"itemize.addItem(\"il 1 item 3 some text\", il2);\r\n" + 
				"\r\n" + 
				"itemize.getContext().setLabelLeftMargin(0);\r\n" + 
				"itemize.getContext().setStyle(A7_ItemizeLists.allStarIncremental());\r\n" + 
				"\r\n" + 
				"EnumerateList enumerate = new EnumerateList()\r\n" + 
				"		.addItem(\"el 1 item 1 some text\")\r\n" + 
				"		.addItem(\"el 1 item 2 some text\")\r\n" + 
				";\r\n" + 
				"EnumerateList e2 = new EnumerateList()\r\n" + 
				"	.addItem(\"el 2 item 1 text\")\r\n" + 
				"	.addItem(\"el 2 item 2 text\")\r\n" + 
				";\r\n" + 
				"enumerate.addItem(\"el 1 item 3 some text\", e2);\r\n" + 
				"enumerate.getContext().setLabelLeftMargin(0);\r\n" + 
				"enumerate.getContext().setStyle(A7_EnumerateLists.arabic_Alpha_alpha_Roman_roman());\r\n" + 
				"\r\n" + 
				"System.out.println(itemize.render() + \"\\n\");\r\n" + 
				"System.out.println(enumerate.render() + \"\\n\");\r\n" + 
				"\r\n" + 
				"System.out.println(itemize.render(15) + \"\\n\");\r\n" + 
				"System.out.println(enumerate.render(15));"
		;
	}

	@Override
	public String getDescription() {
		return "setting the width of lists";
	}

	@Override
	public String getName() {
		return "width";
	}

	@Override
	public Object getLongDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}
