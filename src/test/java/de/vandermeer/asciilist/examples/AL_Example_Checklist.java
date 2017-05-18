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

import de.vandermeer.asciilist.checklist.Checklist;
import de.vandermeer.asciithemes.u8.U8_Checklists;
import de.vandermeer.skb.interfaces.examples.StandardExampleAsCmd;

/**
 * AsciiList example for checklists.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.5 build 170502 (02-May-17) for Java 1.8
 * @since      v0.0.4
 */
public class AL_Example_Checklist implements StandardExampleAsCmd {

	@Override
	public String getDescription() {
		return "simple checklist examples";
	}

	@Override
	public Object getLongDescription() {
		return
				"The package also provides a check list.\r\n" + 
				"In this list, items can be marked as checked and unchecked resulting in different labels.\r\n" + 
				"The checklist supports styles to use different characters (ASCII and UTF) for checked and unchecked items.\r\n" + 
				"<br /><br />" + 
				"The example shows the creation of a checklist and the use of different styles for rendering it"
		;
	}

	@Override
	public String getName() {
		return "checklist";
	}

	@Override
	public String getSource(){
		return
				"Checklist list = new Checklist();\r\n" + 
				"list.addItem(\"item unchecked\", false);\r\n" + 
				"list.addItem(\"item checked\", true);\r\n" + 
				"System.out.println(list.render());\r\n" + 
				"\r\n" + 
				"list.getContext().setStyle(U8_Checklists.ballotBox());\r\n" + 
				"System.out.println(list.render());\r\n" + 
				"\r\n" + 
				"list.getContext().setStyle(U8_Checklists.ballotBoxX());\r\n" + 
				"System.out.println(list.render());"
		;
	}

	@Override
	public void showOutput(){
		// tag::example[]
		Checklist list = new Checklist();
		list.addItem("item unchecked", false);
		list.addItem("item checked", true);
		System.out.println(list.render());

		list.getContext().setStyle(U8_Checklists.ballotBox());
		System.out.println(list.render());

		list.getContext().setStyle(U8_Checklists.ballotBoxX());
		System.out.println(list.render());
		// end::example[]
	}
}
