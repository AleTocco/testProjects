package com.king.jobtest.codes;


public class UnencodedStringBuilder {

	public boolean[][] createAllPossibleUnencodedWords(int kLenght) {
		
	    int numRows = (int)Math.pow(2, kLenght);
	   
	    boolean[][] list = new boolean[numRows][kLenght];
	    for(int i = 0;i< list.length;i++)
	    {
	        for(int j = 0; j < list[i].length; j++)
	        {
	            int val = list.length * j + i;
	            int ret = (1 & (val >>> j));
	            list[i][j] = ret !=0;
	            
	        }
	       
	    }

		return list;
	}

}
