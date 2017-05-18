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

import de.vandermeer.asciilist.enumerate.EnumerateList;
import de.vandermeer.asciithemes.u8.U8_EnumerateLists;
import de.vandermeer.skb.interfaces.examples.StandardExampleAsCmd;

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
	public String getSource(){
		return
				"EnumerateList list = new EnumerateList()\r\n" + 
				"		.addItem(\"item 1\")\r\n" + 
				"		.addItem(\"item 2\")\r\n" + 
				"		.addItem(\"item 3\")\r\n" + 
				";\r\n" + 
				"list.getContext().setLeftLabelString(\"E\");\r\n" + 
				"list.getContext().setSeparatorAfterLastNumber(false);\r\n" + 
				"list.getContext().setStyle(U8_EnumerateLists.numberSubscript());\r\n" + 
				";\r\n" + 
				"System.out.println(list.render());"
		;
	}

	@Override
	public String getDescription() {
		return "simple enumerate list";
	}

	@Override
	public String getName() {
		return "enumerate";
	}

	@Override
	public Object getLongDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}
