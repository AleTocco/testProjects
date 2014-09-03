package com.king.jobtest.codes.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.king.jobtest.codes.Codifier;

public class CodifierShould {
	boolean[] zeroCodeWord;
	boolean[] TFFFcodeWord;
	boolean[] TFFTcodeWord;
	boolean[][] generationMatrix;
	Codifier codifier = new Codifier();
			
	
	@Before
	public void init(){
		zeroCodeWord = new boolean[]{false, false, false, false};
		TFFFcodeWord = new boolean[]{true, false, false, false};
		TFFTcodeWord = new boolean[]{true, false, false, true};
		
		generationMatrix = new boolean[][]{
											{true, false, false, false},
											{false, true, false, false},
											{false, false, true, false},
											{false, false, false, true},
											{false, true, true, true},
											{true, false, true, true},
											{true, true, false, true}
									};
	}
	
	@Test
	public void MultiplyMatrix(){
		
		boolean[] encodedWord = codifier.codify(generationMatrix, TFFTcodeWord);
		
		assertTrue(generationMatrix.length == encodedWord.length);
			
	}
	
	@Test
	public void ReturnEncodedLenght0IfTheMatrixMultiplicationIsNotPossible(){
		boolean[] shortUnencodedWord = new boolean[]{true, true, true};
		boolean[] shortEncodedWord = codifier.codify(generationMatrix, shortUnencodedWord);
		
		assertTrue(0 == shortEncodedWord.length);
	}
	
	@Test
	public void FindMinimumDistance(){
		assertTrue(0 ==  codifier.calculateMinimumDistance(zeroCodeWord));
		assertTrue(1 ==  codifier.calculateMinimumDistance(TFFFcodeWord));
		assertTrue(2 ==  codifier.calculateMinimumDistance(TFFTcodeWord));
	}
	
	@Test
	public void RecogniseANonZeroCode(){
		assertFalse(codifier.isNonZerocode(zeroCodeWord));
		assertTrue(codifier.isNonZerocode(TFFFcodeWord));
	}
	
	
}
