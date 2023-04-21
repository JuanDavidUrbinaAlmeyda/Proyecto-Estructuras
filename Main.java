import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //------------------Estudiante----------------
        Estudiante yo= new Estudiante();
        yo.nombre_est=JOptionPane.showInputDialog("Nombre");
        yo.id=JOptionPane.showInputDialog("ID");
        yo.carrera=JOptionPane.showInputDialog("Carrera");
        String sem=JOptionPane.showInputDialog("Semestre");
        yo.semestre=Integer.parseInt(sem);



        String numMat= JOptionPane.showInputDialog("Numero de Materias del Estudiante");
        int numeroMaterias = Integer.parseInt(numMat);

        List<Materia> materias = new ArrayList<>();
        double promedioparcial=0;
        int credparciales=0;
        Materia materiaTemporal;
        for (int i = 0; i < numeroMaterias; i++) {
            // Dar memoria al temporal
            materiaTemporal = new Materia();
            // Llenar temporal
            String nomMat=JOptionPane.showInputDialog("Nombre de la Materia");
            materiaTemporal.setNombre(nomMat);
            String numNot=JOptionPane.showInputDialog("Número de Notas");
            int numeroNotas=Integer.parseInt(numNot);
            materiaTemporal.setNum_notas(numeroNotas);

            List<Nota>listadoNotas = new ArrayList<>();
            Nota notaTemporal;
            double promedio = 0;
            for (int j = 0; j < materiaTemporal.getNum_notas(); j++) {
                notaTemporal = new Nota();
                String nomNot=JOptionPane.showInputDialog("Nombre de la Nota");
                notaTemporal.setNombre_nota(nomNot);

                double porcenNot=2;
                while (porcenNot>1 || porcenNot<0) {
                    String porcentajeNot=JOptionPane.showInputDialog("Porcentaje en Decimal de la Nota");
                    porcenNot = Double.parseDouble(porcentajeNot);
                }
                notaTemporal.setPorcentaje(porcenNot);
                String valorNota=JOptionPane.showInputDialog("Valor de la Nota");
                double vlrNot=Double.parseDouble(valorNota);
                notaTemporal.setCalificacion(vlrNot);
                promedio =promedio+ notaTemporal.getPorcentaje()*notaTemporal.getCalificacion(); // calcular
                listadoNotas.add(notaTemporal);

            }
            materiaTemporal.setPromedio(promedio);
            String numCreditos=JOptionPane.showInputDialog("Número de Créditos de la Materia");
            int numCred=Integer.parseInt(numCreditos);
            materiaTemporal.setCreditos(numCred);

            credparciales=credparciales+materiaTemporal.getCreditos();
            promedioparcial=promedioparcial+materiaTemporal.getPromedio()*materiaTemporal.getCreditos();
            materiaTemporal.setListadoNotas(listadoNotas);
            // Agregarlo a la lista
            materias.add(materiaTemporal);
        }
        double pga=0;
        pga=promedioparcial/credparciales;

        //-----------------Imprimir---------------


        System.out.println(yo.toString());
        for (Materia itemMateria : materias) {
            System.out.println("--------Materia-------- " + itemMateria.toString());

            for(Nota itemNota : itemMateria.getListadoNotas()){
                System.out.println("----Nota----" + itemNota+"\n");
            }
        }

        System.out.println("PGA = " + pga);
    }
}

