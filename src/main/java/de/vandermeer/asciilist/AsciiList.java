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

package de.vandermeer.asciilist;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.skb.interfaces.document.IsList;
import de.vandermeer.skb.interfaces.strategies.collections.IsListStrategy;
import de.vandermeer.skb.interfaces.strategies.collections.list.ArrayListStrategy;
import de.vandermeer.skb.interfaces.transformers.ClusterElementTransformer;
import de.vandermeer.skb.interfaces.transformers.StrBuilder_To_String;

/**
 * An ASCII list with some formatting options.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.4-SNAPSHOT build 160319 (19-Mar-16) for Java 1.7
 * @since      v0.0.1
 */
public abstract class AsciiList<C extends AL_Context<?, ?, ?, ?>, I extends ListItem, R extends AL_Renderer<I, C>> implements IsList {

	/** The list context with optional settings for the list. */
	protected C ctx;

	/** The items of a list. */
	protected List<I> items;

	/** The default list strategy for the item list, set to {@link ArrayListStrategy}. */
	protected IsListStrategy<?, I> defaultStrategy = ArrayListStrategy.create();

	/** The renderer for this context. */
	protected R renderer;

	/**
	 * Creates a new list.
	 */
	public AsciiList(){
		this(null, null);
	}

	/**
	 * Creates a new list.
	 * @param isContinued true if the list is continued from a previous list of the same type, false otherwise
	 * @param ctx the list context, new default context created if null
	 * @throws NullPointerException if the finally set context is null (that is the given context as well as the locally created context were null)
	 */
	public AsciiList(IsListStrategy<?, I> strategy, C ctx){
		this.items = (strategy==null)?this.defaultStrategy.get():strategy.get();
		this.ctx = (ctx==null)?this.getNewContext():ctx;
		Validate.notNull(this.ctx, "could not create any context, all attempts are 'null'");
	}

	/**
	 * Returns a new context for the list
	 * @return new context, cannot be null
	 */
	protected abstract C getNewContext();

	/**
	 * Returns the list context.
	 * @return context, null if not set
	 */
	public C getContext(){
		return this.ctx;
	}

	/**
	 * Returns the items of the list.
	 * @return items of the list
	 */
	public List<I> getItems() {
		return this.items;
	}

	@Override
	public StrBuilder toLog() {
		StrBuilder ret = new StrBuilder();
		for(ListItem i : this.getItems()){
			ret.append(i.toLog());
			ret.appendNewLine();
		}
		return ret;
	}

	@Override
	public String render() {
		return new StrBuilder().appendWithSeparators(this.renderer.render(this.getRawContent(), this.ctx), "\n").toString();
	}

	@Override
	public String render(int width) {
		C renderCtx = this.getNewContext();
		renderCtx.copySettings(this.ctx);
		renderCtx.inheritSettings(this.ctx);
		renderCtx.setWidth(renderCtx.getTextWidth(width + renderCtx.getItemString().length()));
		return new StrBuilder().appendWithSeparators(this.renderer.render(this.getRawContent(), renderCtx), "\n").toString();
	}

	@Override
	public Collection<String> renderAsCollection() {
		return ClusterElementTransformer.create().transform(
				this.renderer.render(this.getRawContent(), this.ctx),
				StrBuilder_To_String.create(),
				ArrayListStrategy.create()
		);
	}

	@Override
	public Collection<String> renderAsCollection(int width) {
		return ClusterElementTransformer.create().transform(
				this.renderer.render(this.getRawContent(), this.ctx, this.ctx.getTextWidth(width)),
				StrBuilder_To_String.create(),
				ArrayListStrategy.create()
		);
	}

	public Collection<StrBuilder> renderAsChild(AL_Context<?, ?, ?, ?> parentCtx, int parentIndent){
		C renderCtx = this.getNewContext();
		renderCtx.copySettings(this.ctx);
		renderCtx.inheritSettings(parentCtx);
		renderCtx.setLevel(parentCtx.getLevel()+1);
		renderCtx.setItemMargin(parentIndent);
		renderCtx.setWidth((parentCtx.getWidth()+(renderCtx.getItemMargin()-renderCtx.getItemString().length())));
		return this.renderer.render(this.getRawContent(), renderCtx);
	}

	@Override
	public int getLongestLineLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<I> getRawContent() {
		return this.items;
	}

	@Override
	public AL_Renderer<I, C> getRenderer(){
		return this.renderer;
	}

	/**
	 * Sets the renderer for the context.
	 * @param renderer new renderer, only set if not null
	 * @return this to allow chaining
	 */
	public AsciiList<?, ?, ?> setRenderer(R renderer){
		if(renderer!=null){
			this.renderer = renderer;
		}
		return this;
	}
}
