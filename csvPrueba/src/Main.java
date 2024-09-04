import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        ManipuladorTemplate manipuladorTemplate = new ManipuladorTemplate();

        manipuladorTemplate.setTemplate("<            Nombre      >,<           Edad      >,<          Direccion  > hola quiero saber como estas");
        ArrayList<String> identificadores = manipuladorTemplate.getlabels();
        manipuladorTemplate.setIdentificadores(identificadores);

        // controller.generarPDF();

    }
}