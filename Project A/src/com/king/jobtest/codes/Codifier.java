package com.king.jobtest.codes;

public class Codifier {

	public boolean[] codify(boolean[][] generationMatrix, boolean[] unencoded){
		boolean[] result = new boolean[0];
		if(checkData(generationMatrix, unencoded)){
			result = matrixProduct(generationMatrix, unencoded);
		}
		
		return result;
	}

	private boolean[] matrixProduct(boolean[][] generationMatrix, boolean[] unencoded) {
		boolean[] result = new boolean[generationMatrix.length];
		
		for (int i = 0; i < generationMatrix.length; i++) {
			for (int j = 0; j < generationMatrix[i].length; j++) {
				result[i] = sum(result[i], (multiply(generationMatrix[i][j],unencoded[j])));
			}
		}
		return result;		
	}
	
	private boolean checkData(boolean[][] generationMatrix, boolean[] unencoded) {
		if(generationMatrix[0].length == unencoded.length) return true;
		else {
			System.out.print("GenerationMatrix ("+generationMatrix[0].length+") and Unencoded String ("+unencoded.length+") are incompatible.");
			return false;
		}
	}
	
	private boolean sum(boolean x, boolean y){
		if (x == y) return false;
		else return true;
	}
	
	private boolean multiply(boolean x, boolean y){
		if(x == true && y == true) return true;
		else return false;
	}
	
	public int calculateMinimumDistance(boolean[] encoded){
		int count = 0;

		for (int i = 0; i < encoded.length; i++) {
			if(encoded[i]) count++;
		}
		return count;

		
	}
	
	public boolean isNonZerocode(boolean[] encoded){
		
		for (int i = 0; i < encoded.length; i++) {
			if(encoded[i] == true) return true;
		}
		return false;
	}
}