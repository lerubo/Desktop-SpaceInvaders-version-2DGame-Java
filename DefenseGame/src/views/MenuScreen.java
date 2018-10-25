
package views;

import javax.swing.JFrame;
/**
 *  This class creates an Panel where it will allow 
 *  the user to choose a game level.
 * 
 * @author Leandro Ruiz Boyle
 */
public class MenuScreen extends javax.swing.JFrame {

    public MenuScreen() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        btn_five = new javax.swing.JButton();
        btn_one = new javax.swing.JButton();
        btn_two = new javax.swing.JButton();
        btn_three = new javax.swing.JButton();
        btn_four = new javax.swing.JButton();
        lbl_Background = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(730, 570));
        setMinimumSize(new java.awt.Dimension(730, 570));
        getContentPane().setLayout(null);

        jLabel6.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 48)); // NOI18N
        jLabel6.setText("Levels");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(550, 0, 160, 65);

        btn_five.setBackground(new java.awt.Color(255, 255, 0));
        btn_five.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/five.png"))); // NOI18N
        btn_five.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_fiveMouseClicked(evt);
            }
        });
        getContentPane().add(btn_five);
        btn_five.setBounds(600, 430, 100, 77);
        btn_five.getAccessibleContext().setAccessibleName("btn_five");

        btn_one.setBackground(new java.awt.Color(255, 255, 0));
        btn_one.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/one.png"))); // NOI18N
        btn_one.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_oneMouseClicked(evt);
            }
        });
        getContentPane().add(btn_one);
        btn_one.setBounds(600, 110, 100, 77);
        btn_one.getAccessibleContext().setAccessibleName("btn_one");

        btn_two.setBackground(new java.awt.Color(255, 255, 0));
        btn_two.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/two.png"))); // NOI18N
        btn_two.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_twoMouseClicked(evt);
            }
        });
        getContentPane().add(btn_two);
        btn_two.setBounds(600, 190, 100, 77);
        btn_two.getAccessibleContext().setAccessibleName("btn_Two");

        btn_three.setBackground(new java.awt.Color(255, 255, 0));
        btn_three.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/three.png"))); // NOI18N
        btn_three.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_threeMouseClicked(evt);
            }
        });
        getContentPane().add(btn_three);
        btn_three.setBounds(600, 270, 100, 77);
        btn_three.getAccessibleContext().setAccessibleName("btn_Three");

        btn_four.setBackground(new java.awt.Color(255, 255, 0));
        btn_four.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/four.png"))); // NOI18N
        btn_four.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_fourMouseClicked(evt);
            }
        });
        getContentPane().add(btn_four);
        btn_four.setBounds(600, 350, 100, 77);
        btn_four.getAccessibleContext().setAccessibleName("btn_four");

        lbl_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Menu.png"))); // NOI18N
        lbl_Background.setText("jLabel1");
        lbl_Background.setMaximumSize(new java.awt.Dimension(600, 700));
        lbl_Background.setMinimumSize(new java.awt.Dimension(600, 700));
        lbl_Background.setPreferredSize(new java.awt.Dimension(600, 700));
        getContentPane().add(lbl_Background);
        lbl_Background.setBounds(0, 0, 730, 700);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(250, 160, 34, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_oneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_oneMouseClicked
      openScreen(1);
    }//GEN-LAST:event_btn_oneMouseClicked

    private void btn_twoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_twoMouseClicked
        openScreen(2);
    }//GEN-LAST:event_btn_twoMouseClicked

    private void btn_threeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_threeMouseClicked
       openScreen(3);
    }//GEN-LAST:event_btn_threeMouseClicked

    private void btn_fourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fourMouseClicked
       openScreen(4);
    }//GEN-LAST:event_btn_fourMouseClicked

    private void btn_fiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fiveMouseClicked
        openScreen(5);
    }//GEN-LAST:event_btn_fiveMouseClicked

    /**
* This is a function that is creating a new game depending on the 
* level selected by the player.
* @param int number of the level the user wants to platy
*/
public void openScreen(int number){
    JFrame f = new JFrame();       
        f.add(new Screen(number)); 
        f.setSize(500, 800);
        f.setLocationRelativeTo(null); 
        f.setTitle("Love Game");           
        f.setVisible(true);       
}
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_five;
    private javax.swing.JButton btn_four;
    private javax.swing.JButton btn_one;
    private javax.swing.JButton btn_three;
    private javax.swing.JButton btn_two;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbl_Background;
    // End of variables declaration//GEN-END:variables
}
