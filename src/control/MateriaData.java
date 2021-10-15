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
import modelo.Conexion;
import modelo.Materia;

/**
 *
 * @author TomasNievas
 */
public class MateriaData {
    
    private Connection con;
    
    public MateriaData(Conexion conexion) {
        
        try {
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    }
    
    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia ( nombre, anio, activo) VALUES (?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isActivo());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                materia.setIdMateria(rs.getInt("idMateria"));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar el registro" + ex);
        }
    }
    
    public boolean actualizarMateria(Materia materia) {
        boolean actualizada;
        actualizada = true;
        String sql = "UPDATE materia SET  nombre=?,anio=?, activo=? WHERE idMateria=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isActivo());
            ps.setInt(4, materia.getIdMateria());
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            actualizada = false;
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la información.");
            System.out.println("Error al intentar modificar registro " + ex);
        }
        
        return actualizada;
    }
    
    public boolean borrarMateria(int idMateria) {
        boolean borrado = true;
        String sql = "DELETE FROM `materia` WHERE idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            borrado = false;
            System.out.println("Error al intentar borrar registro " + ex);
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la información.");
        }
        return borrado;
    }
    
    public boolean desactivarMateria(Materia materia) {
        materia.setActivo(false);
        return actualizarMateria(materia);
    }
    
    public boolean activarMateria(Materia materia) {
        materia.setActivo(true);
        return actualizarMateria(materia);
    }
    
    public List<Materia> obtenerMateria() {
        return obtenerMateria("");
    }
    
    public List<Materia> obtenerMateria(String cadena) {
        List<Materia> materias = new ArrayList<>();
        Materia materia = null;
        
        String sql = "SELECT * FROM materia Where nombre like '%" + cadena + "%'";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setActivo(rs.getBoolean("activo"));
                
                materias.add(materia); //Agrega cada materia a la lista
            }
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar los registros ");
        }
        return materias;  //devuelve un ArrayList
    }
    
    public Materia buscarMateria(int idMateria) {
        
        Materia materia = null;
        
        String sql = "SELECT * FROM materia WHERE idMateria=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setActivo(rs.getBoolean("activo"));
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar materia.");
        }
        return materia;
    }
}
