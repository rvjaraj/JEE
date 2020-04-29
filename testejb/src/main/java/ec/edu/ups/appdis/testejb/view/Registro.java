/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appdis.testejb.view;

import ec.edu.ups.appdis.testejb.business.GestionPer;
import ec.edu.ups.appdis.testejb.entidades.Per;
import ec.edu.ups.appdis.testejb.entidades.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinicio
 */
@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

    @Inject
    GestionPer on;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.getWriter().println("<h1> Rick </h1>");
        Per p = new Per();
        p.setCedula("2020");
        p.setNombre("Locaso");
        p.setEdad(10);
        on.guardarContacto(p);
        
        List<Per> list = on.listarCotacts();
        for (Per p1 : list) {
            response.getWriter().println("<h2>" + p1.getCedula() +" "+ p1.getNombre() +" "+ p1.getEdad() + "</h2><br>");
        }
        
    }


}
