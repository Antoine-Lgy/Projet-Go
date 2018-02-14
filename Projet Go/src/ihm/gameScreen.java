/**
 * 
 */
package ihm;

import javax.swing.JFrame;

/**
 * @author Antoine
 *
 */
public class gameScreen  extends JFrame{

	public gameScreen(){
		
		this.setTitle("Goban");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
}
