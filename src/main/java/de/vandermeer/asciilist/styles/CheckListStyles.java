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

import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.asciilist.AsciiList_Check;

/**
 * Styles for an check lists - {@link AsciiList_Check}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160301 (01-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public enum CheckListStyles implements ListStyle_Check {

	/**
	 * Style that uses square brackets and X.
	 * For example:
	 * <pre>
	[ ] unchecked item
	[X] checked item
	 * </pre>
	 * 
	 */
	ASCII_SQUARE_BRACKET_BLANK_X ("[", " ", "X", "]"),

	/**
	 * Style that uses UTF-8 ballot box characters.
	 * For example:
	 * <pre>
	☐ unchecked item
	☑ checked item
	 * </pre>
	 */
	UTF_BALLOT_BOX ("", "☐", "☑", ""),

	/**
	 * Style that uses UTF-8 ballot box characters with X box for checked.
	 * For example:
	 * <pre>
	☐ unchecked item
	☒ checked item
	 * </pre>
	 */
	UTF_BALLOT_BOX_X ("", "☐", "☒", ""),

	/**
	 * Style that uses blank for unchecked and UTF-8 ballot X for checked items.
	 * For example:
	 * <pre>
	  unchecked item
	✗ checked item
	 * </pre>
	 */
	UTF_BALLOT_X ("", " ", "✗", ""),

	/**
	 * Style that uses blank for unchecked and UTF-8 ballot heavy X for checked items.
	 * For example:
	 * <pre>
	  unchecked item
	✘ checked item
	 * </pre>
	 */
	UTF_BALLOT_X_HEAVY ("", " ", "✘", ""),

	/**
	 * Style that uses blank for unchecked and UTF-8 checkmark for checked items.
	 * For example:
	 * <pre>
	  unchecked item
	✓ checked item
	 * </pre>
	 */
	UTF_CHECKMARK ("", " ", "✓", ""),

	/**
	 * Style that uses blank for unchecked and UTF-8 multiplication x for checked items.
	 * For example:
	 * <pre>
	  unchecked item
	✕ checked item
	 * </pre>
	 */
	UTF_MULTIPLICATION_X ("", " ", "✕", ""),

	;

	/** String left of label. */
	String left;

	/** String right of label. */
	String right;

	/** Checked label. */
	String checked;

	/** Unchecked label. */
	String unchecked;

	CheckListStyles(String left, String unchecked, String checked, String right){
		this.left = left;
		this.unchecked = unchecked;
		this.checked = checked;
		this.right = right;
	}

	@Override
	public String getLabelChecked() {
		return this.left + this.checked + this.right;
	}

	@Override
	public String getLabelUnchecked() {
		return this.left + this.unchecked + this.right;
	}

	@Override
	public StrBuilder toDoc() {
		StrBuilder ret = new StrBuilder(30);
		ret.append(this.getLabelUnchecked()).append(" unchecked item").appendNewLine();
		ret.append(this.getLabelChecked()).append(" checked item").appendNewLine();
		return ret;
	}

}

