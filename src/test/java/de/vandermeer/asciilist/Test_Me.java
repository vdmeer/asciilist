package de.vandermeer.asciilist;

import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;

import de.svenjacobs.loremipsum.LoremIpsum;
import de.vandermeer.asciilist.itemize.ItemizeList;
import de.vandermeer.asciithemes.a7.A7_ItemizeLists;

public class Test_Me {

	@Test
	public void test_me(){

		ItemizeList il4 = new ItemizeList();
		il4.addItem("l4 i1");
		il4.addItem("l4 i2");

		ItemizeList il3 = new ItemizeList();
		il3.addItem("l3 i1");
		il3.addItem("l3 i2");
		il3.addItem("l3 i3", il4);

		ItemizeList il2 = new ItemizeList();
		il2.addItem("l2 i1");
		il2.addItem("l2 i2");
		il2.addItem("l2 i3", il3);

		ItemizeList il = new ItemizeList();
		il.addItem("line 1");
		il.addItem(new StrBuilder().append("line 2"));
		il.addItem("item with list", il2);
		il.addItem(new LoremIpsum().getWords(10));
//		il.getContext().setStyle(A7_ItemizeLists.allStar());
		il.getContext().setStyle(A7_ItemizeLists.allStarIncremental());

//		il.getContext().setWidth(13);
		System.err.println(il.render(13));
	}

	@Test
	public void test_Itemize(){
//		ItemizeList list = new ItemizeList();
//		list.getContext().setAlignment(AL_Alignment.LEFT);
//		list.addItem(new LoremIpsum().getWords(10));
//		list.addItem("item 2");
//		list.addItem("item 3");
//
//		list.getContext().setWidth(15);
//
//		String rend = list.render();
//		System.out.println(rend);
//
//		list.getContext().setLabelLeftMargin(5);
//		System.out.println("\n" + list.render());
//
//		list.getContext().init();
//		list.getContext().setLabelRightMargin(4);
//		System.out.println("\n" + list.render());
//
//		list.getContext().init();
//		list.getContext().setLeftLabelString(">>");
//		list.getContext().setRightLabelString("<<");
//		System.out.println("\n" + list.render());
//
//		list.getContext().init();
//		list.getContext().setStyle(U8_ItemizeLists.htmlLike());
//		System.out.println("\n" + list.render());
	}

	@Test
	public void test_ENumerate(){
//		EnumerateList list = new EnumerateList();
//		list.addItem("item 1");
//		list.addItem("item 2");
//		list.addItem("item 3");
//		System.err.println(list.render() + "\n");

//		EnumerateList list2 = new EnumerateList();
//		list2.addItem("two item 1");
//		list2.addItem("two item 2");
//		list2.addItem("two item 3");
//		list.addItem(list2);
//		System.err.println(list.render() + "\n");

//		list.setListStyle(NestedEnumerateStyles.all_roman_ascii);
//		list.addItem("item 4");
//		EnumerateList list3 = new EnumerateList();
//		list3.addItem("three item 1");
//		list3.addItem("three item 2");
//		list3.addItem("three item 3");
//		list3.setPostLabelString(")");
//		list.addItem(list3);
//		System.err.println(list.render() + "\n");
//
//		list.setListStyle(NestedEnumerateStyles.arabic_Alpha_alpha_Roman_roman);
//		System.err.println(list.render() + "\n");
	}
}

