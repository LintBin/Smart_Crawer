package com.lin.main;

import java.util.List;

import org.jsoup.select.Elements;

import com.lin.connection.Connection;
import com.lin.selector.Expression;
import com.lin.vo.Tag;


public class Main {
	public static void main(String[] args) throws Exception {
		String url = "http://sports.sina.com.cn/nba/2014-11-19/18517416337.shtml";
		Connection connection = new Connection(url);
		Expression expression = new Expression("body>div.wrap>div.Main>div.blkContainer>div#J_Article_Wrap>div.blkContainerSblk>div#artibody.BSHARE_POP");
		Elements element = connection.getTargetElements(expression.judge());
		if(element != null){
			System.out.println("element:" + element.toString());
			System.out.println(element.toString());
		}
		else{
			System.out.println("element is null");
		}
		System.out.println("end");
		
		
		
	}

}
