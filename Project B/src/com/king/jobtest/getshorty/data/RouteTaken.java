package com.king.jobtest.getshorty.data;

import java.util.ArrayList;

public class RouteTaken {
	
	private int nextStep;
	private ArrayList<Integer> stepsDone;
	private float damage;
	private boolean pathCompleted;
	private boolean pathInterrupted;

	public RouteTaken(int inputNextStep, int inputPreviousStep, float inputDamage){
		stepsDone = new ArrayList<Integer>();
		
		nextStep = inputNextStep;
		stepsDone.add(inputPreviousStep);
		damage = inputDamage;
		pathInterrupted = false;
		
		if(this.nextStep == 0) 
			setPathCompleted(true);
		else 
			pathCompleted = false;
		
	}
	
	private RouteTaken(){
		
	}

	public int getNextStep() {
		return nextStep;
	}

	public void setNextStep(int nextStep) {
		this.nextStep = nextStep;
		if(this.nextStep == 0) setPathCompleted(true);
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
	
	public int getLastStepDone(){
		return ((Integer)stepsDone.get(stepsDone.size()-1)).intValue();
	}
	
	public boolean isPathInterrupted() {
		return pathInterrupted;
	}

	private void setPathInterrupted(boolean pathInterrupted) {
		this.pathInterrupted = pathInterrupted;
	}
	
	@SuppressWarnings("unused")
	private ArrayList<Integer> getStepsDone() {
		return stepsDone;
	}

	@SuppressWarnings("unchecked")
	private void setStepsDone(ArrayList<Integer> stepsDone) {
		this.stepsDone = (ArrayList<Integer>) stepsDone.clone();
	}

	public boolean alreadyGoneFromHere(int intersection) {
		int index = stepsDone.indexOf(intersection);
		
		if(index < 0) return false;
		else return true;
	}
	
	public RouteTaken cloneRoute(){
		RouteTaken newRoute = new RouteTaken();
		newRoute.setNextStep(this.nextStep);
		newRoute.setDamage(this.damage);
		newRoute.setStepsDone(this.stepsDone);
		newRoute.setPathCompleted(this.pathCompleted);
		newRoute.setPathInterrupted(this.pathInterrupted);
		return newRoute;
		
	}
	
	public boolean doOneStep(Corridor nextCorridor){
		int exitIntersection = nextCorridor.getOppositeIntersection(nextStep) ;
		if(alreadyGoneFromHere(exitIntersection)) {
			setPathInterrupted(true);
			return false;
		}else{
				stepsDone.add(nextStep);
				setNextStep(exitIntersection);
				setDamage(damage + nextCorridor.getSentry());
				return true;
			}	
	
	}
	
}
