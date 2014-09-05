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
			boolean[][] unencodedWordsList = usb.createAllPossibleUnencodedWords(generationMatrix[0].length);		
						
			ArrayList<boolean[]> encodedWordsList = createEncodedWords(codifier, generationMatrix, unencodedWordsList);
					
			int minimumDistance = getMinimumDistance(codifier, encodedWordsList);
			
			System.out.print("\n"+ minimumDistance);
		}
		
		
	}

	private static ArrayList<boolean[]> createEncodedWords(Codifier codifier, boolean[][] generationMatrix, boolean[][] unencodedWordsList) {
		ArrayList<boolean[]> encodedWordsList = new ArrayList<boolean[]>();
		
		for (int i = 0; i < unencodedWordsList.length; i++) {
			// consider all non-zero unencoded words
			if(codifier.isNonZerocode(unencodedWordsList[i])){
				encodedWordsList.add(codifier.codify(generationMatrix, unencodedWordsList[i]));
		 
			}
		}
		return encodedWordsList;
	}

	private static int getMinimumDistance(Codifier codifier, ArrayList<boolean[]> encodedWordsList) {
		int minimumDistance=99999;
		for (Iterator<boolean[]> iterator = encodedWordsList.iterator(); iterator.hasNext();) {
			
			int distance = codifier.calculateMinimumDistance((boolean[]) iterator.next());
			
			if(distance<minimumDistance) minimumDistance=distance;
		}
		return minimumDistance;
	}


}
