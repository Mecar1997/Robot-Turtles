package Interface;

// Librairies Graphiques
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
// ---------------------------
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Main.Main;

public class Menu extends JFrame {

    static JFrame menuFrame = new JFrame("Robot Turtles");
	
    
    // Initialisation boutons
    static JCheckBox p2 = new JCheckBox("2 joueurs");
    static JCheckBox p3 = new JCheckBox("3 joueurs");
    static JCheckBox p4 = new JCheckBox("4 joueurs");
    static final JButton leaveButton = new JButton("Quitter");
    
    // Initialisation texte
    static JLabel info = new JLabel("Bienvenue dans robot Turtle. Sélectionnez le nombre de joueurs");
    
    // Initialisation panel
    static JPanel menuPanel = (JPanel) menuFrame.getContentPane();
    
    public static void initialisation() {
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//permet la fermetture
		menuFrame.setSize(600, 200);
		menuFrame.setLocation(100,10);
        info.setPreferredSize(new Dimension(5000, 100));
        
        //aligne les éléments de la fenêtre
        menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
       	menuPanel.add(info);
        menuPanel.add(p2);
        menuPanel.add(p3);
        menuPanel.add(p4);
        menuPanel.add(BorderLayout.SOUTH, leaveButton);
	    
        // action des boutons
	    leaveButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Close();
	        }
	    });

        p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               	Main.newGame(2);
            }
        });

        p3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               	Main.newGame(3);
            }
        });



        p4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               	Main.newGame(4);
            }
        });
        Open();
	}
	
	// Open & Close
	public static void Open() {
		menuFrame.setVisible(true);	
	}

	public static void Close() {
		menuFrame.setVisible(false);	
	}
	
	public static void Refresh() {
		Close();
		Open();
	}
	
}
