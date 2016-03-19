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

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.vandermeer.asciilist.styles.NestedItemizeStyles;

/**
 * Tests for {@link ItemizeList}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v1.0.0 build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public class Test_ItemizeList {

	@Rule public ExpectedException exception = ExpectedException.none();

	@Test
	public void test_List(){
		ItemizeList list = new ItemizeList();
		list.addItem("item 1");
		list.addItem("item 2");
		list.addItem("item 3");

		System.err.println(list.render() + "\n");

		list.setPostLabelIndent(4);
		System.err.println(list.render() + "\n");

		list.setListStyle(NestedItemizeStyles.ALL_STAR_INCREMENTAL);
		list.setPostLabelIndent(1);
		ItemizeList list2 = new ItemizeList();
		list2.addItem("two item one");
		list2.addItem("two item two");
		list2.addItem("two item three four five six seven eight nine ten");
		list2 = (ItemizeList)list.addItem(list2);
		System.err.println(list.render() + "\n");

		list.setListStyle(NestedItemizeStyles.HTML_LIKE);
		assertEquals(NestedItemizeStyles.HTML_LIKE, list.style);
		assertEquals(NestedItemizeStyles.HTML_LIKE, list2.style);
		System.err.println(list.render() + "\n");

		list.setWidth(19);
		System.err.println(list.render() + "\n");
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
		il.addItem(il2);
		il.setListStyle(NestedItemizeStyles.ALL_STAR_INCREMENTAL);
		il.setPreLabelIndent(0);
		il.setWidth(18);
		System.err.println(il.render() + "\n");
	}
}
