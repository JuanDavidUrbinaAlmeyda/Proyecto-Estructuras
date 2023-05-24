import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Main {
    static String nombreArchivo = "archivo.txt"; // Nombre del archivo a leer y escribir
    static ArrayList<Materia> materias = new ArrayList<>();

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bievenido a GradeUnab");


        //------------------Estudiante----------------
        Estudiante yo = new Estudiante();
        yo.nombre_est = JOptionPane.showInputDialog("Nombre: ");
        yo.id = JOptionPane.showInputDialog("ID: ");
        yo.carrera = JOptionPane.showInputDialog("Carrera: ");
        String sem = JOptionPane.showInputDialog("Semestre: ");
        yo.semestre = Integer.parseInt(sem);

        JOptionPane.showMessageDialog(null,"Materias guardadas anteriormente: \n"+cargarmat());
        String numMat = JOptionPane.showInputDialog("Numero de Materias del Estudiante");
        int numeroMaterias = Integer.parseInt(numMat);


        double promedioparcial = 0;
        int credparciales = 0;
        Materia materiaTemporal;
        for (int i = 0; i < numeroMaterias; i++) {
            // Dar memoria al temporal
            materiaTemporal = new Materia();
            // Llenar temporal
            String nomMat = JOptionPane.showInputDialog("Nombre de la Materia");
            materiaTemporal.setNombre(nomMat);
            String numNot = JOptionPane.showInputDialog("Número de Notas");
            int numeroNotas = Integer.parseInt(numNot);
            materiaTemporal.setNum_notas(numeroNotas);

            List<Nota> listadoNotas = new ArrayList<>();
            Nota notaTemporal;
            double promedio = 0;
            for (int j = 0; j < materiaTemporal.getNum_notas(); j++) {
                notaTemporal = new Nota();
                String nomNot = JOptionPane.showInputDialog("Nombre de la Nota");
                notaTemporal.setNombre_nota(nomNot);

                double porcenNot = 2;
                while (porcenNot > 1 || porcenNot < 0) {
                    String porcentajeNot = JOptionPane.showInputDialog("Porcentaje en Decimal de la Nota");
                    porcenNot = Double.parseDouble(porcentajeNot);
                }
                notaTemporal.setPorcentaje(porcenNot);
                String valorNota = JOptionPane.showInputDialog("Valor de la Nota");
                double vlrNot = Double.parseDouble(valorNota);
                notaTemporal.setCalificacion(vlrNot);
                promedio = promedio + notaTemporal.getPorcentaje() * notaTemporal.getCalificacion(); // calcular
                listadoNotas.add(notaTemporal);

            }
            materiaTemporal.setPromedio(promedio);
            String numCreditos = JOptionPane.showInputDialog("Número de Créditos de la Materia");
            int numCred = Integer.parseInt(numCreditos);
            materiaTemporal.setCreditos(numCred);

            credparciales = credparciales + materiaTemporal.getCreditos();
            promedioparcial = promedioparcial + materiaTemporal.getPromedio() * materiaTemporal.getCreditos();
            materiaTemporal.setListadoNotas(listadoNotas);
            // Agregarlo a la lista
            materias.add(materiaTemporal);
        }
        double pga = 0;
        pga = promedioparcial / credparciales;

        //-----------------Imprimir---------------


        System.out.println(yo.toString());
        for (Materia itemMateria : materias) {
            System.out.println("--------Materia-------- " + itemMateria.toString());

            for (Nota itemNota : itemMateria.getListadoNotas()) {
                System.out.println("----Nota----" + itemNota + "\n");
            }
        }

        System.out.println("PGA = " + pga);


        //----------MENU 2-----------
        int cicl = 0;
        while (cicl == 0) {
            String opcionmenu2 = JOptionPane.showInputDialog("Seleccione:\n 1) Para listar las materias\n 2) Para eliminar una materia\n  3) Para salir\n 4) Para guardar y salir\n ");
            int opmenu2 = Integer.parseInt(opcionmenu2);
            if (opmenu2 == 1) {
                String txt = "";
                for (Materia el : materias) {
                    txt += "\n" + " [ " + (materias.indexOf(el) + 1) + " ]" + el;
                    JOptionPane.showMessageDialog(null,txt);
                }
                cicl=0;

            } else if (opmenu2 == 2) {
                String txt = "";
                for (Materia materia : materias) {
                    txt += "\n" + " [ " + (materias.indexOf(materia) + 1) + " ]" + materia;
                }
                JOptionPane.showMessageDialog(null,txt);
                int indice = Integer.parseInt(JOptionPane.showInputDialog("Indice de la materia a eliminar: "));
                materias.remove(indice-1);
                JOptionPane.showMessageDialog(null, "Materia Eliminada");
                cicl=0;
            } else if (opmenu2 == 3) {
                JOptionPane.showMessageDialog(null, "Adiós!");
                cicl=1;
            }
            else if(opmenu2==4){
                guardarmat();
                JOptionPane.showMessageDialog(null, "Adiós!");
                cicl=1;

            }
            else {
                JOptionPane.showMessageDialog(null, "Opción Incorrecta");
                cicl=0;
            }


        }

    }
    public static String cargarmat(){
        String rta="";
        try {
            FileReader lector = new FileReader(nombreArchivo);
            BufferedReader bufferedReader = new BufferedReader(lector);

            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
               rta=rta+"\n"+linea;
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return rta;
    }
    public static void guardarmat(){
        try {
            FileWriter escritor = new FileWriter(nombreArchivo);
            BufferedWriter bufferedWriter = new BufferedWriter(escritor);
            for (Materia itemMateria : materias) {
                bufferedWriter.write("--------Materia-------- " + itemMateria.toString());
                bufferedWriter.newLine();
                for (Nota itemNota : itemMateria.getListadoNotas()) {
                    bufferedWriter.write("----Nota----" + itemNota + "\n");
                    bufferedWriter.newLine();
                }
            }



            bufferedWriter.close();
            JOptionPane.showMessageDialog(null,"Guardado Exitosamente");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

}

