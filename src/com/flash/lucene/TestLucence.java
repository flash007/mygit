package com.flash.lucene;

import org.junit.Test;

public class TestLucence {

	@Test
	public void testIndex(){
		HelloLucence hl = new HelloLucence();
		hl.index();
	}
	
	@Test
	public void testSearch(){
		HelloLucence hl = new HelloLucence();
		hl.search();
	}
}
