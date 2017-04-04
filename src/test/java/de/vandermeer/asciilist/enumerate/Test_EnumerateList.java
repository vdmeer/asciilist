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

package de.vandermeer.asciilist.enumerate;

import org.junit.Test;

import de.vandermeer.asciithemes.a7.A7_EnumerateLists;

/**
 * Tests for {@link EnumerateList}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.1.0
 */
public class Test_EnumerateList {

	@Test
	public void test_Enumerate(){
		EnumerateList list2 = new EnumerateList();
		list2.addItem("two item 1");
		list2.addItem("two item 2");
		list2.addItem("two item 3");

		EnumerateList list = new EnumerateList();
		list.addItem("item 1");
		list.addItem("item 2", list2);
		list.addItem("item 3", list2);
		list.getContext().setStyle(A7_EnumerateLists.arabic_Alpha_alpha_Roman_roman());
		list2.getContext().setSeparatorAfterLastNumber(false);
		list2.getContext().setRightLabelString(")");
		System.err.println(list.render() + "\n");


		list.getContext().setStyle(A7_EnumerateLists.roman());
		list.addItem("item 4");
		EnumerateList list3 = new EnumerateList();
		list3.addItem("three item 1");
		list3.addItem("three item 2");
		list3.addItem("three item 3");
		list3.getContext().setRightLabelString(")");
		list.addItem("a new item w/child list", list3);
		System.err.println(list.render() + "\n");

		list.getContext().setStyle(A7_EnumerateLists.arabic_Alpha_alpha_Roman_roman());
		System.err.println(list.render() + "\n");
	}

	@Test
	public void test_Themes(){
		EnumerateList el = new EnumerateList();
		el.addItem("il 1 item 1 some text");
		el.addItem("il 1 item 2 some text");
		el.addItem("il 1 item 3 some text");
		el.applyTheme(El_Themes.latex());
		System.out.println(el.render() + "\n");
	}
}
