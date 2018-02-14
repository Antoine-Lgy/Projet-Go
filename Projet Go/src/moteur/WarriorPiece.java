package moteur;

public class WarriorPiece extends Piece {
	
	//color = couleur du joueur actuel
	
	public static void Warrior(int x, int y, String colo, String[][] board) {
		abs = x;
		ord = y;
		color = colo;
		if (board[x][y] == "void") {
			board[x][y] = color;
			CallToArms(x,y, board);
		}
	}
	
	
	public static void CallToArms(int x, int y, String[][] board) {
		if (x<19){
			if (board[x+1][y] == "void") {
				board[x+1][y] = color;	
			}
		}
		if (x>0){
			if (board[x-1][y] == "void") {
				board[x-1][y] = color;
			}
		}
		if (y<19){
			if (board[x][y+1] == "void") {
				board[x][y+1] = color;	
			}	
		}
		if (y>0){
			if (board[x][y-1] == "void") {
				board[x][y-1] = color;
			}	
		}
	}
}
