package Main;

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

public class Interface extends JFrame {

    static JFrame f = new JFrame("Robot Turtles");
	
    public static void StartMenu() {
	    f.setSize(600, 200);
	    f.setLocation(100,10);
	    JCheckBox p2 = new JCheckBox("2 joueurs");
	    JCheckBox p3 = new JCheckBox("3 joueurs");
	    JCheckBox p4 = new JCheckBox("4 joueurs");
	    final JButton leaveButton = new JButton("Quitter");
	    
        JLabel info = new JLabel("Bienvenue dans robot Turtle. Sélectionnez le nombre de joueurs");
        info.setPreferredSize(new Dimension(5000, 100));

        JPanel menuPanel = (JPanel) f.getContentPane();
        //aligne les éléments de la fenêtre
        menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

       	menuPanel.add(info);
        menuPanel.add(p2);
        menuPanel.add(p3);
        menuPanel.add(p4);
        menuPanel.add(BorderLayout.SOUTH, leaveButton);
	    
	    leaveButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Interface.Close();
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

	}
	
    
    public static void startBoard() {
    	
    }
    
	
	public static void Open() {
	    f.setVisible(true);	
	}

	public static void Close() {
	    f.setVisible(false);	
	}
	
	public static void Refresh() {
		Close();
		Open();
	}
	
}
