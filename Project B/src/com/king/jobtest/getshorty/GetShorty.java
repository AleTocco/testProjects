package com.king.jobtest.getshorty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.king.jobtest.getshorty.data.Corridor;
import com.king.jobtest.getshorty.data.Dungeon;

public class GetShorty {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DungeonBuilder db = new DungeonBuilder();
		int numCorridor =0;
		int numIntersections=0;
		ArrayList<Dungeon> dungeonList = new ArrayList<Dungeon>();
		Parser parser = new Parser();
		
		parser.parseInput(numCorridor, numIntersections, dungeonList);
		

		
		PathFinder pf = new PathFinder();
		
		for (Dungeon dungeon : dungeonList) {
			String result = pf.getShortestPath(dungeon);

			System.out.println(result);
		}

		
	}


}
