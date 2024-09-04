import java.util.ArrayList;
import java.util.HashMap;

public class Reemplazador {

    private String template;
    private ArrayList<String> identificadores;
    private HashMap<String, ArrayList<String>> contenidoCSV;
    private GeneradorPDF generador;

    public Reemplazador(String template, ArrayList<String> identificadores, HashMap<String, ArrayList<String>> contenidoCSV){
        this.template = template;
        this.identificadores = identificadores;
        this.contenidoCSV = contenidoCSV;
        generador = new GeneradorPDF();
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
