/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static config.Config.*;

/**
 *
 * @author Luis G
 */
public class Validate {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    //Se valida la contraseña
    public static boolean validatePassword(JPasswordField password, JLabel label) {
        if (password.getPassword().length < PASSWORD_LENGTH) {
            label.setText(PASSWORD_LENGTH_ERROR);
            password.requestFocus();
            return false;
        } else {
            label.setText("");
            return true;
        }
    }

    //Se validan campos que solo pueden contener texto
    public static boolean validateText(JTextField text, JLabel label) {
        boolean valid = true;
        boolean isNumber = findNumber(text.getText());
        boolean isNull = text.getText().equals("");
        if (isNull || isNumber) {
            if (isNull) {
                label.setText(NULL_DATA_ERROR);
            } else {
                label.setText(ONLY_TEXT_ERROR);
            }
            text.requestFocus();
            valid = false;
        } else {
            label.setText("");
            valid = true;
        }
        return valid;
    }

    public static boolean findNumber(String str) {
        boolean number = false;
        int test = 0;
        for (int i = 0; i < str.length(); i++) {
            try {
                test = Integer.parseInt(str.substring(i, i + 1));
                number = true;
                break;
            } catch (Exception e) {
            }
            number = false;
        }
        return number;
    }

    //Se validan datos que solo pueden tener numeros
    public static boolean validateNumber(JTextField number, JLabel label) {
        boolean valid = true;
        boolean isText = findText(number.getText());
        boolean isNull = number.getText().equals("");
        if (isNull || isText) {
            if (isNull) {
                label.setText(NULL_DATA_ERROR);
            } else {
                label.setText(ONLY_NUMBERS_ERROR);
            }
            number.requestFocus();
            valid = false;
        } else {
            label.setText("");
            valid = true;
        }
        return valid;
    }

    public static boolean findText(String str) {
        boolean text = false;
        int test = 0;
        for (int i = 0; i < str.length(); i++) {
            try {
                test = Integer.parseInt(str.substring(i, i + 1));
                text = false;
                break;
            } catch (Exception e) {
            }
            text = true;
        }
        return text;
    }

    //Se valida email
    public static boolean validateEmail(JTextField email, JLabel label) {
        boolean valid = true;
        boolean isEmail = VALID_EMAIL_ADDRESS_REGEX.matcher(email.getText()).find();
        boolean isNull = email.getText().equals("");
        if (isNull || !isEmail) {
            if (isNull) {
                label.setText(NULL_DATA_ERROR);
            } else {
                label.setText(EMAIL_ERROR);
            }
            email.requestFocus();
            valid = false;
        } else {
            label.setText("");
            valid = true;
        }
        return valid;
    }

}
