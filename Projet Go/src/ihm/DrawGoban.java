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

	private boolean tour=false;
    private JButton[][] tabButton = new JButton[20][20];
	
	public void paintComponent(Graphics g){
		try {
		Image img = ImageIO.read(new File("/Users/Antoine/Desktop/projet GO/img GO/GobanFinal.png"));//je lis mon image 
		g.drawImage(img, 0, 0, 556, 556, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setLayout(null);
		//Create a button on each intersection.
		for(int cpt=0,c=0;cpt<20;cpt++,c=c+28){
			for(int i=0,l=0;i<20;i++,l=l+28){
				tabButton[cpt][i] = new JButton();
				tabButton[cpt][i].setBorderPainted(false); //Button visibility
				tabButton[cpt][i].setBounds((int) l,(int) c,26,26);
				//tabButton[cpt][i].disable(); //If setBorderPainted is true, buttons are transparent.
				this.add(tabButton[cpt][i]);
				tabButton[cpt][i].addActionListener(this);
				tabButton[cpt][i].setActionCommand(Integer.toString(cpt)+","+Integer.toString(i));
			}
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		Point point=this.getLocation();// on recupere la position du click pour y placer la pierre 
		int x =(int)point.getX();
		int y=(int)point.getY();
		String values[]  = e.getActionCommand().split(",");
		int valCPT = Integer.parseInt(values[0]);
		int valI = Integer.parseInt(values[1]);
		//this.remove(tabButton[valCPT][valI]);  //Ne fonctionne pas.
		try {
			this.drawStone(x+valI*28,y+valCPT*28);//placer la pierre sur ces coordonner
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void drawStone(int x, int y) throws IOException {
		Image white,black ;
		white= ImageIO.read(new File("/Users/Antoine/Desktop/projet GO/img GO/whitePiece.png"));//image d'une pierre blanche
		black= ImageIO.read(new File("/Users/Antoine/Desktop/projet GO/img GO/blackPiece.png"));//image d'une pierre noir
		if(tour==true){
			getGraphics().drawImage(white, x-8, y-8, 40,40, this);
			tour=false;
		}
		else if (tour==false) {
			getGraphics().drawImage(black, x-8, y-8, 40,40, this);
			tour=true;
		}
	}
}
