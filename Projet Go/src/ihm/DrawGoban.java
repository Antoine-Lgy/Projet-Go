package ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import boardComponent.Intersection;

public class DrawGoban extends JPanel implements MouseListener{

	//private boolean tour=false;
	int Player = 0;
    private Intersection[][] tabInter = new Intersection[20][20];
	
    public DrawGoban(int nbPlayer){
    	if (nbPlayer == 2){
    		Player = 10;
    	}
    	//Create a button on each intersection.
    	for(int lig=0;lig<20;lig++){
    		for(int col=0;col<20;col++){
    			tabInter[lig][col] = new Intersection(13+col*28,13+lig*28,null);
    		}
    	}
    	this.addMouseListener(this);
    }
    
	public void paintComponent(Graphics g){
		try {
		Image img = ImageIO.read(new File("/Users/Antoine/Desktop/projet GO/img GO/GobanFinal.png")); //Read the image 
		g.drawImage(img, 0, 0, 556, 556, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			this.drawTabPng(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Image img = ImageIO.read(new File(tabInter[0][0].getPngColor()));
		//g.drawImage(img, x-8, y-8, 40, 40, this);
		/*
		g.fillOval(1, 1, 24, 24);
		g.setColor(Color.WHITE);
		g.fillOval(28, 1, 24, 24);
		*/
		/*
		//Create a button on each intersection.
		for(int lig=0,c=0;lig<20;lig++,c=c+28){
			for(int col=0,l=0;col<20;col++,l=l+28){
				tabInter[lig][col] = new Intersection(13+lig*28,13+col*28,lig,col,null);
				//tabInter[lig][col].setBorderPainted(false); //Button visibility
				//tabInter[lig][col].setBounds((int) l,(int) c,26,26);
				//tabInter[lig][col].disable(); //If setBorderPainted is true, buttons are transparent.
				//this.add(tabInter[lig][col]);
				//tabInter[lig][col].addActionListener(this);
				//tabInter[lig][col].setActionCommand(Integer.toString(lig)+","+Integer.toString(col));
			}
		}
		this.addMouseListener(this);
		*/
	}
	
	/*public void actionPerformed(ActionEvent e) {
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
	}*/
	
	private void drawTabPng(Graphics g) throws IOException {
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++){
				if (tabInter[i][j].getColor() == null){
					
				}
				else {
					int x = tabInter[i][j].getAbscisse();
					int y = tabInter[i][j].getOrdonnee();
					g.setColor(tabInter[i][j].getColor());
					g.fillOval(x-12, y-12, 24, 24);
				}
			}
		}
	}
	
	private void addPngInTab(int x, int y) throws IOException {
		Color white,black,red ;
		white= Color.WHITE;//image d'une pierre blanche
		black= Color.BLACK;//image d'une pierre noir
		red= Color.RED;//image d'une pierre rouge
		if(Player==0){
			tabInter[y][x].setColor(black);
			Player=1;
		}
		else if (Player==1) {
			tabInter[y][x].setColor(white);
			Player=2;
		}
		else if (Player==2) {
			tabInter[y][x].setColor(red);
			Player=0;
		}
		else if(Player==10){
			tabInter[y][x].setColor(black);
			Player=11;
		}
		else if(Player==11){
			tabInter[y][x].setColor(white);
			Player=10;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int xclic = e.getX()/28;
		int yclic = e.getY()/28;
		try {
			this.addPngInTab(xclic,yclic);
			this.repaint();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
