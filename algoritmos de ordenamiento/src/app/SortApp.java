/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.swing.JOptionPane;
import lson.Lson;
import tree.Tree;

/**
 *
 * @author Luis G
 */
public class SortApp extends javax.swing.JFrame {

    /**
     * Creates new form SortApp
     */
    Lson lson = new Lson();
    Sort sort = new Sort();
    Tree tree = new Tree();
    int[] array;
    int[] arr;

    public SortApp() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shellSort = new javax.swing.JButton();
        naturalMergeSort = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        arraySize = new javax.swing.JTextField();
        maxValue = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        shellSort.setText("ShellSort");
        shellSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shellSortActionPerformed(evt);
            }
        });

        naturalMergeSort.setText("NaturalMergeSort");
        naturalMergeSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naturalMergeSortActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("Tamaño del arreglo");

        jLabel2.setText("Valor maximo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(arraySize, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(maxValue, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(shellSort)
                        .addGap(71, 71, 71)
                        .addComponent(naturalMergeSort)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shellSort)
                    .addComponent(naturalMergeSort))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arraySize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void shellSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shellSortActionPerformed
        generateArray();
        lson = sort.shell(arr);
        setText();
    }//GEN-LAST:event_shellSortActionPerformed

    private void naturalMergeSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naturalMergeSortActionPerformed
        generateArray();
        lson = sort.naturalMerge(arr);
        setText();
    }//GEN-LAST:event_naturalMergeSortActionPerformed

    private void generateArray() {
        if (arraySize.getText().equals("") && maxValue.getText().equals("")) {
            array = sort.createRandomArray(10, 10);
            arr = array.clone();
        } else if (maxValue.getText().equals("")) {
            try {
                array = sort.createrandomArray(Integer.parseInt(arraySize.getText()));
                arr = array.clone();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan numeros :'v", "Error", 0);
            }
        } else {
            try {
                array = sort.createRandomArray(Integer.parseInt(arraySize.getText()), Integer.parseInt(maxValue.getText()));
                arr = array.clone();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Solo se aceptan numeros :'v", "Error", 0);
            }
        }
    }

    private void setText() {
        jTextArea1.setText("  El arreglo desordenado es:\n\n  ");
        jTextArea1.append(sort.view(array) + "\n\n");
        jTextArea1.append("  El arreglo ordenado por el metodo de " + lson.getElementById(0) + " es:\n\n  ");
        jTextArea1.append(sort.view(lson.getArray()));
        tree();
    }

    private void tree() {
        tree.add(array);
        jTextArea1.append("\n\n  El arreglo ordenado por arbol en pre orden es:\n\n  ");
        jTextArea1.append(sort.view(tree.preOrder()));
        jTextArea1.append("\n\n  El arreglo ordenado por arbol en post orden es:\n\n  ");
        jTextArea1.append(sort.view(tree.postOrder()));
        jTextArea1.append("\n\n  El arreglo ordenado por arbol en in orden es:\n\n  ");
        jTextArea1.append(sort.view(tree.inOrder()));
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
            java.util.logging.Logger.getLogger(SortApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SortApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SortApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SortApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SortApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField arraySize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField maxValue;
    private javax.swing.JButton naturalMergeSort;
    private javax.swing.JButton shellSort;
    // End of variables declaration//GEN-END:variables
}
