package schedulers;

import fil.coo.actions.ForeseableAction;
import fil.coo.actions.TakeResourceAction;
import fil.coo.pool.CubiclePool;
import fil.coo.pool.ResourcePool;
import fil.coo.resource.Cubicle;
import fil.coo.resource.ResourceUser;
import fil.coo.schedulers.*;


public class SequentialSchedulerTest extends SchedulerTest{

	@Override
	public Scheduler createScheduler() {
		ResourcePool<Cubicle> pool = new CubiclePool(5);
		ResourceUser<Cubicle> user = new ResourceUser<Cubicle>();
		
		SequentialScheduler sequentialScheduler = new SequentialScheduler();
		sequentialScheduler.addAction(new TakeResourceAction<Cubicle>(user, pool, "test"));
		sequentialScheduler.addAction(new ForeseableAction(10, null, null));
		return sequentialScheduler;
	}

}
