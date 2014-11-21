package com.lin.connection;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.lin.exception.NoTagException;
import com.lin.exception.TagPropertyExcption;
import com.lin.selector.Parser;
import com.lin.vo.Tag;

public class Connection {
	public static String URL;
	public static Document DOC;
	public static Elements ALL_Elements;
	
	public Connection(String url) throws IOException{
		this.URL = url;
		DOC = Jsoup.connect(URL).get();
		ALL_Elements = DOC.children();
	}
	
	
	public Elements getTargetElements(List<Tag> targetTagList) throws NoTagException, TagPropertyExcption{
		Parser parser = new Parser(targetTagList);
		Elements resultElements  = parser.parse(ALL_Elements);
		if(resultElements.isEmpty()){
			throw new NoTagException();
		}
		return resultElements;
		
	}
}
