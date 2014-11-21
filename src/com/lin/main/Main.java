package com.lin.main;

import java.io.IOException;

import org.jsoup.select.Elements;

import com.lin.connection.Connection;
import com.lin.selector.Expression;
import com.lin.util.XmlFile;


public class Main {
	public static void main(String[] args) throws Exception {
		Connection connection = new Connection();
		Elements element = connection.getTargetElements();
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
