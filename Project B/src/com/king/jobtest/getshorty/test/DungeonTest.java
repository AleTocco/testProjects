package com.king.jobtest.getshorty.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.king.jobtest.getshorty.DungeonBuilder;
import com.king.jobtest.getshorty.data.Corridor;
import com.king.jobtest.getshorty.data.Dungeon;


public class DungeonTest {
	
	
	@Test
	public void getLastCorridorTest(){
		 
		DungeonBuilder db = new DungeonBuilder();
		Dungeon simpleDungeon = db.createSimpleDungeon();
		
		Corridor newCor = new Corridor(10, 7, 0.5f);
		
		assertEquals(8, simpleDungeon.getIntersectionsNum());
		assertEquals(8, simpleDungeon.getCorridors().size());
		
		assertEquals(true, simpleDungeon.addCorridor(newCor));
		
		Corridor newCorB = new Corridor(11, 7, 0.5f);
		assertEquals(11, newCorB.getIntersectionA());
		assertEquals(false, simpleDungeon.isIntersectionInDungeon(newCorB.getIntersectionA()));
	}
	
	
}
