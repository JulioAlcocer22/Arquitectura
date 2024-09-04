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

    public void setTemplate(String template) {
        this.template = template;
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
                int other = template.indexOf('<', index + 1);
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
                index = end + 1;
            } else {
                index++;
            }
        }
        return labels;
    }
}