package actions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fil.coo.actions.Action;
import fil.coo.actions.ForeseableAction;

public class ForeseableActionTest extends ActionTest{

	private final int time = 50;
	
	@Override
	public Action createAction() {
		return new ForeseableAction(time, null, null);
	}
	
	@Test
	public void testCount() {
		int count = 0;
		while (!this.action.isFinished()){
			action.doStep();
			count ++;
		}
		assertEquals(time, count);
	}
	
}
