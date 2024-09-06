import java.util.ArrayList;

public class Controller {
    private ManipuladorTemplate manipuladorTemplate;
    private ManipuladorCSV manipuladorCSV;
    private Validador validador;
    private Reemplazador reemplazador;
    private GeneradorPDF generadorPdf;

    public Controller() {
        manipuladorTemplate = new ManipuladorTemplate();
        manipuladorCSV = new ManipuladorCSV();
        validador = new Validador();
        //validadorTemplate = new ValidadorTemplate();
        reemplazador = new Reemplazador();
        generadorPdf = new GeneradorPDF();
    }

    public void generarPDF(){

        abrirDocumentos("csvPrueba/src/template.txt","csvPrueba/src/datos.csv");






        validador.setContenidoCSV(manipuladorCSV.getContenidoCSV());
        validador.setIdentificadores(manipuladorTemplate.getIdentificadores());

        System.out.println("Validando contenido CSV");
        validador.validar();

        crearPDF();

        validador.imprimirMensaje();
    }
    private void abrirDocumentos(String direccionTxt,String direccionCSV ){
        //abriendo archivo Txt
        manipuladorTemplate.setTemplate(direccionTxt);
        //manipuladorTemplate.setIdentificadores(manipuladorTemplate.getIdentificadores());
        //abriendo archivo CSV
        manipuladorCSV.setDireccionArchivo(direccionCSV);
        manipuladorCSV.leerArchivo();
    }

    private void crearPDF(){
        reemplazador.setTemplate(manipuladorTemplate.getTemplate());
        reemplazador.setIdentificadores(manipuladorTemplate.getIdentificadores());
        reemplazador.setContenidoCSV(manipuladorCSV.getContenidoCSV());
        System.out.println("Reemplazando etiquetas");
        generadorPdf.arrayListToPDFs(reemplazador.reemplazarEtiquetas());
        System.out.println("PDF generado");
    }



}
