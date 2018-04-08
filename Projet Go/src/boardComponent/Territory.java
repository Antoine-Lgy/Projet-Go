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
	
	protected static ArrayList<Color> ListeColAutour = new ArrayList<Color>();
	public static ArrayList<Intersection> Ensemble = new ArrayList<Intersection>();
	public static Color CaptureColor = null;
	
	public static void ResetList(){
		ListeColAutour = new ArrayList<Color>();
	}
	public static void ResetEns(){
		Ensemble = new ArrayList<Intersection>();
	}
	
	//Prevent posing a piece in an eye.
	public static boolean eye(Intersection[][] board, int x, int y){
		if(x>0 && x<(board.length-1) && y>0 && y<(board.length-1)){
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
		if (x==(board.length-1) && y==0){
			if (board[x-1][y].getColor() != null && board[x][y+1].getColor() != null){
				Color couleurTest = board[x-1][y].getColor();
				if (board[x][y+1].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		if (x==0 && y==(board.length-1)){
			if (board[x+1][y].getColor() != null && board[x][y-1].getColor() != null){
				Color couleurTest = board[x+1][y].getColor();
				if (board[x][y-1].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		if (x==(board.length-1) && y==(board.length-1)){
			if (board[x-1][y].getColor() != null && board[x][y-1].getColor() != null){
				Color couleurTest = board[x-1][y].getColor();
				if (board[x][y-1].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		//Ligne du Haut.
		if (x==0 && y!=0 && y!=(board.length-1)){
			if (board[x+1][y].getColor() != null && board[x][y+1].getColor() != null && board[x][y-1].getColor() != null){
				Color couleurTest = board[x+1][y].getColor();
				if (board[x][y+1].getColor().equals(couleurTest) && board[x][y-1].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		//Ligne de Gauche.
		if (y==0 && x!=0 && x!=(board.length-1)){
			if (board[x+1][y].getColor() != null && board[x][y+1].getColor() != null && board[x-1][y].getColor() != null){
				Color couleurTest = board[x+1][y].getColor();
				if (board[x][y+1].getColor().equals(couleurTest) && board[x-1][y].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		//Ligne du Bas.
		if (x==(board.length-1) && y!=(board.length-1) && y!=0){
			if (board[x-1][y].getColor() != null && board[x][y+1].getColor() != null && board[x][y-1].getColor() != null){
				Color couleurTest = board[x-1][y].getColor();
				if (board[x][y+1].getColor().equals(couleurTest) && board[x][y-1].getColor().equals(couleurTest) && board[x][y].getColor() != couleurTest){
					return true;
				}
			}
		}
		//Ligne de Droite.
		if (y==(board.length-1) && x!= (board.length-1) && x!=0){
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
		
		CaptureColor = null;
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
						CaptureColor = CaptCol;
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
		//System.out.println(String.format("testAutour inter(%d:%d)", inter.abscisse, inter.ordonnee));
		if (inter.bCalled) {
			System.out.println(String.format("===> ERROR : already called"));
			return;
		}
		inter.bCalled = true;
		Color CurCol = inter.getColor();
		Intersection nextInter = null;
		Color nextCol = null;
		
		nextInter = inter.getLN();
		nextCol = nextInter.getColor();
		if (nextCol == CurCol){
			if (!nextInter.bCalled){
				testAutour(nextInter);
			}
		}
		else {
			ListeColAutour.add(nextCol);
		}
		
		nextInter = inter.getLS();
		nextCol = nextInter.getColor();
		if (nextCol == CurCol){
			if (!nextInter.bCalled){
				testAutour(nextInter);
			}
		}
		else {
			ListeColAutour.add(nextCol);
		}
		
		nextInter = inter.getLE();
		nextCol = nextInter.getColor();
		if (nextCol == CurCol){
			if (!nextInter.bCalled){
				testAutour(nextInter);
			}
		}
		else {
			ListeColAutour.add(nextCol);
		}
		
		nextInter = inter.getLO();
		nextCol = nextInter.getColor();
		if (nextCol == CurCol){
			if (!nextInter.bCalled){
				testAutour(nextInter);
			}
		}
		else {
			ListeColAutour.add(nextCol);
		}
	}
	
	//Create an arrayList with piece of the same color, close fitting.
	public static void EnsembleMC(Intersection CurInter) {
		Color LaColor = CurInter.getColor();
		if (CurInter.getColor() != null){
			Ensemble.add(CurInter);
			CurInter.inEnsMC = true;
			if (CurInter.getLN().getColor() == LaColor){
				if (!Ensemble.contains(CurInter.getLN())){
					EnsembleMC(CurInter.getLN());
				}
			}
			if (CurInter.getLS().getColor() == LaColor){
				if (!Ensemble.contains(CurInter.getLS())){
					EnsembleMC(CurInter.getLS());
				}
			}
			if (CurInter.getLE().getColor() == LaColor){
				if (!Ensemble.contains(CurInter.getLE())){
					EnsembleMC(CurInter.getLE());
				}
			}
			if (CurInter.getLO().getColor() == LaColor){
				if (!Ensemble.contains(CurInter.getLO())){
					EnsembleMC(CurInter.getLO());
				}
			}
		}
	}
	
	public static void EnsembleNULL(Intersection CurInter) {
		Color LaColor = CurInter.getColor();
		if (CurInter.getColor() == null){
			Ensemble.add(CurInter);
			CurInter.inEnsNULL = true;
			if (CurInter.getLN().getColor() == LaColor){
				if (!Ensemble.contains(CurInter.getLN())){
					EnsembleNULL(CurInter.getLN());
				}
			}
			if (CurInter.getLS().getColor() == LaColor){
				if (!Ensemble.contains(CurInter.getLS())){
					EnsembleNULL(CurInter.getLS());
				}
			}
			if (CurInter.getLE().getColor() == LaColor){
				if (!Ensemble.contains(CurInter.getLE())){
					EnsembleNULL(CurInter.getLE());
				}
			}
			if (CurInter.getLO().getColor() == LaColor){
				if (!Ensemble.contains(CurInter.getLO())){
					EnsembleNULL(CurInter.getLO());
				}
			}
		}
	}
}
