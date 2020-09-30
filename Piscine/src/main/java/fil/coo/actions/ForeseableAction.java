package fil.coo.actions;

public class ForeseableAction  extends Action{
	protected int timeToEnd;
	protected int time;
	protected String message;
	protected String name;
	
	
	public ForeseableAction(int timeToEnd, String message, String name){
		if(timeToEnd == 0){
			throw new IllegalArgumentException("Can't add an already finished action");
		}
		this.timeToEnd = timeToEnd;
		time = 0;
		this.message = message;
		this.name = name;
	}
	
	@Override
	public boolean isReady() {
		return time == 0;
	}

	@Override
	public boolean isInProgress() {
		return time > 0 && time < timeToEnd;
	}

	@Override
	public boolean isFinished() {
		return time == timeToEnd;
	}

	@Override
	public void doStep() throws ActionFinishedException{
		if(!isFinished()){
			time++;
		} else {
			throw new ActionFinishedException("Error action already finished");
		}
		System.out.println(message);
	}

	public int getTimeToEnd() {
		return timeToEnd;
	}

	public int getTime() {
		return time;
	}
	
	@Override
	public String toString() {
		return name + "is " + message + "...";
	}
	
}