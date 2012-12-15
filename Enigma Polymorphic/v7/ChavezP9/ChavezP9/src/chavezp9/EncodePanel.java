/*EncodePanel.java
 * 
 * Javier Chavez
 * jchavez589@cnm.edu
 * 
 * Java I P9 Enigma
 */


package chavezp9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;


public class EncodePanel extends javax.swing.JPanel {
    private Enigma[] enigma;// = new Enigma[3];
    /** Creates new form EncodePanel */
//    public EncodePanel() {
//        initComponents();
//        enigma[0] = new PrimeShiftEnigma();
//        enigma[1] = new QwertyEnigma();
//        enigma[2] = new AlternateEnigma();
//  
//    }
    public EncodePanel(Enigma[] a) {
        initComponents();
        enigma = a;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enigbuttonGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        encodeResults = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageToEncode = new javax.swing.JTextArea();
        encodeBtn = new javax.swing.JButton();
        keyLabel = new javax.swing.JLabel();
        randomCheckBox = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        primeShiftBtn = new javax.swing.JRadioButton();
        qwertyBtn = new javax.swing.JRadioButton();
        alternateBtn = new javax.swing.JRadioButton();
        keySpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        encodeResults.setColumns(20);
        encodeResults.setRows(5);
        encodeResults.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        encodeResults.setFocusable(false);
        jScrollPane1.setViewportView(encodeResults);

        messageToEncode.setColumns(20);
        messageToEncode.setRows(5);
        jScrollPane2.setViewportView(messageToEncode);

        encodeBtn.setText("Encrypt");
        encodeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encodeBtnActionPerformed(evt);
            }
        });

        keyLabel.setText("Key");

        randomCheckBox.setText("Generate Random Key");
        randomCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomCheckBoxActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Secondary Encoding"));

        enigbuttonGroup.add(primeShiftBtn);
        primeShiftBtn.setSelected(true);
        primeShiftBtn.setText("Prime Shift");

        enigbuttonGroup.add(qwertyBtn);
        qwertyBtn.setText("Qwerty");

        enigbuttonGroup.add(alternateBtn);
        alternateBtn.setText("Alternate");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(primeShiftBtn)
                .addGap(83, 83, 83)
                .addComponent(qwertyBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(alternateBtn)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alternateBtn)
                    .addComponent(qwertyBtn)
                    .addComponent(primeShiftBtn))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        keySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        jLabel1.setText("Message to Encrypt");

        jLabel2.setText("Result");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(312, 312, 312)
                                .addComponent(encodeBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(keyLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(keySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(randomCheckBox))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keyLabel)
                    .addComponent(randomCheckBox)
                    .addComponent(keySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(encodeBtn)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

private void randomCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomCheckBoxActionPerformed

    if (randomCheckBox.isSelected()) {
        keyLabel.setVisible(false);
        keySpinner.setVisible(false);
    }
    else
    {
        keyLabel.setVisible(true);
        keySpinner.setVisible(true);        
    }

}//GEN-LAST:event_randomCheckBoxActionPerformed

private void encodeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encodeBtnActionPerformed

    int index = 0;
    if (primeShiftBtn.isSelected()) {
        index = 0;
    }
    else if (qwertyBtn.isSelected()) {
        index = 1;
    }
    else if (alternateBtn.isSelected()) {
        index = 2;
    }
    
    if (randomCheckBox.isSelected()) {
        enigma[index].setMessage(messageToEncode.getText());        
    }
    else{
    enigma[index].setMessage(messageToEncode.getText(), 
            Integer.parseInt(keySpinner.getValue().toString()));
    }
    
    String currPath = System.getProperty("user.dir");
    JFileChooser filechooser = new JFileChooser(currPath);


    int choice = filechooser.showSaveDialog(this);
    File file = null;
    if (choice == JFileChooser.APPROVE_OPTION) {
        file = filechooser.getSelectedFile();


        String out = enigma[index].getEncodedMessage() + "\r\n" + 
                enigma[index].getKey() + "\r\n" + 
                (1+index);

        try{          
            if (!file.exists()) {
                    file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(out);
            
            bw.close(); 
        }
        catch(IOException e){
         System.err.println("Error: " + e.getMessage());
        }        
    }
    
    String results ="";
    results = "Encoded Message:\n" + enigma[index].getEncodedMessage();
    results += "\n\nKey:\n" + enigma[index].getKey();
    results += "\n\nFile is written to path:\n" + filechooser.getName(file);
    
    encodeResults.setText(results); 
}//GEN-LAST:event_encodeBtnActionPerformed

public void clear()
{
    messageToEncode.setText("");
    primeShiftBtn.setSelected(true);
    keySpinner.getModel().setValue(1);
    randomCheckBox.setSelected(false);
    randomCheckBoxActionPerformed(null);
    encodeResults.setText("");
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton alternateBtn;
    private javax.swing.JButton encodeBtn;
    private javax.swing.JTextArea encodeResults;
    private javax.swing.ButtonGroup enigbuttonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel keyLabel;
    private javax.swing.JSpinner keySpinner;
    private javax.swing.JTextArea messageToEncode;
    private javax.swing.JRadioButton primeShiftBtn;
    private javax.swing.JRadioButton qwertyBtn;
    private javax.swing.JCheckBox randomCheckBox;
    // End of variables declaration//GEN-END:variables
}
