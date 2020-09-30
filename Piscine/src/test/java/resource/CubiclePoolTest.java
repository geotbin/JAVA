package resource;

import fil.coo.pool.CubiclePool;
import fil.coo.pool.ResourcePool;
import fil.coo.resource.Cubicle;

public class CubiclePoolTest extends ResourcePoolTest<Cubicle>{

	@Override
	public ResourcePool<Cubicle> createResourcePool() {
		return new CubiclePool(1);
	}

	@Override
	public ResourcePool<Cubicle> createEmptyPool() {
		return new CubiclePool(0);
	}

	@Override
	public Cubicle createResource() {
		return new Cubicle();
	}

}
