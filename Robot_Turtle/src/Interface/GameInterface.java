package Interface;

// Librairies Graphiques
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
// ---------------------------
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Main.Main;

public class GameInterface extends JFrame {

    static JFrame gameFrame = new JFrame("Robot Turtles");
	
    
 // initialisation boutons
    final static JButton wallButton = new JButton("Placer un mur");
    final static JButton executeButton = new JButton("Executer votre programme");
    final static JButton completeButton = new JButton("Compléter votre programme");
    static final JButton passButton = new JButton("Passer");
    
	private static JButton[] cardButton = new JButton[5];
	private static JButton[][] boardButton = new JButton[8][8];
	
	//initialisation Images
	ImageIcon backgroundBoard = new ImageIcon(new ImageIcon("image/Background_board.png").getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT));
	
    final static ImageIcon blueE = new ImageIcon(new ImageIcon("image/blueE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon blueN = new ImageIcon(new ImageIcon("image/blueN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon blueS = new ImageIcon(new ImageIcon("image/blueS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon blueW = new ImageIcon(new ImageIcon("image/blueW.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    
    final static ImageIcon greenE = new ImageIcon(new ImageIcon("image/greenE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon greenN = new ImageIcon(new ImageIcon("image/greenN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon greenS = new ImageIcon(new ImageIcon("image/greenS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon greenW = new ImageIcon(new ImageIcon("image/greenW.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    
    final static ImageIcon redE = new ImageIcon(new ImageIcon("image/redE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon redN = new ImageIcon(new ImageIcon("image/redN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon redS = new ImageIcon(new ImageIcon("image/redS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon redW = new ImageIcon(new ImageIcon("image/redW.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    
    final static ImageIcon purpleE = new ImageIcon(new ImageIcon("image/purpleE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon purpleN = new ImageIcon(new ImageIcon("image/purpleN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon purpleS = new ImageIcon(new ImageIcon("image/purpleS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon purpleW = new ImageIcon(new ImageIcon("image/purpleW.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    
    final static ImageIcon jewelBlue = new ImageIcon(new ImageIcon("images/jewel_blue.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon jewelGreen = new ImageIcon(new ImageIcon("images/jewel_green.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon jewelRed = new ImageIcon(new ImageIcon("images/jewel_red.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon jewelPurple = new ImageIcon(new ImageIcon("images/jewel_purple.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    
    final static ImageIcon wallIce = new ImageIcon(new ImageIcon("images/wall_ice.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon wallStone = new ImageIcon(new ImageIcon("images/wall_stone.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon wallWood = new ImageIcon(new ImageIcon("images/wall_wood.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    
    final static ImageIcon cardBlue = new ImageIcon(new ImageIcon("images/CardBlue.png").getImage().getScaledInstance(81, 146, Image.SCALE_DEFAULT));
    final static ImageIcon cardLaser = new ImageIcon(new ImageIcon("images/CardLaser.png").getImage().getScaledInstance(81, 146, Image.SCALE_DEFAULT));
    final static ImageIcon cardYellow = new ImageIcon(new ImageIcon("images/CardYellow.png").getImage().getScaledInstance(81, 146, Image.SCALE_DEFAULT));
    final static ImageIcon cardPurple = new ImageIcon(new ImageIcon("images/CardPurple.png").getImage().getScaledInstance(81, 146, Image.SCALE_DEFAULT));
    final static ImageIcon cardEmpty = new ImageIcon(new ImageIcon("images/CardEmpty.png").getImage().getScaledInstance(81, 146, Image.SCALE_DEFAULT));
	

    
    // Initialisation texte
    static JLabel labelAction = new JLabel("Choisissez l'action que voulez faire");
    
	private static JLabel labelStone = new JLabel("1");
	private static JLabel labelIce = new JLabel("1");
	private static JLabel labelWood = new JLabel("1");
	
	private static JLabel labelPlayer = new JLabel("Joueur actuel: Beep. Prochain Joueur: Pi");
	
    // Initialisation panel
	static JLayeredPane panelMain = new JLayeredPane();
	static JPanel panelHand = new JPanel(new GridLayout(1, 5));
	static JPanel panelWall = new JPanel();
	static JPanel panelPlayer = new JPanel();
	static JPanel panelAction = new JPanel();
    static JPanel panelBoard = new JPanel(new GridLayout(8,8));
    
    
    public static void initialisation() {
    	gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//permet la fermetture
    	
		//création de la fenetre
		gameFrame.setSize(800, 700);
		gameFrame.setResizable(false);
		gameFrame.setLocationRelativeTo(null);
        gameFrame.getContentPane().setLayout(null);
        
		//Setup des panels
		panelMain.setBounds(15, 16, 1044, 648);
		gameFrame.getContentPane().add(panelMain);
		panelMain.setLayout(null);

		panelBoard.setBounds(5, 44, 425, 425);
		panelMain.add(panelBoard);

		panelHand.setBounds(15, 486, 407, 146);
		panelMain.add(panelHand);
		
		panelPlayer.setBounds(10, 10, 50, 50);
		labelPlayer.setFont(new Font("Courier New", Font.ITALIC, 12));
		labelPlayer.setBounds(10, 10, 33, 56);
		panelMain.add(panelPlayer);
		
		panelAction.setBounds(400, 286, 307, 146);
		panelMain.add(panelAction);
		
		//Action Panel
	
       	panelAction.add(labelAction);
       	panelAction.add(executeButton);
       	panelAction.add(completeButton);
       	panelAction.add(wallButton);
       	panelAction.add(passButton);
		
		//Initialisation des boutons du tableau
		for(int i=0;i<8;i++) {
			for(int j =0; j<8;j++) {
				JButton tileButton = new JButton();
				tileButton.setOpaque(false);
				tileButton.setContentAreaFilled(false);
				tileButton.setName(i+";"+j); //TODO:
				tileButton.addActionListener(new ActionListener() { //
					public void actionPerformed(ActionEvent e) {
						//TODO:
					}
				});
				tileButton.setVisible(true);
				boardButton[i][j]=tileButton;
				panelBoard.add(boardButton[i][j]);
			}
		}
        
		//Initialisation des boutons de la main
		for(int i=0; i<5;i++) {
			JButton cardB = new JButton();
			cardB.setVisible(true);
			cardB.setName(i+";0"); //TODO
			cardB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO:
				}
			});
			cardButton[i]=cardB;
			panelHand.add(cardButton[i]);
		}
		
		//Initialisation wall Panel
				panelWall.setLayout(new GridLayout(3, 1, 0, 0));
				panelMain.add(panelWall);
				JButton buttonStone = new JButton();
				buttonStone.addActionListener(new ActionListener() {
					/*evenement du bouton : lorsqu'on appui sur ce bouton, la variable evenementmur est mise a true
					comme cela, le main peut savoir que l'utilisateur a chois son mur*/
					public void actionPerformed(ActionEvent arg0) {
						//TODO:
					}
				});
				buttonStone.setIcon(wallStone);
				buttonStone.setVisible(true);
				panelWall.add(buttonStone);
				
				JButton buttonWood = new JButton();
				buttonWood.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO:
					}
				});
				buttonWood.setIcon(wallWood);
				buttonWood.setVisible(true);
				panelWall.add(buttonWood);
				
				JButton buttonIce = new JButton();
				buttonIce.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO:
					}
				});
				buttonIce.setIcon(wallIce);
				buttonIce.setVisible(true);
				panelWall.add(buttonIce);
				
				labelStone.setFont(new Font("Courier New", Font.ITALIC, 12));
				labelStone.setBounds(76, 287, 33, 56);
				panelMain.add(labelStone);
				
				
				labelWood.setFont(new Font("Courier New", Font.ITALIC, 12));
				labelWood.setBounds(76, 345, 33, 56);
				panelMain.add(labelWood);
				
				
				labelIce.setFont(new Font("Courier New", Font.ITALIC, 12));
				labelIce.setBounds(76, 402, 33, 56);
				panelMain.add(labelIce);
	    
        // action des boutons
	    passButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Main.nextTurn();
	        }
	    });

        Open();
	}
	
	// Open & Close
	public static void Open() {
		gameFrame.setVisible(true);	
	}

	public static void Close() {
		gameFrame.setVisible(false);	
	}
	
	public static void Refresh() {
		Close();
		Open();
	}
	
	
	public static void UpdateHand() {
		// Affiche la main du joueur
		 if(Main.currentPlayer.hand.size()<5) { //Si la main est plus petite que 5
			 for(int i=Main.currentPlayer.hand.size();i<5;i++ ) {
				 cardButton[i].setIcon(null);
					cardButton[i].setBackground(null);
			 }
		 }
		for(int i=0; i<Main.currentPlayer.hand.size();i++) {
			if (Main.currentPlayer.hand.get(i).getType() == 0) {
				cardButton[i].setIcon(cardBlue);
				cardButton[i].setBackground(Color.BLUE);
			} else if (Main.currentPlayer.hand.get(i).getType() == 1) {
				 cardButton[i].setIcon(cardYellow);
					cardButton[i].setBackground(Color.YELLOW);
			} else if (Main.currentPlayer.hand.get(i).getType() == 2) {
				 cardButton[i].setIcon(cardPurple);
					cardButton[i].setBackground(Color.MAGENTA);
			} else if (Main.currentPlayer.hand.get(i).getType() == 3) {
				 cardButton[i].setIcon(cardLaser);
					cardButton[i].setBackground(Color.BLACK);
			} else if (Main.currentPlayer.hand.get(i).getType() == 4) {
				 //TODO: Carte Bug
			}
		 }
	}
	
	public static void UpdateBoard() {
		// affiche les tortues, joyaux et murs
		 for(int i=0; i<8;i++) {
			 for(int j=0;j<8; j++) {
				 if (Main.board.getTile()[i][j].getType()== 0) {
					 boardButton[i][j].setIcon(null);
				 } else	if (Main.board.getTile()[i][j].getType()== 1) {
					 boardButton[i][j].setIcon(wallStone);
				 } else	if (Main.board.getTile()[i][j].getType()== 2) {
					 boardButton[i][j].setIcon(wallIce);
				 } else	if (Main.board.getTile()[i][j].getType()== 3) {
					 boardButton[i][j].setIcon(wallWood);
				 } else	if (Main.board.getTile()[i][j].getType()== 4) {
					 boardButton[i][j].setIcon(jewelBlue);
				 } else	if (Main.board.getTile()[i][j].getType()== 5) {
					 boardButton[i][j].setIcon(jewelRed);
				 } else	if (Main.board.getTile()[i][j].getType()== 6) {
					 boardButton[i][j].setIcon(jewelGreen);
				 } else	if (Main.board.getTile()[i][j].getType()== 7) {
					 boardButton[i][j].setIcon(jewelPurple);
				 } else	if (Main.board.getTile()[i][j].getType()== 8) {
					 //TODO: Affichage des tortues
				 }	
			 }
		 }
	}
	
	public static void UpdateWalls() {
		
	}
}
