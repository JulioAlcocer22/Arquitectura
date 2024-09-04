import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ManipuladorCSV {
    private String direccionArchivo;
    private LinkedHashMap<String, ArrayList<String>> contenidoCSV;


    public ManipuladorCSV(String direccionArchivo){
        this.direccionArchivo = direccionArchivo;
        contenidoCSV = new LinkedHashMap<>();
    }

    public void leerArchivo(){
        String linea;
        try(BufferedReader br = new BufferedReader(new FileReader(direccionArchivo))){
            while((linea = br.readLine()) != null){
                //System.out.println(linea);
                String[] palabras = linea.split(","); //Separa la oracion en subcadenas donde halla ","
                if(contenidoCSV.isEmpty()){
                    ArrayList<String> fila = new ArrayList<>();
                    for(String palabra: palabras) fila.add(palabra);
                    contenidoCSV.put("Encabezado", fila);
                }
                else{
                    int idx = 0;
                    for(String palabra: palabras){
                        String key = contenidoCSV.get("Encabezado").get(idx);
                        if(!contenidoCSV.containsKey(key)){
                            contenidoCSV.put(key, new ArrayList<>());
                        }
                        contenidoCSV.get(key).add(palabra);
                        idx++;
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public HashMap<String, ArrayList<String>> getContenidoCSV() {
        return contenidoCSV;
    }
}
