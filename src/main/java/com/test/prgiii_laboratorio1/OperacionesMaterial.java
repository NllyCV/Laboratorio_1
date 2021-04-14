/*
   * I N C O S  2 0 2 1 *
   Sistemas Informáticos
   Programación III
   @author Cuenca Vega Nelly
 */
package com.test.prgiii_laboratorio1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionesMaterial {

    List<MaterialBibliografico> listaMaterial;
    transient Scanner leer = new Scanner(System.in);

    public OperacionesMaterial() {
        listaMaterial = new ArrayList<>();
    }

    public void registrarMaterial(MaterialBibliografico ma) {
        System.out.println("        B  I  B  L  I  O  T  E  C  A        ");
        System.out.println("............................................");
        int n;
        System.out.println("... R E G I S T R O ........................");
        System.out.println("Nro de material a registrar: ");
        n = leer.nextInt();
        for (int i = 1; i <= n; i++) {
            if (ma instanceof Libro) {
                Libro libro = new Libro();
                libro.registrar();
                listaMaterial.add(libro);
                System.out.println("\t¡Registro Realizado!");
            }
            if (ma instanceof ProyectoGrado) {
                ProyectoGrado proyecto = new ProyectoGrado();
                proyecto.registrar();
                listaMaterial.add(proyecto);
                System.out.println("\t¡Registro Realizado!");
            }
        }

    }

    public void mostrarMaterial() {
        if (listaMaterial != null) {
            boolean continuar = true;
            do {
                System.out.println("M A T E R I A L   B I B L I O G R Á F I C O ");
                System.out.println("............................................");
                System.out.println("   1. Mostrar lista de libros");
                System.out.println("   2. Mostrar lista de proyectos de grado");
                System.out.println("   3. Volver al MENÚ DE OPCIONES");
                int opc = leer.nextInt();
                switch (opc) {
                    case 1:
                        System.out.println("           L   I   B   R   O   S            ");
                        System.out.println("............................................");
                        for (MaterialBibliografico mat : listaMaterial) {
                            if (mat instanceof Libro) {
                                Libro lib = (Libro) mat;
                                lib.mostrar();
                            }
                        }
                        break;
                    case 2:
                        System.out.println("     P R O Y E C T O S  D E  G R A D O      ");
                        System.out.println("............................................");
                        for (MaterialBibliografico mat : listaMaterial) {
                            if (mat instanceof ProyectoGrado) {
                                ProyectoGrado pro = (ProyectoGrado) mat;
                                pro.mostrar();
                            }
                        }
                        break;
                    default:
                        continuar = false;
                        break;
                }
            } while (continuar);
            leer.nextLine();
        } else {
            System.out.println("\t- Sin registros -");
            System.out.println("");
        }
    }

    public void buscarTitulo() {
        if (listaMaterial != null) {
            int sw = 0;
            System.out.println("Ingrese título: ");
            String tituloB = leer.nextLine();
            System.out.println(".............................................");
            System.out.println("       D  A  T  O  S    L  I  B  R  O        ");
            System.out.println(".............................................");
            for (MaterialBibliografico tituloLibro : listaMaterial) {
                if (tituloLibro instanceof Libro) {
                    Libro lib = (Libro) tituloLibro;
                    if (lib.getTitulo().equalsIgnoreCase(tituloB)) {
                        sw = 1;
                        lib.mostrar();
                    }
                }
            }
            if (sw == 0) {
                System.out.println("\t- Sin resultados -");
            }
        } else {
            System.out.println("\t- Sin registros -");
        }
    }

    public void eliminarMaterial() {
        int sw = 0;
        if (listaMaterial != null) {
            System.out.println(".............................................");
            System.out.println("       D  A  T  O  S    L  I  B  R  O        ");
            System.out.println(".............................................");
            System.out.println("Ingrese título: ");
            String tituloE = leer.nextLine();
            System.out.println("Ingrese autor: ");
            String autorE = leer.nextLine();
            for (MaterialBibliografico mat : listaMaterial) {
                if (mat instanceof Libro) {
                    Libro lib = (Libro) mat;
                    if (lib.getTitulo().equalsIgnoreCase(tituloE) && lib.getAutor().equalsIgnoreCase(autorE)) {
                        sw = 1;
                        listaMaterial.remove(lib);
                        System.out.println("\tMaterial Eliminado");
                        System.out.println("");
                        break;
                    }
                } else {
                    ProyectoGrado pro = (ProyectoGrado) mat;
                    if (pro.getTitulo().equalsIgnoreCase(tituloE) && pro.getAutor().equalsIgnoreCase(autorE)) {
                        sw = 1;
                        listaMaterial.remove(pro);
                        System.out.println("\tMaterial Eliminado");
                        System.out.println("");
                        break;
                    }
                    System.out.println("\tMaterial vigente: No se puede eliminar");
                }
            }
            if (sw == 0) {
                System.out.println("\t- Material no registrado -");
            }

        } else {
            System.out.println("\t- Sin registros -");
        }
    }

    //creando archivo
    public void crearArchivo() {
        Path path = Paths.get("E:\\Aline\\Documents\\INCOS\\TERCER AÑO\\Programación III\\NIO\\archivoMaterial.txt");
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("\tArchivo creado");
            } else {
                System.out.println("\tNo se puede crear - El archivo ya existe");
            }
        } catch (Exception e) {
        }
    }

    //guardando listaMaterial
    public void guardarObjetos() {
        String ruta = "E:\\Aline\\Documents\\INCOS\\TERCER AÑO\\Programación III\\NIO\\archivoMaterial.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(listaMaterial);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesMaterial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //cargando datos del archivo a un list<MaterialBibliografico>
    public void leerMaterial() {
        String ruta = "E:\\Aline\\Documents\\INCOS\\TERCER AÑO\\Programación III\\NIO\\archivoMaterial.txt";
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if (ois != null) {
                listaMaterial = (List<MaterialBibliografico>) ois.readObject();
            } else {
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesMaterial.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesMaterial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OperacionesMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
