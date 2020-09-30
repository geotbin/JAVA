package schedulers;

import fil.coo.actions.ForeseableAction;
import fil.coo.actions.TakeResourceAction;
import fil.coo.pool.CubiclePool;
import fil.coo.pool.ResourcePool;
import fil.coo.resource.Cubicle;
import fil.coo.resource.ResourceUser;
import fil.coo.schedulers.FairScheduler;
import fil.coo.schedulers.Scheduler;

public class FairSchedulerTest  extends SchedulerTest{

	@Override
	public Scheduler createScheduler() {
		ResourcePool<Cubicle> pool = new CubiclePool(5);
		ResourceUser<Cubicle> user = new ResourceUser<Cubicle>();
		FairScheduler fairScheduler = new FairScheduler();
		
		fairScheduler.addAction(new TakeResourceAction<Cubicle>(user, pool, "test"));
		fairScheduler.addAction(new ForeseableAction(10, null, null));
		
		return fairScheduler;
	}

}
