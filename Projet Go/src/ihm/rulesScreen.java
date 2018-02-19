/**
 * 
 */
package ihm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import ihm.secondScreen.back;
import ihm.secondScreen.exit;

/**
 * @author Antoine
 *
 */
public class rulesScreen extends JFrame implements ItemListener{
	
	JPanel cards;
	
	public rulesScreen() {
		
		this.setTitle("Goban");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = {"Normal rules", "Spécial rules"};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
		
        JPanel card1 = new JPanel();
        JLabel a = new JLabel("page 1");
        card1.add(a);
        
        JPanel card2 = new JPanel();
        JLabel b = new JLabel("page 2");
        card2.add(b);
        
        cards = new JPanel(new CardLayout());
        cards.add(card1, "Normal rules");
        cards.add(card2, "Spécial rules");
        
        this.add(comboBoxPane, BorderLayout.PAGE_START);
        this.add(cards, BorderLayout.CENTER);
		
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
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)e.getItem());
	}
}
