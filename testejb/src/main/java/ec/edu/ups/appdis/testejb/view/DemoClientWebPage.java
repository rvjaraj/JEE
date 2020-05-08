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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "clienteweb", urlPatterns = {"/clienteweb"})
public class DemoClientWebPage extends HttpServlet {

    @Inject
    private DemoEJBBeanLocal demoBean;

    @Inject
    private ContactosONLocal contactosON;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {

            response.getWriter().println("<h1>Ricardo Jara</h1>");

            response.getWriter().println("<h1>" + contactosON.validarCedula("0105452172") + "</h1>");
            response.getWriter().println("<h1>" + contactosON.validarCedula("0105452171") + "</h1>");
            ArrayList<Persona> listaPersona = (ArrayList<Persona>) contactosON.listarContactos();

            for (Persona persona : listaPersona) {
                response.getWriter().println(persona.getNombre() + " " + persona.getCedula() + "<br>");
                for (Telefono telefono : persona.getListTelefonos()) {
                    response.getWriter().println(telefono.getNumero() + " " + telefono.getTipo() + "<br>");
                }
                response.getWriter().println("<br>");
            }

            Persona p = contactosON.buscarPersonaCedula("0302405683");
            contactosON.eliminarPersona(p);
            
           
            response.getWriter().println("<h1>" + contactosON.validarCedula("0105452171") + "</h1><br>");

        } catch (Exception ex) {
            response.getWriter().println(ex.getMessage() + " Error ");
            Logger.getLogger(DemoClientWebPage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
