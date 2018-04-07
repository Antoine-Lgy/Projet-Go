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
import java.awt.event.MouseEvent;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import boardComponent.Intersection;
import moteur.Score;

/**
 * @author Antoine
 *
 */
public class gameScreen  extends JFrame{

	DrawGoban myGoban = null;
	JTextField blackScore;
	JTextField whiteScore;
	JTextField redScore;
	JButton spe1black;
	JButton spe1white;
	JButton spe1red;
	JButton spe2black;
	JButton spe2white;
	JButton spe2red;
	JButton spe3black;
	JButton spe3white;
	JButton spe3red;
	JButton spe4black;
	JButton spe4white;
	JButton spe4red;
	JButton cancelButton;
	
	public gameScreen(int nbPlayer, int nbIA){
		
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
		myGoban = new DrawGoban(nbPlayer,nbIA);
		myGoban.setGameScreen(this);
		this.add(myGoban, BorderLayout.CENTER);
		
		///Line_END.
		//Score.
		blackScore = new JTextField("Black score");
		whiteScore = new JTextField("White score");
		redScore = new JTextField("Red score");
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
		spe1black = new JButton("Black archer");
		spe1black.addActionListener(new bArcher());
		spe1white = new JButton("White archer");
		spe1white.addActionListener(new wArcher());
		spe1red = new JButton("Red archer");
		spe1red.addActionListener(new rArcher());
		JPanel spe1Panel = new JPanel();
		spe1Panel.setLayout(new FlowLayout());
		spe1Panel.add(spe1black);
		spe1Panel.add(spe1white);
		spe1Panel.add(spe1red);
		
		spe2black = new JButton("Black mage");
		spe2black.addActionListener(new bMage());
		spe2white = new JButton("White mage");
		spe2white.addActionListener(new wMage());
		spe2red = new JButton("Red mage");
		spe2red.addActionListener(new rMage());
		JPanel spe2Panel = new JPanel();
		spe2Panel.setLayout(new FlowLayout());
		spe2Panel.add(spe2black);
		spe2Panel.add(spe2white);
		spe2Panel.add(spe2red);
		
		spe3black = new JButton("Black monk");
		spe3black.addActionListener(new bMonk());
		spe3white = new JButton("White monk");
		spe3white.addActionListener(new wMonk());
		spe3red = new JButton("Red monk");
		spe3red.addActionListener(new rMonk());
		JPanel spe3Panel = new JPanel();
		spe3Panel.setLayout(new FlowLayout());
		spe3Panel.add(spe3black);
		spe3Panel.add(spe3white);
		spe3Panel.add(spe3red);
		
		spe4black = new JButton("Black warrior");
		spe4black.addActionListener(new bWarrior());
		spe4white = new JButton("White warrior");
		spe4white.addActionListener(new wWarrior());
		spe4red = new JButton("Red warrior");
		spe4red.addActionListener(new rWarrior());
		JPanel spe4Panel = new JPanel();
		spe4Panel.setLayout(new FlowLayout());
		spe4Panel.add(spe4black);
		spe4Panel.add(spe4white);
		spe4Panel.add(spe4red);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionCancel());
		JButton passButton = new JButton("Pass");
		passButton.addActionListener(new ActionPass());
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
	
	class ActionCancel implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			myGoban.Undo();
			cancelButton.setEnabled(false);
		}
	}
	
	class ActionPass implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			myGoban.Pass();
		}
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
	
	class bArcher implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			myGoban.setType("archer");
			spe1black.setEnabled(false);
		}
	}
	
	class wArcher implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			myGoban.setType("archer");
			spe1white.setEnabled(false);
		}
	}
	
	class rArcher implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			myGoban.setType("archer");
			spe1red.setEnabled(false);
		}
	}
	
	class bMage implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			myGoban.setType("mage");
			spe2black.setEnabled(false);
		}
	}
	
	class wMage implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			myGoban.setType("mage");
			spe2white.setEnabled(false);
		}
	}
	
	class rMage implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			myGoban.setType("mage");
			spe2red.setEnabled(false);
		}
	}
	
	class bMonk implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			myGoban.setType("monk");
			spe3black.setEnabled(false);
		}
	}
	
	class wMonk implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			myGoban.setType("monk");
			spe3white.setEnabled(false);
		}
	}
	
	class rMonk implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			myGoban.setType("monk");
			spe3red.setEnabled(false);
		}
	}
	
	class bWarrior implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			myGoban.setType("warrior");
			spe4black.setEnabled(false);
		}
	}
	
	class wWarrior implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			myGoban.setType("warrior");
			spe4white.setEnabled(false);
		}
	}
	
	class rWarrior implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			myGoban.setType("warrior");
			spe4red.setEnabled(false);
		}
	}
	
	public void setBScore(int i){
		String BScore =  Integer.toString(i);
		blackScore.setText(BScore);
	}
	public void setWScore(int i){
		String WScore =  Integer.toString(i);
		whiteScore.setText(WScore);
	}
	public void setRScore(int i){
		String RScore =  Integer.toString(i);
		redScore.setText(RScore);
	}
	
	public void ShowScore(int scoreBlTer,int scoreWhTer,int scoreReTer){
		Intersection[][] GobTab = myGoban.getTab();
		int Bs = Score.BScoreCount(GobTab) + scoreBlTer;
		int Ws = Score.WScoreCount(GobTab) + scoreWhTer;
		int Rs = Score.RScoreCount(GobTab) + scoreReTer;
		setBScore(Bs);
		setWScore(Ws);
		setRScore(Rs);
	}

}
