/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prateek
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Admin_login extends javax.swing.JFrame {

    /**
     * Creates new form Admin_login
     */
    static Connection con = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;
    public static String tbnm = null;
    public Admin_login() {
        initComponents();
    }
    
    public static void connection()
    {
        try {
            
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?user=root&password=");
            stmt = con.createStatement();
           
    }catch (ClassNotFoundException | SQLException e)
    {
         JOptionPane.showMessageDialog(null,e, "Error!", JOptionPane.ERROR_MESSAGE);

    }}
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        a_pass = new javax.swing.JPasswordField();
        a_login = new javax.swing.JTextField();
        log_label = new javax.swing.JLabel();
        b_home = new javax.swing.JButton();
        but_login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        a_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_passActionPerformed(evt);
            }
        });
        getContentPane().add(a_pass);
        a_pass.setBounds(300, 430, 200, 30);

        a_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_loginActionPerformed(evt);
            }
        });
        getContentPane().add(a_login);
        a_login.setBounds(300, 360, 200, 30);

        log_label.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAHE\\Desktop\\pj\\admin111.png")); // NOI18N
        log_label.setText("jLabel1");
        log_label.setMaximumSize(new java.awt.Dimension(700, 700));
        log_label.setMinimumSize(new java.awt.Dimension(700, 700));
        log_label.setPreferredSize(new java.awt.Dimension(700, 700));
        getContentPane().add(log_label);
        log_label.setBounds(0, 0, 700, 700);

        b_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/web.png"))); // NOI18N
        b_home.setBorder(null);
        b_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_homeActionPerformed(evt);
            }
        });
        getContentPane().add(b_home);
        b_home.setBounds(30, 50, 80, 70);

        but_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_loginActionPerformed(evt);
            }
        });
        getContentPane().add(but_login);
        but_login.setBounds(390, 490, 120, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void a_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_loginActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_a_loginActionPerformed

    private void b_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_homeActionPerformed
        // TODO add your handling code here:
         this.dispose();
        new Welcome1().setVisible(true);
        
    }//GEN-LAST:event_b_homeActionPerformed

    private void but_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_loginActionPerformed
        // TODO add your handling code here:
       String login= a_login.getText();
        char pass[]=a_pass.getPassword();
        String pss= new String(pass);
        connection();
        String query1 = "select Table_name, Password, Login_ID from details where Login_ID='"+login+"'and Password='"+pss+"'";
        try {
            rs=stmt.executeQuery(query1);
          if(rs.next())
            {
                 stmt = con.createStatement();
              
                 tbnm = rs.getString(1);
                this.setVisible(false);
                new Admin_window().setVisible(true);
            }
          else{
          this.dispose();
          new Admin_login().setVisible(true);
          }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_but_loginActionPerformed

    private void a_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a_passActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a_login;
    private javax.swing.JPasswordField a_pass;
    private javax.swing.JButton b_home;
    private javax.swing.JButton but_login;
    private javax.swing.JLabel log_label;
    // End of variables declaration//GEN-END:variables
}
