package resource;

import fil.coo.pool.BasketPool;
import fil.coo.pool.ResourcePool;
import fil.coo.resource.Basket;

public class BasketPoolTest extends ResourcePoolTest<Basket>{

	@Override
	public ResourcePool<Basket> createResourcePool() {
		return new BasketPool(1);
	}

	@Override
	public ResourcePool<Basket> createEmptyPool() {
		return new BasketPool(0);
	}

	@Override
	public Basket createResource() {
		return new Basket();
	}

}
