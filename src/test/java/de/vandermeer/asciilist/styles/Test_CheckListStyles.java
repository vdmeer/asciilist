/* Copyright 2015 Sven van der Meer <vdmeer.sven@mykolab.com>
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

package de.vandermeer.asciilist.styles;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests for {@link CheckListStyles}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v1.0.0 build 170404 (04-Apr-17) for Java 1.7
 * @since      v0.0.1
 */
public class Test_CheckListStyles {

	@Test
	public void test_Styles(){
		for(CheckListStyles t : CheckListStyles.values()){
			assertTrue(t.getLabelChecked()!=null);
			assertTrue(t.getLabelUnchecked()!=null);
			System.out.println(t.name() + "\n" + t.toDoc() + "\n\n");
		}
	}

}
