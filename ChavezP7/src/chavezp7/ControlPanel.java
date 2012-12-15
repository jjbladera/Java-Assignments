/*ControlPanel.java
 * 
 * Javier Chavez
 * jchavez589@cnm.edu
 * 
 * CIS 2275 Java Programming 1 
 * 
 * Program 7: polygons
 * DUE Nov8 2012
 * 
 */
package chavezp7;

import java.awt.Color;
import javax.swing.JColorChooser;



/**
 *
 * @author youracow
 */
public class ControlPanel extends javax.swing.JPanel {

    private int sides;
    private int radius;
    private boolean showCircle;
    private Color color;
    private PolygonFrame frame;

    public ControlPanel() {
        initComponents();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        //set UI control
        radiusSlider.setValue(radius);
    }

    public boolean isShowCircle() {
        return showCircle;
    }

    public void setShowCircle(boolean showCircle) {
        this.showCircle = showCircle;
        //set UI control
        if(this.showCircle){
            showCircBox.setSelected(true);
        }
        else{
            showCircBox.setSelected(false);
        }   
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
        //set UI control
        sideNum.setValue(this.sides);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        //set UI control
        currentColor.setBackground(color);
        currentColor.setOpaque(true);
    }

    public PolygonFrame getFrame() {
        return frame;
    }

    public void setFrame(PolygonFrame frame) {
        this.frame = frame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radiusSlider = new javax.swing.JSlider();
        sideNum = new javax.swing.JSpinner();
        showCircBox = new javax.swing.JCheckBox();
        colorButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        currentColor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Control Panel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 1, 18))); // NOI18N
        setMaximumSize(new java.awt.Dimension(160, 314));
        setMinimumSize(new java.awt.Dimension(160, 314));
        setPreferredSize(new java.awt.Dimension(160, 314));

        radiusSlider.setBackground(new java.awt.Color(204, 204, 255));
        radiusSlider.setMajorTickSpacing(2);
        radiusSlider.setMaximum(10);
        radiusSlider.setMinimum(1);
        radiusSlider.setMinorTickSpacing(1);
        radiusSlider.setPaintLabels(true);
        radiusSlider.setPaintTicks(true);
        radiusSlider.setSnapToTicks(true);
        radiusSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radiusSliderStateChanged(evt);
            }
        });

        sideNum.setModel(new javax.swing.SpinnerNumberModel(3, 3, 10, 1));
        sideNum.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sideNumStateChanged(evt);
            }
        });

        showCircBox.setBackground(new java.awt.Color(204, 204, 255));
        showCircBox.setText("Show Circle");
        showCircBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                showCircBoxStateChanged(evt);
            }
        });

        colorButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        colorButton.setText("Choose Line Color");
        colorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorButtonActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setLabelFor(showCircBox);
        jLabel3.setText("Side count");

        jLabel5.setLabelFor(currentColor);
        jLabel5.setText("Currently:");

        currentColor.setText("  ");
        currentColor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        currentColor.setMaximumSize(new java.awt.Dimension(30, 25));
        currentColor.setMinimumSize(new java.awt.Dimension(30, 25));
        currentColor.setPreferredSize(new java.awt.Dimension(30, 20));
        currentColor.setVerifyInputWhenFocusTarget(false);
        currentColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                currentColorMouseReleased(evt);
            }
        });

        jLabel1.setLabelFor(radiusSlider);
        jLabel1.setText("Radius");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(sideNum, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(showCircBox))
                        .add(50, 50, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(currentColor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(colorButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(radiusSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(sideNum, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(showCircBox)
                .add(24, 24, 24)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(radiusSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(colorButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 30, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel5)
                    .add(currentColor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sideNumStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sideNumStateChanged
        frame.setSides(Integer.parseInt(sideNum.getValue().toString()));
    }//GEN-LAST:event_sideNumStateChanged

    private void radiusSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radiusSliderStateChanged
        frame.setRadius(radiusSlider.getValue());
    }//GEN-LAST:event_radiusSliderStateChanged

    private void showCircBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_showCircBoxStateChanged
        frame.setCircumscribe(showCircBox.isSelected());
    }//GEN-LAST:event_showCircBoxStateChanged

    private void colorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorButtonActionPerformed
        // show color dialog 
        Color newColor = JColorChooser.showDialog(
                ControlPanel.this,"Choose new line color",color);
        //if the color is not null set the new color and call update
        if (newColor != null) {
            color = newColor;
            currentColor.setBackground(color);
            currentColor.setOpaque(true);
            frame.setCircleColor(color);
        }
    }//GEN-LAST:event_colorButtonActionPerformed

    private void currentColorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currentColorMouseReleased
        // TODO add your handling code here:
        colorButtonActionPerformed(null);
    }//GEN-LAST:event_currentColorMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton colorButton;
    private javax.swing.JLabel currentColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSlider radiusSlider;
    private javax.swing.JCheckBox showCircBox;
    private javax.swing.JSpinner sideNum;
    // End of variables declaration//GEN-END:variables


}
