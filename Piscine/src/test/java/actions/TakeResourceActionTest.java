package actions;


import fil.coo.actions.*;
import fil.coo.pool.*;
import fil.coo.resource.*;

public class TakeResourceActionTest extends ActionTest{

	@Override
	public Action createAction() {
		ResourcePool<Cubicle> pool = new CubiclePool(5);
		ResourceUser<Cubicle> user = new ResourceUser<Cubicle>();
		return new TakeResourceAction<Cubicle>(user, pool, "test");
	}
	
}
