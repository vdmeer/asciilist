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

import de.vandermeer.asciilist.checklist.Checklist;
import de.vandermeer.asciithemes.u8.U8_Checklists;
import de.vandermeer.skb.interfaces.StandardExampleAsCmd;

/**
 * AsciiList example for checklists.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 170331 (31-Mar-17) for Java 1.8
 * @since      v0.0.4
 */
public class AL_Example_Checklist implements StandardExampleAsCmd {

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

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"Checklist list = new Checklist();",
				"list.addItem(\"item unchecked\", false);",
				"list.addItem(\"item checked\", true);",
				"System.out.println(list.render());",
				"",
				"list.getContext().setStyle(U8_Checklists.ballotBox());",
				"System.out.println(list.render());",
				"",
				"list.getContext().setStyle(U8_Checklists.ballotBoxX());",
				"System.out.println(list.render());",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}

	@Override
	public String getDescription() {
		return "simple checklist";
	}

	@Override
	public String getID() {
		return "checklist";
	}
}
