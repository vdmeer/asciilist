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

package de.vandermeer.asciilist.builder;

import org.junit.Test;

import de.vandermeer.asciilist.itemize.ItemizeList;

/**
 * Tests for {@link ItemizeListBuilder}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 170404 (04-Apr-17) for Java 1.8
 * @since      v0.1.0
 */
public class Test_ItemizeListBuilder {

	@Test
	public void test_Me(){
//		ItemizeListBuilder builder = new ItemizeListBuilder();
//		ItemizeList list = builder
//			.item("line 1")
//				.withItemizeList()
//				.item("1-1")
//				.item("1-2")
//				.item("1-3")
//				.endItemize()
//			.item("line 2")
//				.withItemizeList()
//					.item("2-1")
//					.item("2-2")
//					.item("2-3")
//				.endItemize()
//			.item("line 3")
//				.withItemizeList()
//					.item("3-1")
//					.item("3-2")
//					.item("3-3")
//				.endItemize()
//			.get()
//		;

//		System.err.println(list.render());
	}

	@Test
	public void test_Me2(){
		AbstractItemizeBuilder builder = new AbstractItemizeBuilder();
		builder.item("i1");
		builder.item("i2");
		builder.withItemizeList()
			.item("2-1")
			.item("2-2")
			.endItemize()
		;
		System.err.println(builder.get().render());
	}
}
