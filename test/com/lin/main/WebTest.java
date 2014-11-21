package com.lin.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.lin.connection.Connection;
import com.lin.exception.NoTagException;
import com.lin.selector.Expression;
import com.lin.vo.Tag;

public class WebTest {
    @Test
    public void add() throws IOException{
    	Connection connection = new Connection();
    	File input = new File("test/source.shtml");
    	Connection.DOC = Jsoup.parse(input, "UTF-8", "http://example.com/");
    	Connection.ALL_Elements = Connection.DOC.children();
		//同时存在id和class,暂且统一格式为name#id.class，处理过程有先后过程
    	//Expression expression = new Expression("div.BSHARE_PO");
		try{
			Elements element = connection.getTargetElements();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("<<<<<<<<<<<<<< end >>>>>>>>>>>>");
    }
}
