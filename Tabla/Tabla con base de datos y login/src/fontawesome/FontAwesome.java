package fontawesome;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FontAwesome {

    public FontAwesome() {

    }

    public void getIcon(JLabel label) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try (InputStream is = FontAwesome.class.getResourceAsStream("./fontawesome-webfont.ttf")) {
                    Font font = Font.createFont(Font.TRUETYPE_FONT, is);
                    font = font.deriveFont(Font.PLAIN, 24f);
                    //label.setText("\uf0c9");
                    label.setText(label.getText());
                    label.setFont(font);
                } catch (IOException | FontFormatException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

    public void setIcon(JButton label, String icon) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try (InputStream is = FontAwesome.class.getResourceAsStream("./fontawesome-webfont.ttf")) {
                    Font font = Font.createFont(Font.TRUETYPE_FONT, is);
                    font = font.deriveFont(Font.PLAIN, 24f);
                    //label.setText(label.getText());
                    label.setText(icon);
                    label.setFont(font);
                } catch (IOException | FontFormatException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

}
