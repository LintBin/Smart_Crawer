package com.lin.selector;

import java.util.List;

import org.jsoup.select.Elements;

import com.lin.exception.TagPropertyExcption;
import com.lin.vo.Tag;

public class Parser {
	public static List<Tag> Target_TAG_LIST;
	public static int i = 0;
	
	
	public Parser(List<Tag> targetTagList){
		this.Target_TAG_LIST  = targetTagList;
	}
	
	public int getJudgeCode(Tag tag){
		//同时存在class和id
		if(tag.getTagClass() != null && tag.getTagId() != null ){
			return 0;
		}
		//只存在class
		if(tag.getTagClass() != null && tag.getTagId() == null){
			return 1;
		}
		//只存在id
		if(tag.getTagClass() == null && tag.getTagId() != null){
			return 2;
		}
		//既不存在class，也不存在id
		return 3;
	}
	
	public Elements accurateJudge(Tag tag , Elements elements ) throws TagPropertyExcption{
		System.out.println("accurateJudge is running");
		int judgeCode = this.getJudgeCode(tag);
		switch (judgeCode) {
		case 0:
			return this.findTagByClassAndId(tag, elements);
		case 1:
			return this.findTagByClass(tag, elements);
		case 2:
			return this.findTagById(tag, elements);
		case 3:
			return this.findTagOnlyWithName(tag, elements);
		default:
			throw new TagPropertyExcption();
		}
	}
	
	/**
	 * 进行模糊判断
	 * @param tag
	 * @param elements
	 * @return Elements
	 * @throws TagPropertyExcption 
	 */
	public Elements fuzzyJudge(Tag tag , Elements elements) throws TagPropertyExcption{
		int judgeCode = this.getJudgeCode(tag);
		switch (judgeCode) {
		//同时存在class和id的时候
		case 0:
			Elements classResult = this.findTagByClass(tag, elements);
			Elements idResult = this.findTagById(tag, elements);
			
			if(classResult.isEmpty() && idResult.isEmpty()){
				System.out.println("classResult  is  null and idResult is ");
				return null;
			}
			if(classResult.isEmpty() && (idResult.isEmpty() == false)){
				System.out.println("classResult  is null and idResult is not");
				return idResult;
			}
			if((classResult.isEmpty() == false) && idResult.isEmpty()){
				System.out.println("classResult  is not null and idResult is");
				return classResult;
			}
			if(idResult.isEmpty() == false && classResult.isEmpty() == false){
				System.out.println("both of idResult and classResult is not null");
				if(idResult.containsAll(classResult)){
					System.out.println("idResult.containsAll");
					return idResult;
				}else{
					throw new TagPropertyExcption();
				}
			}
			throw new TagPropertyExcption();
			
			
		case 1:
			return this.findTagOnlyWithName(tag, elements);
		case 2:
			return this.findTagOnlyWithName(tag, elements);
		case 3:
			return null;
		default:
			throw new TagPropertyExcption();
		}
	}
	
	
	
	/**
	 * 递归遍历元素
	 * @param elements
	 * @return Elements
	 * @throws TagPropertyExcption 
	 */
	public Elements parse(Elements elements ) throws TagPropertyExcption{
		System.out.println();
		System.out.println("size:"+ Target_TAG_LIST.size());
		System.out.println("i:" + i);
		if(i >= Target_TAG_LIST.size()){
			System.out.println("目标标签已经找到");
			//已经找到自己想找的标签了
			return elements;
		}
		System.out.println("parse method is running");
		Elements resultElement = this.accurateJudge(Target_TAG_LIST.get(i), elements);
		//检测所查到的元素，如果没有则表示查不到该元素
		if (resultElement.isEmpty() == true){
			//找不到元素，进行模糊查询
			Elements resultElements = this.fuzzyJudge(Target_TAG_LIST.get(i), elements);
			if(resultElements.isEmpty() == false){
				i++;
				resultElements = this.parse(resultElements);
				return resultElements;
			}else{
				return null;
			}
		}else{
			i++;
			resultElement = this.parse(resultElement);
		}
		
		return resultElement;
	}
	
	public Elements findTagById(Tag tag ,Elements elements){
		System.out.println("运行的表达式:" + tag.getTagName() + Expression.IDCHAR + tag.getTagId());
		return elements.select(tag.getTagName() + Expression.IDCHAR + tag.getTagId());
	}
	
	public Elements findTagByClass(Tag tag , Elements elements){
		System.out.println("运行的表达式:" + tag.getTagName() + Expression.CLASSCHAR + tag.getTagClass());
		return elements.select(tag.getTagName() + Expression.CLASSCHAR + tag.getTagClass());
	}
	
	public Elements findTagByClassAndId(Tag tag , Elements elements){
		System.out.println("运行的表达式:" + tag.getTagName() + Expression.CLASSCHAR + tag.getTagId() + Expression.IDCHAR + tag.getTagClass());
		return elements.select(tag.getTagName() + Expression.CLASSCHAR + tag.getTagId() + Expression.IDCHAR + tag.getTagClass());
	}
	
	public Elements findTagOnlyWithName(Tag tag , Elements elements){
		return elements.select(tag.getTagName());
	}
}
