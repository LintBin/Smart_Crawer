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
	
	//��">"Ϊ��׼���ָ���ʽ
	public String[] splite(String expressionStr){
		return expressionStr.split(">");
	}
	
	//�жϱ�ǩ��Ѱ�ҵ���ǩ
	public List judge(){
		String[] expressionArray = this.splite(expressionStr);
		tagList = new ArrayList<Tag>();
		//�õ����ʽ�е�ÿһ����ǩ
		for(String tagStr:expressionArray){
			Tag tag = new Tag();
			
			//ͬʱ����id��class,����ͳһ��ʽΪname#id.class������������Ⱥ����
			if(tagStr.indexOf(IDCHAR) != -1 && tagStr.indexOf(CLASSCHAR) != -1){
				String[] tagPart = tagStr.split(ESC+IDCHAR);
				tag.setTagName(tagPart[0]);
				String[] idAndClass = tagPart[1].split(ESC+CLASSCHAR);
				tag.setTagId(idAndClass[0]);
				tag.setTagClass(idAndClass[1]);
				tagList.add(tag);
				System.out.println("ͬʱӵ��id��class");
				continue;
			}
			//�ҵ�id
			if(tagStr.indexOf(IDCHAR) != -1){
				String[] tagPart = tagStr.split(ESC+IDCHAR);
				tag.setTagName(tagPart[0]);
				tag.setTagId(tagPart[1]);
				tagList.add(tag);
				System.out.println("ӵ��#");
				continue;
			}
			
			//�ҵ�class
			if(tagStr.indexOf(CLASSCHAR) != -1){
				String[] tagPart = tagStr.split(ESC+CLASSCHAR);
				tag.setTagName(tagPart[0]);
				tag.setTagClass(tagPart[1]);
				tagList.add(tag);
				System.out.println("ӵ��.");
				continue;
			}
			System.out.println("û��id��class");
			//��û��id��Ҳû��class
			tag.setTagName(tagStr);
			tagList.add(tag);
		}
		return tagList;
	}
}
