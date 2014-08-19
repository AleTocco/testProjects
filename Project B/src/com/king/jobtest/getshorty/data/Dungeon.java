package com.king.jobtest.getshorty.data;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Dungeon {
	
	private int corridorsNum;
	private int intersectionsNum;

	private Set<Corridor> corridors;
	
	public Dungeon(int inputIntersectionsNum, Set<Corridor> inputCorridors){
		
		intersectionsNum = inputIntersectionsNum;
		corridors = inputCorridors;
		corridorsNum = inputCorridors.size();
	}

	public Dungeon() {
		corridors = new TreeSet<Corridor>();
		corridorsNum = corridors.size();
		intersectionsNum = 0;
	}
	
	public boolean addCorridor(Corridor cor){
		
		for (Iterator<Corridor> iterator = corridors.iterator(); iterator.hasNext();) {
			Corridor dungeonCorridor = (Corridor) iterator.next();
			if(dungeonCorridor.compareTo(cor)==0) {
				System.out.println("ERROR - The Corridor("+cor.getIntersectionA()+";"+cor.getIntersectionB()+") is already in the dungeon!");
				return false;
			}
			
		}
		if(!isIntersectionInDungeon(cor.getIntersectionA())) 
			intersectionsNum++;
		if(!isIntersectionInDungeon(cor.getIntersectionB()))
			intersectionsNum++;
		corridors.add(cor);
		corridorsNum = corridors.size();
		
		
		return true;
	}
	
	public boolean isIntersectionInDungeon(int newInters){
		
		for (Iterator<Corridor> iterator = corridors.iterator(); iterator.hasNext();) {
			Corridor dungeonCorridor = (Corridor) iterator.next();
			
			if(dungeonCorridor.getIntersectionA()==newInters || dungeonCorridor.getIntersectionB()==newInters) {
				
				return true;
			}
			
		}
		
		return false;
	}
	
	public int getCorridorsNum() {
		return corridorsNum;
	}

	public int getIntersectionsNum() {
		return intersectionsNum;
	}

	public Set<Corridor> getCorridors() {
		return corridors;
	}
	
	
}
