/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */
package com.test.prgiii_laboratorio1;

import java.io.Serializable;
import java.util.Scanner;

public class MaterialBibliografico implements Serializable {
    
    static final long serialVersionUID = 43L;

    //atributos
    private String titulo;
    private String autor;

    Scanner leer = new Scanner(System.in);

    //metodos
    public void registrar() {
        System.out.println("Título: ");
        this.titulo = leer.nextLine();
        System.out.println("Autor: ");
        this.autor = leer.nextLine();
    }

    public void mostrar() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
    }

    //getter & setter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
