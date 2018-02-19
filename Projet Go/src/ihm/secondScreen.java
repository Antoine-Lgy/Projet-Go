/**
 * 
 */
package ihm;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import ihm.firstScreen.startButton;
import ihm.gameScreen.back;
import ihm.gameScreen.exit;

/**
 * @author Antoine
 *
 */
public class secondScreen extends JFrame{

	protected JComboBox compoList;
	protected JButton start = new JButton("Start");
	
	public secondScreen() {
		
		this.setTitle("Goban");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		//Screen view.
		JPanel b1 = new JPanel();
		b1.setLayout(new FlowLayout());
		JPanel comboxPanel = new JPanel();
		comboxPanel.setLayout(new FlowLayout());
		Object[] elements = new Object[]{"J vs J", "J vs IA", "IA vs IA", "J vs J vs J", "J vs J vs IA", "J vs IA vs IA"};
		compoList = new JComboBox(elements);
		comboxPanel.add(compoList);
		
		b1.add(comboxPanel);
		b1.add(start);
		start.addActionListener(new start2Button());
		this.add(b1);
		
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
	
	class start2Button implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new gameScreen();
			dispose();
		}
	}
	
	public String getCompo(){
		return compoList.getSelectedItem().toString();
	}
	
}
