package com.lin.selector;

import java.util.Stack;

import org.jsoup.select.Elements;

public class ElementsSelector {
	public Stack<Integer> stack = new Stack();
	//把多个符合要求的标签的元素放到List里面去
	public void select(Elements elements , int i) {
		if(elements.size() > 1 ) {
			stack.add(i);
		}
	}
	
	public int getElementsNum() {
		return stack.pop();
	}
	
	public Stack<Integer> getStack() {
		return stack;
	}
	
}
