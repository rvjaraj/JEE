package ec.edu.ups.appdis.testejb.view;

import ec.edu.ups.appdis.testejb.business.ContactosONLocal;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.appdis.testejb.business.DemoEJBBeanLocal;
import ec.edu.ups.appdis.testejb.entidades.Persona;
import ec.edu.ups.appdis.testejb.entidades.Telefono;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "clienteweb", urlPatterns = {"/clienteweb"})
public class DemoClientWebPage extends HttpServlet {

    @Inject
    private DemoEJBBeanLocal demoBean;

    @Inject
    private ContactosONLocal contactosON;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
          
            response.getWriter().println("<h1>Ricardo Jara</h1>");

            double f = demoBean.convertCelciusToFaren(30);
            response.getWriter().println(f + "<br>");

            response.getWriter().println("<h1>"+contactosON.validarCedula("0105452172") + "</h1>");
            
            //Telefono t = new Telefono(0,"123456","CONVENCIONAL", 0);
            //Telefono t1 = new Telefono(0,"123456","CONVENCIONAL", 0);
            //ArrayList<Telefono> listaTelefono = new ArrayList<>();
            //listaTelefono.add(t);
            //listaTelefono.add(t1);
            //Persona p = new Persona(0,"0107051534","Fanny Gutama", listaTelefono);
            //contactosON.guardadoContacto(p);
            
            ArrayList<Persona> listaPersona = (ArrayList<Persona>) contactosON.listarContactos(); 
            
            for (Persona persona : listaPersona) {
                response.getWriter().println(persona.getNombre() + " " + persona.getCedula() +"<br>");
                
                for (Telefono telefono : persona.getListaTelefonos()) {
                    response.getWriter().println(telefono.getNumero() + " " + telefono.getTipo() + "<br>");
                }
                response.getWriter().println("<br>");
            }

            response.getWriter().println("<h1>"+contactosON.validarCedula("0105452171") + "</h1><br>");

        } catch (Exception ex) {
            response.getWriter().println(ex.getMessage() + " Error ");
            Logger.getLogger(DemoClientWebPage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
