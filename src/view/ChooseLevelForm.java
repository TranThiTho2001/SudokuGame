package view;

import java.awt.Color;
import java.awt.Toolkit;

public class ChooseLevelForm extends javax.swing.JFrame {

    public ChooseLevelForm() {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(171, 235, 255));
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"\\src\\image\\logo.png"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEasy = new javax.swing.JButton();
        btnMedium = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnHard = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SudokuGame");

        btnEasy.setBackground(new java.awt.Color(171, 235, 255));
        btnEasy.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnEasy.setForeground(new java.awt.Color(0, 0, 0));
        btnEasy.setText("Easy");
        btnEasy.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        btnEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEasyActionPerformed(evt);
            }
        });

        btnMedium.setBackground(new java.awt.Color(171, 235, 255));
        btnMedium.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnMedium.setForeground(new java.awt.Color(0, 0, 0));
        btnMedium.setText("Medium");
        btnMedium.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        btnMedium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMediumActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(171, 235, 255));
        btnBack.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setText("Back");
        btnBack.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnHard.setBackground(new java.awt.Color(171, 235, 255));
        btnHard.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnHard.setForeground(new java.awt.Color(0, 0, 0));
        btnHard.setText("Hard");
        btnHard.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        btnHard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHardActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("VNI-Ariston", 0, 60)); // NOI18N
        jLabel2.setText(" Sudoku");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMedium, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHard, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnMedium, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnHard, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEasyActionPerformed
        SudokuForm jframe = new SudokuForm(1, true);
        jframe.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnEasyActionPerformed

    private void btnMediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMediumActionPerformed
        SudokuForm jframe = new SudokuForm(2, true);
        jframe.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMediumActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MenuFrom menu = new MenuFrom();
        this.setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnHardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHardActionPerformed
        SudokuForm jframe = new SudokuForm(3, true);
        jframe.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnHardActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEasy;
    private javax.swing.JButton btnHard;
    private javax.swing.JButton btnMedium;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
