import java.util.ArrayList;

public class Controller {
    private ManipuladorTemplate manipuladorTemplate;
    private ManipuladorCSV manipuladorCSV;
    private ValidadorContenidoCSV validadorContenidoCSV;
    //private ValidadorTemplate validadorTemplate;
    private Reemplazador reemplazador;
    private ArrayList<String> contenido;
    private GeneradorPDF generadorPdf;

    public Controller() {
        manipuladorTemplate = new ManipuladorTemplate();
        manipuladorCSV = new ManipuladorCSV();
        validadorContenidoCSV = new ValidadorContenidoCSV();
        //validadorTemplate = new ValidadorTemplate();
        reemplazador = new Reemplazador();
        generadorPdf = new GeneradorPDF();
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

        validadorContenidoCSV.setContenidoCSV(manipuladorCSV.getContenidoCSV());
        validadorContenidoCSV.setIdentificadores(identificadores);


        if(validadorContenidoCSV.validar()){
            reemplazador.setTemplate(template);
            reemplazador.setIdentificadores(identificadores);
            reemplazador.setContenidoCSV(manipuladorCSV.getContenidoCSV());
            generadorPdf.arrayListToPDFs(reemplazador.reemplazarEtiquetas());
        }
        validadorContenidoCSV.imprimirMensaje();
    }
}
