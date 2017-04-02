/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import config.GrupoCellRenderer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import models.AlumnosModel;
import models.GroupsModel;
import models.UsersModel;
import static config.Config.*;

/**
 *
 * @author lg269
 */
public class TableList extends javax.swing.JFrame {

    /**
     * Creates new form TableList
     */
    private final ResultSet DATA;
    private ResultSet grupos;
    private final GroupsModel GROUPS_MODEL;
    private final UsersModel USERS_MODEL;
    private final AlumnosModel ALUMNOS_MODEL;
    private final DefaultListModel<Grupo> LIST_MODEL = new DefaultListModel();

    public TableList() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.pack();
        this.card.setVisible(false);
        GROUPS_MODEL = new GroupsModel();
        USERS_MODEL = new UsersModel();
        ALUMNOS_MODEL = new AlumnosModel();
        DATA = USERS_MODEL.getUserId(correo);
        user.setText(session);
        groupList.setCellRenderer(new GrupoCellRenderer());
        getGroups();
    }

    private void getGroups() {
        LIST_MODEL.setSize(0);
        grupos = GROUPS_MODEL.getGroups(userId);
        try {
            while (grupos.next()) {
                LIST_MODEL.addElement(new Grupo(grupos.getInt("id"), grupos.getString("nombre")));
            }
            groupList.setModel(LIST_MODEL);
        } catch (SQLException ex) {
            Logger.getLogger(TableList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        agregar = new javax.swing.JButton();
        user = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        groupList = new javax.swing.JList<>();
        card = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        groupName = new javax.swing.JLabel();
        numeroAlumnos = new javax.swing.JLabel();
        entrar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        signIn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        agregar.setBackground(new java.awt.Color(50, 219, 100));
        agregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        agregar.setForeground(new java.awt.Color(255, 255, 255));
        agregar.setText("Agregar tabla");
        agregar.setBorder(null);
        agregar.setBorderPainted(false);
        agregar.setContentAreaFilled(false);
        agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregar.setFocusPainted(false);
        agregar.setOpaque(true);
        agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                agregarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                agregarMouseReleased(evt);
            }
        });
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        user.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user.setText("Usuario :v");

        groupList.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        groupList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groupListMouseClicked(evt);
            }
        });
        groupList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                groupListKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(groupList);

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));

        groupName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        groupName.setText("Nombre del grupo");

        numeroAlumnos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        numeroAlumnos.setText("Número de alumnos");

        entrar.setBackground(new java.awt.Color(56, 126, 245));
        entrar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        entrar.setForeground(new java.awt.Color(255, 255, 255));
        entrar.setText("Entrar");
        entrar.setBorder(null);
        entrar.setBorderPainted(false);
        entrar.setContentAreaFilled(false);
        entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        entrar.setFocusPainted(false);
        entrar.setOpaque(true);
        entrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                entrarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                entrarMouseReleased(evt);
            }
        });
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });

        eliminar.setBackground(new java.awt.Color(245, 61, 61));
        eliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        eliminar.setForeground(new java.awt.Color(255, 255, 255));
        eliminar.setText("Eliminar");
        eliminar.setBorder(null);
        eliminar.setBorderPainted(false);
        eliminar.setContentAreaFilled(false);
        eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminar.setFocusPainted(false);
        eliminar.setOpaque(true);
        eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eliminarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                eliminarMouseReleased(evt);
            }
        });
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        editar.setBackground(new java.awt.Color(50, 219, 100));
        editar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        editar.setForeground(new java.awt.Color(255, 255, 255));
        editar.setText("Editar");
        editar.setBorder(null);
        editar.setBorderPainted(false);
        editar.setContentAreaFilled(false);
        editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editar.setFocusPainted(false);
        editar.setOpaque(true);
        editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editarMouseReleased(evt);
            }
        });
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGap(0, 47, Short.MAX_VALUE)
                        .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(groupName)
                            .addComponent(numeroAlumnos))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(groupName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numeroAlumnos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout cardLayout = new javax.swing.GroupLayout(card);
        card.setLayout(cardLayout);
        cardLayout.setHorizontalGroup(
            cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        cardLayout.setVerticalGroup(
            cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        signIn.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        signIn.setForeground(new java.awt.Color(51, 102, 187));
        signIn.setText("Cerrar sesión");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(card, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(signIn, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(card, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(signIn))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMousePressed
        agregar.setBackground(SECONDARY_PRESSED);
    }//GEN-LAST:event_agregarMousePressed

    private void agregarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseReleased
        agregar.setBackground(SECONDARY);
    }//GEN-LAST:event_agregarMouseReleased

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        String tableName = JOptionPane.showInputDialog(null, "Ingresa el nombre de la tabla", "Crear tabla", 3);
        if (tableName != null) {
            if (!tableName.equals("")) {
                GROUPS_MODEL.insertGroup(tableName, userId);
                getGroups();
                groupList.setSelectedIndex(LIST_MODEL.getSize() - 1);
                getSelectedItemData();
            } else {
                JOptionPane.showMessageDialog(null, "No puedes dejar vacio este campo", "Error", 0);
            }
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void groupListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupListMouseClicked
        getSelectedItemData();
    }//GEN-LAST:event_groupListMouseClicked

    private void entrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrarMousePressed
        entrar.setBackground(DEFAULT_PRESSED);
    }//GEN-LAST:event_entrarMousePressed

    private void entrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrarMouseReleased
        entrar.setBackground(DEFAULT);
    }//GEN-LAST:event_entrarMouseReleased

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        new Alumnos(groupList.getSelectedValue().getId(), groupList.getSelectedValue().getNombre()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_entrarActionPerformed

    private void eliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMousePressed
        this.eliminar.setBackground(DANGER_PRESSED);
    }//GEN-LAST:event_eliminarMousePressed

    private void eliminarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseReleased
        this.eliminar.setBackground(DANGER);
    }//GEN-LAST:event_eliminarMouseReleased

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Seguro que quiere eliminar esta tabla?", "Eliminar tabla", 1) == 0) {
            ALUMNOS_MODEL.deleteAllById(groupList.getSelectedValue().getId());
            GROUPS_MODEL.deleteGroupById(groupList.getSelectedValue().getId());
            card.setVisible(false);
            getGroups();
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        card.setVisible(false);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void groupListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_groupListKeyReleased
        getSelectedItemData();
    }//GEN-LAST:event_groupListKeyReleased

    private void signInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInActionPerformed
        new LogIn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signInActionPerformed

    private void editarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMousePressed
        editar.setBackground(SECONDARY_PRESSED);
    }//GEN-LAST:event_editarMousePressed

    private void editarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editarMouseReleased
        editar.setBackground(SECONDARY);
    }//GEN-LAST:event_editarMouseReleased

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        String tableName = (String) JOptionPane.showInputDialog(null, "Ingresa el nombre de la tabla",
                "Cambiar nombre", JOptionPane.QUESTION_MESSAGE, null, null, groupList.getSelectedValue().getNombre());
        if (tableName != null) {
            if (!tableName.equals("")) {
                GROUPS_MODEL.updateGroupName(tableName, groupList.getSelectedValue().getId());
                getGroups();
                groupList.setSelectedIndex(LIST_MODEL.getSize() - 1);
                getSelectedItemData();
            } else {
                JOptionPane.showMessageDialog(null, "No puedes dejar vacio este campo", "Error", 0);
            }
        }
    }//GEN-LAST:event_editarActionPerformed

    private void getSelectedItemData() {
        boolean isNull = true;
        try {
            ResultSet groupInfo = GROUPS_MODEL.getGroupInfo(groupList.getSelectedValue().getId());
            while (groupInfo.next()) {
                groupName.setText("Nombre del grupo: " + groupInfo.getString("nombre"));
                numeroAlumnos.setText("Número de alumnos: " + groupInfo.getInt("count") + "");
                isNull = false;
            }
            if (isNull) {
                groupName.setText("Nombre del grupo: " + groupList.getSelectedValue().getNombre());
                numeroAlumnos.setText("Número de alumnos: 0");
            }
            card.setVisible(true);
        } catch (Throwable ex) {
            Logger.getLogger(TableList.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(TableList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JPanel card;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton entrar;
    private javax.swing.JList<Grupo> groupList;
    private javax.swing.JLabel groupName;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel numeroAlumnos;
    private javax.swing.JButton signIn;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}