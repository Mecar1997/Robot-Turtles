package Interface;

// Librairies Graphiques
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
// ---------------------------

import Main.Main;

public class Menu extends JFrame {

    static JFrame menuFrame = new JFrame("Robot Turtles");
	
    
    // Initialisation boutons
    static JButton p2 = new JButton("2 joueurs");
    static JButton p3 = new JButton("3 joueurs");
    static JButton p4 = new JButton("4 joueurs");
    static final JButton leaveButton = new JButton("Quitter");
    
    // Initialisation texte
    static JLabel labelTitle = new JLabel("ROBOT TURTLES");
    
    // Initialisation panel
    static JPanel menuPanel = new JPanel() {
		@Override
		public void paintComponent(Graphics g)
	    {
	        //Chargement de l"image de fond
	        try {
	            Image img = ImageIO.read(new File("images\\Background_menu.jpeg"));
	            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("ERREUR: Background image " +e.getMessage());
	        }
	    }
	};
    
    public static void initialisation() {
    	menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//permet la fermetture
		menuFrame.setSize(400, 600);
		menuFrame.setResizable(false);
		menuFrame.setLocationRelativeTo(null);
		menuFrame.getContentPane().setLayout(null);

		menuFrame.getContentPane().add(menuPanel);
		
		//Setup des panels
		menuPanel.setBounds(0, 0, 400, 600);
        
        //aligne les éléments de la fenêtre
       	menuPanel.add(labelTitle);
        menuPanel.add(p2);
        menuPanel.add(p3);
        menuPanel.add(p4);
        menuPanel.add(leaveButton);
        
        menuPanel.setLayout(new BorderLayout());
        
		labelTitle.setFont(new Font("Arial", Font.BOLD, 25));
		labelTitle.setForeground(Color.red);
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setBounds(0, 0, 400, 50);
		p2.setBounds(125, 100, 150, 50);
		p3.setBounds(125, 175, 150, 50);
		p4.setBounds(125, 250, 150, 50);
		leaveButton.setBounds(125, 325, 150, 50);
		
		
        // action des boutons
	    leaveButton.addActionListener(new ActionListener() {
            @Override
	        public void actionPerformed(ActionEvent e) {
	            Close();
	        }
	    });

        p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               	Main.newGame(2);

        		Menu.Close();
            }
        });

        p3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               	Main.newGame(3);

        		Menu.Close();
            }
        });



        p4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               	Main.newGame(4);

        		Menu.Close();
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
