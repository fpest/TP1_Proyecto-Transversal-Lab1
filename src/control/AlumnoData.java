package control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Conexion;

public class AlumnoData {

    private Connection con;

    public AlumnoData(Conexion conexion) {

        try {
            con = conexion.getConexion();

        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    }

    public boolean guardarAlumno(Alumno alumno) {
        boolean guardado = true;
        String sql = "INSERT INTO alumno (legajo, nombre, apellido ,fechaNac, activo) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getLegajo());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt("idAlumno"));
            }
            ps.close();
        } catch (SQLException ex) {
            guardado = false;
            //System.out.println("Error al insertar el registro" + ex);
            JOptionPane.showMessageDialog(null, "No se pudo guardar la información. No pueden haber 2 Alumnos con el mismo Numero de Legajo.");
        }
    return guardado;
    }

    public boolean actualizarAlumno(Alumno alumno) {
        boolean actualizado = true;
        String sql = "UPDATE alumno SET legajo=?, nombre=?, apellido=? ,fechaNac=?, activo=? WHERE idAlumno=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getLegajo());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));//LocalDate a Date
            ps.setBoolean(5, alumno.isActivo());
            ps.setInt(6, alumno.getIdAlumno());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            actualizado = false;
            //System.out.println("Error al intentar modificar registro " + ex);
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la información. No pueden haber 2 Alumnos con el mismo Numero de Legajo.");
        }
        return actualizado;
    }
    
    public void borrarAlumno(int idAlumno){
        Alumno alumno = new Alumno();
        alumno = buscarAlumno(idAlumno);
        alumno.setActivo(false);
        actualizarAlumno(alumno);
    }

    public List<Alumno> obtenerAlumnos() {
        return obtenerAlumnos("");
    }

    public List<Alumno> obtenerAlumnos(String cadena) {
        List<Alumno> alumnos = new ArrayList<>();
        Alumno alumno = null;

        String sql = "SELECT * FROM alumno Where nombre like '%" + cadena + "%' or apellido like '%" + cadena + "%'  or legajo like '%" + cadena + "%'";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

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

    public Alumno buscarAlumno(int idAlumno) {

        Alumno alumno = null;

        String sql = "SELECT * FROM alumno WHERE idAlumno=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setLegajo(rs.getInt("legajo"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());  //date a LocalDate
                alumno.setActivo(rs.getBoolean("activo"));
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar alumno.");
        }
        return alumno;
    }
 




}
