import java.util.ArrayList;

public class Controller {
    private ManipuladorTemplate manipuladorTemplate;
    private ManipuladorCSV manipuladorCSV;

    public Controller() {
        manipuladorTemplate = new ManipuladorTemplate();
        manipuladorCSV = new ManipuladorCSV();
    }

    public void generarPDF(){
        manipuladorCSV.setDireccionArchivo("csvPrueba\\src\\datos.csv");
        //El template se debe recuperar como String tras leer un archivo
        String template = "<<Nombre>,<Edad>,<Direccion>> hola quiero saber como estas";

        manipuladorTemplate.setTemplate(template);
        ArrayList<String> identificadores = manipuladorTemplate.getlabels();
        manipuladorTemplate.setIdentificadores(identificadores);


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
