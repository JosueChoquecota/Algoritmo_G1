
package src.model;

public class Estudiante extends Usuario {
  
    private int estID;
    private String carrera;
    private String codEst;
    private Boolean estado;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, String correo, String dni) {
        super(nombre, apellido, correo, dni);
    }

    public int getEstID() {
        return estID;
    }

    public void setEstID(int estID) {
        this.estID = estID;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCodEst() {
        return codEst;
    }

    public void setCodEst(String codEst) {
        this.codEst = codEst;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    

    
}
