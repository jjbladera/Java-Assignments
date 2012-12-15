/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Frame.java
 *
 * Javier Chavez
 * jchavez589@cnm.edu
 * 
 * Java 1 P8
 */
package user;
import data.*;
import data.Website;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 * 
 * @author jchavez589
 */
public class Frame extends javax.swing.JFrame {

    private DbManager db = new DbManager();
    private Website selectedSite = new Website();
    private Website deleteSite = new Website();
    private Website updatedSite;

    /** Creates new form Frame */
    public Frame() throws SQLException {
        initComponents();
        insertPanel1.setDb(db);
        insertPanel1.setFrame(this);
        //listPanel1.setDb(db);
        updatePanel1.setDb(db);
        updatePanel1.setFrame(this);
        deletePanel1.setDb(db);
        deletePanel1.setFrame(this);
    }    

    private void update()
    {
        updatePanel1.setWebsite(selectedSite);
        deletePanel1.setWebsite(selectedSite);

    }

    public void setSelectedSite(Website selectedSite) {
        this.selectedSite = selectedSite;
        update();
    }

    void updatedSite() {
        //listPanel1.refreshSites();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        insertPanel1 = new user.InsertPanel();
        updatePanel1 = new user.UpdatePanel();
        deletePanel1 = new user.DeletePanel();
        listPanel1 = new user.ListPanel(this.db,this);
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        helpMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addTab("Add Website", insertPanel1);
        jTabbedPane1.addTab("Update Website", updatePanel1);
        jTabbedPane1.addTab("Delete Website", deletePanel1);

        fileMenu.setText("File");

        exitMenuItem.setText("Exit item");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuBar1.add(fileMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About items");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        helpMenuItem.setText("Help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(helpMenuItem);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(listPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
// TODO add your handling code here:
    System.exit(0);
}//GEN-LAST:event_exitMenuItemActionPerformed

private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
// TODO add your handling code here:
    JOptionPane.showMessageDialog(null, "These are some the best websites on the net!",
                    "About", JOptionPane.OK_OPTION);
}//GEN-LAST:event_aboutMenuItemActionPerformed

private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
// TODO add your handling code here:
    JOptionPane.showMessageDialog(null, "To Update:\r\nSelect website from list. choose update tab then save when finished"+
            "\r\nTo Delete:\r\nSelect website from list. Then verify the site and click delete"+
            "\r\nTo Add:\r\nChoose add website fill out the information and click save.",
                    "Help", JOptionPane.OK_OPTION);
}//GEN-LAST:event_helpMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private user.DeletePanel deletePanel1;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem helpMenuItem;
    private user.InsertPanel insertPanel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private user.ListPanel listPanel1;
    private user.UpdatePanel updatePanel1;
    // End of variables declaration//GEN-END:variables


}
