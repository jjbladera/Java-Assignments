/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DeletePanel.java
 *
 * Javier Chavez
 * jchavez589@cnm.edu
 * 
 * Java 1 P8
 */
package user;

import data.DbManager;
import data.Website;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jchavez589
 */
public class DeletePanel extends javax.swing.JPanel {
    private DbManager db ;
    private Website website;
    private Frame frame;
    private int index;
    /** Creates new form DeletePanel */
    public DeletePanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        companyNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        companyAssetsField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        yrFoundedField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        companyUrlField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        alexaRankField = new javax.swing.JTextField();
        delButton = new javax.swing.JButton();

        jLabel1.setText("Company Name:");

        companyNameField.setEnabled(false);
        companyNameField.setMinimumSize(new java.awt.Dimension(65, 20));
        companyNameField.setPreferredSize(new java.awt.Dimension(65, 20));

        jLabel3.setText("Company Assets:");

        companyAssetsField.setEnabled(false);
        companyAssetsField.setMinimumSize(new java.awt.Dimension(65, 20));
        companyAssetsField.setPreferredSize(new java.awt.Dimension(65, 20));

        jLabel6.setText("Billion");

        yrFoundedField.setEnabled(false);
        yrFoundedField.setMinimumSize(new java.awt.Dimension(65, 20));
        yrFoundedField.setPreferredSize(new java.awt.Dimension(65, 20));

        jLabel2.setText("Founded:");

        jLabel4.setText("URL:");

        companyUrlField.setEnabled(false);
        companyUrlField.setMinimumSize(new java.awt.Dimension(65, 20));
        companyUrlField.setPreferredSize(new java.awt.Dimension(65, 20));

        jLabel5.setText("Alexa Rank:");

        alexaRankField.setEnabled(false);
        alexaRankField.setMinimumSize(new java.awt.Dimension(65, 20));
        alexaRankField.setPreferredSize(new java.awt.Dimension(65, 20));

        delButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delButton.setForeground(new java.awt.Color(255, 51, 51));
        delButton.setText("Delete Website");
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(delButton)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(alexaRankField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(companyAssetsField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6)
                                    .addContainerGap())
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(yrFoundedField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                        .addComponent(companyNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                                    .addGap(198, 198, 198))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(companyUrlField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap()))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(companyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(companyAssetsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(yrFoundedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(companyUrlField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(alexaRankField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(delButton)
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
    
    int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the record for " + website.getCompName() +"?",
                    "Confirm Delete", JOptionPane.YES_NO_OPTION);
    if(result == 0){
        try {
            // TODO add your handling code here:
                db.delete(website);
                frame.updatedSite();
        } catch (SQLException ex) {
            Logger.getLogger(DeletePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    else{
            JOptionPane.showMessageDialog(null,
                    "You must make a selection to delete.",
                    "No Selection", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_delButtonActionPerformed


    public void setWebsite(Website website) {
        this.website = website;
        updateFields();
    }

    public void setDb(DbManager db) {
        this.db = db;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }    
    private void updateFields()
    {
        companyNameField.setText(website.getCompName());
        yrFoundedField.setText(website.getFounded());
        companyAssetsField.setText(Double.toString(website.getAssets()));
        companyUrlField.setText(website.getUrl());
        alexaRankField.setText(Integer.toString(website.getAlexaRank()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alexaRankField;
    private javax.swing.JTextField companyAssetsField;
    private javax.swing.JTextField companyNameField;
    private javax.swing.JTextField companyUrlField;
    private javax.swing.JButton delButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField yrFoundedField;
    // End of variables declaration//GEN-END:variables


}
