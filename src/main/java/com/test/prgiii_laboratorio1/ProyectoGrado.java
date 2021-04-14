/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */
package com.test.prgiii_laboratorio1;

import java.io.Serializable;

public class ProyectoGrado extends MaterialBibliografico implements Serializable{

    static final long serialVersionUID = 42L;
    
    //atributos
    private String tutor;
    private String revisor;

    //metodos
    @Override
    public void registrar() {
        super.registrar();
        System.out.println("Tutor: ");
        this.tutor = leer.nextLine();
        System.out.println("Revisor: ");
        this.revisor = leer.nextLine();
        System.out.println("Registrando...");
    }
    
    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Tutor: " + this.tutor);
        System.out.println("Revisor: " + this.revisor);
        System.out.println("............................................");
    }

    //getter & setter
    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

}
