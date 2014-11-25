package com.lin.selector;

import java.util.Stack;

import org.jsoup.select.Elements;

public class ElementsSelector {
	public Stack<Integer> stack = new Stack();
	//�Ѷ������Ҫ��ı�ǩ��Ԫ�طŵ�List����ȥ
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
