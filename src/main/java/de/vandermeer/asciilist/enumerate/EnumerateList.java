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

package de.vandermeer.asciilist.enumerate;

import de.vandermeer.asciilist.AsciiList;
import de.vandermeer.asciilist.ListItem;

/**
 * An enumerate list.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.3-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.1.0
 */
public class EnumerateList extends AsciiList<El_Context, ListItem, El_Renderer> {

	/**
	 * Creates a new enumerate list.
	 */
	public EnumerateList(){
		this(null);
	}

	/**
	 * Creates a new enumerate list.
	 * @param ctx list context, using default if null
	 */
	public EnumerateList(El_Context ctx){
		if(ctx==null){
			this.ctx = new El_Context();
		}
		else{
			this.ctx = ctx;
		}
		this.renderer = new El_Renderer();
	}

	public EnumerateList addItem(Object text){
		this.getItems().add(new ListItem(text));
		return this;
	}

	public EnumerateList addItem(Object text, AsciiList<?, ?, ?> list){
		this.getItems().add(new ListItem(text, list));
		return this;
	}

	@Override
	protected El_Context getNewContext() {
		return new El_Context();
	}
}
