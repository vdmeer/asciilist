/* Copyright 2014 Sven van der Meer <vdmeer.sven@mykolab.com>
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

package de.vandermeer.asciilist;

import org.junit.Test;

import de.vandermeer.asciilist.styles.NestedCheckStyles;
import de.vandermeer.asciilist.styles.NestedEnumerateStyles;
import de.vandermeer.asciilist.styles.NestedItemizeStyles;


/**
 * Tests for ASCII table V2 for code used in documentation.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v1.0.0 build 170331 (31-Mar-17) for Java 1.7
 * @since      v0.0.2
 */
public class Test_CodeForDocs {

	@Test
	public void test_SimpleListItemize(){
		this.output("simple itemize");

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

		this.output();
	}

	@Test
	public void test_NestedLists(){
		this.output("simple itemize");

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

		this.output();
	}

	@Test
	public void test_Width(){
		this.output("width");

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

		this.output();
	}

	@Test
	public void test_Checklist(){
		this.output("checklist");

		CheckList list = new CheckList();
		list.addItem("item unchecked");
		list.addItemChecked("item checked");
		System.out.println(list.render() + "\n");

		list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX);
		System.out.println(list.render() + "\n");

		list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX_X);
		System.out.println(list.render() + "\n");

		this.output();
	}

	@Test
	public void test_EnumSubscript(){
		this.output("enum subscript");

		AsciiList enumerate = new EnumerateList()
			.addItem("item 1")
			.addItem("item 2")
			.addItem("item 3")
			.setPreLabelString("E")
			.setListStyle(NestedEnumerateStyles.all_utf_arabic_subscript)
		;

		System.out.println(enumerate.render());

		this.output();
	}


	protected void output(String str){
		System.out.println(str);
		System.out.println("----------------------------");
	}

	protected void output(){
		System.out.println("----------------------------");
		System.out.println();
	}

}
