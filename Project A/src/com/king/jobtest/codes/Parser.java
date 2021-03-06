package com.king.jobtest.codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Parser {

	public ArrayList<boolean[][]> parseInput() {
		int testCases = 0;
		int testCasesRead = 9999;
		int n = 0;
		int k = 0;
		int matrixRowCount = 9999;
		boolean propertiesRead = false;
		
		ArrayList<boolean[][]> generationMatrixList = new ArrayList<boolean[][]>(); 
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String input;
			
			while((input=br.readLine())!=null){
				
				 
				
				String[] inputLine = input.split(" ");
				
				if(!propertiesRead){
					switch (inputLine.length) {
					// first row with test case number
					case 1:
						testCases = Integer.parseInt(inputLine[0]);
						testCasesRead = 0;
						break;
					// row with 'n' and 'k'
					case 2:
						matrixRowCount=0;
						propertiesRead = true;
						n =  Integer.parseInt(inputLine[0]);
						k =  Integer.parseInt(inputLine[1]);
						generationMatrixList.add(testCasesRead, new boolean[n][k]);
						break;
					
					default:
						
							
						break;
					}
				}else {
					// row with k element, is a row of generation matrix
					boolean[][] generationMatrix = (boolean[][]) generationMatrixList.get(testCasesRead);
					
					for (int i = 0; i < inputLine.length; i++) {
						generationMatrix[matrixRowCount][i] = (inputLine[i].equalsIgnoreCase("1")) ? true : false;
					}
					matrixRowCount++;
					
					if(matrixRowCount == n) {
						testCasesRead++;
						propertiesRead = false;
						}
					}
				
				//stop reading
				if (testCases == testCasesRead && matrixRowCount == n)  break;
			}		
			
		
		}catch(IOException io){
			io.printStackTrace();
		}
		
		return generationMatrixList;
	}
	

}
