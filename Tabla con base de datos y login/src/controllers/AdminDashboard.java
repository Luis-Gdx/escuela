/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static config.Config.*;
import config.OfflineWindowListener;
import config.User;
import config.UserCellRenderer;
import fontawesome.FontAwesome;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import models.GroupsModel;
import models.NotificacionesModel;
import models.PermisosModel;
import models.UsersModel;
import realtime.Online;

/**
 *
 * @author Luis G
 */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboard
     */
    // default text xd String input = (String)JOptionPane.showInputDialog(null, "Please enter new quantity", "Please enter new quantity", JOptionPane.QUESTION_MESSAGE,null,null,"default text");
    private final UsersModel USERS_MODEL;
    private final NotificacionesModel NOTIFICACIONES_MODEL;
    private final PermisosModel PERMISOS_MODEL;
    private final GroupsModel GROUPS_MODEL = new GroupsModel();
    public static final DefaultListModel<User> LIST_MODEL = new DefaultListModel();
    private int tableId;
    private ResultSet users;
    private boolean adminFlag, createFlag, readFlag, updateFlag, deleteFlag;
    private FontAwesome fa = new FontAwesome();
    public static UserCellRenderer userCellRender;
    private Online online;

    public AdminDashboard(int id, String grupo) {
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new OfflineWindowListener());
        this.group.setText(grupo);
        fa.setIcon(regresar, "\uf060");
        //fa.setIcon(regresar, "\uf0a8");
        //fa.setIcon(regresar, "\uf177");
        //fa.setIcon(regresar, "\uf190");
        USERS_MODEL = new UsersModel();
        NOTIFICACIONES_MODEL = new NotificacionesModel();
        PERMISOS_MODEL = new PermisosModel();
        //userCellRender = new UserCellRenderer();
        online = new Online();
        //userList.setCellRenderer(userCellRender);
        online.thread.start();
        card.setVisible(false);
        tableId = id;
        getUsers();
    }

    public AdminDashboard() {
        initComponents();
        USERS_MODEL = new UsersModel();
        NOTIFICACIONES_MODEL = new NotificacionesModel();
        PERMISOS_MODEL = new PermisosModel();
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
        group = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();
        card = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        userName = new javax.swing.JLabel();
        userEmail = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        typeOfUser = new javax.swing.JLabel();
        numeroAlumnos2 = new javax.swing.JLabel();
        c = new javax.swing.JLabel();
        r = new javax.swing.JLabel();
        u = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        signIn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        regresar = new javax.swing.JButton();
        regresar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        agregar.setBackground(new java.awt.Color(50, 219, 100));
        agregar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        agregar.setForeground(new java.awt.Color(255, 255, 255));
        agregar.setText("Agregar usuario");
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

        group.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        group.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        group.setText("Nombre del grupo");
        group.setToolTipText("");

        jScrollPane2.setName("ytutyu"); // NOI18N

        userList.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        userList.setName(""); // NOI18N
        userList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userListMouseClicked(evt);
            }
        });
        userList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userListKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(userList);

        card.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardMouseClicked(evt);
            }
        });

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));

        userName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        userName.setText("Nombre del usuario");

        userEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        userEmail.setText("Correo del usuario");

        guardar.setBackground(new java.awt.Color(56, 126, 245));
        guardar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        guardar.setForeground(new java.awt.Color(255, 255, 255));
        guardar.setText("Guardar");
        guardar.setBorder(null);
        guardar.setBorderPainted(false);
        guardar.setContentAreaFilled(false);
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar.setFocusPainted(false);
        guardar.setOpaque(true);
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                guardarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                guardarMouseReleased(evt);
            }
        });
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
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

        typeOfUser.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        typeOfUser.setText("Tipo de usuario");

        numeroAlumnos2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        numeroAlumnos2.setText("Tipo de permiso");

        c.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        c.setForeground(new java.awt.Color(56, 126, 245));
        c.setText("C");
        c.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cMouseClicked(evt);
            }
        });

        r.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        r.setForeground(new java.awt.Color(255, 153, 0));
        r.setText("R");
        r.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        r.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rMouseClicked(evt);
            }
        });

        u.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        u.setForeground(new java.awt.Color(50, 219, 100));
        u.setText("U");
        u.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        u.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uMouseClicked(evt);
            }
        });

        d.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        d.setForeground(new java.awt.Color(245, 61, 61));
        d.setText("D");
        d.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dMouseClicked(evt);
            }
        });

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estandar", "Admin" }));

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGap(0, 128, Short.MAX_VALUE)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userName)
                            .addComponent(userEmail)
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addComponent(typeOfUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addComponent(numeroAlumnos2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(r)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(u)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeOfUser)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroAlumnos2)
                    .addComponent(c)
                    .addComponent(r)
                    .addComponent(u)
                    .addComponent(d))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        regresar.setBackground(new java.awt.Color(56, 126, 245));
        regresar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        regresar.setForeground(new java.awt.Color(255, 255, 255));
        regresar.setText("\\uf0c9");
        regresar.setBorder(null);
        regresar.setBorderPainted(false);
        regresar.setContentAreaFilled(false);
        regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regresar.setFocusPainted(false);
        regresar.setOpaque(true);
        regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                regresarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                regresarMouseReleased(evt);
            }
        });
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        regresar1.setBackground(new java.awt.Color(56, 126, 245));
        regresar1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        regresar1.setForeground(new java.awt.Color(255, 255, 255));
        regresar1.setText("Cambiar nombre");
        regresar1.setBorder(null);
        regresar1.setBorderPainted(false);
        regresar1.setContentAreaFilled(false);
        regresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regresar1.setFocusPainted(false);
        regresar1.setOpaque(true);
        regresar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                regresar1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                regresar1MouseReleased(evt);
            }
        });
        regresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(card, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(regresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(signIn, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(group, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(group, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regresar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(card, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
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
        String destinatario = JOptionPane.showInputDialog(null, "Ingrese el correo del usuario a agregar", "Agregar usuario", 3);
        if (destinatario != null) {
            if (!destinatario.equals("")) {
                if (!destinatario.equals(correo)) {
                    if (!isOnList(destinatario)) {
                        try {
                            if (USERS_MODEL.getUserByEmail(destinatario).next()) {
                                String mensaje = (String) JOptionPane.showInputDialog(null, "Introduce un mensaje", "Mensaje", JOptionPane.QUESTION_MESSAGE, null, null, "Quiero que te unas a mi tabla plox xd");
                                if (mensaje != null) {
                                    if (!mensaje.equals("")) {
                                        NOTIFICACIONES_MODEL.sendNotification(mensaje, correo, destinatario, userId, tableId);
                                        getUsers();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No puedes dejar vacio este campo", "Error", 0);
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El correo no existe", "Error", 0);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El correo escrito ya esta en la lista o ya se le mando una solisitud", "Error", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No puedes mandarte una solisitud a ti mismo :p", "Error", 0);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No puedes dejar vacio este campo", "Error", 0);
            }
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void userListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userListMouseClicked
        getSelectedItemData();
    }//GEN-LAST:event_userListMouseClicked

    private void userListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userListKeyReleased
        getSelectedItemData();
    }//GEN-LAST:event_userListKeyReleased

    private void guardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMousePressed
        if (userList.getSelectedValue().getPermisoId() != -1) {
            guardar.setBackground(DEFAULT_PRESSED);
        }
    }//GEN-LAST:event_guardarMousePressed

    private void guardarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseReleased
        try {
            if (userList.getSelectedValue().getPermisoId() != -1) {
                guardar.setBackground(DEFAULT);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_guardarMouseReleased

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        adminFlag = type.getSelectedIndex() == 1;
        PERMISOS_MODEL.updatePermisos(adminFlag, createFlag, readFlag, updateFlag, deleteFlag, userList.getSelectedValue().getPermisoId());
        card.setVisible(false);
        getUsers();
    }//GEN-LAST:event_guardarActionPerformed

    private void eliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMousePressed
        this.eliminar.setBackground(DANGER_PRESSED);
    }//GEN-LAST:event_eliminarMousePressed

    private void eliminarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseReleased
        this.eliminar.setBackground(DANGER);
    }//GEN-LAST:event_eliminarMouseReleased

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Seguro que quiere eliminar a este miembro?", "Eliminar usuario", 1) == 0) {
            if (userList.getSelectedValue().getPermisoId() != -1) {
                PERMISOS_MODEL.deletePermisoById(userList.getSelectedValue().getPermisoId());
                card.setVisible(false);
                this.getUsers();
            } else {
                NOTIFICACIONES_MODEL.deleteNotification(userList.getSelectedValue().getNotificationId());
                card.setVisible(false);
                this.getUsers();
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void signInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInActionPerformed
        USERS_MODEL.updateOnline(false, userId);
        new LogIn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signInActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        card.setVisible(false);
    }//GEN-LAST:event_jPanel1MouseClicked

    private void cardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cardMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cardMouseClicked

    private void cMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cMouseClicked
        createFlag = crudClick(createFlag, c, DEFAULT);
    }//GEN-LAST:event_cMouseClicked

    private void rMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rMouseClicked
        readFlag = crudClick(readFlag, r, ALERT);
    }//GEN-LAST:event_rMouseClicked

    private void uMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uMouseClicked
        updateFlag = crudClick(updateFlag, u, SECONDARY);
    }//GEN-LAST:event_uMouseClicked

    private void dMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dMouseClicked
        deleteFlag = crudClick(deleteFlag, d, DANGER);
    }//GEN-LAST:event_dMouseClicked

    private void regresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarMousePressed
        regresar.setBackground(DEFAULT_PRESSED);
    }//GEN-LAST:event_regresarMousePressed

    private void regresarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarMouseReleased
        regresar.setBackground(DEFAULT);
    }//GEN-LAST:event_regresarMouseReleased

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        new TableList().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void regresar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresar1MousePressed
        regresar.setBackground(DEFAULT_PRESSED);
    }//GEN-LAST:event_regresar1MousePressed

    private void regresar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresar1MouseReleased
        regresar.setBackground(DEFAULT);
    }//GEN-LAST:event_regresar1MouseReleased

    private void regresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresar1ActionPerformed
        String nombre = JOptionPane.showInputDialog(null, "Ingresa un nombre para el grupo", "Cambiar nombre", 3);
        if (nombre != null) {
            if (!nombre.equals("")) {
                GROUPS_MODEL.updateGroupName(nombre, groupId);
                group.setText(nombre);
            } else {
                JOptionPane.showMessageDialog(null, "No puedes dejar el nombre en blanco", "Error", 0);
            }
        }
    }//GEN-LAST:event_regresar1ActionPerformed

    private void getUsers() {
        LIST_MODEL.setSize(0);
        users = USERS_MODEL.getUserByTable(tableId, userId);
        ResultSet pendingUsers = USERS_MODEL.getPendingUsers(tableId);
        try {
            while (pendingUsers.next()) {
                User user = new User(pendingUsers.getInt("id"), pendingUsers.getString("user"), -1);
                user.setEmail(pendingUsers.getString("email"));
                user.setNotificationId(pendingUsers.getInt("notificacion_id"));
                LIST_MODEL.addElement(user);
            }
            while (users.next()) {
                User user = new User(users.getInt("id"), users.getString("user"), users.getInt("permisoId"));
                user.setEmail(users.getString("email"));
                user.setAdmin(users.getBoolean("admin"));
                user.setC(users.getBoolean("create"));
                user.setR(users.getBoolean("read"));
                user.setU(users.getBoolean("update"));
                user.setD(users.getBoolean("delete"));
                user.setOnline(users.getBoolean("online"));
                LIST_MODEL.addElement(user);
            }
            userList.setModel(LIST_MODEL);
        } catch (SQLException ex) {
            Logger.getLogger(TableList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getSelectedItemData() {
        if (userList.getSelectedValue().getPermisoId() == -1) {
            guardar.setEnabled(false);
            guardar.setBackground(Color.GRAY);
            guardar.setSelected(false);
            type.setEnabled(false);
            c.setCursor(java.awt.Cursor.getDefaultCursor());
            r.setCursor(java.awt.Cursor.getDefaultCursor());
            u.setCursor(java.awt.Cursor.getDefaultCursor());
            d.setCursor(java.awt.Cursor.getDefaultCursor());
        } else {
            guardar.setBackground(DEFAULT);
            guardar.setEnabled(true);
            type.setEnabled(true);
            c.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
            r.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
            u.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
            d.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        }
        String usuario = userList.getSelectedValue().getNombre();
        userName.setText("Nombre del usuario: " + usuario);
        userEmail.setText("Correo del usuario: " + userList.getSelectedValue().getEmail());
        adminFlag = userList.getSelectedValue().isAdmin();
        createFlag = userList.getSelectedValue().isC();
        readFlag = userList.getSelectedValue().isR();
        updateFlag = userList.getSelectedValue().isU();
        deleteFlag = userList.getSelectedValue().isD();
        type.setSelectedIndex(adminFlag ? 1 : 0);
        if (createFlag) {
            c.setForeground(DEFAULT);
        } else {
            c.setForeground(Color.GRAY);
        }
        if (readFlag) {
            r.setForeground(ALERT);
        } else {
            r.setForeground(Color.GRAY);
        }
        if (updateFlag) {
            u.setForeground(SECONDARY);
        } else {
            u.setForeground(Color.GRAY);
        }
        if (deleteFlag) {
            d.setForeground(DANGER);
        } else {
            d.setForeground(Color.GRAY);
        }
        card.setVisible(true);
    }

    private boolean isOnList(String email) {
        for (int i = 0; i < LIST_MODEL.getSize(); i++) {
            if (LIST_MODEL.getElementAt(i).getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private boolean crudClick(boolean flag, JLabel label, Color color) {
        if (userList.getSelectedValue().getPermisoId() != -1) {
            if (flag) {
                label.setForeground(Color.gray);
            } else {
                label.setForeground(color);
            }
        }
        return !flag;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JLabel c;
    private javax.swing.JPanel card;
    private javax.swing.JLabel d;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel group;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel numeroAlumnos2;
    private javax.swing.JLabel r;
    private javax.swing.JButton regresar;
    private javax.swing.JButton regresar1;
    private javax.swing.JButton signIn;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JLabel typeOfUser;
    private javax.swing.JLabel u;
    private javax.swing.JLabel userEmail;
    public static javax.swing.JList<User> userList;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
}
