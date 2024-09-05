import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManipuladorTemplate {
    private String template;
    private ArrayList<String> labels;

    public ManipuladorTemplate() {
        this.template = "";
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String ruta) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.template = contenido.toString();
    }

    public ArrayList<String> getIdentificadores() {
        return labels;
    }

    public void setIdentificadores(ArrayList<String> labels) {
        this.labels = labels;
    }

    public ArrayList<String> getlabels() {
        ArrayList<String> labels = new ArrayList<String>();
        int index = 0;
        while (index < template.length()) {
            if (template.charAt(index) == '<') {
                int other = template.indexOf('<', index+1);
                int end = template.indexOf('>', index);
                if (other != -1 && other < end) {
                    index = other;
                    continue;
                }
                if (end == -1) {
                    break;
                }
                String label = template.substring(index + 1, end);
                label = label.replace("\n", " ");
                label = label.trim();
                labels.add(label);

                this.template = this.template.substring(0, index+1) + label + this.template.substring(end);

                index++;
            } else {
                index++;
            }
        }
        return labels;
    }
}