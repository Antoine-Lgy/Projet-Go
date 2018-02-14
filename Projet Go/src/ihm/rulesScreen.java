/**
 * 
 */
package ihm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Antoine
 *
 */
public class rulesScreen extends JFrame implements ItemListener{
	
	JPanel cards;
	protected JLabel a = new JLabel("page 1");
	protected JLabel b = new JLabel("page 2");
	
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
        card1.add(a);
        
        JPanel card2 = new JPanel();
        card2.add(b);
        
        cards = new JPanel(new CardLayout());
        cards.add(card1, "Normal rules");
        cards.add(card2, "Spécial rules");
        
        this.add(comboBoxPane, BorderLayout.PAGE_START);
        this.add(cards, BorderLayout.CENTER);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)e.getItem());
	}
}
