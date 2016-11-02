package pe.edu.upeu.asistencia.dao;

import java.util.Vector;
import pe.edu.upeu.asistencia.objects.Alumno;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author itecs
 */
public class AlumnoDao {

    public Vector vector = new Vector();

    public void add(Alumno alumno) {
        vector.add(alumno);
    }

    public void list() {
        for (int i = 0; i < vector.size(); i++) {
            Alumno alumno = (Alumno) vector.get(i);
            System.out.println(alumno.getCodigo() + " - " + alumno.getNombres() + " - " + alumno.getApellidos());
        }
    }

    public Alumno findByCode(int codigo) {

        Alumno alumnoBus = null;

        for (int i = 0; i < vector.size(); i++) {
            Alumno alumno = (Alumno) vector.get(i);
            if (alumno.getCodigo() == codigo) {
                alumnoBus = alumno;
                break;
            }
        }

        return alumnoBus;

    }

    public void remove(Alumno alumno) {
        if (vector.remove(alumno) == true) {
            System.out.println("codigo : " + alumno.getCodigo() + "Eliminado correctamente");
        } else {
            System.out.println("No se pudo eliminar");
        }
    }

    public void update(Alumno alumnoOld, Alumno AlumnoNew) {
        int indiceAlumno = vector.indexOf(alumnoOld);
        vector.set(indiceAlumno, AlumnoNew);
    }

}
