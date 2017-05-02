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

package de.vandermeer.asciilist.descriptionlist;

import org.junit.Test;

import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

/**
 * Tests for {@link DescriptionList}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.5 build 170502 (02-May-17) for Java 1.8
 * @since      v0.1.0
 */
public class Test_DescriptionList {

	@Test
	public void test_DescriptionList(){
		DescriptionList list = new DescriptionList();
		list.addItem("item 1", "text for item 1");
		list.addItem("item 2", "text for item 2");
		list.addItem("item 3", "text for item 3");

		list.getContext().setUseSameLine(true);
		list.getContext().setLeftLabelString("[");
		list.getContext().setRightLabelString("]");
		list.getContext().setListStart("\\begin{description}");
		list.getContext().setListEnd("\\end{description}");
		list.getContext().setItemMargin(4);
		list.getContext().setAlignment(TextAlignment.LEFT);
		System.err.println(list.render(80) + "\n");
	}

	@Test
	public void test_MultiLine(){
		DescriptionList list = new DescriptionList();
		list.getContext().setAlignment(TextAlignment.LEFT);
		list.getContext().setUseSameLine(false);
		list.addItem("term 1", "this is the first term in the list");
		list.addItem("term 2", "this is the second term in the list");
		list.addItem("term 3", "this is the third term in the list");
		System.out.println("multi-line");
		System.out.println(list.render() + "\n");

		list.getContext().setDescriptionIndent(4);
		list.getContext().setLabelRightMargin(5);
		System.out.println("multi-line wrapped");
		System.out.println(list.render(15) + "\n");
	}

	@Test
	public void test_SingleLine(){
		DescriptionList list = new DescriptionList();
		list.getContext().setAlignment(TextAlignment.LEFT);
		list.getContext().setUseSameLine(true);
		list.addItem("term 1", "this is the first term in the list");
		list.addItem("term 2", "this is the second term in the list");
		list.addItem("term 3", "this is the third term in the list");
		System.out.println("single-line");
		System.out.println(list.render() + "\n");

		list.getContext().setDescriptionIndent(4);
		list.getContext().setLabelRightMargin(5);
		System.out.println("single-line wrapped");
		System.out.println(list.render(15) + "\n");
	}

	@Test
	public void test_Themes(){
		DescriptionList list = new DescriptionList();
		list.addItem("item 1", "text for item 1");
		list.addItem("item 2", "text for item 2");
		list.addItem("item 3", "text for item 3");
		list.applyTheme(Dl_Themes.latex());
		System.out.println(list.render() + "\n");
	}

	@Test
	public void test_Sorting(){
		DescriptionList list = new DescriptionList();
		list.addItem("item 3", "text for item");
		list.addItem("item 1", "text for item");
		list.addItem("item 4", "text for item");
		list.addItem("item 2", "text for item");
		System.out.println(list.render() + "\n");
	}

}
