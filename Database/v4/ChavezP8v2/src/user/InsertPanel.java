/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InsertPanel.java
 *
 * Created on Nov 15, 2012, 9:45:11 AM
 */
package user;

import data.DbManager;
import data.Website;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jchavez589
 */
public class InsertPanel extends javax.swing.JPanel {

    private DbManager db ;
    private Frame frame;
   
    /** Creates new form InsertPanel */
    public InsertPanel() {
        initComponents();
    }


    public void setDb(DbManager db) {
        this.db = db;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        insertBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        companyNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        companyAssetsField = new javax.swing.JTextField();
        assetLabel6 = new javax.swing.JLabel();
        yrFoundedField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        companyUrlField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        alexaRankField = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        insertBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertBtn.setText("Add Website");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Company Name:");

        companyNameField.setMinimumSize(new java.awt.Dimension(65, 20));
        companyNameField.setPreferredSize(new java.awt.Dimension(65, 20));

        jLabel3.setText("Company Assets:");

        companyAssetsField.setMinimumSize(new java.awt.Dimension(65, 20));
        companyAssetsField.setPreferredSize(new java.awt.Dimension(65, 20));

        assetLabel6.setText("Billion");

        yrFoundedField.setToolTipText("MM/DD/YYYY");
        yrFoundedField.setMinimumSize(new java.awt.Dimension(65, 20));
        yrFoundedField.setPreferredSize(new java.awt.Dimension(65, 20));

        jLabel2.setText("Founded:");

        jLabel4.setText("URL:");

        companyUrlField.setMinimumSize(new java.awt.Dimension(65, 20));
        companyUrlField.setPreferredSize(new java.awt.Dimension(65, 20));

        jLabel5.setText("Alexa Rank:");

        alexaRankField.setMinimumSize(new java.awt.Dimension(65, 20));
        alexaRankField.setPreferredSize(new java.awt.Dimension(65, 20));

        jCheckBox1.setText("Not Public");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel7.setText("MM/DD/YYYY");

        jLabel8.setText("http://google.com");

        jLabel9.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(companyAssetsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(assetLabel6))
                            .addComponent(yrFoundedField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jCheckBox1))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(companyUrlField, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8))
                    .addComponent(companyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alexaRankField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addGap(72, 72, 72))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addComponent(insertBtn)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(companyNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(companyAssetsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(assetLabel6)
                    .addComponent(jCheckBox1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(yrFoundedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(companyUrlField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(alexaRankField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(54, 54, 54)
                .addComponent(insertBtn)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
    Website newWebsite = new Website();
    newWebsite.setCompName(companyNameField.getText());
    newWebsite.setFounded(yrFoundedField.getText());
    if (jCheckBox1.isSelected()) {
        newWebsite.setAssets(0.0);
    }
    else{
        newWebsite.setAssets(Double.parseDouble(companyAssetsField.getText()));
    }
    newWebsite.setUrl(companyUrlField.getText());
    newWebsite.setAlexaRank(Integer.parseInt(alexaRankField.getText()));
        try {
            db.insert(newWebsite);
            frame.updatedSite();
        } catch (SQLException ex) {
            Logger.getLogger(InsertPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_insertBtnActionPerformed

private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
// TODO add your handling code here:
    if (jCheckBox1.isSelected()) {
        assetLabel6.setVisible(false);
        companyAssetsField.setVisible(false);       
    }
    else{
        assetLabel6.setVisible(false);
        companyAssetsField.setVisible(false);    
    }

}//GEN-LAST:event_jCheckBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alexaRankField;
    private javax.swing.JLabel assetLabel6;
    private javax.swing.JTextField companyAssetsField;
    private javax.swing.JTextField companyNameField;
    private javax.swing.JTextField companyUrlField;
    private javax.swing.JButton insertBtn;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField yrFoundedField;
    // End of variables declaration//GEN-END:variables


}
