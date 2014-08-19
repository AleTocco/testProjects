package com.king.jobtest.codes;

public class Codifier {

	public boolean[] codify(boolean[][] generationMatrix, boolean[] unencoded){
		boolean[] resut = new boolean[generationMatrix.length];
		if(checkData(generationMatrix, unencoded)){
			matrixProduct(generationMatrix, unencoded, resut);
		}
		return resut;
	}

	private void matrixProduct(boolean[][] generationMatrix, boolean[] unencoded, boolean[] resut) {
		for (int i = 0; i < generationMatrix.length; i++) {
			for (int j = 0; j < generationMatrix[i].length; j++) {
				resut[i] = sum(resut[i], (multiply(generationMatrix[i][j],unencoded[j])));
			}
		}
		
		for (int i = 0; i < resut.length; i++) {
			System.out.print(resut[i]+ " ");
		}
		System.out.print("\n");
	}
	
	private boolean checkData(boolean[][] generationMatrix, boolean[] unencoded){
		if(generationMatrix[0].length == unencoded.length) return true;
		else {
			System.out.print("GenerationMatrix ("+generationMatrix[0].length+") and Unencoded ("+unencoded.length+") String are incompatible.");
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
	

}