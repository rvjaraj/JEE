/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.appdis.testejb.controler;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Vinicio
 */
@ManagedBean
public class BeanFanny {
    private String cedula;
    private String variable1;
    private String varaible2;
    
    
    @PostConstruct
    public void init() {
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getVariable1() {
        return variable1;
    }

    public void setVariable1(String variable1) {
        this.variable1 = variable1;
    }

    public String getVaraible2() {
        return varaible2;
    }

    public void setVaraible2(String varaible2) {
        this.varaible2 = varaible2;
    }
    
    
    public String metodoFanny(){
        System.out.println(cedula);
        variable1 = "Fanny Gutama";
        varaible2 = "Ricardo Jara";
        return null;
    }
    
    
    
}
