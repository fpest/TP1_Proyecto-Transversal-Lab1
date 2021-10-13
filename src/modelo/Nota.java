
package modelo;

public class Nota {

    private int idInscripcion;
    private int idMateria;
    private String nombreMateria;
    private Double nota;

    public Nota(int idInscripcion, int idMateria, String nombreMateria, Double nota) {
        this.idInscripcion = idInscripcion;
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.nota = nota;
    }

    public Nota() {
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nombreMateria;
    }
    
    
    
}
