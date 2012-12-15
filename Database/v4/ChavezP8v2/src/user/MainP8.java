/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.Frame;

/**
 *
 * @author jchavez589
 */
public class MainP8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Frame frame = null;
        try {
            frame = new Frame();
        } catch (SQLException ex) {
            Logger.getLogger(MainP8.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.setVisible(true);
        frame.setTitle("Javier C Program 8: Database Manipulation");
        
    }
}
