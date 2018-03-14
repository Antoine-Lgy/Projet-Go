package ihm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawGoban extends JPanel implements ActionListener{

	private boolean tour=false;
	
	public void paintComponent(Graphics g){
		try {
		Image img = ImageIO.read(new File("/Users/Antoine/Desktop/projet GO/img GO/GobanFinal.png"));//je lis mon image 
		g.drawImage(img, 0, 0, 556, 556, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setLayout(null);
		//Create a button on each intersection.
		for(double cpt=0,c=0;cpt<20;cpt++,c=c+28){
			for(double i=0,l=0;i<20;i++,l=l+28){
				JButton goLeftCase= new JButton();
				goLeftCase.setBorderPainted(false); //Button visibility
				goLeftCase.setBounds((int) l,(int) c,26,26);
				//goLeftCase.disable(); //If setBorderPainted is true, buttons are transparent.
				this.add(goLeftCase);
				goLeftCase.addActionListener(this);
				
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Point point=this.getMousePosition();// on recupere la position du click pour y placer la piere 
		int x =(int)point.getX();
		int y=(int)point.getY();
		try {
			this.drawStone(x,y);//placer la pierre sur ces coordonner
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void drawStone(int x, int y) throws IOException {
		Image white,black ;
		white= ImageIO.read(new File("/Users/Antoine/Desktop/projet GO/img GO/whitePiece.png"));//image d'une pierre blanche
		black= ImageIO.read(new File("/Users/Antoine/Desktop/projet GO/img GO/blackPiece.png"));//image d'une pierre noir
		if(tour==true){
			getGraphics().drawImage(white, x-22, y-22, 40,40, this);
			tour=false;
		}
		else if (tour==false) {
			getGraphics().drawImage(black, x-22, y-22, 40,40, this);
			tour=true;
		}
	}
	
}
