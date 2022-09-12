/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Prashant Choudhary
 */
public class Insertbook extends javax.swing.JFrame {
     Connection con;
    
    Statement stmt;
    int noa=0;
    int e;
    String roll3;


    /**
     * Creates new form Insertbook
     */
    public Insertbook(int d,String roll2) {
        initComponents();
        connect c1=new connect();
        con=c1.connectDB();
        setSize(800,800);
        e =d;
        roll3 = roll2;
        serial();
        table();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("S.No");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 50, 70, 30);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(210, 50, 170, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Book Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 130, 90, 40);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(210, 130, 170, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Author Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 210, 90, 40);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(210, 210, 180, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Publisher");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 290, 80, 40);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(210, 290, 180, 40);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("No of Copies");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 370, 110, 50);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(200, 380, 190, 40);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(180, 480, 72, 26);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(360, 480, 72, 26);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Book Name", "Author", "Publisher", "NOC", "NOCA"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(400, 90, 280, 290);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new manage(1,roll3).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
        void serial()
        {
            int count=0;
                try
        {
           
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select* From book");
            
            while(rs.next())
         {
             count++;
         } 
            
        }
                catch(Exception e)
                {
                    
                }
                jTextField1.setText(""+(count+1));
                
        }
        
        void table()
        {
            try
        {
           
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select* From book");
        String str[]={"Book Name","Author","Publisher","NOC","NOCA"};
        Object ob[][] = new Object[100][5];
        int i = 0;
        while(rs.next())
        {
            for(int j = 0 ; j<5; j++)
            {
        ob[i][j]= rs.getString(j+1);
            }
            i++;
        
        jTable1.setModel(new DefaultTableModel(ob,str));
        }
        jScrollPane1.setViewportView(jTable1);
        
        }
         catch(Exception e)
         {
             
         }
        }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                
                        
                try
        {
            noa =0;
            noa = noa+ Integer.parseInt(jTextField5.getText());
           
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select* From book where book_name = '"+jTextField2.getText()+"'"); 
            
            
            if(rs.next())
            {
                noa = noa+Integer.parseInt(rs.getString(5));
                stmt.executeUpdate("Update book set noca ='"+noa+"' where book_name ='"+jTextField2.getText()+"' ");
                JOptionPane.showMessageDialog(null,"Record Updated.....");
            }
            else
            {
                        
            stmt.executeUpdate("insert into book values('"+jTextField2.getText()+"','"+jTextField3.getText()+"' ,'"+jTextField4.getText()+"','"+noa+"')");
            JOptionPane.showMessageDialog(null,"Record Saved.....");
            }
        }
            catch(Exception e)
                    {
                    
                    }
    
                
                

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Insertbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insertbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insertbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insertbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Insertbook(1,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
