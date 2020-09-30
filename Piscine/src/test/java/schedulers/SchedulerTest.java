package schedulers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fil.coo.actions.ForeseableAction;
import fil.coo.schedulers.Scheduler;

public abstract class SchedulerTest {

	
	private Scheduler scheduler;
	public abstract Scheduler createScheduler();
	
	
	@Before
	public void init() {
		this.scheduler = createScheduler(); // 2 actions (1 doStep = inprogress / 2 doStep = finished)
	}
	
	
	@Test
	public void testAddAction() {
		int nbActions = this.scheduler.getActions().size();
		this.scheduler.addAction(new ForeseableAction(10, null, null));
		assertEquals(nbActions + 1, this.scheduler.getActions().size());
	}
	
	
	@Test(expected=Exception.class)
	public void testAddWhenSchedulerIsInProgressThrowException() {
		this.scheduler.doStep();
		assertEquals(true, this.scheduler.isInProgress());
		this.scheduler.addAction(new ForeseableAction(10, null, null));
	}
	
	@Test(expected=Exception.class)
	public void testAddWhenSchedulerIsFinishedThrowException() {
		this.scheduler.doStep();
		this.scheduler.doStep();
		assertEquals(false, this.scheduler.isFinished());
		this.scheduler.addAction(new ForeseableAction(10, null, null));
	}
	
	
	
}
