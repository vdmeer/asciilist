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

/**
 * Tests for {@link DescriptionList}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v1.0.0 build 170331 (31-Mar-17) for Java 1.7
 * @since      v0.0.2
 */
public class Test_DescriptionList {

	@Test
	public void test_MultiLine(){
		DescriptionList list = new DescriptionList();
		list.useSingleLine(false);
		list.addItem("term 1", "this is the first term in the list");
		list.addItem("term 2", "this is the second term in the list");
		list.addItem("term 3", "this is the third term in the list");
		System.out.println("multi-line");
		System.out.println(list.render() + "\n");

		list.setWrappedLineIndentation(4);
		list.setPostLabelIndent(5);
		list.setWidth(15);
		System.out.println("multi-line wrapped");
		System.out.println(list.render() + "\n");
	}

	@Test
	public void test_SingleLine(){
		DescriptionList list = new DescriptionList();
		list.useSingleLine(true);
		list.addItem("term 1", "this is the first term in the list");
		list.addItem("term 2", "this is the second term in the list");
		list.addItem("term 3", "this is the third term in the list");
		System.out.println("single-line");
		System.out.println(list.render() + "\n");

		list.setWrappedLineIndentation(4);
		list.setPostLabelIndent(5);
		list.setWidth(15);
		System.out.println("single-line wrapped");
		System.out.println(list.render() + "\n");
	}

}
