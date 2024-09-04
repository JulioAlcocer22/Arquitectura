import java.util.ArrayList;
import java.util.HashMap;

public class ValidadorContenidoCSV {

    private HashMap<String, ArrayList<String>> contenidoCSV;
    private ArrayList<String> identificadores; 
    private String errorMessage = "No existe ningún error identificado";

    public ValidadorContenidoCSV(HashMap<String, ArrayList<String>> contenidoCSV, ArrayList<String> identificadores){
        this.contenidoCSV = contenidoCSV;
        this.identificadores = identificadores;
    }

    public boolean validar(){
        if(!templateTieneIdentificadores()){
            errorMessage = "No existen identificadores en el template";
            return false;
        }
        if(csvSoloTieneEncabezado()){
            errorMessage = "El archivo CSV solo tiene la primera linea";
            return false;
        }
        if(!csvTieneIdentificadoresDelTemplate()){
            errorMessage = "El CSV no contiene todos los identificadores";
            return false;
        }
        return true;
    }

    private boolean templateTieneIdentificadores(){
        if(!identificadores.isEmpty()) return true;
        else return false;
    }

    private boolean csvTieneIdentificadoresDelTemplate(){
        if(contenidoCSV.get("Encabezado").containsAll(identificadores)) return true;
        else return false;
    }

    private boolean csvSoloTieneEncabezado(){
        if(contenidoCSV.size() == 1) return true;
        else return false;
    }

    public void imprimirMensaje(){
        System.out.println(errorMessage);
    }
}