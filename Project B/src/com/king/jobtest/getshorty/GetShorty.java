package com.king.jobtest.getshorty;

import java.util.ArrayList;

import com.king.jobtest.getshorty.data.Dungeon;

public class GetShorty {

	public static void main(String[] args) {
		
		Parser parser = new Parser();
		PathFinder pf = new PathFinder();
		
		ArrayList<Dungeon> dungeonList = parser.parseInput();
		
		for (Dungeon dungeon : dungeonList) {
			String result = pf.getShortestPath(dungeon);

			System.out.println(result);
		}

	}


}
