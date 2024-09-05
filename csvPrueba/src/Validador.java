import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
public class Validador {

    private HashMap<String, ArrayList<String>> contenidoCSV;
    private ArrayList<String> identificadores; 
    private String errorMessage = "No existe ningún error identificado";

    public Validador(){
    }

    public void setContenidoCSV(HashMap<String, ArrayList<String>> contenidoCSV) {
        this.contenidoCSV = contenidoCSV;
    }

    public void setIdentificadores(ArrayList<String> identificadores) {
        this.identificadores = identificadores;
    }

    public void validar(){

        try{
            csvTieneIdentificadoresDelTemplate();
            templateTieneIdentificadores();
            csvSoloTieneEncabezado();
        } catch (ExcepcionVerificaciones e){
            JOptionPane.showMessageDialog(null, "Se ha producido un error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void templateTieneIdentificadores() throws ExcepcionVerificaciones {
        if(identificadores.isEmpty()) {
            throw new ExcepcionVerificaciones("El archivo Txt no tiene identificadores");
        }
    }

    private void csvTieneIdentificadoresDelTemplate() throws ExcepcionVerificaciones {
        if(!contenidoCSV.get("Encabezado").containsAll(identificadores)){
            throw new ExcepcionVerificaciones("El CSV no contiene los identificadores del Template");
        }

    }

    private void csvSoloTieneEncabezado()throws ExcepcionVerificaciones {
        if(contenidoCSV.size() == 1){
            throw new ExcepcionVerificaciones("El archivo CSV no tiene información, solo tiene encabezado");
        }
    }

    public void imprimirMensaje(){
        System.out.println(errorMessage);
    }
}