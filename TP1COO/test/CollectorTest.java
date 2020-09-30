import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

import generics.AlreadyCarryingException;
import static org.hamcrest.CoreMatchers.*;
import generics.Carrot;
import generics.Collector;

public class CollectorTest {
	
	Carrot c1;
	Carrot c2;
	Collector<Carrot> collectorcarrot1;
	Collector<Carrot> collectorcarrot2;

	@Before public void initialize() {
		c1 = new Carrot(1);
		c2 = new Carrot(2);
		collectorcarrot1 = new Collector<Carrot>("carrot-collector-1");
		collectorcarrot2 = new Collector<Carrot>("carrot-collector-2");
	}
	
	@Test
	public void testTakeObjectSuccess() throws AlreadyCarryingException {
		collectorcarrot1.take(c1);
		assertEquals(c1, collectorcarrot1.getCarriedObject());
	}
	
	@Test
	public void testTakeObjectFail() throws AlreadyCarryingException {
		collectorcarrot1.take(c1);
		collectorcarrot1.take(c2);
		assertEquals(c2, collectorcarrot1.getCarriedObject());
	}
	
	@Test
	public void testDropObjectSuccess() throws AlreadyCarryingException {
		collectorcarrot1.take(c1);
		collectorcarrot1.drop();
		assertEquals(null, collectorcarrot1.getCarriedObject());
	}
	
	@Test public void testDropObjectFail() throws AlreadyCarryingException {
		Carrot cActual = collectorcarrot1.getCarriedObject();
		collectorcarrot1.drop();
		assertThat(cActual, not(collectorcarrot1.getCarriedObject()));
	}
	
	@Test public void giveToObjectSuccess() throws AlreadyCarryingException {
		collectorcarrot1.take(c1);
		Carrot cActual = collectorcarrot1.getCarriedObject();
		collectorcarrot1.giveTo(collectorcarrot2);
		
		assertEquals(cActual, collectorcarrot2.getCarriedObject());
	}
	
	@Test public void giveToObjectFail() throws AlreadyCarryingException {
		collectorcarrot1.giveTo(collectorcarrot2);
		assertNotNull(collectorcarrot2.getCarriedObject());
	}
	
	
	
}
