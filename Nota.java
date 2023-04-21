public class Nota {
    private String nombre_nota;
    private double porcentaje, calificacion;

    public Nota() {
    }

    public Nota(String nombre_nota, double porcentaje, double calificacion) {
        this.nombre_nota = nombre_nota;
        this.porcentaje = porcentaje;
        this.calificacion = calificacion;
    }

    public String getNombre_nota() {
        return nombre_nota;
    }

    public void setNombre_nota(String nombre_nota) {
        this.nombre_nota = nombre_nota;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return
                '\n'+nombre_nota + '\n' +
                "Porcentaje=" + porcentaje +
                "\nCalificación=" + calificacion
                ;
    }
}
