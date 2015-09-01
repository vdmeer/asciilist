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
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.vandermeer.asciilist.styles.ListStyle;

/**
 * Tests for {@link AbstractAsciiList}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 150901 (01-Sep-15) for Java 1.7
 * @since      v0.0.1
 */
public class Test_AbstractAsciiList {

	protected class TAA extends AbstractAsciiList{
		@Override public String render(){return this.items.toString();}
		@Override public String renderItem(AsciiListItem item, int position) {return null;}
		@Override public AsciiList setListStyle(ListStyle style) {return null;}
		@Override public AsciiList copy() {return null;}
	}

	@Rule public ExpectedException exception = ExpectedException.none();

	@Test
	public void test_List(){
		TAA taa = new TAA();

		taa.addItem((String)null);
		assertEquals(0, taa.items.size());

		taa.addItem("");
		assertEquals(0, taa.items.size());

		taa.addItem("1");
		assertEquals(1, taa.items.size());

		taa.addItem("2");
		assertEquals(2, taa.items.size());
		assertEquals("1", ((AsciiListItem)taa.items.get(0)).getContent().toString());
		assertEquals("2", ((AsciiListItem)taa.items.get(1)).getContent().toString());

		TAA taa2 = new TAA();
		try {taa2.addItem((AsciiList)null);fail( "no exception" );} catch (NullPointerException expected) {}
		try {taa2.addItem(new TAA());fail( "no exception" );} catch (IllegalArgumentException expected) {}
		assertEquals(0, taa2.items.size());
		taa2.addItem(taa);
		assertEquals(1, taa2.items.size());
	}
}
