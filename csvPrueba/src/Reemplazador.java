import java.util.ArrayList;
import java.util.HashMap;

public class Reemplazador {

    private String template;
    private ArrayList<String> identificadores;
    private HashMap<String, ArrayList<String>> contenidoCSV;
    private GeneradorPDF generador;

    public void setTemplate(String template) {
        this.template = template;
    }

    public void setIdentificadores(ArrayList<String> identificadores) {
        this.identificadores = identificadores;
    }

    public void setContenidoCSV(HashMap<String, ArrayList<String>> contenidoCSV) {
        this.contenidoCSV = contenidoCSV;
    }

    public void setGenerador(GeneradorPDF generador) {
        this.generador = generador;
    }

    public void reemplazarEtiquetas(){
        String key = identificadores.get(0);
        int n = contenidoCSV.get(key).size();
        int idx = 0;
        while(idx < n){
            String aux = template;
            for(String label: identificadores){
                String val = contenidoCSV.get(label).get(idx);
                aux = aux.replace("<" + label + ">", val);
            }
            generador.generarPDF(aux, idx++);
        }
    }
}
