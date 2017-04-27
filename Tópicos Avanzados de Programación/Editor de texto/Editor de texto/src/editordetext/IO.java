/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editordetext;

import static editordetext.Editor.path;
import java.io.*;
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
            ArrayList<String> lines = new ArrayList();
            Path file = Paths.get(path);
            lines.add(txt);
            try {
                Files.write(file, lines, Charset.forName("UTF-8"));
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            new Save().setVisible(true);
        }
    }

    public void save(String txt, String path) {
        if (!path.equals("")) {
            ArrayList<String> lines = new ArrayList();
            Path file = Paths.get(path);
            lines.add(txt);
            try {
                Files.write(file, lines, Charset.forName("UTF-8"));
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            new Save().setVisible(true);
        }
    }

}
