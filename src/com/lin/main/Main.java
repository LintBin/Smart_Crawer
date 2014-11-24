package com.lin.main;

import org.jsoup.select.Elements;

import com.lin.connection.Connection;


public class Main {
	public static void main(String[] args) throws Exception {
		Connection connection = new Connection();
		Elements element = connection.getTargetElements();
		if(element != null){
			System.out.println("element:" + element.toString());
		}
		else{
			System.out.println("element is null");
		}
		System.out.println("end");
		
		
		
	}

}
