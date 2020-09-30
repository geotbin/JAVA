package actions;

import org.junit.*;
import fil.coo.actions.Action;
import fil.coo.actions.ActionFinishedException;

import static org.junit.Assert.*;


public abstract class ActionTest {

	protected Action action;
	public abstract Action createAction();	
	
	@Before
	public void init() {
		this.action = createAction();
	}
	
	
	@Test
	public void testCheckFinishedStatusAfterDoingAllActions() throws Exception{
		assertEquals(true, this.action.isReady());
		
		while (!this.action.isFinished()){
			action.doStep();
		}
		assertEquals(true, this.action.isFinished());
	}
	
	
	
	
	@Test(expected=ActionFinishedException.class)
	public void testTryingToDoStepWhenSchedulerHasFinishedThrowsActionFinishedException() throws Exception{
		assertEquals(true, this.action.isReady());
		
		while (!this.action.isFinished()){
			action.doStep();
		}
		assertEquals(true, this.action.isFinished());
		action.doStep();
	}
	
	
	
	
}
