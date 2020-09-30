package fil.coo.schedulers;

import fil.coo.actions.*;
import fil.coo.pool.*;
import fil.coo.resource.Basket;
import fil.coo.resource.Cubicle;
import fil.coo.resource.ResourceUser;
public class Swimmer extends SequentialScheduler{
	
	
	protected String name;
	protected BasketPool basketPool;
	protected CubiclePool cubiclePool;
	protected int timeUndressing;
	protected int timeSwimming;
	protected int timeDressing;
	
	public Swimmer(String name,BasketPool basketPool, CubiclePool cubiclePool, int timeUndressing, int timeSwimming, int timeDressing){
		this.name = name;
		this.basketPool = basketPool;
		this.cubiclePool = cubiclePool;
		this.timeUndressing = timeUndressing;
		this.timeSwimming = timeSwimming;
		this.timeDressing = timeDressing;
		ResourceUser<Basket> basketUser = new ResourceUser<Basket>();
		ResourceUser<Cubicle> cubicleUser = new ResourceUser<Cubicle>();
		
		actions.add(new TakeResourceAction<Basket>(basketUser, this.basketPool, name));
		actions.add(new TakeResourceAction<Cubicle>(cubicleUser, this.cubiclePool, name));
		actions.add(new ForeseableAction(this.timeUndressing, "undressing", name));
		actions.add(new FreeResourceAction<Cubicle>(cubicleUser, this.cubiclePool, name));
		actions.add(new ForeseableAction(this.timeSwimming,"swimming", name));
		actions.add(new TakeResourceAction<Cubicle>(cubicleUser, this.cubiclePool, name));
		actions.add(new ForeseableAction(this.timeDressing, "dressing", name));
		actions.add(new FreeResourceAction<Cubicle>(cubicleUser, this.cubiclePool, name));
		actions.add(new FreeResourceAction<Basket>(basketUser, this.basketPool, name));

		
	}
	
	public String toString(){
		return this.name;
	}
}