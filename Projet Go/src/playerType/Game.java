/**
 * 
 */
package playerType;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Antoine
 *
 */
public class Game {
	
	protected HashMap<String,Player> composition;
	
	
	public static void RunGame(/*HashMap<String,Player> comp,*/ int nbPlayers, String[][] board) {
		while (!moteur.Goban.FullGoban(board) ) {		//Boucle de jeu, passer à ajouter
			for (int i=0; i<nbPlayers; i++) {
				Turn(board);
			}
			
		}
	}
	

	public static void Turn(String[][] board /*,int x, int y*/) {
		
		System.out.println("Abs?");		//get the abs
		Scanner scx = new Scanner(System.in);
		int x = scx.nextInt();
		scx.close();
		
		System.out.println("Ord?");		//get the ord
		Scanner scy = new Scanner(System.in);
		int y = scy.nextInt();
		scy.close();
		
		System.out.println("What type of piece? (nm, arc, mon, war, mag)");		//get the type
		Scanner sc = new Scanner(System.in);
		String piece = sc.nextLine();
		sc.close();
		
		if (piece == "nm") {
			moteur.NormalPiece.Normal(x, y, Player.getColor(), board);
		}
		if (piece == "arc") {
			moteur.ArcherPiece.Archer(x, y, Player.getColor(), board);
		}
		if (piece == "mon") {
			moteur.MonkPiece.Monk(x, y, Player.getColor(), board);
		}
		if (piece == "war") {
			moteur.WarriorPiece.Warrior(x, y, Player.getColor(), board);
		}
		if (piece == "mag") {
			moteur.MagePiece.Mage(x, y, Player.getColor(), board);
		}
	}
	
}
