package Interface;

// Librairies Graphiques
import java.awt.Color;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
// ---------------------------

import Main.Main;

public class GameInterface extends JFrame {

    static JFrame gameFrame = new JFrame("Robot Turtles");
	
    
 // initialisation boutons
    final JButton wallButton = new JButton("Placer un mur");
    final JButton executeButton = new JButton("Executer votre programme");
    final JButton completeButton = new JButton("Compléter votre programme");
    final JButton discardButton = new JButton("Défausser une carte");
    final JButton passButton = new JButton("Passer votre tour");
    final JButton cancelButton = new JButton("Annuler");
    
	private JButton[] cardButton = new JButton[5];
	private JButton[][] boardButton = new JButton[8][8];
	
	//initialisation Images
	ImageIcon backgroundBoard = new ImageIcon(new ImageIcon("image/Background_board.png").getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT));
    
    final static ImageIcon wallIce = new ImageIcon(new ImageIcon("images/wall_ice.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon wallStone = new ImageIcon(new ImageIcon("images/wall_stone.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    final static ImageIcon wallWood = new ImageIcon(new ImageIcon("images/wall_wood.png").getImage().getScaledInstance(53, 53, Image.SCALE_DEFAULT));
    
    // Initialisation texte
    JLabel labelAction = new JLabel("Choisissez l'action que voulez faire");
    
	JLabel labelStone = new JLabel("1");
	JLabel labelIce = new JLabel("1");
	JLabel labelWood = new JLabel("1");
	
	JLabel labelPlayer = new JLabel("1");
	
	JLabel labelScoreTitle = new JLabel("SCORE");
	JLabel labelScore = new JLabel("1");
	
    // Initialisation panel
	JLayeredPane panelMain = new JLayeredPane();
	JPanel panelHand = new JPanel(new GridLayout(1, 5));
	JPanel panelWall = new JPanel();
	JPanel panelPlayer = new JPanel();
	JPanel panelAction = new JPanel();
	JPanel panelScore = new JPanel();
    JPanel panelBoard = new JPanel(new GridLayout(8,8)) {
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
    static int currentCommand = 0; // 0 = rien, 1 = en train d'exécuter un programme, 2 = en train de compléter un programme, 3 = construction mur de pierre, 4 = construction mur de glace, 5 = construction mur en bois, 6 = Va passer son tour, 7 = En train de défausser, 8 = A passé son tour, 9 = va bugger un autre joueur
    static boolean hasAdded = false; //variable boolean pour empêcher d'annuler la complétion du programme si le joueur a ajouté au moins une carte
    
    public void initialisation() {
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

		//TODO: Score Panel
		// panelScore.setLayout(new BoxLayout(panelScore, BoxLayout.PAGE_AXIS));
		// panelScore.setBounds(475, 300, 250, 350);
		// panelScore.setBackground(Color.white);
		// panelScore.setBorder(BorderFactory.createLineBorder(Color.black));
		// panelMain.add(panelScore);
		// labelScoreTitle.setFont(new Font("Arial", Font.BOLD, 17));
		// labelScoreTitle.setHorizontalAlignment(SwingConstants.CENTER);
		// panelScore.add(labelScoreTitle);
		// labelScore.setFont(new Font("Arial", Font.ITALIC, 13));
		// labelScore.setHorizontalAlignment(SwingConstants.CENTER);
		// panelScore.add(labelScore);
		
		
		
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
						// TODO: Implémentation de la carte Bug
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
					if (Main.currentGame.currentPlayer.getWalls(0) > 0) {
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
					if (Main.currentGame.currentPlayer.getWalls(1) > 0) {
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
					if (Main.currentGame.currentPlayer.getWalls(2) > 0) {
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
						} else if ((currentCommand == 0) &&  (Main.currentGame.board.getTile()[h][k].getType() == 8)){
							System.out.println(Main.currentGame.board.getTile()[h][k].getPlayer().getDirection());
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
	
	
	public void updateHand() {
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
				cardButton[i].setIcon(Main.currentGame.currentPlayer.hand.get(i).getIcon());
				cardButton[i].setToolTipText(Main.currentGame.currentPlayer.hand.get(i).getTooltip());
			}
			
		 }
	}
	
	public void updateBoard() {
		// affiche les tortues, joyaux et murs
		 for(int i=0; i<8;i++) {
			 for(int j=0;j<8; j++) {
					 boardButton[i][j].setIcon(Main.currentGame.board.getTile()[i][j].getIcon());
			 }
		 }
	}

	public void updateButtons() {
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
	public void updateText() {
		labelPlayer.setText("Tour de " + Main.currentGame.currentPlayer.getName() +" (" + Main.currentGame.currentPlayer.getColorString() + "). Prochain joueur: " + Main.currentGame.turns.getFirst().getName());
		
		
		String messageScore = "";
		//TODO: Ordonner la liste des joueurs en fonction de leur score. Algorithme de tri.
		//TODO: Ne s'affiche pas correctement
		for (int i = 0; i < Main.players.size(); i++) {
			messageScore += Main.players.get(i).getName() + ":\t\t" + Main.players.get(i).getPoints() + "\r\n";
		}
		labelScore.setText(messageScore);
		
		if (currentCommand == 8) {
			labelStone.setText("?");
			labelIce.setText("?");
			labelWood.setText("?");
		} else {
			labelStone.setText("" + Main.currentGame.currentPlayer.getWalls(0));
			labelIce.setText("" + Main.currentGame.currentPlayer.getWalls(1));
			labelWood.setText("" + Main.currentGame.currentPlayer.getWalls(2));
		}
	}
	
	public void newTurn() {
		currentCommand = 8;
		updateHand();
		updateText();
		JOptionPane.showMessageDialog(null, "C'est le tour de " + Main.currentGame.currentPlayer.getName() , "Tour " + Main.currentGame.turnCounter, JOptionPane.INFORMATION_MESSAGE);
		currentCommand = 0;
		hasAdded = false;
		updateButtons();
		update();
	}
	
	public void update() {
		updateText();
		updateBoard();
		updateHand();
	}
}
