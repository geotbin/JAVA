package fil.coo.actions;

import fil.coo.pool.ResourcePool;
import fil.coo.resource.Resource;
import fil.coo.resource.ResourceUser;

public class FreeResourceAction<R extends Resource> extends ResourceAction<R>{
	
	public boolean freeResource = false;
	
	
	public FreeResourceAction(ResourceUser<R> resourceUser, ResourcePool<R> resourcePool, String name) {
		super(resourcePool, resourceUser, name);
	}

	
	@Override
	public void doStep() throws ActionFinishedException{
		if(!isFinished()) {
			if(resourceUser.getResource() != null) {
				resourcePool.recoverResource(resourceUser.getResource());
				resourceUser.resetResource();
				freeResource = true;
				System.out.println(this);
			}
		} else {
			throw new ActionFinishedException("already finished");
		}
		
		
	}

	@Override
	public boolean isReady() {
		return freeResource == false;
	}

	@Override
	public boolean isInProgress() {
		return !isReady() && !isFinished();
	}

	@Override
	public boolean isFinished() {
		return freeResource == true && resourceUser.getResource() == null;
	}
	
	@Override
	public String toString() {
		return name + " FREE " + resourcePool;
	}
}