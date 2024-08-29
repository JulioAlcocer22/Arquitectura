import java.util.ArrayList;

public class ManipuladorTemplate implements ManipularArchivos{

    //Atributos
    private ArrayList<String> identificadores;

    public ManipuladorTemplate(){
        identificadores = new ArrayList<>();
        identificadores.add("Edad");
        identificadores.add("destinatario");
    }


    @Override
    public void leerArchivo() {
    }

    @Override
    public boolean archivoValido() {
        return false;
    }

    public ArrayList<String> getIdentificadores() {
        return identificadores;
    }
}
