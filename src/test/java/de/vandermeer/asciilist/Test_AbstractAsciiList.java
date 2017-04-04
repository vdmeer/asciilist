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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.vandermeer.asciilist.styles.ListStyle;


/**
 * Tests for {@link AbstractAsciiList}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v1.0.0 build 170331 (31-Mar-17) for Java 1.7
 * @since      v0.0.1
 */
public class Test_AbstractAsciiList {

	protected class TAA extends AbstractAsciiList{
		TAA(){super();}
		TAA(boolean flag){super(flag);}
		@Override public String render(){return this.items.toString();}
		@Override public String renderItem(AsciiListItem item, int position) {return null;}
		@Override public AsciiList setListStyle(ListStyle style) {return null;}
		@Override public AsciiList copy() {return null;}
		@Override public int calculateMaxIndentation(AsciiListItem item, int position) {return 0;}
	}

	@Test
	public void test_Constructor(){
		TAA taa = new TAA();

		assertTrue(taa.getItems()!=null);
		assertEquals(0, taa.getItems().size());

		assertEquals(1, taa.getPreLabelIndent());
		assertEquals(1, taa.getPostLabelIndent());
		assertEquals("", taa.getPreLabelString());
		assertEquals("", taa.getPostLabelString());
		assertEquals(1, taa.getLevel());
		assertTrue(taa.isContinuedList()==true);
		assertEquals(0, taa.maxItemIndent);
		assertEquals(-1, taa.width);

		taa = new TAA(false);
		assertTrue(taa.isContinuedList()==false);
		taa = new TAA(true);
		assertTrue(taa.isContinuedList()==true);
	}
}
