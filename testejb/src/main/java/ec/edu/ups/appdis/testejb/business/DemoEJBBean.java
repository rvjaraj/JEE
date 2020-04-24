package ec.edu.ups.appdis.testejb.business;


import javax.ejb.Stateless;

//para @Remote remota y @local para local

@Stateless
public class DemoEJBBean implements DemoEJBBeanRemote, DemoEJBBeanLocal  {
	public double convertCelciusToFaren(int c) {
		return (c * 9/5) +32+10;
	}
	
	public int suma(int a , int b) {
		return a+b;
	}
}

