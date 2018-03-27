package moteur;

import java.awt.Color;

import boardComponent.Intersection;

public class WarriorPiece extends Piece {
	
	public static void CallToArms(Intersection[][] board, Color couleur, int x, int y) {
		if (x<19){
			if (board[x+1][y].getColor() == null) {
				board[x+1][y].setColor(couleur);	
			}
		}
		if (x>0){
			if (board[x-1][y].getColor() == null) {
				board[x-1][y].setColor(couleur);
			}
		}
		if (y<19){
			if (board[x][y+1].getColor() == null) {
				board[x][y+1].setColor(couleur);
			}	
		}
		if (y>0){
			if (board[x][y-1].getColor() == null) {
				board[x][y-1].setColor(couleur);
			}	
		}
		board[x][y].setColor(couleur);
	}
}
