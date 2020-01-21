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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
// ---------------------------
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import Main.Main;
import Main.Player;

public class GameInterface extends JFrame {

    static JFrame gameFrame = new JFrame("Robot Turtles");
	
    
 // initialisation boutons
    final static JButton wallButton = new JButton("Placer un mur");
    final static JButton executeButton = new JButton("Executer votre programme");
    final static JButton completeButton = new JButton("Compléter votre programme");
    final static JButton discardButton = new JButton("Défausser une carte");
    final static JButton passButton = new JButton("Passer votre tour");
    final static JButton cancelButton = new JButton("Annuler");
    
	private static JButton[] cardButton = new JButton[5];
	private static JButton[][] boardButton = new JButton[8][8];
	
	//initialisation Images
	ImageIcon backgroundBoard = new ImageIcon(new ImageIcon("image/Background_board.png").getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT));
	
    final static ImageIcon blueE = new ImageIcon(new ImageIcon("images/blueE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon blueN = new ImageIcon(new ImageIcon("images/blueN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon blueS = new ImageIcon(new ImageIcon("images/blueS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon blueW = new ImageIcon(new ImageIcon("images/blueW.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    
    final static ImageIcon greenE = new ImageIcon(new ImageIcon("images/greenE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon greenN = new ImageIcon(new ImageIcon("images/greenN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon greenS = new ImageIcon(new ImageIcon("images/greenS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon greenW = new ImageIcon(new ImageIcon("images/greenW.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    
    final static ImageIcon redE = new ImageIcon(new ImageIcon("images/redE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon redN = new ImageIcon(new ImageIcon("images/redN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon redS = new ImageIcon(new ImageIcon("images/redS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon redW = new ImageIcon(new ImageIcon("images/redW.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    
    final static ImageIcon purpleE = new ImageIcon(new ImageIcon("images/purpleE.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon purpleN = new ImageIcon(new ImageIcon("images/purpleN.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon purpleS = new ImageIcon(new ImageIcon("images/purpleS.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon purpleW = new ImageIcon(new ImageIcon("images/purpleW.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    
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
    final static ImageIcon cardBug = new ImageIcon(new ImageIcon("images/CardEmpty.png").getImage().getScaledInstance(81, 146, Image.SCALE_DEFAULT));
    
    // Initialisation texte
    static JLabel labelAction = new JLabel("Choisissez l'action que voulez faire");
    
	private static JLabel labelStone = new JLabel("1");
	private static JLabel labelIce = new JLabel("1");
	private static JLabel labelWood = new JLabel("1");
	
	private static JLabel labelPlayer = new JLabel("1");
	
	private static JLabel labelScoreTitle = new JLabel("SCORE");
	private static JLabel labelScore = new JLabel("1");
	//TODO: Affichage manche + scores des joueurs en bas
	
    // Initialisation panel
	static JLayeredPane panelMain = new JLayeredPane();
	static JPanel panelHand = new JPanel(new GridLayout(1, 5));
	static JPanel panelWall = new JPanel();
	static JPanel panelPlayer = new JPanel();
	static JPanel panelAction = new JPanel();
	static JPanel panelScore = new JPanel();
    static JPanel panelBoard = new JPanel(new GridLayout(8,8)) {
		@Override
		public void paintComponent(Graphics g)
	    {
	        //Chargement de l"image de fond
	        try {
	            Image img = ImageIO.read(new File("images\\Background_board.png"));
	            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("ERREUR: Background image " +e.getMessage());
	        }
	    }
	};
    
    // Initialisation variables
    static int currentCommand = 0; // 0 = rien, 1 = en train d'exécuter un programme, 2 = en train de compléter un programme, 3 = construction mur de pierre, 4 = construction mur de glace, 5 = construction mur en bois, 6 = Va passer son tour, 7 = En train de défausser, 8 = A passé son tour
    static boolean hasAdded = false; //variable booleene pour empecher d'annuler la complétion du programme si le joueur a ajouté au moins une cart
    
    public static void initialisation() {
    	gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//permet la fermetture
    	
		//création de la fenetre
		gameFrame.setSize(800, 700);
		gameFrame.setResizable(false);
		gameFrame.setLocationRelativeTo(null);
        gameFrame.getContentPane().setLayout(null);
        
		//Setup des panels
		panelMain.setBounds(0, 0, 800, 700);
		gameFrame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
	
		labelPlayer.setFont(new Font("Courier New", Font.BOLD, 13));
		panelPlayer.setBounds(0, 0, 800, 44);
		panelPlayer.add(labelPlayer);
		panelMain.add(panelPlayer);

		panelBoard.setBounds(5, 44, 425, 425);
		panelMain.add(panelBoard);

		panelHand.setBounds(15, 486, 407, 146);
		panelMain.add(panelHand);
		
		panelAction.setBounds(500, 86, 200, 96);
		panelMain.add(panelAction);

		panelScore.setBounds(475, 300, 250, 350);
		panelScore.setBackground(Color.white);
		panelScore.setBorder(BorderFactory.createLineBorder(Color.black));
		panelMain.add(panelScore);
		labelScoreTitle.setFont(new Font("Arial", Font.BOLD, 17));
		labelScoreTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelScore.add(labelScoreTitle);
		labelScore.setFont(new Font("Arial", Font.ITALIC, 13));
		labelScore.setHorizontalAlignment(SwingConstants.CENTER);
		panelScore.add(labelScore);
		//Action Panel
	
       	panelAction.add(labelAction);
       	panelAction.add(executeButton);
       	panelAction.add(completeButton);
       	panelAction.add(cancelButton);
       	panelAction.add(discardButton);
       	panelAction.add(passButton);
       	updateButtons();
       	
		//Initialisation des boutons du tableau
		for(int i=0;i<8;i++) {
			for(int j =0; j<8;j++) {
				JButton tileButton = new JButton();
				tileButton.setOpaque(false);
				tileButton.setContentAreaFilled(false);
				tileButton.setVisible(true);
				boardButton[i][j]=tileButton;
				panelBoard.add(boardButton[i][j]);
			}
		}
        
		//Initialisation des boutons de la main
		for(int i=0; i<5;i++) {
			int a = i;
			JButton cardB = new JButton();
			cardB.setVisible(true);
			cardB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton c = (JButton) e.getSource();
					if (a < Main.currentGame.currentPlayer.hand.size()) {
						if (currentCommand == 7) {
							Main.currentGame.currentPlayer.discardCard(a+1);
							updateHand();
						} else if (currentCommand == 2) {
							hasAdded = true;
							Main.currentGame.currentPlayer.addToProgram(a);
							updateButtons();
							updateHand();
						}
					}
				}
			});
			cardButton[i]=cardB;
			panelHand.add(cardButton[i]);
		}
		
		//Initialisation wall Panel
		
		panelWall.setLayout(new GridLayout(1, 3, 10, 10));
		panelMain.add(panelWall);
		JButton buttonStone = new JButton();
		buttonStone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentCommand == 0) {
					if (Main.currentGame.currentPlayer.getWallStone() > 0) {
			        	currentCommand = 3;
			            updateButtons();
					} else {
			       		JOptionPane.showMessageDialog(null, "Vous n'avez pas de mur de pierre", "Construction d'un mur", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		buttonStone.setIcon(wallStone);
		buttonStone.setVisible(true);
		buttonStone.setBackground(Color.lightGray);
		panelWall.add(buttonStone);
			
		JButton buttonIce = new JButton();
		buttonIce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentCommand == 0) {
					if (Main.currentGame.currentPlayer.getWallIce() > 0) {
			        	currentCommand = 4;
			            updateButtons();
					} else {
			       		JOptionPane.showMessageDialog(null, "Vous n'avez pas de mur de glace", "Construction d'un mur", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		buttonIce.setIcon(wallIce);
		buttonIce.setBackground(Color.CYAN);
		buttonIce.setVisible(true);
		panelWall.add(buttonIce);
			
		JButton buttonWood = new JButton();
		buttonWood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentCommand == 0) {
					if (Main.currentGame.currentPlayer.getWallWood() > 0) {
			        	currentCommand = 5;
			            updateButtons();
					} else {
		        		JOptionPane.showMessageDialog(null, "Vous n'avez pas de mur en bois", "Construction d'un mur", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		buttonWood.setIcon(wallWood);
		buttonWood.setVisible(true);
		buttonWood.setBackground(Color.lightGray);			
		panelWall.add(buttonWood);
				
		labelStone.setFont(new Font("Courier New", Font.ITALIC, 12));
		labelStone.setBounds(535, 220, 33, 56);
		panelMain.add(labelStone);
			
		labelIce.setFont(new Font("Courier New", Font.ITALIC, 12));
		labelIce.setBounds(585, 220, 33, 56);
		panelMain.add(labelIce);
				
		labelWood.setFont(new Font("Courier New", Font.ITALIC, 12));
		labelWood.setBounds(635, 220, 33, 56);
		panelMain.add(labelWood);
				
		panelWall.setBounds(520, 200, 140, 40);
	    
        // action des boutons
	    passButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
		        	Main.currentGame.nextTurn();
	        }
	    });
	    
	    executeButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	currentCommand = 1;
	            Main.currentGame.currentPlayer.executeProgram();
	        	currentCommand = 6;
	            updateButtons();
	        }
	        //TODO: Main: Ralentir les actions pour quelles soient toutes visibles. (import Time ?)
	    });
	    
	    completeButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            	currentCommand = 2;
	        		JOptionPane.showMessageDialog(null, "Cliquez sur les cartes de votre main pour les ajouter au programme", "Compléter le programme", JOptionPane.INFORMATION_MESSAGE);
		            updateButtons();	
	        }
	    });    
	    
	    cancelButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	if ((currentCommand >= 2) && (currentCommand <= 5) && (!hasAdded)) {
	        		currentCommand = 0;
	        		updateButtons();
	        	}
			}
	    });
	    
	    discardButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            	currentCommand = 7;
	        		JOptionPane.showMessageDialog(null, "Cliquez sur les cartes de votre main pour les défausser", "Défausser une carte", JOptionPane.INFORMATION_MESSAGE);
		            updateButtons();	
	        }
	    });
	    
	    
		for(int i=0;i<8;i++) {
			for(int j =0; j<8;j++) {
				int h = i; int k = j;
			    boardButton[h][k].addActionListener(new ActionListener() { //
					public void actionPerformed(ActionEvent e) {
						if (Main.currentGame.board.getTile()[h][k].getType() == 0) {
							if (currentCommand == 3) {
								if (Main.currentGame.currentPlayer.placeWall(h, k, 1) == true) {
									currentCommand = 6;
						        	updateBoard();
									updateButtons();
									updateText();
								};
							} else if (currentCommand == 4) {
								if (Main.currentGame.currentPlayer.placeWall(h, k, 2) == true) {
									currentCommand = 6;
						        	updateBoard();
									updateButtons();
									updateText();
								};
							} else if (currentCommand == 5) {
								if (Main.currentGame.currentPlayer.placeWall(h, k, 3) == true) {
									currentCommand = 6;
						        	updateBoard();
									updateButtons();
									updateText();
								};
							}
						}
					}
				});
			}	
		}

	       
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
	
	
	public static void updateHand() {
		// Affiche la main du joueur
		 if(Main.currentGame.currentPlayer.hand.size()<5) { //Si la main est plus petite que 5
			 for(int i=Main.currentGame.currentPlayer.hand.size();i<5;i++ ) {
				 cardButton[i].setIcon(null);
					cardButton[i].setBackground(null);
					cardButton[i].setToolTipText(null);
			 }
		 }
		for(int i=0; i<Main.currentGame.currentPlayer.hand.size();i++) {
			if (currentCommand == 8) {
				cardButton[i].setIcon(null);
				cardButton[i].setToolTipText(null);
			} else {
				if (Main.currentGame.currentPlayer.hand.get(i).getType() == 0) {
					cardButton[i].setIcon(cardBlue);
					cardButton[i].setToolTipText("Fait avancer la tortue d’une case");
				} else if (Main.currentGame.currentPlayer.hand.get(i).getType() == 1) {
					 cardButton[i].setIcon(cardYellow);
					cardButton[i].setToolTipText("Fait tourner la tortue dans le sens anti-horaire");
				} else if (Main.currentGame.currentPlayer.hand.get(i).getType() == 2) {
					 cardButton[i].setIcon(cardPurple);
					cardButton[i].setToolTipText("Fait tourner la tortue dans le sens horaire");
				} else if (Main.currentGame.currentPlayer.hand.get(i).getType() == 3) {
					 cardButton[i].setIcon(cardLaser);
					cardButton[i].setToolTipText("Touche la première tuile se trouvant en face de la tortue. Si la tuile touchée est un mur de glace, celui-ci va fondre et disparaître");
				} else if (Main.currentGame.currentPlayer.hand.get(i).getType() == 4) {
					 cardButton[i].setIcon(cardBug);
				}
			}
			
		 }
	}
	
	public static void updateBoard() {
		// affiche les tortues, joyaux et murs
		 for(int i=0; i<8;i++) {
			 for(int j=0;j<8; j++) {
				 if (Main.currentGame.board.getTile()[i][j].getType()== 0) {
					 boardButton[i][j].setIcon(null);
				 } else	if (Main.currentGame.board.getTile()[i][j].getType()== 1) {
					 boardButton[i][j].setIcon(wallStone);
				 } else	if (Main.currentGame.board.getTile()[i][j].getType()== 2) {
					 boardButton[i][j].setIcon(wallIce);
				 } else	if (Main.currentGame.board.getTile()[i][j].getType()== 3) {
					 boardButton[i][j].setIcon(wallWood);
				 } else	if (Main.currentGame.board.getTile()[i][j].getType()== 4) {
					 boardButton[i][j].setIcon(jewelBlue);
				 } else	if (Main.currentGame.board.getTile()[i][j].getType()== 5) {
					 boardButton[i][j].setIcon(jewelRed);
				 } else	if (Main.currentGame.board.getTile()[i][j].getType()== 6) {
					 boardButton[i][j].setIcon(jewelGreen);
				 } else	if (Main.currentGame.board.getTile()[i][j].getType()== 7) {
					 boardButton[i][j].setIcon(jewelPurple);
				 } else	if (Main.currentGame.board.getTile()[i][j].getType()== 8) { // tortue
					 Player p = Main.currentGame.board.getTile()[i][j].getPlayer();
					 if (p.getColor() == 0) {
						 if (p.getDirection() == 0) {
							 boardButton[i][j].setIcon(blueN);
						 } else if (p.getDirection() == 1) {
							 boardButton[i][j].setIcon(blueW);
						 } else if (p.getDirection() == 2) {
							 boardButton[i][j].setIcon(blueS);
						 } else if (p.getDirection() == 3) {
							 boardButton[i][j].setIcon(blueE);
						 }
					 } else	if (p.getColor() == 1) {
						 if (p.getDirection() == 0) {
							 boardButton[i][j].setIcon(redN);
						 } else if (p.getDirection() == 1) {
							 boardButton[i][j].setIcon(redW);
						 } else if (p.getDirection() == 2) {
							 boardButton[i][j].setIcon(redS);
						 } else if (p.getDirection() == 3) {
							 boardButton[i][j].setIcon(redE);
						 }
					 } else	if (p.getColor() == 2) {
						 if (p.getDirection() == 0) {
							 boardButton[i][j].setIcon(greenN);
						 } else if (p.getDirection() == 1) {
							 boardButton[i][j].setIcon(greenW);
						 } else if (p.getDirection() == 2) {
							 boardButton[i][j].setIcon(greenS);
						 } else if (p.getDirection() == 3) {
							 boardButton[i][j].setIcon(greenE);
						 }
					 } else	if (p.getColor() == 3) {
						 if (p.getDirection() == 0) {
							 boardButton[i][j].setIcon(purpleN);
						 } else if (p.getDirection() == 1) {
							 boardButton[i][j].setIcon(purpleW);
						 } else if (p.getDirection() == 2) {
							 boardButton[i][j].setIcon(purpleS);
						 } else if (p.getDirection() == 3) {
							 boardButton[i][j].setIcon(purpleE);
						 }
					 }
				 }	
			 }
		 }
	}

	public static void updateButtons() {
		if (currentCommand == 0) {
			passButton.setVisible(false);
			cancelButton.setVisible(false);
			wallButton.setVisible(true);
			executeButton.setVisible(true);
			completeButton.setVisible(true);
			discardButton.setVisible(false);
		} else if ((currentCommand >= 3) && (currentCommand <= 5)) {
			passButton.setVisible(false);
			cancelButton.setVisible(true);
			wallButton.setVisible(false);
			executeButton.setVisible(false);
			completeButton.setVisible(false);
			discardButton.setVisible(false);
		} else if (currentCommand == 2){
			if (hasAdded) {
				passButton.setVisible(true);
				discardButton.setVisible(true);
				cancelButton.setVisible(false);
			} else {
				cancelButton.setVisible(true);
				passButton.setVisible(false);
				discardButton.setVisible(false);
			}
			wallButton.setVisible(false);
			executeButton.setVisible(false);
			completeButton.setVisible(false);
		} else if (currentCommand == 6){
			cancelButton.setVisible(false);
			wallButton.setVisible(false);
			executeButton.setVisible(false);
			completeButton.setVisible(false);
			discardButton.setVisible(true);
			passButton.setVisible(true);
		} else if (currentCommand == 7) {
			passButton.setVisible(true);
			cancelButton.setVisible(false);
			wallButton.setVisible(false);
			executeButton.setVisible(false);
			completeButton.setVisible(false);
			discardButton.setVisible(false);
		}
	}
	public static void updateText() {
		labelPlayer.setText("Tour de " + Main.currentGame.currentPlayer.getName() + ". Prochain joueur: " + Main.turns.getFirst().getName());
		
		
		String messageScore = "";
		//TODO: Ordonner la liste des joueurs en fonction de leur score. Algorithme de tri.
		labelScore.setText("");
		
		if (currentCommand == 8) {
			labelStone.setText("?");
			labelIce.setText("?");
			labelWood.setText("?");
		} else {
			labelStone.setText("" + Main.currentGame.currentPlayer.getWallStone());
			labelIce.setText("" + Main.currentGame.currentPlayer.getWallIce());
			labelWood.setText("" + Main.currentGame.currentPlayer.getWallWood());
		}
	}
	
	public static void newTurn() {
		currentCommand = 8;
		updateHand();
		updateText();
		JOptionPane.showMessageDialog(null, "C'est le tour de " + Main.currentGame.currentPlayer.getName() , "Tour " + Main.currentGame.turnCounter, JOptionPane.INFORMATION_MESSAGE);
		currentCommand = 0;
		hasAdded = false;
		updateButtons();
		update();
	}
	
	public static void update() {
		updateText();
		updateBoard();
		updateHand();
	}
}
