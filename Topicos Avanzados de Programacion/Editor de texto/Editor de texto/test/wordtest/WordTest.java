/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordtest;

/**
 * Simple Hello World example.
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordTest {

    public static void main(String args[]) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Luis G\\Documents\\Programas\\escuela\\Tópicos Avanzados de Programación\\Editor de texto\\test.pdf"));
            document.open();
            document.add(new Paragraph("Hola :ddv"));
            document.close();
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(WordTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
