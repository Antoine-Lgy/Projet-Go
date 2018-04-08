package moteur;

import java.awt.Color;
import java.util.ArrayList;

import boardComponent.Intersection;
import boardComponent.Territory;
import ihm.gameScreen;

public class Score {
	
	public static int BScoreCount(Intersection[][] board) {
		
		int BlackScore = 0;
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++){
				if (board[i][j].getColor() == Color.BLACK) {
					BlackScore++;
				}
			}
		}
		return BlackScore;
	}
	
	public static int WScoreCount(Intersection[][] board) {
		
		int WhiteScore = 0;
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++){
				if (board[i][j].getColor() == Color.WHITE) {
					WhiteScore++;
				}
			}
		}
		return WhiteScore;
	}

	public static int RScoreCount(Intersection[][] board) {
	
		int RedScore = 0;
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++){
				if (board[i][j].getColor() == Color.RED) {
					RedScore++;
				}
			}
		}
		return RedScore;
	}
	
}
