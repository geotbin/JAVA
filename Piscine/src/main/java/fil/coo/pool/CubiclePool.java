package fil.coo.pool;

import fil.coo.resource.Cubicle;

public class CubiclePool extends ResourcePool<Cubicle>{
	

	public CubiclePool(int number) {
		super(number);
	}
	
	/* create Basket */
	public Cubicle createResource() {
		return new Cubicle();
	}
}
