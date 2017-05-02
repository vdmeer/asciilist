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
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.text.StrBuilder;

import de.vandermeer.skb.interfaces.strategies.collections.IsSetStrategy;
import de.vandermeer.skb.interfaces.strategies.collections.list.ArrayListStrategy;
import de.vandermeer.skb.interfaces.strategies.collections.set.LinkedHashSetStrategy;
import de.vandermeer.skb.interfaces.transformers.ClusterElementTransformer;
import de.vandermeer.skb.interfaces.transformers.StrBuilder_To_String;

/**
 * Fully functional abstract implementation of {@link AsciiList}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.0.5 build 170502 (02-May-17) for Java 1.8
 * @since      v0.0.1
 */
public abstract class AbstractAsciiList<C extends AbstractAsciiListContext, I extends AsciiListItem, R extends AbstractAsciiListRenderer<I, C>> implements AsciiList<C, I, R> {

	/** The list context with optional settings for the list. */
	public final C ctx;

	/** The items of a list. */
	protected final Set<I> items;

	/** The default list strategy for the item list, set to {@link LinkedHashSetStrategy}. */
	protected IsSetStrategy<?, I> defaultStrategy = LinkedHashSetStrategy.create();

	/** The renderer for this context. */
	protected R renderer;

	/**
	 * Creates a new list.
	 * @param ctx the list context, new default context created if null
	 * @throws NullPointerException if the finally set context is null (that is the given context as well as the locally created context were null)
	 */
	protected AbstractAsciiList(C ctx){
		this(ctx, null);
	}

	/**
	 * Creates a new list.
	 * @param ctx the list context, new default context created if null
	 * @param strategy the list strategy to be used for the list of items
	 * @throws NullPointerException if the finally set context is null (that is the given context as well as the locally created context were null)
	 */
	protected AbstractAsciiList(C ctx, IsSetStrategy<?, I> strategy){
		this.items = (strategy==null)?this.defaultStrategy.get():strategy.get();
		this.ctx = (ctx==null)?this.getNewContext():ctx;
		Validate.notNull(this.ctx, "could not create any context, all attempts are 'null'");
	}

	/**
	 * Creates a new list.
	 * @param strategy the list strategy to be used for the list of items
	 * @throws NullPointerException if the finally set context is null (that is the given context as well as the locally created context were null)
	 */
	protected AbstractAsciiList(IsSetStrategy<?, I> strategy){
		this(null, strategy);
	}

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
	public Set<I> getItems() {
		return this.items;
	}

	@Override
	public int getLongestLineLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<I> getRawContent() {
		return this.items;
	}

	@Override
	public AbstractAsciiListRenderer<I, C> getRenderer(){
		return this.renderer;
	}

	@Override
	public String render() {
		return new StrBuilder().appendWithSeparators(this.renderer.renderAsCollection(this.getRawContent(), this.ctx), "\n").toString();
	}

	@Override
	public String render(int width) {
		C renderCtx = this.getNewContext();
		renderCtx.copySettings(this.ctx);
		renderCtx.inheritSettings(this.ctx);
		renderCtx.setWidth(renderCtx.getTextWidth(width + renderCtx.getCalculatedItemString().length()));
		return new StrBuilder().appendWithSeparators(this.renderer.renderAsCollection(this.getRawContent(), renderCtx), "\n").toString();
	}

	@Override
	public Collection<StrBuilder> renderAsChild(AsciiListContext parentCtx, int parentIndent, int parentIndex){
		C renderCtx = this.getNewContext();
		renderCtx.copySettings(this.ctx);
		renderCtx.setParents(ArrayUtils.add(parentCtx.getParentIndex(), parentIndex));
		renderCtx.inheritSettings(parentCtx);
		renderCtx.setLevel(parentCtx.getLevel()+1);
		renderCtx.setItemMargin(parentIndent);
		renderCtx.setWidth((parentCtx.getWidth()+(renderCtx.getItemMargin()-renderCtx.getCalculatedItemString().length())));
		return this.renderer.renderAsCollection(this.getRawContent(), renderCtx);
	}

	@Override
	public Collection<String> renderAsCollection() {
		return ClusterElementTransformer.create().transform(
				this.renderer.renderAsCollection(this.getRawContent(), this.ctx),
				StrBuilder_To_String.create(),
				ArrayListStrategy.create()
		);
	}

	@Override
	public Collection<String> renderAsCollection(int width) {
		return ClusterElementTransformer.create().transform(
				this.renderer.renderAsCollection(this.getRawContent(), this.ctx, this.ctx.getTextWidth(width)),
				StrBuilder_To_String.create(),
				ArrayListStrategy.create()
		);
	}

	@Override
	public AsciiList<?, ?, ?> setRenderer(R renderer){
		if(renderer!=null){
			this.renderer = renderer;
		}
		return this;
	}

	@Override
	public StrBuilder toLog() {
		StrBuilder ret = new StrBuilder();
		for(AsciiListItem i : this.getItems()){
			ret.append(i.toLog());
			ret.appendNewLine();
		}
		return ret;
	}

}
