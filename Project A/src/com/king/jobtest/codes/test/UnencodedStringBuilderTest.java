package com.king.jobtest.codes.test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.king.jobtest.codes.UnencodedStringBuilder;

public class UnencodedStringBuilderTest {
	
	@Test
	public void createUnencodedStringsTest(){
		
		UnencodedStringBuilder usb = new UnencodedStringBuilder();
		int kLenght = 2;
		boolean[][] list = usb.createAllPossibleUnencodedWords(kLenght);
		double numberOfCases = Math.pow(2, kLenght);
		assertEquals((int) numberOfCases, list.length);
		
	}
}
