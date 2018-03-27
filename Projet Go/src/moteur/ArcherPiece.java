package moteur;

import java.awt.Color;
import java.util.Scanner;

import boardComponent.Intersection;

public class ArcherPiece extends Piece{
	
	public static void Arrow(Intersection[][] board, Color couleur, int x, int y, String direction) {
		int i;
		if (direction.equals("left")){
			for (i=0;i<=4;i++){
				if (y-1-i >= 0){
					board[x][y-1-i].setColor(null);
				}
			}
		}
		else if (direction.equals("right")){
			for (i=0;i<=4;i++){
				if (y+1+i <= 19){
					board[x][y+1+i].setColor(null);
				}
			}
		}
		else if (direction.equals("up")){
			for (i=0;i<=4;i++){
				if (x-1-i >= 0){
					board[x-1-i][y].setColor(null);
				}
			}
		}
		else if (direction.equals("down")){
			for (i=1;i<=4;i++){
				if (x+1+i <= 19){
					board[x+1+i][y].setColor(null);
				}
			}	
		}
		board[x][y].setColor(couleur);
	}

}
