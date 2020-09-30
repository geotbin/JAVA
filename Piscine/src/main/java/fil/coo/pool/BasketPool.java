package fil.coo.pool;

import fil.coo.resource.Basket;

public class BasketPool extends ResourcePool<Basket>{


	public BasketPool(int number) {
		super(number);
	}
	
	/* create Basket */
	public Basket createResource() {
		return new Basket();
	}

}
