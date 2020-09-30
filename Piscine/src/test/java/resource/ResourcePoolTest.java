package resource;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import fil.coo.pool.ResourcePool;
import fil.coo.resource.Resource;

public abstract class ResourcePoolTest<T extends Resource> {

	protected ResourcePool<T> pool; 
	protected ResourcePool<T> emptyPool;
	protected T resource;
	
	public abstract ResourcePool<T> createResourcePool();
	public abstract ResourcePool<T> createEmptyPool();
	public abstract T createResource();
	
	@Before
	public void init() {
		this.pool = createResourcePool();
		this.resource = createResource();
		this.emptyPool = createEmptyPool();
	}
	
	@Test
	public void testProvideResourceWhenPoolIsNotEmpty(){
		
		this.pool = createResourcePool();
		int countAvailableRes = pool.getNbAvailableResources();
		int countUsed = pool.getNbUsedResources();
		
		pool.provideResource();
		
		assertEquals(countAvailableRes - 1, pool.getNbAvailableResources());
		assertEquals(countUsed + 1, pool.getNbUsedResources());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testProvideResourceException() {
		emptyPool.provideResource();
	}
	
	
	@Test
	public void testRecoverResource() {
		int countAvailableRes = pool.getNbAvailableResources();
		int countUsed = pool.getNbUsedResources();
		
		T test = pool.provideResource();
		pool.recoverResource(test);
		
		assertEquals(countAvailableRes, pool.getNbAvailableResources());
		assertEquals(countUsed, pool.getNbUsedResources());
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testRecoverResourceWhenPoolsAreDifferentThrowException() {
		T test = pool.provideResource();
		emptyPool.recoverResource(test);
	}
	
	
}
