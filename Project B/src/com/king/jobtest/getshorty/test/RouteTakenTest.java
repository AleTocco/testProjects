package com.king.jobtest.getshorty.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.king.jobtest.getshorty.data.Corridor;
import com.king.jobtest.getshorty.data.RouteTaken;

public class RouteTakenTest {
	
	@Test
	public void doOneStepTest(){
		
		RouteTaken route = new RouteTaken(1, 0, 0.1f);
		
		Corridor corA = new Corridor(1, 2, 0.1f);
		Corridor corB = new Corridor(2, 3, 0.1f);
		Corridor corC = new Corridor(3, 1, 0.1f);
		Corridor corD = new Corridor(3, 4, 0.1f);
		Corridor corE = new Corridor(4, 5, 0.1f);
		
		route.doOneStep(corA);
		assertEquals(2, route.getNextStep());
		assertEquals(true, route.doOneStep(corB));
		assertEquals(false, route.doOneStep(corC));
		
		route.doOneStep(corD);
		route.doOneStep(corE);
		
		assertEquals(4, route.getLastStepDone());
		
	}
}
