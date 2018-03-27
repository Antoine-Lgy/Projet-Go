package moteur;

import java.awt.Color;

import boardComponent.Intersection;

public class MagePiece extends Piece{
	
	public static void Blast(Intersection[][] board, Color couleur, int x, int y) {
		if (x<19 && y<19){
			if (board[x+1][y+1].getColor() != null) {
				board[x+1][y+1].setColor(null);
			}
		}
		if (x>0 && y<19){
			if (board[x-1][y+1].getColor() != null) {
				board[x-1][y+1].setColor(null);
			}
		}
		if (y>0 && x>0){
			if (board[x-1][y-1].getColor() != null) {
				board[x-1][y-1].setColor(null);
			}	
		}
		if (y>0 && x<19){
			if (board[x+1][y-1].getColor() != null) {
				board[x+1][y-1].setColor(null);
			}	
		}
		board[x][y].setColor(couleur);
	}
}


