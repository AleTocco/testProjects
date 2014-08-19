package com.king.jobtest.getshorty.data;


public class Corridor implements Comparable<Corridor>{
	
	private float sentry;
	private int intersectionA; 
	private int intersectionB; 
	
	public Corridor (int inputIntersectionA, int inputIntersectionB, float sentryWeponPower){
		
		intersectionA = inputIntersectionA;
		intersectionB = inputIntersectionB;
		
		sentry = sentryWeponPower;
	}

	public float getSentry() {
		return sentry;
	}

	public int getIntersectionA() {
		return intersectionA;
	}

	public int getIntersectionB() {
		return intersectionB;
	}

	public int getOppositeIntersection(int enter){
		int exit = -1;
		
		if(enter == intersectionA) exit = intersectionB;
		else if(enter == intersectionB) exit = intersectionA;
		
		return exit;
			
	}

	public int compareTo(Corridor o) {
		
		if(o.getIntersectionA() == this.getIntersectionA() &&
				o.getIntersectionB() == this.getIntersectionB()) return 0;
		else return 1;
	}
	
}
