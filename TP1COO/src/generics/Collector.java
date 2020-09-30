package generics;
import java.util.*;

/** define collectors able to collect (and carry) one specific type T of objects
 * only one T object can be carried at a time
 */

public class Collector<T> {

    /**
     * @param name
     * constructor with no object default
     */
    public Collector(String name) {
	this.name = name;
	this.carriedObject = null;
    }

    /**
     * name of the collector
     */
    private String name;
    /**
     * the carried object by the collector
     */
    private T carriedObject;
	
    // ATTRIBUTS carriedObject à DEFINIR

    public String toString() {
	return this.name;
    }
    
    /**
     * @return information about what is carrying the collector
     */
    public String description() {
	return this.name + " carries " + this.carriedObject;
    }

    /**
     * @param myObj
     * @throws AlreadyCarryingException
     * take an object as a param, object is now carried by the collector
     */
    public void take(T myObj) throws AlreadyCarryingException {

    	if(this.carriedObject == null) {
    		this.carriedObject = myObj;
    	}
    	else {
    	//throw new AlreadyCarryingException("Already carrying an object.");
    	}
    }
   
    /**
     * dropping the carried object
     */
    public void drop() {
    	if(this.carriedObject != null) {
    		this.carriedObject = null;
    	}
    }

    /**
     * @return carriedObject
     * get the carried object of the collector
     */
    public T getCarriedObject() {
    	return this.carriedObject;
    }



    /**
     * @param gatherer
     * @throws AlreadyCarryingException
     * give the object of the actual collector to the collector in param
     * exception if there is no object or already one
     */
    public void giveTo(Collector<? super T> gatherer) throws AlreadyCarryingException {
    	if(this.getCarriedObject() != null) {
    		if(gatherer.getCarriedObject() == null) {
        		gatherer.carriedObject = this.carriedObject;
        		this.carriedObject = null;
    		}else {
        	//	throw new AlreadyCarryingException("Le receveur a déjà un objet");
    		}

    	}else {
    		//throw new AlreadyCarryingException("Le donneur n'a pas d'objets");
    	}
    }

    public static void main(String[] args) throws AlreadyCarryingException {
	
		Carrot c1 = new Carrot(1);
		Carrot c2 = new Carrot(2);
		Carrot c3 = new Carrot(3);
		Apple p1 = new Apple(1);
		Apple p2 = new Apple(2);

		Collector<Carrot> carrotCollector1 = new Collector<Carrot>("carrot-collector-1");
		Collector<Carrot> carrotCollector2 = new Collector<Carrot>("carrot-collector-2");
		Collector<Apple> appleCollector1 = new Collector<Apple>("apple-collector-1");
		
		// attention ici le type d'objets ramasses est Legume :
		Collector<Vegetable> vegetableCollector = new Collector<Vegetable>("vegetable-collector");

		carrotCollector1.take(c3);
		System.out.println(carrotCollector1.description());
		// NE COMPILE PAS
		// carrotCollector2.take(p1);

		// NE COMPILE PAS
		// carrotCollector1.giveTo(appleCollector1);

		// COMPILE :
		carrotCollector1.giveTo(vegetableCollector);

		// NE COMPILE PAS
		// vegetableCollector.giveTo(carrotCollector1);
		// NE COMPILE PAS
		// appleCollector1.giveTo(vegetableCollector);

		carrotCollector1.take(c1);
		carrotCollector1.giveTo(carrotCollector2);
		System.out.println(carrotCollector1.description());
		System.out.println(carrotCollector2.description());
		carrotCollector1.take(c2);
		
		
		try {
			carrotCollector1.giveTo(carrotCollector2);
		} catch (IllegalStateException e) {
			//System.out.println("*** exception : " + carrotCollector2 + " porte deja qque chose");
			System.out.println(" * " + e.getMessage());
		}

		appleCollector1.take(p2);
		System.out.println(appleCollector1.description());
		try {
			appleCollector1.take(p1);
		} catch (IllegalStateException e) {
			//System.out.println("*** exception : " + appleCollector1 + " porte deja qque chose");
			System.out.println(" * " + e.getMessage());
		}
		appleCollector1.drop();
		System.out.println(appleCollector1.description());
		appleCollector1.take(p1);
	
     }
}
