package testUniversidad;


import control.AlumnoData;
import control.InscripcionData;
import control.MateriaData;
import java.time.LocalDate;
import modelo.Alumno;
import modelo.Conexion;
import modelo.Inscripcion;
import modelo.Materia;


public class PruebaUniversidad {

    public static void main(String[] args) {

  try {
            // TODO code application logic here
            Conexion conexion= new Conexion();
            AlumnoData ad = new AlumnoData(conexion);
            MateriaData md = new MateriaData(conexion);
            InscripcionData id = new InscripcionData(conexion);
           
      // Permitir al personal administrativo dar de alta a las materias
      /* 
      Materia m1 = new Materia("Lengua", 1, true);
      Materia m2 = new Materia("Matematica", 2, true);
      Materia m3 = new Materia("Laboratorio de Programacion", 2, true);
        
      md.guardarMateria(m1);
      md.guardarMateria(m2);
      md.guardarMateria(m3);
      
      System.out.println(md.obtenerMateria(""));
      
      */

        
          
        // Premitir al personal administrativo dar de alta a alumnos
        /*
        Alumno a1 = new Alumno(104, "Alejandro", "Perez", LocalDate.of(2001, 11, 18), true);
        Alumno a2 = new Alumno(105, "Lautaro", "Ortiz", LocalDate.of(1986, 6, 26), true);
        Alumno a3 = new Alumno(106, "Jose", "Ochoa", LocalDate.of(1995, 9, 21), true);
        
        ad.guardarAlumno(a1);
        ad.guardarAlumno(a2);
        ad.guardarAlumno(a3);
        
        System.out.println(ad.obtenerAlumnos(""));
        */
        
        
        // Permitir que un alumno se pueda inscribir o des-inscribir en las materias que desee
        // buscarAlumno(idAlumno)   buscarMateria(idMateria)
        /* 
        Inscripcion i1 = new Inscripcion(ad.buscarAlumno(18), md.buscarMateria(7));
        Inscripcion i2 = new Inscripcion(ad.buscarAlumno(18), md.buscarMateria(8));
        Inscripcion i3 = new Inscripcion(ad.buscarAlumno(19), md.buscarMateria(7));
        Inscripcion i4 = new Inscripcion(ad.buscarAlumno(20), md.buscarMateria(8));
        Inscripcion i5 = new Inscripcion(ad.buscarAlumno(20), md.buscarMateria(9));
        
        id.inscribir(i1);
        id.inscribir(i2);
        id.inscribir(i3);
        id.inscribir(i4);
        id.inscribir(i5);
        
        System.out.println(id.obtenerAlumnoMaterias(8));
        */
        
        /*
        // Permitir registrar la calificación final de una materia que está cursando
        // registrarNota(idInscripcion, nota)
        
        id.registrarNota(1, 9.5);
        id.registrarNota(2, 9);
        id.registrarNota(3, 7.5);
        id.registrarNota(4, 7);
        id.registrarNota(5, 8.5);
        
        */
        
        // Permitir el alta, baja y modificación de los alumnos y las materias.
        
        /*
        // Dar de baja a un alumno 
        ad.desactivarAlumno(ad.buscarAlumno(18));
        ad.desactivarAlumno(ad.buscarAlumno(20));
        */
        
        /*
        // Dar de alta a un alumno
        ad.activarAlumno(ad.buscarAlumno(18));
        ad.activarAlumno(ad.buscarAlumno(20));
        */
        
        
        // Borrar un alumno en forma definitiva
        // borrarAlumno(idAlumno)
        
        //ad.borrarAlumno(18);
        
        // No se puede borrar alumno si está inscripto en alguna materia por lo tanto hay que borrar las inscripciones
        // de dicho alumno
        /*
        System.out.println("Antes");
        
        System.out.println(ad.obtenerAlumnos(""));
        id.borrarInscripcion(1);
        id.borrarInscripcion(2);
        ad.borrarAlumno(18);
        
        System.out.println("Despues");
        System.out.println(ad.obtenerAlumnos(""));
        
        */
        
        
        // Descativar Materias 
        //md.desactivarMateria(md.buscarMateria(7));
       
        
        // Activar Materias
        //md.activarMateria(md.buscarMateria(7));
        
        // Borrar un Materia
        //md.borrarMateria(7);
        // No se puede borrar materia si está inscripto algun alumno a esa materia por lo tanto hay que borrar las inscripciones
        
        /*
        System.out.println("Antes");
        
        System.out.println(md.obtenerMateria(""));
        id.borrarInscripcion(3);
        md.borrarMateria(7);
        
        System.out.println("Despues");
        System.out.println(md.obtenerMateria(""));
        */
        
        
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error dentro de la Clase Prueba"+ ex);
        }
    }
    




    }
    

