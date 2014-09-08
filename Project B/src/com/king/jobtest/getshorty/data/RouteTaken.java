package com.king.jobtest.getshorty.data;

import java.util.ArrayList;

public class RouteTaken {
	
	private int nextIntersection;
	private ArrayList<Integer> intersectionsTaken;
	private float damage;
	private boolean pathCompleted;
	private boolean pathInterrupted;

	public RouteTaken(int inputNextIntersection, int inputPreviousIntersection, float inputDamage){
		intersectionsTaken = new ArrayList<Integer>();
		
		nextIntersection = inputNextIntersection;
		intersectionsTaken.add(inputPreviousIntersection);
		damage = inputDamage;
		pathInterrupted = false;
		
		if(this.nextIntersection == 0) 
			setPathCompleted(true);
		else 
			pathCompleted = false;
		
	}
	
	private RouteTaken(){
		
	}
	
	
	public RouteTaken cloneRoute(){
		RouteTaken newRoute = new RouteTaken();
		newRoute.setNextIntersection(this.nextIntersection);
		newRoute.setDamage(this.damage);
		newRoute.setIntersectionsTaken(this.intersectionsTaken);
		newRoute.setPathCompleted(this.pathCompleted);
		newRoute.setPathInterrupted(this.pathInterrupted);
		return newRoute;
		
	}

	public int getNextIntersection() {
		return nextIntersection;
	}

	public void setNextIntersection(int nextIntersection) {
		this.nextIntersection = nextIntersection;
		if(this.nextIntersection == 0) setPathCompleted(true);
	}

	public float getDamage() {
		return damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	public boolean isPathCompleted() {
		return pathCompleted;
	}

	private void setPathCompleted(boolean pathCompleted) {
		this.pathCompleted = pathCompleted;
	}
	
	public int getLastIntersectionTaken(){
		return ((Integer)intersectionsTaken.get(intersectionsTaken.size()-1)).intValue();
	}
	
	public boolean isPathInterrupted() {
		return pathInterrupted;
	}

	private void setPathInterrupted(boolean pathInterrupted) {
		this.pathInterrupted = pathInterrupted;
	}
	
	@SuppressWarnings("unchecked")
	private void setIntersectionsTaken(ArrayList<Integer> stepsDone) {
		this.intersectionsTaken = (ArrayList<Integer>) stepsDone.clone();
	}

	public boolean alreadyGoneFromHere(int intersection) {
		int index = intersectionsTaken.indexOf(intersection);
		
		if(index < 0) return false;
		else return true;
	}

	
	public boolean goToNextIntersection(Corridor nextCorridor){
		int exitIntersection = nextCorridor.getOppositeIntersection(nextIntersection) ;
		if(alreadyGoneFromHere(exitIntersection)) {
			setPathInterrupted(true);
			return false;
		}else{
				intersectionsTaken.add(nextIntersection);
				setNextIntersection(exitIntersection);
				setDamage(damage + nextCorridor.getSentry());
				return true;
			}	
	
	}
	
}
