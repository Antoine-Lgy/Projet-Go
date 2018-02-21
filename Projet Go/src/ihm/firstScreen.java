/**
 * 
 */
package ihm;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Antoine
 *
 */
public class firstScreen extends JFrame{
	
	protected JButton startGame = new JButton("Start Game");
	protected JButton quitGame = new JButton("Quit Game");
	protected JButton rules = new JButton("Rules");
	protected JLabel nameGame = new JLabel("围棋");
	
	public firstScreen() {

		initLayout();
		
	}
	
	protected void initLayout(){
		this.setTitle("Goban");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(300, 150);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		//Screen view.
		JPanel b1 = new JPanel();
		b1.setLayout(new BoxLayout(b1, BoxLayout.PAGE_AXIS));
		b1.add(nameGame);
		b1.add(startGame);
		b1.add(rules);
		b1.add(quitGame);
		startGame.addActionListener(new startButton());
		quitGame.addActionListener(new quitButton());
		rules.addActionListener(new rulesButton());
		nameGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		Font nameFont = new Font("Arial",Font.BOLD,30);
		nameGame.setFont(nameFont);
		startGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		quitGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		rules.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.getContentPane().add(b1);
		
	}

	class quitButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	class startButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new secondScreen();
			dispose();
		}
	}
	
	class rulesButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new rulesScreen();
			dispose();
		}
	}
	
	public static void main(String[] args){
		new firstScreen();
	}

}
