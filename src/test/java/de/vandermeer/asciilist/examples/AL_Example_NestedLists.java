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

import de.vandermeer.skb.interfaces.StandardExampleAsCmd;

/**
 * AsciiList example for nested lists.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.5 build 170502 (02-May-17) for Java 1.8
 * @since      v0.0.4
 */
public class AL_Example_NestedLists implements StandardExampleAsCmd {

	@Override
	public void showOutput(){
		// tag::example[]
//		AsciiList itemize = new ItemizeList()
//		.addItem("item 1")
//		.addItem(new ItemizeList().addItem("item 2")
//			.addItem(new ItemizeList().addItem("item 3")
//				.addItem(new ItemizeList().addItem("item 4")
//					.addItem(new ItemizeList().addItem("item 5")
//						.addItem(new ItemizeList().addItem("item 6"))
//					)
//				)
//			)
//		).setListStyle(NestedItemizeStyles.ALL_STAR_INCREMENTAL);
//
//		AsciiList_Enumerate enumerate = new EnumerateList()
//		.addItem("item 1")
//		.addItem(new EnumerateList().addItem("item 2")
//			.addItem(new EnumerateList().addItem("item 3")
//				.addItem(new EnumerateList().addItem("item 4")
//					.addItem(new EnumerateList().addItem("item 5")
//						.addItem(new EnumerateList().addItem("item 6"))
//					)
//				)
//			)
//		);
//
//		System.out.println(itemize.render());
//		System.out.println(enumerate.render());
		// end::example[]
	}

	@Override
	public StrBuilder getSource(){
		String[] source = new String[]{
				"AsciiList itemize = new ItemizeList()",
				".addItem(\"item 1\")",
				".addItem(new ItemizeList().addItem(\"item 2\")",
				"	.addItem(new ItemizeList().addItem(\"item 3\")",
				"		.addItem(new ItemizeList().addItem(\"item 4\")",
				"			.addItem(new ItemizeList().addItem(\"item 5\")",
				"				.addItem(new ItemizeList().addItem(\"item 6\"))",
				"			)",
				"		)",
				"	)",
				").setListStyle(NestedItemizeStyles.ALL_STAR_INCREMENTAL);",

				"",
				"AsciiList_Enumerate enumerate = new EnumerateList()",
				".addItem(\"item 1\")",
				".addItem(new EnumerateList().addItem(\"item 2\")",
				"	.addItem(new EnumerateList().addItem(\"item 3\")",
				"		.addItem(new EnumerateList().addItem(\"item 4\")",
				"			.addItem(new EnumerateList().addItem(\"item 5\")",
				"				.addItem(new EnumerateList().addItem(\"item 6\"))",
				"			)",
				"		)",
				"	)",
				");",

				"",
				"System.out.println(itemize.render());",
				"System.out.println(enumerate.render());",
		};
		return new StrBuilder().appendWithSeparators(source, "\n");
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
}


/*
 * item 1
   ** item 2
      *** item 3
          **** item 4
               ***** item 5
                     ****** item 6
 1 item 1
   1.1 item 2
       1.1.1 item 3
             1.1.1.1 item 4
                     1.1.1.1.1 item 5
                               1.1.1.1.1.1 item 6

*/