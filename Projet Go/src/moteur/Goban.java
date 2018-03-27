package moteur;

import playerType.Human;
import playerType.Player;
import boardComponent.Intersection;


public class Goban {

	
	public static Intersection[][] board(){
		Intersection[][] board = new Intersection [20][20];
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++){
				board[i][j]= null;
			}
		}
		return board;
	}
	
	public static boolean FullGoban(Intersection[][] board) {
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++){
				if (board[i][j]== null) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		Intersection [][] bor= board();
		//playerType.Game.InitGame("JvJ");
		//playerType.Game.RunGame("JvJ", bor, p1, p2);
		
		/*
		WarriorPiece.Warrior(5,5,"red", bor);
		MagePiece.Mage(6, 6, "black", bor);
		MonkPiece.Monk(6, 4, "white", bor);
		ArcherPiece.Archer(5, 7, "blue", bor);
		NormalPiece.Normal(3, 3, "red", bor);
		*/
		
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++){
				System.out.print(bor[i][j] + "	");	
			}System.out.println();
		}
		
	}
}
