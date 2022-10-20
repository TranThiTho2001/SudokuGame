
package view;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class MenuFrom extends javax.swing.JFrame {

    public MenuFrom() {
        initComponents();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(171,235,255));
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir")+"\\src\\image\\logo.png"));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnContinue = new javax.swing.JButton();
        btnNewGame = new javax.swing.JButton();
        btnTutorial = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SudokuGame");
        setBackground(new java.awt.Color(145, 219, 242));
        setIconImages(null);

        btnContinue.setBackground(new java.awt.Color(145, 219, 242));
        btnContinue.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnContinue.setForeground(new java.awt.Color(0, 0, 0));
        btnContinue.setText("Continue");
        btnContinue.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });

        btnNewGame.setBackground(new java.awt.Color(145, 219, 242));
        btnNewGame.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnNewGame.setForeground(new java.awt.Color(0, 0, 0));
        btnNewGame.setText("New Game");
        btnNewGame.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });

        btnTutorial.setBackground(new java.awt.Color(145, 219, 242));
        btnTutorial.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnTutorial.setForeground(new java.awt.Color(0, 0, 0));
        btnTutorial.setText("Tutorial");
        btnTutorial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        btnTutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutorialActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("VNI-Ariston", 0, 60)); // NOI18N
        jLabel2.setText(" Sudoku");

        btnExit.setBackground(new java.awt.Color(145, 219, 242));
        btnExit.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnExit.setForeground(new java.awt.Color(0, 0, 0));
        btnExit.setText("Exit");
        btnExit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTutorial, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnContinue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNewGame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnTutorial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        SudokuForm sudoku = new SudokuForm(0,false);
        sudoku.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnContinueActionPerformed

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        ChooseLevelForm levelForm = new ChooseLevelForm();
        levelForm.setVisible(true); 
        this.setVisible(false);
    }//GEN-LAST:event_btnNewGameActionPerformed

    private void btnTutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutorialActionPerformed
        JOptionPane.showMessageDialog(rootPane,
                        "               SOFTWARE MANUALS  :\n"
                        + "+ Click \"Continue\" to continue the previous game.\n"
                        + "+ Click \"New Game\" to create a new game.\n"  
                        + "+ Click \"Tutorial\" to view the software manual.\n"      
                        + "+ Click \"Exit\" to exit the game.\n"         
                        + "+ Click \"Easy\" to create new game in easy level.\n"
                        + "+ Click \"Medium\" to create a new game in medium level.\n"
                        + "+ Click \"Hard\" to create a new game in difficulty level.\n"
                        + "+ Click \"Menu\" to return to the Menu interface.\n"
                        + "+ Click \"Solve\" to see the Sudoku solution.\n"
                        + "+ Click \"Back\" to return to the previous interface.\n"
                        + "                 Click \"OK\" to return.\n" ,
                        "Sudoku", JOptionPane.INFORMATION_MESSAGE
                );
    }//GEN-LAST:event_btnTutorialActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(MenuFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFrom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinue;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnTutorial;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
