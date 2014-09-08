package com.king.jobtest.getshorty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import com.king.jobtest.getshorty.data.Corridor;
import com.king.jobtest.getshorty.data.Dungeon;
import com.king.jobtest.getshorty.data.RouteTaken;


public class PathFinder {
		
	public String getShortestPath(Dungeon dungeon){
		ArrayList<RouteTaken> routesToStart = new ArrayList<RouteTaken>();
		
		// we have to find the shortest way to the exit, I'll start from the exit coming back to start
		routesToStart = getLastCorridors(dungeon, routesToStart);
		routesToStart = goPaths(dungeon, routesToStart);
			
		return getLessDamage(routesToStart);

	}


	private ArrayList<RouteTaken> goPaths(Dungeon dungeon, ArrayList<RouteTaken> routesToStart) {
		// trace all the possible paths from the exit to the start
		while(!areAllRoutesCompleted(routesToStart)){
			ArrayList<RouteTaken> routeListTmp = new ArrayList<RouteTaken>();
			
			for (int i = 0; i < routesToStart.size(); i++) {
				RouteTaken route = routesToStart.get(i);

				if(!(route.isPathCompleted() || route.isPathInterrupted())){	
					
					ArrayList<Corridor> nextCorridors = getCorridorsByIntersection(dungeon, route.getNextIntersection()); 
					
					for (int j = 0; j < nextCorridors.size(); j++) {
						Corridor cor = nextCorridors.get(j);

						if(!route.alreadyGoneFromHere(cor.getOppositeIntersection(route.getNextIntersection()))){
							RouteTaken newRoute = route.cloneRoute();
							newRoute.goToNextIntersection(cor);
									
							routeListTmp.add(newRoute);
						}
					}							
				}else routeListTmp.add(route);

			}
			routesToStart.clear();
			routesToStart = routeListTmp;

		}	
					
		return routesToStart;
	}
	
	private ArrayList<RouteTaken> getLastCorridors(Dungeon dungeon, ArrayList<RouteTaken> routesToStart) {
		ArrayList<Corridor> lastCorridors = getCorridorsByIntersection(dungeon, dungeon.getIntersectionsNum() - 1);
		
		for (Iterator<Corridor> iterator = lastCorridors.iterator(); iterator.hasNext();) {
			Corridor corridor = (Corridor) iterator.next();
			RouteTaken route = new RouteTaken(getOtherIntersection(corridor, dungeon.getIntersectionsNum() - 1), 
												dungeon.getIntersectionsNum() - 1,
												corridor.getSentry());
			routesToStart.add(route);
		}
		
		return routesToStart;
	}
	
	private String getLessDamage(ArrayList<RouteTaken> routesToStart) {
		
		final float MAXDAMAGE = 9999;
		float result = MAXDAMAGE;
		
		for (Iterator<RouteTaken> iterator = routesToStart.iterator(); iterator.hasNext();) {
			RouteTaken routeTaken = (RouteTaken) iterator.next();
			
			if(routeTaken.getDamage() < result && !routeTaken.isPathInterrupted()){
				result = routeTaken.getDamage();
			}
		}
		
		if(result != MAXDAMAGE)
			return 	String.format("%.4f%n", result);
		else return "ERROR";
	}

	public ArrayList<Corridor> getCorridorsByIntersection(Dungeon dungeon, int intersection){
		// return the list of all dungeoun's corridors that have the specific intersection
		ArrayList<Corridor> corridorsWithSelectedIntersection = new ArrayList<Corridor>();
		Set<Corridor> dungeonCorridors = dungeon.getCorridors();
		
		for (Iterator<Corridor> iterator = dungeonCorridors.iterator(); iterator.hasNext();) {
			Corridor corrTmp = (Corridor) iterator.next();
			if(corrTmp.getIntersectionA() == intersection ||
					corrTmp.getIntersectionB() == intersection){
				corridorsWithSelectedIntersection.add(corrTmp);
			}
		}
		
		
		return corridorsWithSelectedIntersection;
	}
	
	private int getOtherIntersection(Corridor corr, int intersection) {
		// given one intersection, return the opposite intersection of the same corridor (a corridor can have just 2 intersections)
		int otherIntersection = -1;
		
		if(intersection == corr.getIntersectionA()){
			otherIntersection = corr.getIntersectionB();
		}else if(intersection == corr.getIntersectionB()){
			otherIntersection = corr.getIntersectionA();
		}
		
		return otherIntersection;
	}
	
	public boolean areAllRoutesCompleted(ArrayList<RouteTaken> routes){
		boolean areCompleted = false;
		int count =0;
		for (int i = 0; i < routes.size(); i++) {
			RouteTaken route = (RouteTaken) routes.get(i);
			if(route.isPathCompleted()) count++;
		}
		
		if(count == routes.size()) areCompleted = true;
		
		return areCompleted;
	}
}
