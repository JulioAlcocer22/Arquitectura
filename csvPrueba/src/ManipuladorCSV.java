//Julio Alcocer
import java.io.*;
import java.util.ArrayList;

public class ManipuladorCSV implements ManipularArchivos{
    //atributos
    private String direccionArchivo; //donde esta alojado el csv
    private ArrayList<ArrayList<String>> contenidoCSV; //toda la informacion del csv
    private ArrayList<String> encabezadoCSV;

    private ArrayList<String> identificadoresTemplate;
    private ArrayList<ArrayList<String>> contenidoCsvParaTemplate;
    //constructor
    public ManipuladorCSV(String direccionArchivo, ArrayList<String> identificadoresTemplate){
        this.direccionArchivo = direccionArchivo;
        contenidoCSV = new ArrayList<>();
        encabezadoCSV = new ArrayList<>();
        this.identificadoresTemplate = identificadoresTemplate;
        contenidoCsvParaTemplate = new ArrayList<>();
    }

    @Override
    public void leerArchivo() {
        String linea;

        try(BufferedReader br = new BufferedReader(new FileReader(direccionArchivo))){
            while((linea = br.readLine()) != null){
                //System.out.println(linea);
                String[] palabras = linea.split(",");//Separa la oracion en subcadenas donde halla ","
                ArrayList<String> fila = new ArrayList<>();
                for(String palabra : palabras){
                    fila.add(palabra);
                    //System.out.print(palabra );
                }
                contenidoCSV.add(fila);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public boolean archivoValido() {
        if(csvContieneIdentificadoresDelTemplate(identificadoresTemplate)){
            return true;
        }else{
            return false;
        }
    }

    public void imprimirInformacionCSV(ArrayList<ArrayList<String>> contenido){
        for(ArrayList<String> dato: contenido){
            System.out.println(dato);
        }
    }

    //funciones requerridas para validarArchivo
    public void generarContenidoCsvParaTemplate(){
        ArrayList<Integer> indices = obtenerIndicesDeIdeintificadoresEnEncabezadosCSV();

        for(ArrayList<String> arrayCsv: contenidoCSV){
            //System.out.println(arrayCsv);
            ArrayList<String> nuevaLineaCSV = new ArrayList<>();
            for(String nombre :arrayCsv){

                //System.out.println(arrayCsv.indexOf(nombre) + " " + nombre);

                for(Integer indice: indices){
                    if(arrayCsv.indexOf(nombre) == indice) {
                        //System.out.println("\t aqui");
                        nuevaLineaCSV.add(nombre);
                        //System.out.println(arrayCsv.indexOf(elemento));
                    }
                }

                //contenidoCsvParaTemplate.add(linea)
            }
            contenidoCsvParaTemplate.add(nuevaLineaCSV);//en este punto ya estan los strings que concuerdan con los identificidadores
           // System.out.println(nuevaLineaCSV);
           // System.out.println("\n");
        }
    }

    private boolean csvContieneIdentificadoresDelTemplate(ArrayList<String> identificadores){ //el string que es atributo de la clase ManipuladorTemplate
       obtenerEncabezadosCSV();
       if(encabezadoCSV.containsAll(identificadores)){
           return true;
       }
       else{
           return false;
       }

    } // punto 3.a

    public boolean csvSoloTienePrimeraFila(){ // punto 3.b
        System.out.println(contenidoCSV.size());
        if(contenidoCSV.size() == 1){
            System.out.println("Vrg we te mamaste");
            return true;
        }
        else{
            System.out.println("Todo bien pa siguele");
            return false;
        }
    }
    private void obtenerEncabezadosCSV(){
        encabezadoCSV.addAll(contenidoCSV.get(0));
    }

    private ArrayList<Integer> obtenerIndicesDeIdeintificadoresEnEncabezadosCSV(){
        ArrayList<Integer> indices = new ArrayList<>();
        obtenerEncabezadosCSV();

        for(String elemento: identificadoresTemplate){
            int indice = encabezadoCSV.indexOf(elemento);
            //System.out.println(encabezadoCSV.indexOf(elemento));
            indices.add(indice);
        }
        return indices;
    }

    public ArrayList<ArrayList<String>> getContenidoCSV() {
        return contenidoCSV;
    }

    public ArrayList<ArrayList<String>> getContenidoCsvParaTemplate() {
        return contenidoCsvParaTemplate;
    }
}
