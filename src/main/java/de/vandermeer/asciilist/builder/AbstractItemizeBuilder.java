package de.vandermeer.asciilist.builder;

import de.vandermeer.asciilist.itemize.ItemizeList;
import de.vandermeer.asciilist.itemize.ItemizeListContext;
import de.vandermeer.asciilist.itemize.ItemizeListItem;
import de.vandermeer.skb.interfaces.strategies.collections.IsSetStrategy;

public class AbstractItemizeBuilder extends Lb2<ItemizeList> {

	protected Object currentItem;

	protected ItemizeList list;

	protected Lb2<?> currentBuilder;

	protected Object parrentBuilder;

	public AbstractItemizeBuilder(){
		this(null, null);
	}

	public AbstractItemizeBuilder(IsSetStrategy<?, ItemizeListItem> strategy){
		this(null, strategy);
	}

	public AbstractItemizeBuilder(ItemizeListContext ctx){
		this(ctx, null);
	}

	public AbstractItemizeBuilder(ItemizeListContext ctx, IsSetStrategy<?, ItemizeListItem> strategy){
		this.list = new ItemizeList(ctx, strategy);
	}

	public AbstractItemizeBuilder endItemize(){
		this.item(null);
		if(this.parrentBuilder!=null && (this.parrentBuilder instanceof AbstractItemizeBuilder)){
			return (AbstractItemizeBuilder)this.parrentBuilder;
		}
		else if(this.parrentBuilder!=null){
			throw new IllegalThreadStateException("end itemize called without a start itemze");
		}
		return this;
	}

	@Override
	public ItemizeList get(){
		this.item(null);
		return this.list;
	}

	public AbstractItemizeBuilder item(Object text){
		if(this.currentItem!=null && this.currentBuilder==null){
			this.list.addItem(this.currentItem);
		}
		else if(this.currentItem!=null && this.currentBuilder!=null){
			this.list.addItem(this.currentItem, this.currentBuilder.get());
			this.currentBuilder = null;
		}
		this.currentItem = text;
		return this;
	}

	@Override
	void setParent(Lb2<?> parent){
		this.parrentBuilder = parent;
	}

	public AbstractItemizeBuilder withItemizeList(){
		this.currentBuilder = new AbstractItemizeBuilder();
		return (AbstractItemizeBuilder)this.currentBuilder;
	}
}
