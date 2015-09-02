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

/**
 * ASCII lists - ordered and unordered and checklist and more, with many configuration options.
 * 
 * 
 * <br><h3>Features</h3>
 * 
 * 
 * <br><h3>Concepts and Realization</h3>
 * <p>
 * 		The main concepts are: list, item, label, style.
 * </p>
 * 
 * <br><h4>List</h4>
 * A list is a collection of items.
 * The content and form of the items depends on the list.
 * Lists can be:
 * <ul>
 * 		<li>Itemize or unordered - simple items with same label</li>
 * 		<li>Enumerate or ordered - simple items, ordered, with individual label</li>
 * 		<li>Checklist - items that have a label showing that they are checked or unchecked</li>
 * 		<li>Description or definition or labled - items that have a term and a description</li>
 * 		<li>FAQ or Q&amp;A - items that have an question and an answer, can be itemize or enumerate</li>
 * </ul>
 * 
 * <p>
 * 		Lists items can contain other lists. This feature results in nested lists.
 * 		If lists of the same type are nested the label itself ot the label style can be a continuation of the parent list.
 * </p>
 * 
 * <p>
 * 		Lists are created and filled.
 * 		Then lists can be configured to get the expected printed output.
 * 		Finally, a list is rendered, i.e. a printable representation of the list and all its items is created.
 * </p>
 * 
 * 
 * <br><h4>Item</h4>
 * <p>
 * 		An item is the actual content of a list.
 * 		Simple items have only some text.
 * 		More complex items have several parts, for instance the term and desription of a description list.
 * 		Some items have text plus other configuration options, such as items in a checklist.
 * </p>
 * 
 * 
 * <br><h4>Label</h4>
 * <p>
 * 		A label is the marker of an item.
 * 		Labels strongly depend on the particular list.
 * 		Most configuration on lists is actually on the label.
 * </p>
 * 
 * The following concepts are used in the lists here for labels:
 * <ul>
 * 		<li>Pre-label indentation - is the indentation used before the label. This is the first set of characters printed.</li>
 * 		<li>Pre-label string - is a string printed before every label of a list. This is printed after the pre-label indentation, as the second set of characters.</li>
 * 		<li>Label - the actual label, for instance "*" or "-" for itemize or "1." and "1.1." for enumerate lists.</li>
 * 		<li>Post-label string - is a string printed right after every label of a list.</li>
 * 		<li>Post-label indentation - is the indentation after the label (and before the item's content).</li>
 * 		<li>Multi-line indentation - is used in some lists for the indentation from the second line onwards (if lines are wrapped).</li>
 * </ul>
 * 
 * <p>
 * 		All lists allow to manipulate the pre/post label characteristics directly.
 * 		The label can be styled using a style.
 * 		Multi-line indentation do only apply for some lists, where it cannot or should not be calculated automatically.
 * </p>
 * 
 * 
 * <br><h4>Style</h4>
 * <p>
 * 		Styles are used to style labels of lists or of nested lists.
 * 		The style of a label depends on the particular list.
 * 		Most lists in this package provide a number of different styles.
 * </p>
 * 
 * <p>
 * 		Styles for nested lists are used if those lists are a continuation.
 * 		These styles allow to change the label style in nested lists.
 * 		For some lists (e.g. enumerate) they also allow to re-use parts of the parent list for the label.
 * </p>
 * 
 * 
 * 
 * <br><h3>Standard usage - create and render a simple list</h3>
 * The standard usage is:
 * <ul>
 * 		<li>create a list</li>
 * 		<li>add items to the list</li>
 * 		<li>configure any aspect to cange default render behavior, if required</li>
 * 		<li>render the list</li>
 * 		<li>use the created string, e.g. print it to a console or write it to a file</li>
 * </ul>
 * 
 * <h4>Create a list</h4>
 * <pre>{@code
	ItemizeList list = new ItemizeList();
 * }</pre>
 * 
 * <h4>Add content (items)</h4>
 * <pre>{@code
	list.addItem("item 1");
	list.addItem("item 2");
	list.addItem("item 3");
 * }</pre>
 * 
 * <h4>Render the list</h4>
 * <pre>{@code
	String rend = list.render();
 * }</pre>
 * 
 * <h4>Print the list</h4>
 * <pre>{@code
	System.out.println(rend);
 * }</pre>
 * 
 * This will result in the following list:
 * <pre>
	 &#42; item 1
	 &#42; item 2
	 &#42; item 3
 * </pre>
 * 
 * 
 * <br><h3>Set of examples for list features</h3>
 * 
 * 
 * <br><h4>Change list render behavior</h4>
 * We can change pre/post label indentation and strings as well as the label style.
 * In the following example we first set the pre-label indentation to 5.
 * Then we set the post-label indentation to 5.
 * Then we set the post-label string to "all":
 * <pre>{@code
	list.setPreLabelIndent(5);
	System.out.println(list.render());

	list.setLabelDefaults();
	list.setPostLabelIndent(5);
	System.out.println(list.render());

	list.setLabelDefaults();
	list.setPreLabelString(">>");
	list.setPostLabelString("<<");
	System.out.println(list.render());
 * }</pre>
 * 
 * This will result in the following three outputs:
 * <pre>
	     &#42; item 1		 &#42;     item 1		 &gt;&gt;&#42;&lt;&lt; item 1
	     &#42; item 2		 &#42;     item 2		 &gt;&gt;&#42;&lt;&lt; item 2
	     &#42; item 3		 &#42;     item 3		 &gt;&gt;&#42;&lt;&lt; item 3
 * </pre>
 * 
 * We can also change the label style:
 * <pre>{@code
	list.setLabelDefaults();
	list.setListStyle(NestedItemizeStyles.HTML_LIKE);
	System.out.println(list.render());
 * }</pre>
 * 
 * This will result in the following list:
 * <pre>
	 • item 1
	 • item 2
	 • item 3
 * </pre>
 * 
 * 
 * 
 * <br><h4>Nested lists</h4>
 * <p>
 * 		Itemize and enumerate lists can be nested.
 * 		The nesting is not limited.
 * 		Using standard labels ("*", "-", "+") for itemize lists and ASCII-7 characters for enumerate lists, the nesting can be of any depth.
 * 		However, styles for nested lists currently support a maximum of 6 levels only.
 * 		Some nested styles support less than 6 levels.
 * </p>
 * 
 * Let's start with creating an itemize list and add nested itemize lists 6-levls deep to it.
 * Additionally, set a nested style for the list:
 * <pre>{@code
	AsciiList itemize = new ItemizeList()
	.addItem("item 1")
	.addItem(new ItemizeList().addItem("item 2")
			.addItem(new ItemizeList().addItem("item 3")
					.addItem(new ItemizeList().addItem("item 4")
							.addItem(new ItemizeList().addItem("item 5")
									.addItem(new ItemizeList().addItem("item 6"))
							)
					)
			)
	).setListStyle(NestedItemizeStyles.ALL_STAR_INCREMENTAL);
 * }</pre>
 * 
 * Next, create an enumerate list in the same way, using it's default configuration:
 * <pre>{@code
	AsciiList_Enumerate enumerate = new EnumerateList()
	.addItem("item 1")
	.addItem(new EnumerateList().addItem("item 2")
			.addItem(new EnumerateList().addItem("item 3")
					.addItem(new EnumerateList().addItem("item 4")
							.addItem(new EnumerateList().addItem("item 5")
									.addItem(new EnumerateList().addItem("item 6"))
							)
					)
			)
	);
 * }</pre>
 * 
 * These two examples will print as follows (manually formatted to a 2-column output):
 * <pre>
 &#42; item 1                             1 item 1
   &#42;&#42; item 2                            1.1 item 2
      &#42;&#42;&#42; item 3                            1.1.1 item 3
          &#42;&#42;&#42;&#42; item 4                             1.1.1.1 item 4
               &#42;&#42;&#42;&#42;&#42; item 5                               1.1.1.1.1 item 5
                     &#42;&#42;&#42;&#42;&#42;&#42; item 6                                  1.1.1.1.1.1 item 6
 * </pre>
 * 
 * 
 * 
 * <br><h4>Width with automated line wrapping</h4>
 * <p>
 * 		The lists allow to set a maximum width and will, if any item is longer than that width, an automatic line break with indentation calculation will be performed.
 * 		All lists support this feature.
 * </p>
 * 
 * We create two lits, one itemize and one enumerate:
 * <pre>{@code
	AsciiList itemize = new ItemizeList()
		.addItem("il 1 item 1 some text")
		.addItem("il 1 item 2 some text")
		.addItem(new ItemizeList()
			.addItem("il 2 item 1 text")
			.addItem("il 2 item 2 text")
		)
		.setPreLabelIndent(0)
		.setListStyle(NestedItemizeStyles.ALL_STAR_INCREMENTAL);

	AsciiList enumerate = new EnumerateList()
		.addItem("el 1 item 1 some text")
		.addItem("el 1 item 2 some text")
		.addItem(new EnumerateList()
			.addItem("el 2 item 1 text")
			.addItem("el 2 item 2 text")
		)
		.setPreLabelIndent(0)
		.setListStyle(NestedEnumerateStyles.arabic_Alpha_alpha_Roman_roman);
 * }</pre>
 * 
 * Rendering and printint the two lists will result in the following output (shown in two columns):
 * <pre>
        &#42; il 1 item 1 some text        1 el 1 item 1 some text
        &#42; il 1 item 2 some text        2 el 1 item 2 some text
          &#42;&#42; il 2 item 1 text            2.A el 2 item 1 text
          &#42;&#42; il 2 item 2 text            2.B el 2 item 2 text
 * </pre>
 * 
 * Changing the width of both lists will result in line wrapping:
 * <pre>{@code
	itemize.setWidth(19);
	enumerate.setWidth(19);
 * }</pre>
 * 
 * Now the rendering and printing will result in the following output:
 * <pre>
        &#42; il 1 item 1 some        1 el 1 item 1 some
          text                      text
        &#42; il 1 item 2 some        2 el 1 item 2 some
          text                      text
          &#42;&#42; il 2 item 1            2.A el 2 item 1
             text                       text
          &#42;&#42; il 2 item 2            2.B el 2 item 2
             text                       text
 * </pre>
 * 
 * 
 *  <br><h4>Enumerate list, pre-label string and special style</h4>
 * The list configuration option offer a lot of possibilities.
 * The following example creates an enumerate list with a set pre-label string and a particular style:
 * <pre>{@code
	AsciiList enumerate = new EnumerateList()
		.addItem("item 1")
		.addItem("item 2")
		.addItem("item 3")
		.setPreLabelString("E")
		.setListStyle(NestedEnumerateStyles.all_utf_arabic_subscript)
	;
 * }</pre>
 * 
 * The rendered list looks like this:
 * <pre>
	 E₁ item 1
	 E₂ item 2
	 E₃ item 3
 * </pre>
 * 
 * 
 * <br><h4>Checklists</h4>
 * <p>
 * 		The package also provides a check list.
 *		In this list, items can be marked as checked and unchecked resulting in different labels.
 *		The checklist supports styles to use different characters (ASCII and UTF) for checked and unchecked items.
 * </p>
 * 
 * The following code shows the creation of a checklist and the use of different styles for rendering it:
 * <pre>{@code
	CheckList list = new CheckList();
	list.addItem("item checked");
	list.addItemChecked("item unchecked");

	list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX);

	list.setListStyle(NestedCheckStyles.ALL_UTF_BALLOT_BOX_X);
 * }</pre>
 * 
 * The resulting output of these examples is (in columns):
 * <pre>
         [ ] item unchecked     ☐ item unchecked     ☐ item unchecked
         [X] item checked       ☑ item checked       ☒ item checked
 * </pre>
 * 
 * 
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.1 build 150901 (01-Sep-15) for Java 1.7
 */
package de.vandermeer.asciilist;


