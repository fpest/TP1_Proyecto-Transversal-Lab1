package control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Inscripcion;

import modelo.Conexion;
import modelo.Materia;
import modelo.Nota;

public class InscripcionData {

    private Connection con;
    private Inscripcion inscripcion;

    public InscripcionData(Conexion conexion) {

        try {
            con = conexion.getConexion();

        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }

    }

    public boolean inscribir(Inscripcion inscripcion) {
        boolean inscripto;

        inscripto = true;

        String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota, activo) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            double nota = 0.0;
            boolean activo = true;

            ps.setInt(1, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(2, inscripcion.getMateria().getIdMateria());
            ps.setDouble(3, nota);
            ps.setBoolean(4, activo);

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                inscripcion.setIdInscripcion(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            inscripto = false;
            //System.out.println("Error al insertar el registro" + ex);

        }
        return inscripto;

    }

    public boolean reInscribir(Alumno alumno, Materia materia) {

        boolean reInscripto;

        reInscripto = true;

        String sql = "UPDATE inscripcion SET activo=true WHERE idAlumno=? and idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getIdAlumno());
            ps.setInt(2, materia.getIdMateria());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            reInscripto = false;
            System.out.println("Error al intentar modificar registro " + ex);
        }
        return reInscripto;
    }

    public boolean registrarNota(int idInscripcion, double nota) {
        boolean registrada = true;
        String sql = "UPDATE inscripcion SET nota=? WHERE idInscripcion=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idInscripcion);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            registrada = false;
            System.out.println("Error al intentar modificar registro " + ex);
        }
        return registrada;

    }

    public boolean desInscribir(Inscripcion inscripcion) {

        boolean desInscripto;
        desInscripto = true;
        String sql = "UPDATE inscripcion SET activo=false WHERE idAlumno=? and idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(2, inscripcion.getMateria().getIdMateria());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            desInscripto = false;
            System.out.println("Error al intentar modificar registro " + ex);
        }
        return desInscripto;
    }

    public Inscripcion buscarInscripcion(Alumno alumno, Materia materia) {
        Inscripcion inscripcion = null;
        String sql = "SELECT * FROM inscripcion WHERE idAlumno=? and idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getIdAlumno());
            ps.setInt(2, materia.getIdMateria());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);
                inscripcion.setActivo(rs.getBoolean("activo"));
                inscripcion.setNota(rs.getDouble("nota"));
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar alumno.");
        }
        return inscripcion;
    }

    public ArrayList<Nota> buscarNotas(Alumno alumno) {
        Nota nota = null;
        ArrayList<Nota> notas = new ArrayList<>();

        String sql = "SELECT idInscripcion, ins.idMateria, ma.nombre, nota FROM `inscripcion` ins \n"
                + "JOIN materia ma on  ins.idMateria=ma.idMateria\n"
                + "WHERE idAlumno=? and ins.activo=1 and ma.activo=1;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getIdAlumno());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                nota = new Nota();
                nota.setIdInscripcion(rs.getInt("idInscripcion"));
                nota.setIdMateria(rs.getInt("idMateria"));
                nota.setNombreMateria(rs.getString("nombre"));
                nota.setNota(rs.getDouble("nota"));

                notas.add(nota);
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar alumno.");
        }
        return notas;
    }

    public ArrayList<Alumno> obtenerAlumnoMaterias(int idMateria) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        Alumno alumno = null;

        String sql = "SELECT al.idAlumno, al.legajo, al.nombre, al.apellido, al.fechaNac, al.activo, nota from alumno al, inscripcion ins where al.idAlumno = ins.idAlumno and ins.idMateria = ? and ins.activo=1;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setLegajo(rs.getInt("legajo"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());  //date a LocalDate
                alumno.setActivo(rs.getBoolean("activo"));

                alumnos.add(alumno); //Agrega cada alumno a la lista
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al buscar los registros ");
        }
        return alumnos;  //devuelve un ArrayList
    }

}
