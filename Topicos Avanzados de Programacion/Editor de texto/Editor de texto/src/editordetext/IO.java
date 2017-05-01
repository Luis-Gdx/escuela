/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editordetext;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import static editordetext.Editor.fileType;
import static editordetext.Editor.path;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Luis G
 */
public class IO {

    public String read(File file) {
        String data = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            data = sb.toString();
            System.out.println(data);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public void save(String txt) {
        if (!path.equals("")) {
            switch (fileType) {
                case "txt":
                    ArrayList<String> lines = new ArrayList();
                    Path file = Paths.get(path);
                    lines.add(txt);
                    try {
                        Files.write(file, lines, Charset.forName("UTF-8"));
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Word":
                    XWPFDocument document = new XWPFDocument();
                    try {
                        FileOutputStream out = new FileOutputStream(new File(path));
                        XWPFParagraph paragraph = document.createParagraph();
                        XWPFRun run = paragraph.createRun();
                        run.setText(txt);
                        document.write(out);
                        out.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "PDF":
                    try {
                        Document pdf = new Document();
                        PdfWriter.getInstance(pdf, new FileOutputStream(path));
                        pdf.open();
                        pdf.add(new Paragraph(txt));
                        pdf.close();
                    } catch (DocumentException | FileNotFoundException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        } else {
            new Save().setVisible(true);
        }
    }

    public void save(String txt, String path) {
        System.out.println(path);
        if (!path.equals("")) {
            switch (fileType) {
                case "txt":
                    ArrayList<String> lines = new ArrayList();
                    Path file = Paths.get(path);
                    lines.add(txt);
                    try {
                        Files.write(file, lines, Charset.forName("UTF-8"));
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Word":
                    XWPFDocument document = new XWPFDocument();
                    try {
                        FileOutputStream out = new FileOutputStream(new File(path));
                        XWPFParagraph paragraph = document.createParagraph();
                        XWPFRun run = paragraph.createRun();
                        run.setText(txt);
                        document.write(out);
                        out.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "PDF":
                    try {
                        Document pdf = new Document();
                        PdfWriter.getInstance(pdf, new FileOutputStream(path));
                        pdf.open();
                        pdf.add(new Paragraph(txt));
                        pdf.close();
                    } catch (DocumentException | FileNotFoundException ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        } else {
            new Save().setVisible(true);
        }
    }

}
