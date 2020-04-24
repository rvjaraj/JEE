package ec.edu.ups.appdis.testejb.business;

import javax.ejb.Remote;

// Para crear la interfaz remota
@Remote
public interface DemoEJBBeanRemote {
	
	public double convertCelciusToFaren(int c);
	//public int suma(int a, int b);
}
