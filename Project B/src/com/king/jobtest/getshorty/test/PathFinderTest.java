package com.king.jobtest.getshorty.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.king.jobtest.getshorty.DungeonBuilder;
import com.king.jobtest.getshorty.PathFinder;
import com.king.jobtest.getshorty.data.Corridor;
import com.king.jobtest.getshorty.data.Dungeon;
import com.king.jobtest.getshorty.data.RouteTaken;


public class PathFinderTest {
	
	
	@Test
	public void getLastCorridorTest(){
		 
		DungeonBuilder db = new DungeonBuilder();
		Dungeon simpleDungeon = db.createSimpleDungeon();
		
		PathFinder pf = new PathFinder();
		ArrayList<Corridor> lastCorridors = pf.getCorridorsByIntersection(simpleDungeon, simpleDungeon.getIntersectionsNum() - 1);		
		 
		assertEquals(2, lastCorridors.size());
		
		assertEquals(7, lastCorridors.get(0).getIntersectionA());
		assertEquals(6, lastCorridors.get(0).getIntersectionB());	
		
		assertEquals(7, lastCorridors.get(1).getIntersectionA());
		assertEquals(5, lastCorridors.get(1).getIntersectionB());
	}
	
	@Test
	public void getFirstCorridorTest(){
		
		DungeonBuilder db = new DungeonBuilder();
		Dungeon averageDungeon = db.createAverageDungeon();
		
		PathFinder pf = new PathFinder();
		ArrayList<Corridor> lastCorridors = pf.getCorridorsByIntersection(averageDungeon, 0);		
		for (int i = 0; i < lastCorridors.size(); i++) {
			Corridor corr = lastCorridors.get(i);
			
			assertEquals(0, corr.getIntersectionA());
		}		
				
	}
	
	
	public void getOtherIntersectionTest(){
/*
		DungeonBuilder db = new DungeonBuilder();
		Dungeon averageDungeon = db.createAverageDungeon();
		
		PathFinder pf = new PathFinder();
		Corridor corr = averageDungeon.getCorridors().iterator().get(4);
		
		int nextStep = -1;
		try {
			nextStep = pf.getOtherIntersection(corr, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(4, nextStep);
*/		
	}
	
	@Test
	public void areAllRoutesCompletedTest(){

		RouteTaken routeA = new RouteTaken(5,4, 0.1f);
		assertEquals(false, routeA.isPathCompleted());
		
		routeA.setNextStep(0);
		assertEquals(true, routeA.isPathCompleted());
		 
		RouteTaken routeB = new RouteTaken(0,4, 0.1f);
		assertEquals(true, routeB.isPathCompleted());
		
		RouteTaken routeC = new RouteTaken(0,4, 0.1f);
		RouteTaken routeD = new RouteTaken(0,4, 0.1f);
		RouteTaken routeE = new RouteTaken(0,4, 0.1f);
		RouteTaken routeF = new RouteTaken(0,4, 0.1f);
		
		ArrayList<RouteTaken> routeList = new ArrayList<RouteTaken>();
		routeList.add(routeA);
		routeList.add(routeB);
		routeList.add(routeC);
		routeList.add(routeD);
		routeList.add(routeE);
		routeList.add(routeF);
		
		assertEquals(true, new PathFinder().areAllRoutesCompleted(routeList));
	}
	
	public void getShortestPathTest(){

	
		
	}
}
