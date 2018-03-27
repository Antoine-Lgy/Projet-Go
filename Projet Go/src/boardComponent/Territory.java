/**
 * 
 */
package boardComponent;
import java.awt.Color;
import java.util.ArrayList;

/**
 * @author Antoine
 *
 */
public class Territory {

	public static boolean eye(Intersection[][] board, int x, int y){
		Intersection currentInter = board[x][y];
		if(x>0 && x<19 && y>0 && y<19){
			if (board[x+1][y].getColor() != null && board[x-1][y].getColor() != null && board[x][y+1].getColor() != null && board[x][y-1].getColor() != null){
				Color couleurTest = board[x+1][y].getColor();
				if (board[x-1][y].getColor().equals(couleurTest) && board[x][y+1].getColor().equals(couleurTest) && board[x][y-1].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		if (x==0 && y==0){
			if (board[x+1][y].getColor() != null && board[x][y+1].getColor() != null){
				Color couleurTest = board[x+1][y].getColor();
				if (board[x][y+1].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		if (x==19 && y==0){
			if (board[x-1][y].getColor() != null && board[x][y+1].getColor() != null){
				Color couleurTest = board[x-1][y].getColor();
				if (board[x][y+1].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		if (x==0 && y==19){
			if (board[x+1][y].getColor() != null && board[x][y-1].getColor() != null){
				Color couleurTest = board[x+1][y].getColor();
				if (board[x][y-1].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		if (x==19 && y==19){
			if (board[x-1][y].getColor() != null && board[x][y-1].getColor() != null){
				Color couleurTest = board[x-1][y].getColor();
				if (board[x][y-1].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		if (x==0){
			if (board[x+1][y].getColor() != null && board[x][y+1].getColor() != null && board[x][y-1].getColor() != null){
				Color couleurTest = board[x+1][y].getColor();
				if (board[x][y+1].getColor().equals(couleurTest) && board[x][y-1].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		if (y==0 && x!=19){
			if (board[x+1][y].getColor() != null && board[x][y+1].getColor() != null && board[x-1][y].getColor() != null){
				Color couleurTest = board[x+1][y].getColor();
				if (board[x][y+1].getColor().equals(couleurTest) && board[x-1][y].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		if (x==19){
			if (board[x-1][y].getColor() != null && board[x][y+1].getColor() != null && board[x][y-1].getColor() != null){
				Color couleurTest = board[x-1][y].getColor();
				if (board[x][y+1].getColor().equals(couleurTest) && board[x][y-1].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		if (y==19 && x!= 19){
			if (board[x+1][y].getColor() != null && board[x][y-1].getColor() != null && board[x-1][y].getColor() != null){
				Color couleurTest = board[x+1][y].getColor();
				if (board[x][y-1].getColor().equals(couleurTest) && board[x-1][y].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		return false;
	}
	
}
