
/*
 * DecodePanel.java
 * Javier Chavez
 * jchavez589@cnm.edu
 * 
 * Java I P9 Enigmaeated on Nov 29, 2012, 5:27:16 PM
 */
package chavezp9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;


public class DecodePanel extends javax.swing.JPanel {
    private Enigma[] enigma;// = new Enigma[3];


//    public DecodePanel() {
//        initComponents();
//        enigma[0] = new PrimeShiftEnigma();
//        enigma[1] = new QwertyEnigma();
//        enigma[2] = new AlternateEnigma();
//    }
    public DecodePanel(Enigma[] a) {
        initComponents();
        enigma = a;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        decodeResults = new javax.swing.JTextArea();
        decodeBtn = new javax.swing.JButton();

        decodeResults.setColumns(20);
        decodeResults.setEditable(false);
        decodeResults.setRows(5);
        jScrollPane1.setViewportView(decodeResults);

        decodeBtn.setText("Open File and Decode");
        decodeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decodeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(decodeBtn)
                        .addGap(122, 122, 122))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(decodeBtn)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void decodeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decodeBtnActionPerformed
// TODO add your handling code here:
        String currPath = System.getProperty("user.dir");
        String results = "";

        JFileChooser filechooser = new JFileChooser(currPath);

        int index = 0;
        String tmpMsg = "";
        int tmpKey = 1;
        File file = null;
        int choice = filechooser.showOpenDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
             file = filechooser.getSelectedFile();
            try
            {
                Scanner input = new Scanner(file);
                tmpMsg = input.nextLine();
                tmpKey = Integer.parseInt(input.nextLine());
                index = Integer.parseInt(input.nextLine())-1;
                
                input.close();

            }catch(FileNotFoundException e){
                System.out.println("Error: " + e.getMessage());
            }
            enigma[index].setEncodedMessage(tmpMsg, tmpKey);
        
            results += "Decoded Message:\n"+enigma[index].getMessage();
            results += "\n\nKey:\n" + Integer.toString(enigma[index].getKey());

            results += "\n\nEncryption Type:\n" + keyName(index);

        }
        else
        {
            results = "Open file was cancelled.";
        }

        decodeResults.setText(results);
        
}//GEN-LAST:event_decodeBtnActionPerformed

private String keyName (int i)
{
    String n = null;
    
    if (i == 0)  n = "Prime Shift";
    else if(i == 1) n = "Qwerty"; 
    else if(i == 2) n = "Alternate"; 

    return n;
}

public void clear()
{
    decodeResults.setText("");
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton decodeBtn;
    private javax.swing.JTextArea decodeResults;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
