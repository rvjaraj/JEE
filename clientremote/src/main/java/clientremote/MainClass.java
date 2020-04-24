package clientremote;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import ec.edu.ups.appdis.testejb.business.DemoEJBBeanRemote;
import javax.swing.JOptionPane;

public class MainClass {

    //Esto es como teniamos la referencia local pero sin el @injec
    public DemoEJBBeanRemote demoEJB;

    //con este metodo se consta al srv para q evuelva la instancia
    public void instanciarEJBRemote() throws Exception {
        try {
            final Hashtable<String, Comparable> jndiProperties
                    = new Hashtable<String, Comparable>();
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");
            jndiProperties.put("jboss.naming.client.ejb.context", true);

            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "admin");
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "admin");

            final Context context = new InitialContext(jndiProperties);

            //Nombre del EJB al que yo me quiero conectar o llamar       
            //Si se tiene otro ejb se le pone lookupName2 y asi
            final String lookupName = "ejb:/testejb/DemoEJBBean!ec.edu.ups.appdis.testejb.business.DemoEJBBeanRemote";

            //this.memberRegistration = (MemberRegistrationRemote) context.lookup(lookupName);  
            //Conecta al servidor y devuelve la isntacia remota de lookupName
            this.demoEJB = (DemoEJBBeanRemote) context.lookup(lookupName);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
    
    public static void main(String args[]) {
        MainClass mc = new MainClass();

        try {
            mc.instanciarEJBRemote();
            double f = mc.demoEJB.convertCelciusToFaren(64);
            System.out.println(f + " Lo que sea");
            JOptionPane.showMessageDialog(null, "si se");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
