package com.king.jobtest.getshorty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.king.jobtest.getshorty.data.Corridor;
import com.king.jobtest.getshorty.data.Dungeon;

public class Parser {

	public void parseInput(int numCorridor, int numIntersections, ArrayList<Dungeon> dungeonList) {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String input;
			
			while((input=br.readLine())!=null){
				
				if (input.equalsIgnoreCase("0 0"))  break; 
				
				String[] inputLine = input.split(" ");
				
				switch (checkInput(inputLine)) {
				case 2:
					if(dungeonList.isEmpty() || 
						(dungeonList.get(dungeonList.size()-1).getCorridorsNum() == numCorridor &&
						dungeonList.get(dungeonList.size()-1).getIntersectionsNum() == numIntersections)){

							dungeonList.add(new Dungeon());
							numCorridor = Integer.parseInt(inputLine[0]);
							numIntersections = Integer.parseInt(inputLine[1]);
					} else 
						System.out.println("Your last Test Case does not correspond to input number of Corridors ("+numCorridor +") and number of Intervals ("+numIntersections+")!");
					
					break;
				case 3:
					Corridor newCorr = new Corridor(Integer.parseInt(inputLine[0]), 
							Integer.parseInt(inputLine[1]), 
							Float.valueOf(inputLine[2]));
					dungeonList.get(dungeonList.size()-1).addCorridor(newCorr);
					break;
				default:
					break;
				}
						
			}
		
		}catch(IOException io){
			io.printStackTrace();
		}
	}
	
	private static int checkInput(String[] inputLine){
		int result = -1;
		
		switch (inputLine.length) {
		case 2: if(2 <=Integer.parseInt(inputLine[0]) &&
					10000 >= Integer.parseInt(inputLine[0]) &&
					1 <=Integer.parseInt(inputLine[1]) &&
					15000 >= Integer.parseInt(inputLine[1]) ) result = 2;
				else 
					System.out.println("Error in InputDimension: 2<='n'<=10000 OR 1<='m'<=15000");
				break;
		case 3: if(0<=Float.valueOf(inputLine[2]) && 
					Float.valueOf(inputLine[2])<=1 ) result = 3;
				else System.out.println("Error in InputDimension: 0<='f'<=1");
			break;
		default:
			System.out.println("Error in InputDimension, you che insert 2 OR 3 elemnts: instead you inserted "+inputLine.length +" element!");
			
			break;
		}
		return result;
	}

}
