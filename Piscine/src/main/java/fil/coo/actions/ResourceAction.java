package fil.coo.actions;

import fil.coo.pool.ResourcePool;
import fil.coo.resource.Resource;
import fil.coo.resource.ResourceUser;

public abstract class ResourceAction<R extends Resource> extends Action {

	protected ResourcePool<R> resourcePool; 
	protected ResourceUser<R> resourceUser; 
	
	protected String name;

	public ResourceAction(ResourcePool<R> resourcePool, ResourceUser<R> resourceUser, String name) {
		this.resourcePool = resourcePool;
		this.resourceUser = resourceUser;
		this.name = name;
	}
	
	

}
