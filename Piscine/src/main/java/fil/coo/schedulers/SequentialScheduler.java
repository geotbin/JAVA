package fil.coo.schedulers;

import fil.coo.actions.ActionFinishedException;

public class SequentialScheduler extends Scheduler {
	
	private int index = 0;
	
	
	@Override
	public void nextAction() {
		if(index < actions.size() - 1) {
			index++;
		}
	}

	@Override
	public void doStep() throws ActionFinishedException {
		this.isReady = false;
		if(isFinished()) {
			throw new ActionFinishedException("already finished");
		}
		actions.get(index).doStep();
		if(actions.get(index).isFinished()) {
			actions.remove(index--);
			nextAction();
		}
		
	}


}