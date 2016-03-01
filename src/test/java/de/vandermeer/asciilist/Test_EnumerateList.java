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

import de.vandermeer.asciilist.styles.NestedEnumerateStyles;

/**
 * Tests for {@link EnumerateList}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160301 (01-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public class Test_EnumerateList {

	@Rule public ExpectedException exception = ExpectedException.none();

	@Test
	public void test_List(){
		EnumerateList list = new EnumerateList();
		list.addItem("item 1");
		list.addItem("item 2");
		list.addItem("item 3");
		System.err.println(list.render() + "\n");

		EnumerateList list2 = new EnumerateList();
		list2.addItem("two item 1");
		list2.addItem("two item 2");
		list2.addItem("two item 3");
		list.addItem(list2);
		System.err.println(list.render() + "\n");

		list.setListStyle(NestedEnumerateStyles.aLL_roman_ascii);
		list.addItem("item 4");
		EnumerateList list3 = new EnumerateList();
		list3.addItem("three item 1");
		list3.addItem("three item 2");
		list3.addItem("three item 3");
		list3.setPostLabelString(")");
		list.addItem(list3);
		System.err.println(list.render() + "\n");

		list.setListStyle(NestedEnumerateStyles.arabic_Alpha_alpha_Roman_roman);
		System.err.println(list.render() + "\n");
	}
}
