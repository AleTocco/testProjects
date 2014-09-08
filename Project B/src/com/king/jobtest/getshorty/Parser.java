package com.king.jobtest.getshorty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.king.jobtest.getshorty.data.Corridor;
import com.king.jobtest.getshorty.data.Dungeon;

public class Parser {

	public ArrayList<Dungeon> parseInput() {
		
		int numCorridor =0;
		int numIntersections=0;
		ArrayList<Dungeon> dungeonList = new ArrayList<Dungeon>();
				
		try{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String input;
			
			while((input=br.readLine())!=null){
				
				if (input.equalsIgnoreCase("0 0"))  break; 
				
				String[] inputLine = input.split(" ");
				
				switch (checkInput(inputLine)) {
				case 2:
					// if the dungeonList is empty or the last dungeon is completed -> add new dungeon to the list
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
					// add new Corridor into the dungeon
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
		
		return dungeonList;
	}
	
	private static int checkInput(String[] inputLine){
		int result = -1;
		
		switch (inputLine.length) {
		case 2: if(2 <=Integer.parseInt(inputLine[0]) &&
					10000 >= Integer.parseInt(inputLine[0]) &&
					1 <=Integer.parseInt(inputLine[1]) &&
					15000 >= Integer.parseInt(inputLine[1]) ) result = 2;
				else 
					System.out.println("Error in InputDimension: 2<='n'<=10000 OR 1<='m'<=15000 \n");
				break;
		case 3: if(0<=Float.valueOf(inputLine[2]) && 
					Float.valueOf(inputLine[2])<=1 ) result = 3;
				else System.out.println("Error in InputDimension: 0<='f'<=1 \n");
			break;
		default:
			System.out.println("Error in InputDimension, you che insert 2 OR 3 elemnts: instead you inserted "+inputLine.length +" element! \n");
			
			break;
		}
		return result;
	}

}
