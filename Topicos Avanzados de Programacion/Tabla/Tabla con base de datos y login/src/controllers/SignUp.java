/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static config.Config.*;
import java.awt.*;
import models.*;
import static security.Validate.*;

/**
 *
 * @author Luis G
 */
public class SignUp extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    private final UsersModel USERS_MODEL;

    public SignUp(Component component) {
        initComponents();
        frameConfig(this, component);
        this.setResizable(false);
        USERS_MODEL = new UsersModel();
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        userImg = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        signUp = new javax.swing.JButton();
        emailError = new javax.swing.JLabel();
        passwordError = new javax.swing.JLabel();
        userError = new javax.swing.JLabel();
        signIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign In");

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        userLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        userLabel.setText("Usuario");

        user.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userKeyReleased(evt);
            }
        });

        emailLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        emailLabel.setText("Correo");

        email.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailKeyReleased(evt);
            }
        });

        userImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userlogin.png"))); // NOI18N

        passwordLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        passwordLabel.setText("Contraseña");

        password.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordKeyReleased(evt);
            }
        });

        signUp.setBackground(new java.awt.Color(56, 126, 245));
        signUp.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        signUp.setForeground(new java.awt.Color(255, 255, 255));
        signUp.setText("Crear cuenta");
        signUp.setBorder(null);
        signUp.setBorderPainted(false);
        signUp.setContentAreaFilled(false);
        signUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUp.setFocusPainted(false);
        signUp.setOpaque(true);
        signUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                signUpMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                signUpMouseReleased(evt);
            }
        });
        signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpActionPerformed(evt);
            }
        });

        emailError.setForeground(new java.awt.Color(255, 0, 0));

        passwordError.setForeground(new java.awt.Color(255, 0, 0));

        userError.setForeground(new java.awt.Color(255, 0, 0));

        signIn.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        signIn.setForeground(new java.awt.Color(51, 102, 187));
        signIn.setText("Iniciar sesion");
        signIn.setBorder(null);
        signIn.setBorderPainted(false);
        signIn.setContentAreaFilled(false);
        signIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signIn.setFocusPainted(false);
        signIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(signUp, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(90, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(signIn)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwordLabel)
                                .addComponent(userImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(userLabel)
                                .addComponent(user)
                                .addComponent(emailLabel)
                                .addComponent(emailError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(email)
                                .addComponent(password)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(passwordError, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(userImg)
                .addGap(33, 33, 33)
                .addComponent(userLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userError, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailError, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordError, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signUp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signIn)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signUpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpMousePressed
        this.signUp.setBackground(DEFAULT_PRESSED);
    }//GEN-LAST:event_signUpMousePressed

    private void signUpMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpMouseReleased
        this.signUp.setBackground(DEFAULT);
    }//GEN-LAST:event_signUpMouseReleased

    private void signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpActionPerformed
        submit();
    }//GEN-LAST:event_signUpActionPerformed

    private void signInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInActionPerformed
        new LogIn(this).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signInActionPerformed

    private void userKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userKeyReleased
        if (evt.getKeyCode() == 10) {
            submit();
        }
    }//GEN-LAST:event_userKeyReleased

    private void emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyReleased
        if (evt.getKeyCode() == 10) {
            submit();
        }
    }//GEN-LAST:event_emailKeyReleased

    private void passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyReleased
        if (evt.getKeyCode() == 10) {
            submit();
        }
    }//GEN-LAST:event_passwordKeyReleased

    private boolean lgValidate() {
        boolean userValid, passwordValid, emailValid;
        if (user.getText().equals("")) {
            userError.setText(NULL_DATA_ERROR);
            userValid = false;
        } else {
            userError.setText("");
            userValid = true;
        }
        passwordValid = validatePassword(password, passwordError);
        emailValid = validateEmail(email, emailError);
        if (emailValid && passwordValid && userValid) {
            return true;
        } else {
            return false;
        }
    }

    private void submit() {
        if (lgValidate()) {
            int id = USERS_MODEL.insertUser(
                    user.getText(),
                    email.getText(),
                    getPassword(password)
            );
            if (id != -1) {
                userId = id;
                session = user.getText();
                correo = email.getText().toLowerCase();
                new TableList(this).setVisible(true);
                this.dispose();
            } else {
                emailError.setText(EMAIL_EXIST_ERROR);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public /*static*/ void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JLabel emailError;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordError;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton signIn;
    private javax.swing.JButton signUp;
    private javax.swing.JTextField user;
    private javax.swing.JLabel userError;
    private javax.swing.JLabel userImg;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
