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
        int clave = 1;
        try(BufferedReader br = new BufferedReader(new FileReader(direccionArchivo))){
            while((linea = br.readLine()) != null){
                //System.out.println(linea);
                String[] palabras = linea.split(",");//Separa la oracion en subcadenas donde halla ","
                ArrayList<String> fila = new ArrayList<>();
                for(String palabra : palabras){
                    fila.add(palabra);
                    //System.out.print(palabra );
                }
                if(contenidoCSV.isEmpty()){
                    contenidoCSV.put("Encabezado", fila);
                }
                else{
                    String nombreClave = "Dato " + clave;
                    contenidoCSV.put(nombreClave, fila);
                    clave++;
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
