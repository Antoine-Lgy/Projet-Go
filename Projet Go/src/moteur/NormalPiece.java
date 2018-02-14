package moteur;

public class NormalPiece extends Piece{
	
	public static void Normal(int x, int y, String colo, String[][] board) {
		abs = x;
		ord = y;
		color = colo;
		if (board[x][y] == "void") {
			board[x][y] = color;
		}
	}

}
