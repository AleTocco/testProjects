package com.king.jobtest.getshorty;

import java.util.Set;
import java.util.TreeSet;

import com.king.jobtest.getshorty.data.Corridor;
import com.king.jobtest.getshorty.data.Dungeon;

public class DungeonBuilder {
	
	public Dungeon createNewDungeon(){
		
		return new Dungeon();
	}
	public Dungeon createSimpleDungeon(){
		
		int intersectionsNum = 8;
		Set<Corridor> corridors = new TreeSet<Corridor>();
		
		Corridor corA = new Corridor(0, 1, 0.123f);
		Corridor corB = new Corridor(0, 3, 0.324f);
		Corridor corC = new Corridor(1, 2, 0.001f);
		Corridor corD = new Corridor(3, 6, 0.5f);
		Corridor corE = new Corridor(5, 4, 0.155f);
		Corridor corF = new Corridor(7, 6, 0.2f);
		Corridor corG = new Corridor(2, 4, 0.2f);
		Corridor corH = new Corridor(7, 5, 0.1f);
		
		corridors.add(corA);
		corridors.add(corB);
		corridors.add(corC);
		corridors.add(corD);
		corridors.add(corE);
		corridors.add(corF);
		corridors.add(corG);
		corridors.add(corH);
		
		Dungeon lab = new Dungeon(intersectionsNum, corridors);
		
		return lab;
		
	}
	
	public Dungeon createAverageDungeon(){
		
		int intersectionsNum = 10;
		Set<Corridor> corridors = new TreeSet<Corridor>();
		
		Corridor corA = new Corridor(0, 1, 0.123f);
		Corridor corB = new Corridor(0, 2, 0.324f);
		Corridor corC = new Corridor(2, 3, 0.001f);
		Corridor corD = new Corridor(0, 3, 0.5f);
		Corridor corE = new Corridor(0, 4, 0.155f);
		Corridor corF = new Corridor(1, 5, 0.2f);
		Corridor corG = new Corridor(1, 6, 0.2f);
		Corridor corH = new Corridor(5, 7, 0.2f);
		Corridor corI = new Corridor(6, 7, 0.2f);
		Corridor corL = new Corridor(7, 9, 0.2f);
		Corridor corM = new Corridor(4, 5, 0.2f);
		Corridor corN = new Corridor(8, 9, 0.2f);
		Corridor corO = new Corridor(0, 8, 0.2f);
		
		corridors.add(corA);
		corridors.add(corB);
		corridors.add(corC);
		corridors.add(corD);
		corridors.add(corE);
		corridors.add(corF);
		corridors.add(corG);
		corridors.add(corH);
		corridors.add(corI);
		corridors.add(corL);
		corridors.add(corM);
		corridors.add(corN);
		corridors.add(corO);
		
		Dungeon lab = new Dungeon(intersectionsNum, corridors);
		
		return lab;
	}
}
