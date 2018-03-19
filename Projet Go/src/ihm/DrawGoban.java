package ihm;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawGoban extends JPanel implements ActionListener{

	//private boolean tour=false;
	int Player = 0;
    private JButton[][] tabButton = new JButton[20][20];
    private static String[][] tabPng = new String[20][20];
	
    public DrawGoban(int nbPlayer){
    	if (nbPlayer == 2){
    		Player = 10;
    	}
    }
    
	public void paintComponent(Graphics g){
		try {
		Image img = ImageIO.read(new File("/Users/Antoine/Desktop/projet GO/img GO/GobanFinal.png")); //Read the image 
		g.drawImage(img, 0, 0, 556, 556, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setLayout(null);
		//Create a button on each intersection.
		for(int lig=0,c=0;lig<20;lig++,c=c+28){
			for(int col=0,l=0;col<20;col++,l=l+28){
				tabButton[lig][col] = new JButton();
				tabButton[lig][col].setBorderPainted(false); //Button visibility
				tabButton[lig][col].setBounds((int) l,(int) c,26,26);
				tabButton[lig][col].disable(); //If setBorderPainted is true, buttons are transparent.
				this.add(tabButton[lig][col]);
				tabButton[lig][col].addActionListener(this);
				tabButton[lig][col].setActionCommand(Integer.toString(lig)+","+Integer.toString(col));
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Point point=this.getLocation(); // on recupere la position du bouton cliquer pour y placer la pierre 
		int x =(int)point.getX();
		int y=(int)point.getY();
		String values[]  = e.getActionCommand().split(",");
		int valLIG = Integer.parseInt(values[0]);
		int valCOL = Integer.parseInt(values[1]);
		try {
			this.addPngInTab(valCOL,valLIG);  //Ajoute une Image dans un tableau.
			this.drawTabPng(e);  //Dessine tout le tableau tabPng.
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void drawTabPng(ActionEvent e) throws IOException {
		Point point=this.getLocation(); // on recupere la position du bouton cliquer pour y placer la pierre 
		int x =(int)point.getX();
		int y=(int)point.getY();
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++){
				if (getTabPng()[i][j] == null){
					
				}
				else {
					Image img = ImageIO.read(new File(getTabPng()[i][j]));
					getGraphics().drawImage(img, x-8+j*28, y-8+i*28, 40, 40, this);
				}
			}
		}
	}
	
	private void addPngInTab(int x, int y) throws IOException {
		String white,black,red ;
		white= "/Users/Antoine/Desktop/projet GO/img GO/whitePiece.png";//image d'une pierre blanche
		black= "/Users/Antoine/Desktop/projet GO/img GO/blackPiece.png";//image d'une pierre noir
		red= "/Users/Antoine/Desktop/projet GO/img GO/redPiece.png";//image d'une pierre rouge
		if(Player==0){
			getTabPng()[y][x] = black;
			Player=1;
		}
		else if (Player==1) {
			getTabPng()[y][x] = white;
			Player=2;
		}
		else if (Player==2) {
			getTabPng()[y][x] = red;
			Player=0;
		}
		else if(Player==10){
			getTabPng()[y][x] = black;
			Player=11;
		}
		else if(Player==11){
			getTabPng()[y][x] = white;
			Player=10;
		}
	}

	public static String[][] getTabPng() {
		return tabPng;
	}
}
