/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editordetext;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis G
 */
public class EditorDeTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList() /*Arrays.asList("The first line", "The second line")*/;
        Path file = Paths.get("test.txt");
        lines.add(":v");
        lines.add(":3 " + System.lineSeparator() + "Hola xd");
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(EditorDeTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (BufferedReader br = new BufferedReader(new FileReader("./test.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            System.out.println(everything);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EditorDeTexto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EditorDeTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
