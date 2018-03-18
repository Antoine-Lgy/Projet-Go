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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ihm.secondScreen.back;
import ihm.secondScreen.exit;

/**
 * @author Antoine
 *
 */
public class rulesScreen extends JFrame implements ItemListener{
	
	JPanel cards;
	
	private JTextArea textPane= new JTextArea("On ne peut pas poser une pierre sur une intersection déjà occupée. De même on ne peut pas poser une pierre sur une intersection vide si elle n’a pu de libertés dans le cas où l’on ne peut rien capturer.\n" + 
			"Un joueur peut passer son tour, principalement pour indiquer qu’il a finis sa partie. Lorsque tous les joueurs passent  consécutivement la partie s’arrête et le comptage des points, comprenant les intersections vides constituants les territoires, "
			+ "les prisonniers de chaque joueur et le komi des joueurs le possédant, s’effectue pour désigner le vainqueur.Un joueur ne doit pas redonner au goban un état identique à l’un de ceux qu’il a eu précédemment.\n");
	private JScrollPane scroll=new JScrollPane(textPane);
	
	private JTextArea textPane2= new JTextArea("Le méga-pion est posé sur l’intersection rouge et pose automatiquement des pions, ici représentés en rouge pour facilité la visualisation, sur les intersections voisines qui sont libres.\n" + 
			"Le méga-pion « mage » qui supprime les pions, de notre couleur ou non, sur les diagonales dans un rayon de 2 intersections autour de la future position de la pierre. Il est donc important de faire attention avant de l’utiliser \n" + 
			"Le méga-pion se situe sur l’intersection rouge et détruit les pions  sur les deux prochaines intersections sur les différentes diagonales.");
	
	private JScrollPane scroll2=new JScrollPane(textPane2);
	
	
	public rulesScreen() {
		
		
		
		this.setTitle("Goban");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(500, 500);
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
       
        textPane.setLineWrap(true);
        textPane.setWrapStyleWord(true);
        textPane.setEditable(false);
        textPane.setRows(20);
        textPane.setColumns(40);
        
        scroll.setWheelScrollingEnabled(true);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        //card1.add(textPane, BorderLayout.CENTER);
        card1.add(scroll, BorderLayout.CENTER);
        
        
        JPanel card2 = new JPanel();
       
        textPane2.setLineWrap(true);
        textPane2.setWrapStyleWord(true);
        textPane2.setEditable(false);
        textPane2.setRows(20);
        textPane2.setColumns(40);
        scroll2.setWheelScrollingEnabled(true);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        scroll2.setSize(1000,100);
        card2.add(scroll2, BorderLayout.CENTER);
        
        
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
