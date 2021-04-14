/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */
package com.test.prgiii_laboratorio1;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        MaterialBibliografico matLibro = new Libro();
        MaterialBibliografico matProyecto = new ProyectoGrado();
        OperacionesMaterial obj = new OperacionesMaterial();
        Scanner leer = new Scanner(System.in);
        boolean continuar = true;
        int opcion;
        do {
            System.out.println("                                             ");
            System.out.println("        M E N Ú  D E  O P C I O N E S        ");
            System.out.println(".............................................");
            System.out.println("\t1. Crear Archivo");
            System.out.println("\t2. Registrar Libro");
            System.out.println("\t3. Registrar Proyecto de Grado");
            System.out.println("\t4. Guardar Registros");
            System.out.println("\t5. Ver Material Bibliográfico");
            System.out.println("\t6. Buscar Libro por Título");
            System.out.println("\t7. Eliminar Material");
            System.out.println("\t8. Salir");
            System.out.println("");
            System.out.println("Ingrese una opción...");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.registrarMaterial(matLibro);
                    break;
                case 3:
                    obj.registrarMaterial(matProyecto);
                    break;
                case 4:
                    obj.guardarObjetos();
                    System.out.println("¡Registros Guardados!");
                    break;
                case 5:
                    //obj.leerMaterial();
                    obj.mostrarMaterial();
                    break;
                case 6:
                    obj.leerMaterial();
                    obj.buscarTitulo();
                    break;
                case 7:
                    obj.leerMaterial();
                    obj.eliminarMaterial();
                    obj.guardarObjetos();
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }

}
