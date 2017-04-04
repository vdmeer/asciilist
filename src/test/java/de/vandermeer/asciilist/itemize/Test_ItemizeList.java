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

package de.vandermeer.asciilist.itemize;

import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;

import de.svenjacobs.loremipsum.LoremIpsum;
import de.vandermeer.asciithemes.a7.A7_ItemizeLists;
import de.vandermeer.asciithemes.u8.U8_ItemizeLists;
import de.vandermeer.skb.interfaces.strategies.collections.sortedset.TreeSetStrategy;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

/**
 * Tests for {@link ItemizeList}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.1.0
 */
public class Test_ItemizeList {

	@Test
	public void test_me(){
		ItemizeList il4 = new ItemizeList();
		il4.addItem("l4 i1");
		il4.addItem("l4 i2");

		ItemizeList il3 = new ItemizeList();
		il3.addItem("l3 i1");
		il3.addItem("l3 i2");
		il3.addItem("l3 i3", il4);

		ItemizeList il2 = new ItemizeList();
		il2.addItem("l2 i1");
		il2.addItem("l2 i2");
		il2.addItem("l2 i3", il3);

		ItemizeList il = new ItemizeList();
		il.addItem("line 1");
		il.addItem(new StrBuilder().append("line 2"));
		il.addItem("item with list", il2);
		il.addItem(new LoremIpsum().getWords(10));
//		il.getContext().setStyle(A7_ItemizeLists.allStar());
		il.getContext().setStyle(A7_ItemizeLists.allStarIncremental());

//		il.getContext().setWidth(13);
		System.err.println(il.render());
	}

	@Test
	public void test_Itemize(){
		ItemizeList list = new ItemizeList();
		list.getContext().setAlignment(TextAlignment.LEFT);
		list.addItem(new LoremIpsum().getWords(10));
		list.addItem("item 2");
		list.addItem("item 3");

		list.getContext().setWidth(15);

		String rend = list.render();
		System.out.println(rend);

		list.getContext().setLabelLeftMargin(5);
		System.out.println("\n" + list.render());

		list.getContext().init();
		list.getContext().setLabelRightMargin(4);
		System.out.println("\n" + list.render());

		list.getContext().init();
		list.getContext().setLeftLabelString(">>");
		list.getContext().setRightLabelString("<<");
		System.out.println("\n" + list.render());

		list.getContext().init();
		list.getContext().setStyle(U8_ItemizeLists.htmlLike());
		System.out.println("\n" + list.render());
	}

	@Test
	public void test_List(){
		ItemizeList list = new ItemizeList();
		list.addItem("item 1");
		list.addItem("item 2");
		list.addItem("item 3");

		System.out.println(list.render() + "\n");

		list.getContext().setTextLeftMargin(4);
		System.out.println(list.render() + "\n");

		list.getContext().setStyle(A7_ItemizeLists.allStarIncremental());
		list.getContext().setTextLeftMargin(1);
		ItemizeList list2 = new ItemizeList();
		list2.addItem("two item one");
		list2.addItem("two item two");
		list2.addItem("two item three four five six seven eight nine ten");
		list.addItem("item 4 w/child", list2);
		System.out.println(list.render() + "\n");

		list.getContext().setStyle(U8_ItemizeLists.htmlLike());
		System.out.println(list.render() + "\n");

		list.getContext().setWidth(19);
		System.out.println(list.render() + "\n");
	}

	@Test
	public void test_19(){
		ItemizeList il = new ItemizeList();
		il.addItem("il 1 item 1 some text");
		il.addItem("il 1 item 2 some text");
		il.addItem("il 1 item 3 some text");

		ItemizeList il2 = new ItemizeList();
		il2.addItem("il 2 item 1 text");
		il2.addItem("il 2 item 2 text");
		il2.addItem("il 2 item 3 text");
		il.addItem("il 1 item 4 some text", il2);

		il.getContext().setStyle(A7_ItemizeLists.allStarIncremental());
		il.getContext().setWidth(18);
		System.out.println(il.render() + "\n");
	}

	@Test
	public void test_Themes(){
		ItemizeList il = new ItemizeList();
		il.addItem("il 1 item 1 some text");
		il.addItem("il 1 item 2 some text");
		il.addItem("il 1 item 3 some text");
		il.applyTheme(Il_Themes.latex());
		System.out.println(il.render() + "\n");
	}

	@Test
	public void test_Sorting(){
		ItemizeList il = new ItemizeList(TreeSetStrategy.create());
		il.addItem("il 1 item 4 some text");
		il.addItem("il 1 item 1 some text");
		il.addItem("il 1 item 3 some text");
		il.addItem("il 1 item 2 some text");
		il.applyTheme(Il_Themes.latex());
		System.out.println(il.render() + "\n");
	}
}
