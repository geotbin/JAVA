package fil.coo.pool;

import java.util.*;

import fil.coo.resource.Resource;


public abstract class ResourcePool<T extends Resource> {
	
	protected List<T> availableResource = new ArrayList<>();
	protected List<T> usedResources = new ArrayList<>();
	
	public abstract T createResource();
	
	
	public ResourcePool(int nbResources){
		this.availableResource = new ArrayList<T>();
		this.usedResources = new ArrayList<T>();
		for(int i = 0; i < nbResources; i++){
			this.availableResource.add(this.createResource());
		}
	}
	
	/*
	 * take the first available resource from available resources list
	 * add resource to used resources list
	 * remove resource from available resources list
	 * */
	
	public T provideResource() throws NoSuchElementException {
		T res;
		if(this.getNbAvailableResources() == 0){
			throw new NoSuchElementException();
		}else{
			res = this.availableResource.get(0);
			this.usedResources.add(res);
			this.availableResource.remove(res);
			return res;
		}
	}
	
	/*
	 * free specificied resource form the swimmer
	 * add resource to available resources list
	 * remove resource from used resources list
	 * */
	public void recoverResource(T r) throws IllegalArgumentException{
		int index = usedResources.indexOf(r);
		if(index > -1 ){
			availableResource.add(usedResources.get(index));
			usedResources.remove(index);
			System.out.println("ressource free");
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	/*
	 * get first resource from available resources list
	 * @return resource
	 * */
	public T getFResource(){
		if(availableResource.size() > 0)
			return availableResource.get(0);
		return null;
	}
	
	
	/**
	 * @return size of available resources list
	 */
	public int getNbAvailableResources() {
		return availableResource.size();
	}
	
	/**
	 * @return size of used resources list
	 */
	public int getNbUsedResources() {
		return usedResources.size();
	}
	
	
	
	@Override
	public String toString() {
		return "from pool";
	}
	
}
