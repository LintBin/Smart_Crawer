package com.lin.selector;

import java.util.ArrayList;
import java.util.List;

import com.lin.vo.Tag;

public class Expression {
	public static final String CLASSCHAR = ".";
	public static final String IDCHAR = "#";
	public static final String ESC = "\\";
	public List<Tag> tagList = null;
	
	public String expressionStr;
	
	public Expression(String expressionStr){
		this.expressionStr = expressionStr;
	}
	
	//以">"为基准，分割表达式
	public String[] splite(String expressionStr){
		return expressionStr.split(">");
	}
	
	//判断标签，寻找到标签
	public List judge(){
		String[] expressionArray = this.splite(expressionStr);
		tagList = new ArrayList<Tag>();
		//拿到表达式中的每一个标签
		for(String tagStr:expressionArray){
			Tag tag = new Tag();
			
			//同时存在id和class,暂且统一格式为name#id.class，处理过程有先后过程
			if(tagStr.indexOf(IDCHAR) != -1 && tagStr.indexOf(CLASSCHAR) != -1){
				String[] tagPart = tagStr.split(ESC+IDCHAR);
				tag.setTagName(tagPart[0]);
				String[] idAndClass = tagPart[1].split(ESC+CLASSCHAR);
				tag.setTagId(idAndClass[0]);
				tag.setTagClass(idAndClass[1]);
				tagList.add(tag);
				System.out.println("同时拥有id和class");
				continue;
			}
			//找到id
			if(tagStr.indexOf(IDCHAR) != -1){
				String[] tagPart = tagStr.split(ESC+IDCHAR);
				tag.setTagName(tagPart[0]);
				tag.setTagId(tagPart[1]);
				tagList.add(tag);
				System.out.println("拥有#");
				continue;
			}
			
			//找到class
			if(tagStr.indexOf(CLASSCHAR) != -1){
				String[] tagPart = tagStr.split(ESC+CLASSCHAR);
				tag.setTagName(tagPart[0]);
				tag.setTagClass(tagPart[1]);
				tagList.add(tag);
				System.out.println("拥有.");
				continue;
			}
			System.out.println("没有id和class");
			//既没有id，也没有class
			tag.setTagName(tagStr);
			tagList.add(tag);
		}
		return tagList;
	}
}
