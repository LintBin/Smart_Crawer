package com.lin.util;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class XmlFile {
	public static String URL ;
	public static String EXPRESSION ;
	public XmlFile() throws IOException{
		File file = new File("src/Application.xml");
		Document doc = Jsoup.parse(file, "UTF-8");
		URL = doc.select("URL").text();
		EXPRESSION = doc.select("expression").text();
		System.out.println("URL:" + URL);
		System.out.println("expression:" + EXPRESSION);
	}
}
