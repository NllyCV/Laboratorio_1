/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */
package com.test.prgiii_laboratorio1;

import java.io.Serializable;
import java.util.Scanner;

public class Libro extends MaterialBibliografico implements Serializable{

    static final long serialVersionUID = 41L;
    
    //atributos
    private int edicion;
    private String area;
    
    transient Scanner leer = new Scanner(System.in);

    //metodos
    @Override
    public void registrar() {
        super.registrar();
        System.out.println("Edición: ");
        this.edicion = leer.nextInt();
        leer.nextLine();
        System.out.println("Área: ");
        this.area = leer.nextLine();
        System.out.println("Registrando...");
    }
    
    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Edición: " + this.edicion);
        System.out.println("Área: " + this.area);
        System.out.println("............................................");
    }

    //getter & setter
    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
