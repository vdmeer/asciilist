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

import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.asciilist.enumerate.EnumerateList;
import de.vandermeer.asciithemes.u8.U8_EnumerateLists;
import de.vandermeer.skb.interfaces.StandardExampleAsCmd;

/**
 * AsciiList example for an enumerate list with subscripts.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.5 build 170502 (02-May-17) for Java 1.8
 * @since      v0.0.4
 */
public class AL_Example_EnumerateSubscript implements StandardExampleAsCmd {

	@Override
	public void showOutput(){
		// tag::example[]
		EnumerateList list = new EnumerateList()
				.addItem("item 1")
				.addItem("item 2")
				.addItem("item 3")
		;
		list.getContext().setLeftLabelString("E");
		list.getContext().setSeparatorAfterLastNumber(false);
		list.getContext().setStyle(U8_EnumerateLists.numberSubscript());
		;
		System.out.println(list.render());
		// end::example[]
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"EnumerateList list = new EnumerateList()",
				"		.addItem(\"item 1\")",
				"		.addItem(\"item 2\")",
				"		.addItem(\"item 3\")",
				";",
				"list.getContext().setLeftLabelString(\"E\");",
				"list.getContext().setSeparatorAfterLastNumber(false);",
				"list.getContext().setStyle(U8_EnumerateLists.numberSubscript());",
				";",
				"System.out.println(list.render());",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}

	@Override
	public String getDescription() {
		return "simple enumerate list";
	}

	@Override
	public String getID() {
		return "enumerate";
	}
}
