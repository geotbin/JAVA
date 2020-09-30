package actions;

import fil.coo.actions.Action;
import fil.coo.actions.FreeResourceAction;
import fil.coo.pool.CubiclePool;
import fil.coo.pool.ResourcePool;
import fil.coo.resource.Cubicle;
import fil.coo.resource.ResourceUser;

public class FreeResourceActionTest extends ActionTest{

	@Override
	public Action createAction() {
		ResourcePool<Cubicle> pool = new CubiclePool(10);
		ResourceUser<Cubicle> user = new ResourceUser<Cubicle>();
		
		user.setResource(pool.provideResource());
		return new FreeResourceAction<Cubicle>(user, pool, "test");
	}
	
	
}
