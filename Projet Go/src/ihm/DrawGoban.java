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
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import boardComponent.Intersection;
import boardComponent.Territory;
import moteur.ArcherPiece;
import moteur.MagePiece;
import moteur.MonkPiece;
import moteur.NormalPiece;
import moteur.Score;
import moteur.WarriorPiece;

public class DrawGoban extends JPanel implements MouseListener{

	int Player = 0;
	int PassNumLim = 3;
	int ActualPassNum = 3;
    Intersection[][] tabInter = new Intersection[20][20];
    private Intersection lastIntersection = null;
	private String type = "normal";
	public gameScreen myGameScreen;
	public Image img;
	
    public DrawGoban(int nbPlayer){
    	try {
			img = ImageIO.read(new File("/Users/Antoine/Desktop/projet GO/img GO/GobanFinal.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if (nbPlayer == 2){
    		Player = 10;
    		PassNumLim = 2;
    		ActualPassNum = 2;
    	}
    	//Create an object Intersection on each intersection.
    	for(int lig=0;lig<20;lig++){
    		for(int col=0;col<20;col++){
    			tabInter[lig][col] = new Intersection(13+col*28,13+lig*28,null);
    		}
    	}
    	for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++){
				if (i>0 && i<19 && j>0 && j<19) {
					tabInter[i][j].setLN(tabInter[i-1][j]);
					tabInter[i][j].setLS(tabInter[i+1][j]);
					tabInter[i][j].setLD(tabInter[i][j+1]);
					tabInter[i][j].setLG(tabInter[i][j-1]);
				}
				if (i==0 && j==0){
					tabInter[i][j].setLN(new Intersection());
					tabInter[i][j].setLS(tabInter[i+1][j]);
					tabInter[i][j].setLD(tabInter[i][j+1]);
					tabInter[i][j].setLG(new Intersection());
				}
				if (i==0 && j==19){
					tabInter[i][j].setLN(new Intersection());
					tabInter[i][j].setLS(tabInter[i+1][j]);
					tabInter[i][j].setLD(new Intersection());
					tabInter[i][j].setLG(tabInter[i][j-1]);
				}
				if (i==19 && j==0){
					tabInter[i][j].setLN(tabInter[i-1][j]);
					tabInter[i][j].setLS(new Intersection());
					tabInter[i][j].setLD(tabInter[i][j+1]);
					tabInter[i][j].setLG(new Intersection());
				}
				if (i==19 && j==19){
					tabInter[i][j].setLN(tabInter[i-1][j]);
					tabInter[i][j].setLS(new Intersection());
					tabInter[i][j].setLD(new Intersection());
					tabInter[i][j].setLG(tabInter[i][j-1]);
				}
				if (i==0 && j!=0 && j!=19){
					tabInter[i][j].setLN(new Intersection());
					tabInter[i][j].setLS(tabInter[i+1][j]);
					tabInter[i][j].setLD(tabInter[i][j+1]);
					tabInter[i][j].setLG(tabInter[i][j-1]);
				}
				if (i==19 && j!=19 && j!=0){
					tabInter[i][j].setLN(tabInter[i-1][j]);
					tabInter[i][j].setLS(new Intersection());
					tabInter[i][j].setLD(tabInter[i][j+1]);
					tabInter[i][j].setLG(tabInter[i][j-1]);
				}
				if (j==0 && i!=0 && i!=19){
					tabInter[i][j].setLN(tabInter[i-1][j]);
					tabInter[i][j].setLS(tabInter[i+1][j]);
					tabInter[i][j].setLD(tabInter[i][j+1]);
					tabInter[i][j].setLG(new Intersection());
				}
				if (j==19 && i!= 19 && i!=0){
					tabInter[i][j].setLN(tabInter[i-1][j]);
					tabInter[i][j].setLS(tabInter[i+1][j]);
					tabInter[i][j].setLD(new Intersection());
					tabInter[i][j].setLG(tabInter[i][j-1]);
				}
			}
    	}
    	this.addMouseListener(this);
    }
    
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, 556, 556, this);
		this.drawTabPng(g);
	}
	
	private void drawTabPng(Graphics g) {
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++){
				if (tabInter[i][j].getColor() == null){
					
				}
				else {
					int x = tabInter[i][j].getAbscisse();
					int y = tabInter[i][j].getOrdonnee();
					/*if (Territory.eye(tabInter, i, j) == true){
						tabInter[i][j].setColor(null);
					}*/
					Territory.ResetList();
					Territory.ResetEns();
					for (int i1=0; i1<20; i1++) {
						for (int j1=0; j1<20; j1++){
							tabInter[i1][j1].setCaller(null);
							tabInter[i1][j1].setCalled(null);
						}
					}
					Territory.EnsembleMC(tabInter[i][j]);
					if (Territory.GrandTer(Territory.Ensemble) == true){
						ArrayList<Intersection> EnsTest = Territory.Ensemble;
						for(int a = 0; a < EnsTest.size(); a++){
							EnsTest.get(a).setColor(null);
						}
					}
					
					g.setColor(tabInter[i][j].getColor());
					g.fillOval(x-12, y-12, 24, 24);
				}
			}
		}
		this.repaint();
	}
	
	private void addPngInTab(int x, int y) {
		Color white,black,red ;
		white= Color.WHITE;//image d'une pierre blanche
		black= Color.BLACK;//image d'une pierre noir
		red= Color.RED;//image d'une pierre rouge
		if(tabInter[y][x].getColor()==null) {
			if (Territory.eye(tabInter, y, x) == false){
			if (type=="normal") {
				if(Player==0){
					NormalPiece.Normal(tabInter,black,y,x);
					Player=1;
				}
				else if (Player==1) {
					NormalPiece.Normal(tabInter,white,y,x);
					Player=2;
				}
				else if (Player==2) {
					NormalPiece.Normal(tabInter,red,y,x);
					Player=0;
				}
				else if(Player==10){
					NormalPiece.Normal(tabInter,black,y,x);
					Player=11;
				}
				else if(Player==11){
					NormalPiece.Normal(tabInter,white,y,x);
					Player=10;
				}
			}
			if (type=="warrior") {
				if(Player==0){
					WarriorPiece.CallToArms(tabInter,black,y,x);
					Player=1;
				}
				else if (Player==1) {
					WarriorPiece.CallToArms(tabInter,white,y,x);
					Player=2;
				}
				else if (Player==2) {
					WarriorPiece.CallToArms(tabInter,red,y,x);
					Player=0;
				}
				else if(Player==10){
					WarriorPiece.CallToArms(tabInter,black,y,x);
					Player=11;
				}
				else if(Player==11){
					WarriorPiece.CallToArms(tabInter,white,y,x);
					Player=10;
				}
				type = "normal";
			}
			if (type=="monk") {
				if(Player==0){
					MonkPiece.Convert(tabInter,black,y,x);
					Player=1;
				}
				else if (Player==1) {
					MonkPiece.Convert(tabInter,white,y,x);
					Player=2;
				}
				else if (Player==2) {
					MonkPiece.Convert(tabInter,red,y,x);
					Player=0;
				}
				else if(Player==10){
					MonkPiece.Convert(tabInter,black,y,x);
					Player=11;
				}
				else if(Player==11){
					MonkPiece.Convert(tabInter,white,y,x);
					Player=10;
				}
				type = "normal";
			}
			if (type=="mage") {
				if(Player==0){
					MagePiece.Blast(tabInter,black,y,x);
					Player=1;
				}
				else if (Player==1) {
					MagePiece.Blast(tabInter,white,y,x);
					Player=2;
				}
				else if (Player==2) {
					MagePiece.Blast(tabInter,red,y,x);
					Player=0;
				}
				else if(Player==10){
					MagePiece.Blast(tabInter,black,y,x);
					Player=11;
				}
				else if(Player==11){
					MagePiece.Blast(tabInter,white,y,x);
					Player=10;
				}
				type = "normal";
			}
			if (type=="archer") {
				JOptionPane jop = new JOptionPane();
			    String direc = jop.showInputDialog(null, "Chose a direction (right, left, up, down):", "Arrow", JOptionPane.QUESTION_MESSAGE);
				if(Player==0){
					ArcherPiece.Arrow(tabInter,black,y,x,direc);
					Player=1;
				}
				else if (Player==1) {
					ArcherPiece.Arrow(tabInter,white,y,x,direc);
					Player=2;
				}
				else if (Player==2) {
					ArcherPiece.Arrow(tabInter,red,y,x,direc);
					Player=0;
				}
				else if(Player==10){
					ArcherPiece.Arrow(tabInter,black,y,x,direc);
					Player=11;
				}
				else if(Player==11){
					ArcherPiece.Arrow(tabInter,white,y,x,direc);
					Player=10;
				}
				type = "normal";
			}
			tabInter[y][x].setPrevIntersection(lastIntersection);
			lastIntersection = tabInter[y][x];
		}
		}
	}
	
	//Retourne un coup en avant.
	public void Undo() {
		if (lastIntersection != null) {
			lastIntersection.setColor(null);
			lastIntersection = lastIntersection.getPrevIntersection();
			repaint();
			if(Player==0){
				Player=2;
			}
			else if (Player==1) {
				Player=0;
			}
			else if (Player==2) {
				Player=1;
			}
			else if(Player==10){
				Player=11;
			}
			else if(Player==11){
				Player=10;
			}
		}
	}
	
	public void Pass() {
		if(Player==0){
			Player=1;
		}
		else if (Player==1) {
			Player=2;
		}
		else if (Player==2) {
			Player=0;
		}
		else if(Player==10){
			Player=11;
		}
		else if(Player==11){
			Player=10;
		}
		ActualPassNum--;
		if (ActualPassNum == 1){
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, "Si le prochain joueur passe son tour, la partie sera finie.", null, JOptionPane.INFORMATION_MESSAGE);
		}
		if (ActualPassNum == 0){
			Player = 5;
			JOptionPane jop = new JOptionPane();
			int Bs = Score.BScoreCount(tabInter);
			int Ws = Score.WScoreCount(tabInter);
			int Rs = Score.RScoreCount(tabInter);
			if (PassNumLim == 3){
				if (Bs > Ws && Bs > Rs) {
					jop.showMessageDialog(null, "Fin de la partie, Le jouer Noir à gagné !" + " Noir : "+ Bs + "  Blanc : "+ Ws + "  Rouge : "+ Rs, null, JOptionPane.INFORMATION_MESSAGE);
				}
				if (Ws > Bs && Ws > Rs) {
					jop.showMessageDialog(null, "Fin de la partie, Le jouer Blanc à gagné !" + " Noir : "+ Bs + "  Blanc : "+ Ws + "  Rouge : "+ Rs, null, JOptionPane.INFORMATION_MESSAGE);
				}
				if (Rs > Ws && Rs > Bs) {
					jop.showMessageDialog(null, "Fin de la partie, Le jouer Rouge à gagné !" + " Noir : "+ Bs + "  Blanc : "+ Ws + "  Rouge : "+ Rs, null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else {
				if (Bs > Ws && Bs > Rs) {
					jop.showMessageDialog(null, "Fin de la partie, Le jouer Noir à gagné !" + " Noir : "+ Bs + "  Blanc : "+ Ws, null, JOptionPane.INFORMATION_MESSAGE);
				}
				if (Ws > Bs && Ws > Rs) {
					jop.showMessageDialog(null, "Fin de la partie, Le jouer Blanc à gagné !" + " Noir : "+ Bs + "  Blanc : "+ Ws, null, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	public void setGameScreen(gameScreen myGS){
		myGameScreen = myGS;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int xclic = e.getX()/28;
		int yclic = e.getY()/28;
		this.addPngInTab(xclic, yclic);
		this.repaint();
		ActualPassNum = PassNumLim;
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
	
	public void setType(String type){
		this.type = type;
	}
	
	public Intersection[][] getTab(){
		return tabInter;
	}
}
