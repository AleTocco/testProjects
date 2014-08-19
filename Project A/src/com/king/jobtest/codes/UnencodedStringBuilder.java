package com.king.jobtest.codes;


public class UnencodedStringBuilder {

	public boolean[][] createUnencodedStrings(int kLenght) {
		
	    int numRows = (int)Math.pow(2, kLenght);
	   
	    boolean[][] list = new boolean[numRows][kLenght];
	    for(int i = 0;i< list.length;i++)
	    {
	        for(int j = 0; j < list[i].length; j++)
	        {
	            int val = list.length * j + i;
	            int ret = (1 & (val >>> j));
	            list[i][j] = ret !=0;
	            System.out.print(list[i][j] + "\t");
	        }
	        System.out.println();
	    }

	    
		return list;
	}

}
