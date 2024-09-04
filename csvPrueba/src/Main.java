import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ManipuladorTemplate manipuladorTemplate = new ManipuladorTemplate();
        //El template se debe recuperar como String tras leer un archivo
        String template = "<<Nombre>,<Edad>,<Direccion>> hola quiero saber como estas";
        manipuladorTemplate.setTemplate(template);
        ArrayList<String> identificadores = manipuladorTemplate.getlabels(manipuladorTemplate.getTemplate());  
        manipuladorTemplate.setIdentificadores(identificadores);     
        
        ManipuladorCSV manipuladorCSV = new ManipuladorCSV("csvPrueba\\src\\datos.csv");
        manipuladorCSV.leerArchivo();
        manipuladorCSV.getContenidoCSV().forEach((k,v) -> System.out.println("Key: " + k + " Value: " + v));

        //VALIDACIÓN!
        ValidadorContenidoCSV validador = new ValidadorContenidoCSV(manipuladorCSV.getContenidoCSV(), identificadores);
        
        if(validador.validar()){
            Reemplazador reemplazador = new Reemplazador(template, identificadores, manipuladorCSV.getContenidoCSV());
            reemplazador.reemplazarEtiquetas();
        }
        validador.imprimirMensaje();
    }
}