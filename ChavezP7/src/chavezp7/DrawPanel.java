/*DrawPanel.java
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
import java.awt.Graphics;


/**
 *
 * @author youracow
 */
public class DrawPanel extends javax.swing.JPanel {
    
//    int widthBox;
//    int height;
    private int NumberOfSides;
    private boolean circle;
    private int radius;
    private Color circleColor;
    
    /**
     * Creates new form DrawPanel
     */
    public DrawPanel() {
        initComponents();
        NumberOfSides=3;
        circle=false;
        radius=1;
        circleColor = Color.RED;
    }

    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setNumberOfSides(int NumberOfSides) {
        this.NumberOfSides = NumberOfSides;
        repaint();
    }
    
    public void setCircle(boolean circle) {
        this.circle = circle;
        repaint();
    }
    
    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }
    
    public void setCircleColor(Color circleColor) {
        this.circleColor = circleColor;
        repaint();
    }
    //</editor-fold>
    
    @Override
    protected void paintComponent(final Graphics g)
    {
        super.paintComponent(g);
        
        //the repaint will not fire correctly if radius is
        //reassigned back to itself.
        int newRadius; 
        
        //get the center of each of the sides
        int centerX = (getWidth() / 2);
        int centerY = (getHeight() / 2);
        //set the color
        g.setColor(circleColor);

        //check to what is larger side is lager and take the smaller of the two
        if (centerX < centerY) {
            newRadius = (centerX*radius)/10;
        }
        else {
            newRadius = (centerY*radius)/10;
        }
        //radius(userGiven)*centerX|Y(smallest sidelength)/10(max radius)
        
        int top = (centerY - newRadius);    // top edge of square                                     
        int left = (centerX - newRadius);   // left edge of square 

        int [] x = new int[NumberOfSides];
        int [] y = new int[NumberOfSides];
        
        
        for (int i = 0; i < NumberOfSides; i++) {
            double theta = Math.toRadians((360.0/NumberOfSides)*i);
            x[i] = (int) ((newRadius) * Math.cos(theta));
            y[i] = (int) ((newRadius) * Math.sin(theta));
        }
        //only draw the circle if user requested it
        if (circle) {
            //no translation is needed for this part
            //the circle is actually draw from top left edge
            g.drawOval(left,top, newRadius*2, newRadius*2);
        }
        //translate center since the drawing is based on center values
        g.translate(centerX, centerY);
        
        g.drawPolygon(x,y,NumberOfSides);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 290, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
