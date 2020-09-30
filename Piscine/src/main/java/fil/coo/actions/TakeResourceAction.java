package fil.coo.actions;


import fil.coo.pool.ResourcePool;
import fil.coo.resource.*;



public class TakeResourceAction<R extends Resource> extends ResourceAction<R>{
	
	protected boolean takeResource = false;



	public TakeResourceAction(ResourceUser<R> resourceUser, ResourcePool<R> resourcePool, String name) {
		super(resourcePool, resourceUser, name);
	}
	
	@Override
	public boolean isReady() {
		return (takeResource == false);
	}
	
	@Override
	public void doStep() throws ActionFinishedException{
		if(!isFinished()) {
			System.out.print(this);
			
			/*get first resource*/
			R resource = resourcePool.getFResource();
			
			try {
				resource = resourcePool.provideResource();
				resourceUser.setResource(resource);
				this.takeResource = true;
				System.out.println("success");
			} catch (Exception e) {
				this.takeResource = false;
				System.out.println("failed");
			}
		} else {
			throw new ActionFinishedException("already finished");
		}
	}
	
	
	@Override
	public boolean isInProgress() {
		return !isReady() && !isFinished();
	}
	
	@Override
	public boolean isFinished() {
		return takeResource == true && resourceUser.getResource() != null;
	}
	
	@Override
	public String toString() {
		return name + " TAKE " + resourcePool + "... ";
	}
}