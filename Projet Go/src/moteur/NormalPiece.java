package moteur;

import java.awt.Color;

import boardComponent.Intersection;

public class NormalPiece extends Piece{
	
	public static void Normal(Intersection[][] board, Color couleur, int ord, int abs) {
		board[ord][abs].setColor(couleur);
	}

}
