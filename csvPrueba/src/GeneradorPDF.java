import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneradorPDF {

    public void generarPDF(String texto, int idx){
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Página " + idx + ".pdf"));
            document.open();
            Paragraph p = new Paragraph(texto);
            document.add(p);
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        } 
    }
}
