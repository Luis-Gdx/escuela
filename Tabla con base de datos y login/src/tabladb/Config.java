/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabladb;

import java.awt.Color;
import javax.swing.JPasswordField;

/**
 *
 * @author Luis G
 */
public class Config {

    //Sesión
    public static String session = "";
    //Id de usuario
    public static int userId;
    //Correo del usuario
    public static String correo = "";
    //Titulo de la tabla
    public static final String TITULO = "Lista de alumnos de 4ISC11 :v";
    //Id del grupo
    public static int groupId;
    //Configuración de la contraseña
    public static final int PASSWORD_LENGTH = 4;
    public static final String PASSWORD_LENGTH_ERROR = "La contraseña es muy corta (minimo " + PASSWORD_LENGTH + " caracteres)";

    public static String getPassword(JPasswordField password) {
        String pass = "";
        for (int i = 0; i < password.getPassword().length; i++) {
            pass += password.getPassword()[i];
        }
        return pass;
    }
    //Configuración de los mensajes de error
    public static final String NULL_DATA_ERROR = "Este campo no puede ir sin datos";
    public static final String ONLY_TEXT_ERROR = "Solo puede contener letras";
    public static final String ONLY_NUMBERS_ERROR = "Solo puede contener números";
    public static final String EMAIL_ERROR = "Introduzca un correo válido";
    //Configuración del color de los botones
    public static final Color DEFAULT = new Color(56, 126, 245);
    public static final Color DEFAULT_PRESSED = new Color(52, 116, 225);
    public static final Color SECONDARY = new Color(51, 205, 95);
    public static final Color SECONDARY_PRESSED = new Color(40, 165, 76);
    public static final Color DANGER = new Color(245, 61, 61);
    public static final Color DANGER_PRESSED = new Color(225, 56, 56);

}
