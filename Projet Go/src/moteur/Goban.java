package moteur;
public class Goban {

	
	public static String[][] board(){
		String[][] board = new String [20][20];
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++){
				board[i][j]= "void";
			}
		}
		return board;
	}
	
	
	public static void main(String[] args) {
		String [][] bor= board();
		WarriorPiece.Warrior(5,5,"red", bor);
		MagePiece.Mage(6, 6, "black", bor);
		MonkPiece.Monk(6, 4, "white", bor);
		ArcherPiece.Archer(5, 7, "ez", bor, "left");
		NormalPiece.Normal(3, 3, "red", bor);
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++){
				System.out.print(bor[i][j] + "	");	
			}System.out.println();
		}
		
	}
}
