package com.lin.connection;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.lin.exception.NoTagException;
import com.lin.exception.TagPropertyExcption;
import com.lin.selector.Expression;
import com.lin.selector.Parser;
import com.lin.util.XmlFile;
import com.lin.vo.Tag;

public class Connection {
	public static Document DOC;
	public static Elements ALL_Elements;
	
	static{
		try {
			XmlFile xmlFile = new XmlFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection() throws IOException{
		DOC = Jsoup.connect(XmlFile.URL).get();
		ALL_Elements = DOC.children();
	}
	
	
	public Elements getTargetElements() throws NoTagException, TagPropertyExcption, IOException{
		Expression expression = new Expression();
		List<Tag> targetTagList = expression.judge();
		Parser parser = new Parser(targetTagList);
		Elements resultElements  = parser.parse(ALL_Elements);
		if(resultElements.isEmpty()){
			throw new NoTagException();
		}
		return resultElements;
		
	}
}
