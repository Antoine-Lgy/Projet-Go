/**
 * 
 */
package ihm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
		this.add(new DrawGoban(), BorderLayout.CENTER);
		
		//Line_END.
		JButton blackScore = new JButton("a");
		JButton whiteScore = new JButton("b");
		JButton redScore = new JButton("c");
		/*JPanel c = new JPanel();
		c.setLayout(new FlowLayout());
		c.add(blackScore);
		c.add(whiteScore);
		this.add(c, BorderLayout.LINE_END);
		*/
		JPanel d = new JPanel();
		d.setLayout(new FlowLayout());
		d.add(blackScore);
		d.add(whiteScore);
		d.add(redScore);
		this.add(d, BorderLayout.LINE_END);
		
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
