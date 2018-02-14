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
import javax.swing.JPanel;

import ihm.firstScreen.startButton;

/**
 * @author Antoine
 *
 */
public class secondScreen extends JFrame{

	protected JComboBox compoList;
	protected JButton start = new JButton("Start");
	protected JButton get = new JButton("get");
	
	
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
		b1.setLayout(new BoxLayout(b1, BoxLayout.PAGE_AXIS));
		JPanel comboxPanel = new JPanel();
		comboxPanel.setLayout(new FlowLayout());
		Object[] elements = new Object[]{"J vs J", "J vs IA", "IA vs IA", "J vs J vs J", "J vs J vs IA", "J vs IA vs IA"};
		compoList = new JComboBox(elements);
		comboxPanel.add(compoList);
		
		b1.add(comboxPanel);
		b1.add(start);
		b1.add(get);
		start.addActionListener(new start2Button());
		get.addActionListener(new getButton());
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		get.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(b1);
		
	}
	
	class getButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println(compoList.getSelectedItem());
		}
	}
	
	class start2Button implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new gameScreen();
			dispose();
		}
	}
	
}
