import java.util.ArrayList;
import java.util.HashMap;

public class ValidadorContenidoCSV {

    HashMap<String, ArrayList<String>> contenidoCSV;

    public ValidadorContenidoCSV(HashMap<String, ArrayList<String>> contenidoCSV){
        this.contenidoCSV = contenidoCSV;

    }
    boolean csvTieneIdentificadoresDelTemplate(ArrayList<String> identificadores){
        if(contenidoCSV.get("Encabezado").containsAll(identificadores)){
            return true;
        }
        else{
            return false;
        }
    }

    boolean csvSoloTieneEncabezado(){
        if(contenidoCSV.size() == 1){
            return true;
        }
        else{
            return false;
        }
    }
}
