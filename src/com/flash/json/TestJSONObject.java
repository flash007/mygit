package com.flash.json;

import org.json.JSONObject;
import org.junit.Test;

public class TestJSONObject {

	
	@Test
	public void testDoubleToString(){
		Double d = 12.36E12;
		String d2s = JSONObject.doubleToString(d);
		System.out.println(d2s);
	}
	
	@Test
	public void testJSONObject(){
		String jsonString="{\"a\":1}";
		JSONObject jo = new JSONObject(jsonString);
		
		int value = jo.getInt("a");
		System.out.println(value);
	}
	
	@Test
	public void testGetNames(){
		
		String jsonString ="{a:1,b:2,c:3}";
		JSONObject jo = new JSONObject(jsonString);
		
		String[] names = JSONObject.getNames(jo);
		
		for(String name :names){
			System.out.println(name);
		}
	}
	
	@Test
	public void testQuote(){
		String inString = "125";
		String outString = JSONObject.quote(inString);
		System.out.println(outString);
	}
	
}
