package moteur;

import java.awt.Color;

import boardComponent.Intersection;
import boardComponent.Territory;
import ihm.gameScreen;

public class Score {
	
	public static int BScoreCount(Intersection[][] board) {
		
		int BlackScore = 0;
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++){
				if (board[i][j].getColor() == Color.BLACK) {
					BlackScore++;
				}
				if (Territory.eye(board, i, j) == true){
					if (i>0 && i<19 && j>0 && j<19) {
						if (board[i+1][j].getColor() == Color.BLACK){
							BlackScore++;
						}
					}
					if (i==0 && j==0){
						if (board[i+1][j].getColor() == Color.BLACK){
							BlackScore++;
						}
					}
					if (i==0 && j==19){
						if (board[i+1][j].getColor() == Color.BLACK){
							BlackScore++;
						}
					}
					if (i==19 && j==0){
						if (board[i-1][j].getColor() == Color.BLACK){
							BlackScore++;
						}
					}
					if (i==19 && j==19){
						if (board[i-1][j].getColor() == Color.BLACK){
							BlackScore++;
						}
					}
					if (i==0 && j!=0 && j!=19){
						if (board[i+1][j].getColor() == Color.BLACK){
							BlackScore++;
						}
					}
					if (i==19 && j!=19 && j!=0){
						if (board[i-1][j].getColor() == Color.BLACK){
							BlackScore++;
						}
					}
					if (j==0 && i!=0 && i!=19){
						if (board[i][j+1].getColor() == Color.BLACK){
							BlackScore++;
						}
					}
					if (j==19 && i!= 19 && i!=0){
						if (board[i][j-1].getColor() == Color.BLACK){
							BlackScore++;
						}
					}
				}
			}
		}
		return BlackScore;
	}
	
	public static int WScoreCount(Intersection[][] board) {
		
		int WhiteScore = 0;
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++){
				if (board[i][j].getColor() == Color.WHITE) {
					WhiteScore++;
				}
				if (Territory.eye(board, i, j) == true){
					if (i>0 && i<19 && j>0 && j<19) {
						if (board[i+1][j].getColor() == Color.WHITE){
							WhiteScore++;
						}
					}
					if (i==0 && j==0){
						if (board[i+1][j].getColor() == Color.WHITE){
							WhiteScore++;
						}
					}
					if (i==0 && j==19){
						if (board[i+1][j].getColor() == Color.WHITE){
							WhiteScore++;
						}
					}
					if (i==19 && j==0){
						if (board[i-1][j].getColor() == Color.WHITE){
							WhiteScore++;
						}
					}
					if (i==19 && j==19){
						if (board[i-1][j].getColor() == Color.WHITE){
							WhiteScore++;
						}
					}
					if (i==0 && j!=0 && j!=19){
						if (board[i+1][j].getColor() == Color.WHITE){
							WhiteScore++;
						}
					}
					if (i==19 && j!=19 && j!=0){
						if (board[i-1][j].getColor() == Color.WHITE){
							WhiteScore++;
						}
					}
					if (j==0 && i!=0 && i!=19){
						if (board[i][j+1].getColor() == Color.WHITE){
							WhiteScore++;
						}
					}
					if (j==19 && i!= 19 && i!=0){
						if (board[i][j-1].getColor() == Color.WHITE){
							WhiteScore++;
						}
					}
				}
			}
		}
		return WhiteScore;
	}

	public static int RScoreCount(Intersection[][] board) {
	
		int RedScore = 0;
		for (int i=0; i<20; i++) {
			for (int j=0; j<20; j++){
				if (board[i][j].getColor() == Color.RED) {
					RedScore++;
				}
				if (Territory.eye(board, i, j) == true){
					if (i>0 && i<19 && j>0 && j<19) {
						if (board[i+1][j].getColor() == Color.RED){
							RedScore++;
						}
					}
					if (i==0 && j==0){
						if (board[i+1][j].getColor() == Color.RED){
							RedScore++;
						}
					}
					if (i==0 && j==19){
						if (board[i+1][j].getColor() == Color.RED){
							RedScore++;
						}
					}
					if (i==19 && j==0){
						if (board[i-1][j].getColor() == Color.RED){
							RedScore++;
						}
					}
					if (i==19 && j==19){
						if (board[i-1][j].getColor() == Color.RED){
							RedScore++;
						}
					}
					if (i==0 && j!=0 && j!=19){
						if (board[i+1][j].getColor() == Color.RED){
							RedScore++;
						}
					}
					if (i==19 && j!=19 && j!=0){
						if (board[i-1][j].getColor() == Color.RED){
							RedScore++;
						}
					}
					if (j==0 && i!=0 && i!=19){
						if (board[i][j+1].getColor() == Color.RED){
							RedScore++;
						}
					}
					if (j==19 && i!= 19 && i!=0){
						if (board[i][j-1].getColor() == Color.RED){
							RedScore++;
						}
					}
				}
			}
		}
		return RedScore;
	}
	
}
