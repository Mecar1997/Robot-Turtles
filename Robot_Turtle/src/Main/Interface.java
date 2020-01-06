package Main;

// Librairies Graphiques
import edu.princeton.cs.introcs.StdDraw;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.Jpanel;
// ---------------------------


public class Interface {

    static JFrame f = new JFrame("Robot Turtles");
	public static void InitialiserMenu() {
	    f.setSize(100, 100);
	    f.setLocation(100,10);
	    final JButton startButton = new JButton("Lancer une partie");
	    final JButton leaveButton = new JButton("Quitter");
	    f.getContentPane().add(BorderLayout.NORTH, startButton);
	    f.getContentPane().add(BorderLayout.SOUTH, leaveButton);
	    startButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	        }
	    });
	    leaveButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Interface.Fermer();
	        }
	    });

	}
	public static void Afficher() {
	    f.setVisible(true);	
	}

	public static void Fermer() {
	    f.setVisible(false);	
	}
	
}
