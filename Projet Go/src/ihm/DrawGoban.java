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
	int tour = 0;
    private JButton[][] tabButton = new JButton[20][20];
	
    public DrawGoban(int nbPlayer){
    	if (nbPlayer == 2){
    		tour = 10;
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
				tabButton[lig][col].setBorderPainted(true); //Button visibility
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
		//this.remove(tabButton[valCPT][valI]);  //Ne fonctionne pas.
		try {
			this.drawStone(x+valCOL*28,y+valLIG*28);//placer la pierre sur ces coordonner
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void drawStone(int x, int y) throws IOException {
		Image white,black,red ;
		white= ImageIO.read(new File("/Users/Antoine/Desktop/projet GO/img GO/whitePiece.png"));//image d'une pierre blanche
		black= ImageIO.read(new File("/Users/Antoine/Desktop/projet GO/img GO/blackPiece.png"));//image d'une pierre noir
		red= ImageIO.read(new File("/Users/Antoine/Desktop/projet GO/img GO/redPiece.png"));//image d'une pierre rouge
		if(tour==0){
			getGraphics().drawImage(black, x-8, y-8, 40,40, this);
			tour=1;
		}
		else if (tour==1) {
			getGraphics().drawImage(white, x-8, y-8, 40,40, this);
			tour=2;
		}
		else if (tour==2) {
			getGraphics().drawImage(red, x-8, y-8, 40,40, this);
			tour=0;
		}
		else if(tour==10){
			getGraphics().drawImage(black, x-8, y-8, 40,40, this);
			tour=11;
		}
		else if(tour==11){
			getGraphics().drawImage(white, x-8, y-8, 40,40, this);
			tour=10;
		}
	}
}
