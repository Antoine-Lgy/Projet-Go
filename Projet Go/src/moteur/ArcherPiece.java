package moteur;

import java.util.Scanner;

public class ArcherPiece extends Piece{
	

	
	//color = couleur du joueur actuel
	
	public static void Archer(int x, int y, String colo, String[][] board ,String direc) {
		abs = x;
		ord = y;
		color = colo;
		if (board[x][y] == "void") {
			board[x][y] = color;
			/*System.out.println("Chose a direction (right, left, up, down)");
			Scanner sc = new Scanner(System.in);
			String direc = sc.nextLine();
			sc.close();*/
			Arrow(x,y, board, direc);
		}
	}
	
	
	public static void Arrow(int x, int y, String[][] board, String direction) {
		int i=0;
		if (direction == "left"){
			while (x>=0 && i<4) {
				board[x][y-1] = "void";
				i++;
				y--;
			}
		}
		else if (direction == "right"){
			while (x<=20 && i<4) {
				board[x][y+1] = "void";
				i++;
				y++;
			}
		}
		else if (direction == "up"){
			while (y>=0 && i<4) {
				board[x-1][y] = "void";
				i++;
				x--;
			}
		}
		else if (direction == "down"){
			while (y<=20 && i<4) {
				board[x-1][y] = "void";
				i++;
				x++;
			}	
		}
	}

}
