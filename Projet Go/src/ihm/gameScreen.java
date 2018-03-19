/**
 * 
 */
package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Antoine
 *
 */
public class gameScreen  extends JFrame{

	public gameScreen(int nbPlayer){
		
		this.setTitle("Goban");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(950, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		//Menu.
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		JMenuItem exitItem = new JMenuItem("Quit");
		exitItem.addActionListener(new exit());
		JMenuItem backItem = new JMenuItem("Back to title screen");
		backItem.addActionListener(new back());
		menu.add(backItem);
		menu.addSeparator();
		menu.add(exitItem);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		
		//Center.
		this.add(new DrawGoban(nbPlayer), BorderLayout.CENTER);
		
		///Line_END.
		//Score.
		JTextField blackScore = new JTextField("Black score");
		JTextField whiteScore = new JTextField("White score");
		JTextField redScore = new JTextField("Red score");
		blackScore.setEditable(false);
		blackScore.setPreferredSize(new Dimension(120,80));
		blackScore.setHorizontalAlignment(JTextField.CENTER);
		whiteScore.setEditable(false);
		whiteScore.setPreferredSize(new Dimension(120,80));
		whiteScore.setHorizontalAlignment(JTextField.CENTER);
		redScore.setEditable(false);
		redScore.setPreferredSize(new Dimension(120,80));
		redScore.setHorizontalAlignment(JTextField.CENTER);
		JPanel scorePanel = new JPanel();
		scorePanel.setLayout(new FlowLayout());
		scorePanel.add(blackScore);
		scorePanel.add(whiteScore);
		scorePanel.add(redScore);
		
		//Player list.
		JLabel bl = new JLabel("J1                          ");
		JLabel wh = new JLabel("J2");
		JLabel re = new JLabel("                          J3");
		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(new FlowLayout());
		playerPanel.add(bl);
		playerPanel.add(wh);
		playerPanel.add(re);
		
		//Special piece button.
		JButton spe1black = new JButton("Black archer");
		JButton spe1white = new JButton("White archer");
		JButton spe1red = new JButton("Red archer");
		JPanel spe1Panel = new JPanel();
		spe1Panel.setLayout(new FlowLayout());
		spe1Panel.add(spe1black);
		spe1Panel.add(spe1white);
		spe1Panel.add(spe1red);
		
		JButton spe2black = new JButton("Black mage");
		JButton spe2white = new JButton("White mage");
		JButton spe2red = new JButton("Red mage");
		JPanel spe2Panel = new JPanel();
		spe2Panel.setLayout(new FlowLayout());
		spe2Panel.add(spe2black);
		spe2Panel.add(spe2white);
		spe2Panel.add(spe2red);
		
		JButton spe3black = new JButton("Black monk");
		JButton spe3white = new JButton("White monk");
		JButton spe3red = new JButton("Red monk");
		JPanel spe3Panel = new JPanel();
		spe3Panel.setLayout(new FlowLayout());
		spe3Panel.add(spe3black);
		spe3Panel.add(spe3white);
		spe3Panel.add(spe3red);
		
		JButton spe4black = new JButton("Black warrior");
		JButton spe4white = new JButton("White warrior");
		JButton spe4red = new JButton("Red warrior");
		JPanel spe4Panel = new JPanel();
		spe4Panel.setLayout(new FlowLayout());
		spe4Panel.add(spe4black);
		spe4Panel.add(spe4white);
		spe4Panel.add(spe4red);
		
		JButton cancelButton = new JButton("Cancel");
		JButton passButton = new JButton("Pass");
		JCheckBox noobMode = new JCheckBox("Beginner mode");
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black,1));
		buttonPanel.setLayout(new GridLayout());
		buttonPanel.add(cancelButton);
		buttonPanel.add(passButton);
		buttonPanel.add(noobMode);
		
		
		JPanel b2 = new JPanel();
		b2.setLayout(new BoxLayout(b2, BoxLayout.PAGE_AXIS));
		b2.add(scorePanel);
		b2.add(playerPanel);
		b2.add(spe1Panel);
		b2.add(spe2Panel);
		b2.add(spe3Panel);
		b2.add(spe4Panel);
		b2.add(buttonPanel);
		
		
		this.add(b2, BorderLayout.LINE_END);
		
	}
	
	class exit implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	class back implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new firstScreen();
			dispose();
		}
	}
	
}
