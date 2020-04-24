package ec.edu.ups.appdis.testejb.business;

import javax.ejb.Local;

// Para crear la interfaz local
@Local
public interface DemoEJBBeanLocal {
	
	//Se puede poner todos los metodos o solo los q se desee
	public double convertCelciusToFaren(int c);
	public int suma(int a, int b);
}
