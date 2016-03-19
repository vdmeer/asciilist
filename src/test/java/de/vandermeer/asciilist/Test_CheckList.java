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

/**
 * Tests for {@link CheckList}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v1.0.0 build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public class Test_CheckList {

	@Test
	public void test_List(){
		CheckList list = new CheckList();
		list.addItem("item 1");
		list.addItemChecked("item 2");
		System.err.println(list.render() + "\n");

		list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX);
		System.err.println(list.render() + "\n");

		list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX_X);
		System.err.println(list.render() + "\n");
	}
}
