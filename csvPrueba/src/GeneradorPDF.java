import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneradorPDF {
    public void arrayListToPDFs(ArrayList<String> contenido){
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("TEST.pdf"));
            document.open();
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
        for(String correo : contenido){
            generarPDF(correo, document);
        }
        document.close();
    }

    public void generarPDF(String texto, Document document){
        Paragraph p = new Paragraph(texto);
        try {
            document.add(p);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.newPage();
    }
}
