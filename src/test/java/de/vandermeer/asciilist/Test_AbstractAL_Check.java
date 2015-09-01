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

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.vandermeer.asciilist.styles.NestedCheckStyles;

/**
 * Tests for {@link CheckList}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 150901 (01-Sep-15) for Java 1.7
 * @since      v0.0.1
 */
public class Test_AbstractAL_Check {

	protected class TAAI extends ItemizeList{}

	@Rule public ExpectedException exception = ExpectedException.none();

	@Test
	public void test_List(){
		CheckList list = new CheckList();
		list.addItem("item 1");
		list.addItemChecked("item 2");
		list.addItem("item 3");

		System.err.println(list.render() + "\n");

		list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX);
		System.err.println(list.render() + "\n");

		CheckList list2 = new CheckList(false);
		list2.addItemChecked("two item 1");
		list2.addItem("two item 2");
		list2.addItem("two item 3");
		list2.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX_X);
		list.addItem(list2);
//		list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX_X);
		System.err.println(list.render() + "\n");

//		list.setLabel("-");
//		list.setPostIndent(4);
//		System.err.println(list.render() + "\n");
//
//		list.setStyle(ItemizeStyles.ASCII_ALL_STAR);
//		list.setPostIndent(1);
//		AbstractAL_Itemize list2 = new AbstractAL_Itemize();
//		list2.addItem("two item one");
//		list2.addItem("two item two");
//		list2.addItem("two item three");
//		list.addItem(list2);
//		System.err.println(list.render() + "\n");
	}
}