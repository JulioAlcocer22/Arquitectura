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
        validarEtiquetas();
        reemplazarEtiquetas();
        generadorPdf.arrayListToPDFs(reemplazador.reemplazarEtiquetas());
        System.out.println("PDF Generado");
        validador.imprimirMensaje();
    }
    private void abrirDocumentos(String direccionTxt,String direccionCSV ){
        manipuladorTemplate.setTemplate(direccionTxt);
        manipuladorCSV.setDireccionArchivo(direccionCSV);
        manipuladorCSV.leerArchivo();
    }
    public void validarEtiquetas(){
        validador.setContenidoCSV(manipuladorCSV.getContenidoCSV());
        validador.setIdentificadores(manipuladorTemplate.getIdentificadores());
        validador.validar();
        System.out.println("Etiquetas validadas");
    }

    private void reemplazarEtiquetas(){
        reemplazador.setTemplate(manipuladorTemplate.getTemplate());
        reemplazador.setIdentificadores(manipuladorTemplate.getIdentificadores());
        reemplazador.setContenidoCSV(manipuladorCSV.getContenidoCSV());
        System.out.println("Etiquetas reemplazadas");
    }



}
