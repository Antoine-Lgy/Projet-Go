package moteur;

public class MagePiece extends Piece{
	
	//color = couleur du joueur actuel
	
	public static void Mage(int x, int y, String colo, String[][] board) {
		abs = x;
		ord = y;
		color = colo;
		if (board[x][y] == "void") {
			board[x][y] = color;
			Blast(x,y, board);
		}
	}
	
	
	public static void Blast(int x, int y, String[][] board) {
		if (x<19 && y<19){
			if (board[x+1][y+1] != "void") {
				board[x+1][y+1] = "void";	
			}
		}
		if (x>0 && y<19){
			if (board[x-1][y+1] != "void") {
				board[x-1][y+1] = "void";
			}
		}
		if (y>0 && x>0){
			if (board[x-1][y-1] != "void") {
				board[x-1][y-1] = "void";	
			}	
		}
		if (y>0 && x<19){
			if (board[x+1][y-1] != "void") {
				board[x+1][y-1] = "void";
			}	
		}
	}
}


