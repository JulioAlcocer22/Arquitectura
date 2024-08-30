import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ManipuladorTemplate manipuladorTemplate = new ManipuladorTemplate();
        manipuladorTemplate.setTemplate("<<Nombre>,<Edad>,<Direccion>,<Telefono>>");
        ArrayList<String> identificadores = manipuladorTemplate.getlabels(manipuladorTemplate.getTemplate());  
        manipuladorTemplate.setIdentificadores(identificadores);      

        // System.out.println("Identificadores: ");
        // for (String identificador : manipuladorTemplate.getIdentificadores()) {
        //     System.out.println(identificador);
        // }

        ManipuladorCSV manipuladorCSV = new ManipuladorCSV("src/datos.csv", manipuladorTemplate.getIdentificadores());
        manipuladorCSV.leerArchivo();
        manipuladorCSV.imprimirInformacionCSV(manipuladorCSV.getContenidoCSV());
        manipuladorCSV.csvSoloTienePrimeraFila();
        System.out.println("\nAhora solo el contenido de acuerdo a los identificadores\n");
        manipuladorCSV.generarContenidoCsvParaTemplate();
        manipuladorCSV.imprimirInformacionCSV(manipuladorCSV.getContenidoCsvParaTemplate());
    }
}