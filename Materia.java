import java.util.List;

public class Materia {
    //------------------------------------------Atributos-------------------------------
    private String nombre;
    private double promedio;
    private int num_notas,creditos;

    private List<Nota> listadoNotas;

    public Materia() {
    }

    public Materia(String nombre, double promedio, int num_notas, List<Nota> notas) {
        this.nombre = nombre;
        this.promedio = promedio;
        this.num_notas = num_notas;
        this.listadoNotas = notas;
    }

    //----------------------------------Getters y Setters-------------------------------
    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getNum_notas() {
        return num_notas;
    }

    public void setNum_notas(int num_notas) {
        this.num_notas = num_notas;
    }

    public List<Nota> getListadoNotas() {
        return listadoNotas;
    }

    public void setListadoNotas(List<Nota> listadoNotas) {
        this.listadoNotas = listadoNotas;
    }

    //-----------------------------------Métodos------------------------------------------


    @Override
    public String toString() {
        return
                '\n'+ nombre + '\n' +
                "Promedio=" + promedio+
                 "\nCréditos= "+creditos
              ;
    }
}
