/**
 * 
 */
package boardComponent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Antoine
 *
 */
public class Territory {
	
	protected static ArrayList<Color> ListeColAutour = new ArrayList<Color>();
	public static ArrayList<Intersection> Ensemble = new ArrayList<Intersection>();
	
	public static void ResetList(){
		ListeColAutour = new ArrayList<Color>();
	}
	public static void ResetEns(){
		Ensemble = new ArrayList<Intersection>();
	}
	
	//Prevent posing a piece in an eye.
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
		//Ligne du Haut.
		if (x==0 && y!=0 && y!=19){
			if (board[x+1][y].getColor() != null && board[x][y+1].getColor() != null && board[x][y-1].getColor() != null){
				Color couleurTest = board[x+1][y].getColor();
				if (board[x][y+1].getColor().equals(couleurTest) && board[x][y-1].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		//Ligne de Gauche.
		if (y==0 && x!=0 && x!=19){
			if (board[x+1][y].getColor() != null && board[x][y+1].getColor() != null && board[x-1][y].getColor() != null){
				Color couleurTest = board[x+1][y].getColor();
				if (board[x][y+1].getColor().equals(couleurTest) && board[x-1][y].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		//Ligne du Bas.
		if (x==19 && y!=19 && y!=0){
			if (board[x-1][y].getColor() != null && board[x][y+1].getColor() != null && board[x][y-1].getColor() != null){
				Color couleurTest = board[x-1][y].getColor();
				if (board[x][y+1].getColor().equals(couleurTest) && board[x][y-1].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		//Ligne de Droite.
		if (y==19 && x!= 19 && x!=0){
			if (board[x+1][y].getColor() != null && board[x][y-1].getColor() != null && board[x-1][y].getColor() != null){
				Color couleurTest = board[x+1][y].getColor();
				if (board[x][y-1].getColor().equals(couleurTest) && board[x-1][y].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		return false;
	}
	
	//Return true if the group is surrounded by an other color or the edge of the board.
	public static boolean GrandTer(ArrayList<Intersection> EnsTest){
		
		testAutour(EnsTest.get(0));
		if (ListeColAutour.size() >= 4){
			Color CaptCol = null;
			for (int i=0; i < ListeColAutour.size();i++){
				
				if (ListeColAutour.get(i) == Color.GRAY){
					continue;
				}
				else{
					if (CaptCol == null){
						CaptCol = ListeColAutour.get(i);
					}
				}
				if (CaptCol != ListeColAutour.get(i) || ListeColAutour.get(i) == null){
					return false;
				}
			}
			return true;
		}
		else{
			return false;
		}
	}
	
	//Create an arrayList of close fitting piece, and verify if its surrounded by different colors pieces.
	public static void testAutour(Intersection inter){
		Color CurCol = inter.getColor();
		Color LNCol = null;
		Color LSCol = null;
		Color LDCol = null;
		Color LGCol = null;
		Color CurCaptCol = null;
		
		if (inter.getLN().getColor() == CurCol){
			if (inter.getCaller() != inter.getLN() && inter.getCalled() != inter.getLN()){
				inter.getLN().setCaller(inter);
				inter.setCalled(inter.getLN());
				testAutour(inter.getLN());
			}
		}
		else {
			LNCol = inter.getLN().getColor();
			ListeColAutour.add(LNCol);
		}
		if (inter.getLS().getColor() == CurCol){
			if (inter.getCaller() != inter.getLS() && inter.getCalled() != inter.getLS()){
				inter.getLS().setCaller(inter);
				inter.setCalled(inter.getLS());
				testAutour(inter.getLS());
			}
		}
		else {
			LSCol = inter.getLS().getColor();
			ListeColAutour.add(LSCol);
		}
		if (inter.getLD().getColor() == CurCol){
			if (inter.getCaller() != inter.getLD() && inter.getCalled() != inter.getLD()){
				inter.getLD().setCaller(inter);
				inter.setCalled(inter.getLD());
				testAutour(inter.getLD());
			}
		}
		else {
			LDCol = inter.getLD().getColor();
			ListeColAutour.add(LDCol);
		}
		if (inter.getLG().getColor() == CurCol){
			if (inter.getCaller() != inter.getLG() && inter.getCalled() != inter.getLG()){
				inter.getLG().setCaller(inter);
				inter.setCalled(inter.getLG());
				testAutour(inter.getLG());
			}
		}
		else {
			LGCol = inter.getLG().getColor();
			ListeColAutour.add(LGCol);
		}
	}
	
	//Create an arrayList with piece of the same color, close fitting.
	public static void EnsembleMC(Intersection CurInter) {
		Color LaColor = CurInter.getColor();
		if (CurInter.getColor() != null){
			Ensemble.add(CurInter);
			if (CurInter.getLN().getColor() == LaColor){
				if (!Ensemble.contains(CurInter.getLN())){
					Ensemble.add(CurInter.getLN());
					EnsembleMC(CurInter.getLN());
				}
			}
			if (CurInter.getLS().getColor() == LaColor){
				if (!Ensemble.contains(CurInter.getLS())){
					Ensemble.add(CurInter.getLS());
					EnsembleMC(CurInter.getLS());
				}
			}
			if (CurInter.getLD().getColor() == LaColor){
				if (!Ensemble.contains(CurInter.getLD())){
					Ensemble.add(CurInter.getLD());
					EnsembleMC(CurInter.getLD());
				}
			}
			if (CurInter.getLG().getColor() == LaColor){
				if (!Ensemble.contains(CurInter.getLG())){
					Ensemble.add(CurInter.getLG());
					EnsembleMC(CurInter.getLG());
				}
			}
		}
	}
}
