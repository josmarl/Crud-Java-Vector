/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.asistencia.main;

import java.util.Scanner;
import pe.edu.upeu.asistencia.dao.AlumnoDao;
import pe.edu.upeu.asistencia.objects.Alumno;

/**
 *
 * @author itecs
 */
public class Main {

    public static void menu() {
        String menu = "";
        menu += "-------------------Opciones-------------------";
        menu += "(1) Agregar";
        menu += "(2) Listar";
        menu += "(3) Eliminar";
        menu += "(4) Buscar";
        menu += "(5) Actualizar";
        System.out.println(menu);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AlumnoDao dao = new AlumnoDao();

        do {

            menu();
            System.out.print("Ingrese una opcion:");
            int opc = sc.nextInt();

            switch (opc) {
                case 1: {
                    System.out.print("codigo:");
                    int codigo = sc.nextInt();
                    System.out.print("nombres:");
                    String nombres = sc.next();
                    System.out.print("apellidos:");
                    String apellidos = sc.next();

                    Alumno a = new Alumno(codigo, nombres, apellidos);
                    dao.add(a);
                }
                break;
                case 2: {
                    dao.list();
                }
                break;
                case 3: {
                    System.out.println("buscar codigo:");
                    int codigo = sc.nextInt();
                    Alumno alumnoDel = dao.findByCode(codigo);
                    dao.remove(alumnoDel);
                }
                break;
                case 4: {
                    System.out.println("buscar codigo:");
                    int codigo = sc.nextInt();
                    System.out.println(dao.findByCode(codigo).getNombres());
                }
                break;
                case 5: {
                    System.out.println("buscar codigo:");
                    int codigo = sc.nextInt();
                    Alumno alumnoBus = dao.findByCode(codigo);

                    System.out.println("nuevo codigo:");
                    int codigoNew = sc.nextInt();

                    System.out.println("nuevos nombres:");
                    String nombresNew = sc.next();

                    System.out.println("nuevos apellidos:");
                    String apellidosNew = sc.next();

                    Alumno alumnoNew = new Alumno(codigoNew, nombresNew, apellidosNew);

                    dao.update(alumnoBus, alumnoNew);
                }
                break;
                default: {
                    System.err.println("Error");
                }
            }

        } while (true);
    }

}
