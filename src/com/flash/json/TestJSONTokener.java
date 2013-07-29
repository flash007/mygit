package com.flash.json;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.XML;
import org.junit.Test;

public class TestJSONTokener {

	@Test
	public void test(){
		JSONTokener jk = new JSONTokener("123 56:9d");
		
		System.out.println(jk.nextClean());
		jk.back();
        System.out.println(jk.nextValue().toString());
		System.out.println(jk.nextClean());
	}
	
	
	@Test
	public void testXML(){
		String jsonString ="{a:1,b:2,c:3}";
		JSONObject jo = new JSONObject(jsonString);
		String xmlString = XML.toString(jo);
		
		System.out.println(xmlString);
	}
}
