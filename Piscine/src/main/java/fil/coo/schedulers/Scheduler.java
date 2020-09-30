package fil.coo.schedulers;

import java.util.ArrayList;
import java.util.List;

import fil.coo.actions.Action;

public abstract class Scheduler extends Action {
	
	protected List<Action> actions;
	protected boolean isReady = true;
	protected boolean isInit = false;
	

	public Scheduler(){ 
		this.actions = new ArrayList<>();
	}	
	
	

	public void addAction(Action a){
		if(a.isFinished() || a.isInProgress()) {
			throw new IllegalArgumentException("action already finished or in progress");
		}
		
		this.isInit = true;
		if(isFinished() || isInProgress()) {
			throw new IllegalStateException("Can't add an action to a in progress/finished scheduler");
		}
		actions.add(a);
	}
	

	public abstract void nextAction();
	
	
	
	
	@Override
	public boolean isReady() {
		return isInit && isReady;
	}

	@Override
	public boolean isInProgress() {
		return isInit && !isReady() && !isFinished();
	}

	@Override
	public boolean isFinished() {
		return !isReady() && actions.isEmpty();
	}


	public List<Action> getActions() {
		return actions;
	}	
}