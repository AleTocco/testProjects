package com.king.jobtest.codes;

import java.util.ArrayList;
import java.util.Iterator;

public class Codes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UnencodedStringBuilder usb = new UnencodedStringBuilder();
		Parser parser = new Parser();
		Codifier codifier = new Codifier();
		
		ArrayList<boolean[][]> generationMatrixList = parser.parseInput();
		
		for (Iterator<boolean[][]> iteratorGenMatrixList = generationMatrixList.iterator(); iteratorGenMatrixList.hasNext();) {
			
			boolean[][] generationMatrix = (boolean[][]) iteratorGenMatrixList.next();
			
			// create a list of all possible 'k' dimension unencoded words
			boolean[][] unencodedWords = usb.createUnencodedStrings(generationMatrix[0].length);		
						
			ArrayList<boolean[]> encodedList = new ArrayList<boolean[]>();
			
			for (int i = 0; i < unencodedWords.length; i++) {
				// consider all non-zero unencoded words
				if(codifier.isNonZerocode(unencodedWords[i])){
					encodedList.add(codifier.codify(generationMatrix, unencodedWords[i]));
			 
				}
			}
			
			int minimumDistance=99999;
			for (Iterator<boolean[]> iterator = encodedList.iterator(); iterator.hasNext();) {
				
				int distance = codifier.calculateMinimumDistance((boolean[]) iterator.next());
				
				if(distance<minimumDistance) minimumDistance=distance;
			}
			
			System.out.print("\n"+ minimumDistance + "\n");
		}
		
		
	}


}
