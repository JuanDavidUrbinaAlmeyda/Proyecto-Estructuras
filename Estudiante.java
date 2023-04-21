public class Estudiante {
    String nombre_est, carrera, id;
    int semestre;

    public Estudiante() {
    }

    public String getNombre_est() {
        return nombre_est;
    }

    public void setNombre_est(String nombre_est) {
        this.nombre_est = nombre_est;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return
                "\n Bienvenido " + nombre_est +
                "\nCarrera =" + carrera +
                "\nID =" + id +
                "\nSemestre= " + semestre
                ;
    }
}
