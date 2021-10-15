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
           
        ad.borrarAlumno(2);
        md.borrarMateria(4);
        
        /*
        Alumno a1 = new Alumno(99099, "Javier","Lopez", LocalDate.of(2000,2, 24),true);
        Alumno a2 = new Alumno(88088, "Pedro","Perez", LocalDate.of(2011,3, 24),true);
        
        Materia m1 = new Materia("Ingles 1",1,true);
        Materia m2 = new Materia("Ingles 2",2,true);
        
        ad.guardarAlumno(a1);
        ad.guardarAlumno(a2);
        
        md.guardarMateria(m1);
        md.guardarMateria(m2);
        
        Inscripcion i1 = new Inscripcion(a1,m1);
        Inscripcion i2 = new Inscripcion(a1,m2);
        
        Inscripcion i3 = new Inscripcion(a2,m1);
        
        id.inscribir(i1);
        id.inscribir(i2);
        id.inscribir(i3);
        */

        
        
        // Habilitar para Imprimir el listado de todos los Alumnos Formato: "(legajo) Apellido, Nombre"
        /*
            System.out.println("Listamos todos los alumnos.");
            for(Alumno alu:ad.obtenerAlumnos()){
               System.out.println(alu);
            }
        */
        
                
        
        
        
        
 //       System.out.println(i1.toString());
        
//        id.inscribir(i1);
//        
//        System.out.println("Inscripcion");
//        
//        
        

//        
//        
//        
//        
//        
//        
//        
//        
//        System.out.println("Imprimimos los 2 alumnos ingresados");
//        System.out.println("Alumno: " + a1);
//        System.out.println("Alumno: " + a2);
//              
//        System.out.println("Ahora buscamos alumnos por su ID");
//        System.out.println("Alumno :"+ad.buscarAlumno(7));
//        System.out.println("Alumno :"+ad.buscarAlumno(9));
//        System.out.println("Alumno :"+ad.buscarAlumno(10));
//        
//        System.out.println("Cambiamos el Nombre del Alumno con ID = 7 lo vamos a llamar Ramon");
//        System.out.println("Antes");
//        System.out.println("Alumno " + ad.buscarAlumno(7));
//        ad.actualizarAlumno(new Alumno(7, 9946, "Ramon", "Perez", LocalDate.of(2000,2, 24),true));
//        System.out.println("Despues");
//        System.out.println("Alumno "+ ad.buscarAlumno(7));
//        
//        System.out.println("Listamos todos los alumnos.");
//        for(Alumno alu:ad.obtenerAlumnos()){
//               System.out.println(alu);
//            }
//        
//        
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Error dentro de la Clase Prueba"+ ex);
        }
    }
    




    }
    

