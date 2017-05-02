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

package de.vandermeer.asciilist.examples;

import org.junit.Test;

import de.vandermeer.skb.interfaces.StandardExampleRunner;

/**
 * Tests for ASCII List for code used in documentation.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.5 build 170502 (02-May-17) for Java 1.8
 * @since      v0.0.2
 */
public class Test_Examples implements StandardExampleRunner {

	@Test
	public void test_SimpleListItemize(){
		this.runExample(new AL_Example_SimpleItemize());
	}

	@Test
	public void test_NestedLists(){
		this.runExample(new AL_Example_NestedLists());
	}

	@Test
	public void test_Width(){
		this.runExample(new AL_Example_Width());
	}

	@Test
	public void test_Checklist(){
		this.runExample(new AL_Example_Checklist());
	}

	@Test
	public void test_EnumSubscript(){
		this.runExample(new AL_Example_EnumerateSubscript());
	}

}
