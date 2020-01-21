package Interface;

// Librairies Graphiques
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
// ---------------------------
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Main.Main;

public class PostGame extends JFrame {

    static JFrame menuFrame = new JFrame("Robot Turtles");
    

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
    static JLabel labelScore = new JLabel("");
	private static JLabel labelScoreTitle = new JLabel("SCORE");
	
	static JPanel panelScore = new JPanel();
	
    static final JButton continueButton = new JButton("Continuer");
    //TODO: à implémenter
	
	
    public void initialisation() {
    	menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//permet la fermetture
		menuFrame.setSize(400, 600);
		menuFrame.setResizable(false);
		menuFrame.setLocationRelativeTo(null);
		menuFrame.getContentPane().setLayout(null);

		menuFrame.getContentPane().add(menuPanel);
		panelScore.setBackground(Color.white);
		panelScore.setBorder(BorderFactory.createLineBorder(Color.black));
		menuPanel.add(panelScore);
		labelScoreTitle.setFont(new Font("Arial", Font.BOLD, 17));
		labelScoreTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelScore.add(labelScoreTitle);
		labelScore.setFont(new Font("Arial", Font.ITALIC, 13));
		labelScore.setHorizontalAlignment(SwingConstants.CENTER);
		panelScore.add(labelScore);
		//Setup des panels
		menuPanel.setBounds(0, 0, 400, 600);
		panelScore.setBounds(125, 325, 150, 50);
		menuPanel.add(continueButton);
        
        menuPanel.setLayout(new BorderLayout());
        
		labelScore.setHorizontalAlignment(SwingConstants.CENTER);
		labelScore.setBounds(0, 0, 400, 50);
		continueButton.setBounds(125, 325, 150, 50);
		
		
        // action des boutons
		continueButton.addActionListener(new ActionListener() {
            @Override
	        public void actionPerformed(ActionEvent e) {
	            Main.newGame(Main.currentGame.numberPlayers);
	        }
	    });
		Open();
    }
    
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
