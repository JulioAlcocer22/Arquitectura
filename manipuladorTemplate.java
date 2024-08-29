import java.util.ArrayList;

public class manipuladorTemplate {
    public static void main(String[] args) {
        String template = "Ola <     destinatario      >, voce tem <holaaa\naaaa aa> anos";

        manipuladorTemplate manipulador = new manipuladorTemplate();
        ArrayList<String> labels = manipulador.getlabels(template);

        for (String label : labels) {
            System.out.println(label);
        }
    }

    public ArrayList<String> getlabels(String template) {
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