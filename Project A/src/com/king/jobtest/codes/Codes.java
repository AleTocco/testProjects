package com.king.jobtest.codes;

import java.util.ArrayList;
import java.util.Iterator;

public class Codes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UnencodedStringBuilder usb = new UnencodedStringBuilder();
		/*
		boolean[][] unencodedList = usb.createUnencodedStrings(4);		
		boolean[][] generationMatrix = {{true, false, false, false}, 
											{false, true, false, false},
											{false, false, true, false},
											{false, false, false, true},
											{false, true, true, true},
											{true, false, true, true},
											{true, true, false, true}};
		*/
		Parser parser = new Parser();
		
		ArrayList<boolean[][]> generationMatrixList = parser.parseInput();
		
		for (Iterator<boolean[][]> iteratorGenMatrixList = generationMatrixList.iterator(); iteratorGenMatrixList.hasNext();) {
			
			boolean[][] generationMatrix = (boolean[][]) iteratorGenMatrixList.next();
			
			// create a list of all possible 'k' dimension unencoded words
			boolean[][] unencodedWords = usb.createUnencodedStrings(generationMatrix[0].length);		
						
			ArrayList<boolean[]> encodedList = new ArrayList<boolean[]>();
			
			for (int i = 0; i < unencodedWords.length; i++) {
				// consider all non-zero unencoded words
				if(isNonZerocode(unencodedWords[i])){
					encodedList.add((new Codifier()).codify(generationMatrix, unencodedWords[i]));
			
				}
			}
			
			int minimumDistance=99999;
			for (Iterator<boolean[]> iterator = encodedList.iterator(); iterator.hasNext();) {
				
				int distance = calculateMinimumDistance((boolean[]) iterator.next());
				
				if(distance<minimumDistance) minimumDistance=distance;
			}
			
			System.out.print("\nmin dinstance = "+ minimumDistance);
		}
		
		
	}

	private static int calculateMinimumDistance(boolean[] encoded){
		int count = 0;

		for (int i = 0; i < encoded.length; i++) {
			if(encoded[i]) count++;
		}
		return count;

		
	}
	
	private static boolean isNonZerocode(boolean[] encoded){
		
		for (int i = 0; i < encoded.length; i++) {
			if(encoded[i] == true) return true;
		}
		return false;
	}
}
