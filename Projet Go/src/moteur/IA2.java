/**
 *
 */
package moteur;

import boardComponent.Intersection;
import boardComponent.Territory;
import java.awt.*;

/**
 * @author Antoine
 *
 */
public class IA2{

	
	public Intersection IATurn(Intersection[][] board, Color colo) {		//fonction rep�sentant le tour de l'IA
		int Taille  = board.length;
		int eval[][] = new int[Taille][Taille]; //Tableau qui contient les valeurs de la fonction d'évaluation
		for (int i=1; i<(Taille-1); i++) {
			for (int j=1; j<(Taille-1); j++) {
				if (board[i][j].getColor() == null && !Territory.eye(board, i, j)) {
					eval[i][j]= Evaluation(board[i][j], i, j, board, colo);
				}else {
					eval[i][j]= -1000;
				}
			}
		}

		int choice = eval[0][0];
		int ichoice = 0;
		int jchoice = 0;
		for (int i=1; i<(Taille-1); i++) {
			for (int j=1; j<(Taille-1); j++) {
				if (eval[i][j] > choice) { //determination du meilleur choix possible
					choice = eval[i][j];
					ichoice = i;
					jchoice = j;
				}
			}
		}
		return board[ichoice][jchoice];			//retourne l'intersection la plus avantageuse
	}

	public int Evaluation(Intersection inter, int abs, int ord, Intersection[][] board, Color colo) {
//		int eval = PlayPiece(inter, colo, board) + Chaine(inter, colo, board) + DiagonalChaine(inter, colo, board) + Territory(inter, colo, board);
		int eval = PlayPiece(inter, colo, board) + Chaine(inter, colo, board) + DiagonalChaine(inter, colo, board);
		return eval;
	}


	public int PlayPiece(Intersection inter, Color colo, Intersection [][] board) {		//Le placement du pion agit sue l'�valuation
		if ((inter.getAbscisse()<2 || inter.getAbscisse()>17) && (inter.getOrdonnee()<2 || inter.getOrdonnee()>17)) {
			return 15;
		}else{
			return 10;
		}
	}

	public int Chaine(Intersection inter, Color colo, Intersection [][] board) {		//La formation d'une chaine droite est plus avantageuse
		if (inter.getLO().getColor() == colo || inter.getLE().getColor() == colo ||
			inter.getLN().getColor() == colo || inter.getLS().getColor() == colo){
			return 20;
		}else{
			return 0;
		}

	}

	public int DiagonalChaine(Intersection inter,Color colo, Intersection [][] board) {	//Une chaine diagonale l'est encore plus
		if (inter.getLNO().getColor() == colo || inter.getLSE().getColor() == colo ||
			inter.getLSO().getColor() == colo || inter.getLNE().getColor() == colo){
			return 30;
		}else{
			return 0;
		}
	}

	public int Territory(Intersection inter, Color colo, Intersection [][] board) {		// La formation d'un territoir est favorable
		if (isTerritory(inter, inter.getAbscisse(), inter.getOrdonnee(), board, colo) == 2) {
			return 50;
		}
		else if (isTerritory(inter, inter.getAbscisse(), inter.getOrdonnee(), board, colo) == 1){
			return 40;
		}
		else {
			return 0;
		}
	}

	public int isTerritory(Intersection inter, int abs, int ord, Intersection [][] board, Color colo) {		//d�termine si un territoir va etre form�
		int absstart = abs;
		int ordstart = ord;
		int length = 0;
		if (board[inter.getAbscisse()-1][ord-1].getColor() == colo){
			return TerritoryfromSE( absstart, ordstart, abs-1, ord-1, board, length+1, colo);
		}
		else if(board[inter.getAbscisse()+1][ord+1].getColor() == colo) {
			return TerritoryfromNW( absstart, ordstart, abs+1, ord+1, board, length+1, colo);
		}
		else if(board[inter.getAbscisse()+1][ord-1].getColor() == colo) {
			return TerritoryfromSW( absstart, ordstart, abs+1, ord-1, board, length+1, colo);
		}
		else if(board[inter.getAbscisse()-1][ord+1].getColor() == colo) {
			return TerritoryfromNE( absstart, ordstart, abs-1, ord+1, board, length+1, colo);
		}
		else if(board[inter.getAbscisse()-1][ord].getColor() == colo) {
			return TerritoryfromE( absstart, ordstart, abs-1, ord, board, length+1, colo);
		}
		else if(board[inter.getAbscisse()+1][ord].getColor() == colo) {
			return TerritoryfromW( absstart, ordstart, abs+1, ord, board, length+1, colo);
		}
		else if(board[inter.getAbscisse()][ord-1].getColor() == colo) {
			return TerritoryfromS( absstart, ordstart, abs, ord-1, board, length+1, colo);
		}
		else if(board[inter.getAbscisse()][ord+1].getColor() == colo) {
			return TerritoryfromN( absstart, ordstart, abs, ord+1, board, length+1, colo);
		}
		else {
			return 0;
		}
	}

	public int TerritoryfromN(int absstart, int ordstart, int abs, int ord, Intersection [][] board, int length, Color colo) {
		if ((absstart == abs) && (ordstart == ord)){
			if (length >7) {
				return 2;
			}else {
				return 1;
			}
		}
		else if (board[abs-1][ord-1].getColor() == colo){
			return TerritoryfromSE( absstart, ordstart, abs-1, ord-1, board, length+1, colo);
		}
		else if(board[abs+1][ord+1].getColor() == colo) {
			return TerritoryfromNW( absstart, ordstart, abs+1, ord+1, board, length+1, colo);
		}
		else if(board[abs+1][ord-1].getColor() == colo) {
			return TerritoryfromSW( absstart, ordstart, abs+1, ord-1, board, length+1, colo);
		}
		else if(board[abs-1][ord+1].getColor() == colo) {
			return TerritoryfromNE( absstart, ordstart, abs-1, ord+1, board, length+1, colo);
		}
		else if(board[abs-1][ord].getColor() == colo) {
			return TerritoryfromE( absstart, ordstart, abs-1, ord, board, length+1, colo);
		}
		else if(board[abs+1][ord].getColor() == colo) {
			return TerritoryfromW( absstart, ordstart, abs, ord-1, board, length+1, colo);
		}
		else if(board[abs][ord+1].getColor() == colo) {
			return TerritoryfromN( absstart, ordstart, abs, ord+1, board, length+1, colo);
		}
		else {
			return 0;
		}
	}

	public int TerritoryfromNE(int absstart, int ordstart, int abs, int ord, Intersection [][] board, int length, Color colo) {
		if ((absstart == abs) && (ordstart == ord)){
			if (length >7) {
				return 2;
			}else {
				return 1;
			}
		}
		else if (board[abs-1][ord-1].getColor() == colo){
			return TerritoryfromSE( absstart, ordstart, abs-1, ord-1, board, length+1, colo);
		}
		else if(board[abs+1][ord+1].getColor() == colo) {
			return TerritoryfromNW( absstart, ordstart, abs+1, ord+1, board, length+1, colo);
		}
		else if(board[abs+1][ord-1].getColor() == colo) {
			return TerritoryfromSW( absstart, ordstart, abs+1, ord-1, board, length+1, colo);
		}
		else if(board[abs-1][ord].getColor() == colo) {
			return TerritoryfromE( absstart, ordstart, abs-1, ord, board, length+1, colo);
		}
		else if(board[abs+1][ord].getColor() == colo) {
			return TerritoryfromW( absstart, ordstart, abs+1, ord, board, length+1, colo);
		}
		else if(board[abs][ord-1].getColor() == colo) {
			return TerritoryfromS( absstart, ordstart, abs, ord-1, board, length+1, colo);
		}
		else if(board[abs][ord+1].getColor() == colo) {
			return TerritoryfromN( absstart, ordstart, abs, ord+1, board, length+1, colo);
		}
		else {
			return 0;
		}
	}

	public int TerritoryfromE(int absstart, int ordstart, int abs, int ord, Intersection [][] board, int length, Color colo) {
		if ((absstart == abs) && (ordstart == ord)){
			if (length >7) {
				return 2;
			}else {
				return 1;
			}
		}
		else if (board[abs-1][ord-1].getColor() == colo){
			return TerritoryfromSE( absstart, ordstart, abs-1, ord-1, board, length+1, colo);
		}
		else if(board[abs+1][ord+1].getColor() == colo) {
			return TerritoryfromNW( absstart, ordstart, abs+1, ord+1, board, length+1, colo);
		}
		else if(board[abs+1][ord-1].getColor() == colo) {
			return TerritoryfromSW( absstart, ordstart, abs+1, ord-1, board, length+1, colo);
		}
		else if(board[abs-1][ord+1].getColor() == colo) {
			return TerritoryfromNE( absstart, ordstart, abs-1, ord+1, board, length+1, colo);
		}
		else if(board[abs-1][ord].getColor() == colo) {
			return TerritoryfromE( absstart, ordstart, abs-1, ord, board, length+1, colo);
		}
		else if(board[abs][ord-1].getColor() == colo) {
			return TerritoryfromS( absstart, ordstart, abs, ord-1, board, length+1, colo);
		}
		else if(board[abs][ord+1].getColor() == colo) {
			return TerritoryfromN( absstart, ordstart, abs, ord+1, board, length+1, colo);
		}
		else {
			return 0;
		}
	}

	public int TerritoryfromSE(int absstart, int ordstart, int abs, int ord, Intersection [][] board, int length, Color colo) {
		if ((absstart == abs) && (ordstart == ord)){
			if (length >7) {
				return 2;
			}else {
				return 1;
			}
		}
		else if(board[abs-1][ord-1].getColor() == colo) {
			return TerritoryfromSE( absstart, ordstart, abs-1, ord-1, board, length+1, colo);
		}
		else if(board[abs-1][ord+1].getColor() == colo) {
			return TerritoryfromNE( absstart, ordstart, abs+1, ord-1, board, length+1, colo);
		}
		else if(board[abs+1][ord-1].getColor() == colo) {
			return TerritoryfromSW( absstart, ordstart, abs-1, ord+1, board, length+1, colo);
		}
		else if(board[abs-1][ord].getColor() == colo) {
			return TerritoryfromE( absstart, ordstart, abs-1, ord, board, length+1, colo);
		}
		else if(board[abs+1][ord].getColor() == colo) {
			return TerritoryfromW( absstart, ordstart, abs+1, ord, board, length+1, colo);
		}
		else if(board[abs][ord-1].getColor() == colo) {
			return TerritoryfromS( absstart, ordstart, abs, ord-1, board, length+1, colo);
		}
		else if(board[abs][ord+1].getColor() == colo) {
			return TerritoryfromN( absstart, ordstart, abs, ord+1, board, length+1, colo);
		}
		else {
			return 0;
		}
	}

	public int TerritoryfromS(int absstart, int ordstart, int abs, int ord, Intersection [][] board, int length, Color colo) {
		if ((absstart == abs) && (ordstart == ord)){
			if (length >7) {
				return 2;
			}else {
				return 1;
			}
		}
		else if (board[abs-1][ord-1].getColor() == colo){
			return TerritoryfromSE( absstart, ordstart, abs-1, ord-1, board, length+1, colo);
		}
		else if(board[abs+1][ord+1].getColor() == colo) {
			return TerritoryfromNW( absstart, ordstart, abs+1, ord+1, board, length+1, colo);
		}
		else if(board[abs+1][ord-1].getColor() == colo) {
			return TerritoryfromSW( absstart, ordstart, abs+1, ord-1, board, length+1, colo);
		}
		else if(board[abs-1][ord+1].getColor() == colo) {
			return TerritoryfromNE( absstart, ordstart, abs-1, ord+1, board, length+1, colo);
		}
		else if(board[abs+1][ord].getColor() == colo) {
			return TerritoryfromW( absstart, ordstart, abs+1, ord, board, length+1, colo);
		}
		else if(board[abs-1][ord].getColor() == colo) {
			return TerritoryfromE( absstart, ordstart, abs-1, ord, board, length+1, colo);
		}
		else if(board[abs][ord-1].getColor() == colo) {
			return TerritoryfromS( absstart, ordstart, abs, ord-1, board, length+1, colo);
		}
		else {
			return 0;
		}
	}

	public int TerritoryfromSW(int absstart, int ordstart, int abs, int ord, Intersection [][] board, int length, Color colo) {
		if ((absstart == abs) && (ordstart == ord)){
			if (length >7) {
				return 2;
			}else {
				return 1;
			}
		}
		else if (board[abs-1][ord-1].getColor() == colo){
			return TerritoryfromSE( absstart, ordstart, abs-1, ord-1, board, length+1, colo);
		}
		else if(board[abs+1][ord+1].getColor() == colo) {
			return TerritoryfromNW( absstart, ordstart, abs+1, ord+1, board, length+1, colo);
		}
		else if(board[abs+1][ord-1].getColor() == colo) {
			return TerritoryfromSW( absstart, ordstart, abs-1, ord+1, board, length+1, colo);
		}
		else if(board[abs-1][ord].getColor() == colo) {
			return TerritoryfromE( absstart, ordstart, abs-1, ord, board, length+1, colo);
		}
		else if(board[abs+1][ord].getColor() == colo) {
			return TerritoryfromW( absstart, ordstart, abs+1, ord, board, length+1, colo);
		}
		else if(board[abs][ord-1].getColor() == colo) {
			return TerritoryfromS( absstart, ordstart, abs, ord-1, board, length+1, colo);
		}
		else if(board[abs][ord+1].getColor() == colo) {
			return TerritoryfromN( absstart, ordstart, abs, ord+1, board, length+1, colo);
		}
		else {
			return 0;
		}
	}

	public int TerritoryfromW(int absstart, int ordstart, int abs, int ord, Intersection [][] board, int length, Color colo) {
		if ((absstart == abs) && (ordstart == ord)){
			if (length >7) {
				return 2;
			}else {
				return 1;
			}
		}
		else if (board[abs-1][ord-1].getColor() == colo){
			return TerritoryfromSE( absstart, ordstart, abs-1, ord-1, board, length+1, colo);
		}
		else if(board[abs+1][ord+1].getColor() == colo) {
			return TerritoryfromNW( absstart, ordstart, abs+1, ord+1, board, length+1, colo);
		}
		else if(board[abs+1][ord-1].getColor() == colo) {
			return TerritoryfromSW( absstart, ordstart, abs+1, ord-1, board, length+1, colo);
		}
		else if(board[abs-1][ord+1].getColor() == colo) {
			return TerritoryfromNE( absstart, ordstart, abs-1, ord+1, board, length+1, colo);
		}
		else if(board[abs][ord+1].getColor() == colo) {
			return TerritoryfromN( absstart, ordstart, abs, ord+1, board, length+1, colo);
		}
		else if(board[abs+1][ord].getColor() == colo) {
			return TerritoryfromW( absstart, ordstart, abs+1, ord, board, length+1, colo);
		}
		else if(board[abs][ord-1].getColor() == colo) {
			return TerritoryfromS( absstart, ordstart, abs, ord-1, board, length+1, colo);
		}
		else {
			return 0;
		}
	}

	public int TerritoryfromNW(int absstart, int ordstart, int abs, int ord, Intersection [][] board, int length, Color colo) {
		if ((absstart == abs) && (ordstart == ord)){
			if (length >7) {
				return 2;
			}else {
				return 1;
			}
		}
		else if (board[abs+1][ord+1].getColor() == colo){
			return TerritoryfromNW( absstart, ordstart, abs+1, ord+1, board, length+1, colo);
		}
		else if(board[abs+1][ord-1].getColor() == colo) {
			return TerritoryfromSW( absstart, ordstart, abs+1, ord-1, board, length+1, colo);
		}
		else if(board[abs-1][ord+1].getColor() == colo) {
			return TerritoryfromNE( absstart, ordstart, abs-1, ord+1, board, length+1, colo);
		}
		else if(board[abs-1][ord].getColor() == colo) {
			return TerritoryfromE( absstart, ordstart, abs-1, ord, board, length+1, colo);
		}
		else if(board[abs+1][ord].getColor() == colo) {
			return TerritoryfromW( absstart, ordstart, abs+1, ord, board, length+1, colo);
		}
		else if(board[abs][ord-1].getColor() == colo) {
			return TerritoryfromS( absstart, ordstart, abs, ord-1, board, length+1, colo);
		}
		else if(board[abs][ord+1].getColor() == colo) {
			return TerritoryfromN( absstart, ordstart, abs, ord+1, board, length+1, colo);
		}
		else {
			return 0;
		}
	}


	public int BlockTerritory(Intersection inter, Color colo, Intersection [][] board) {		//Fonction qui d�tecte la possibilit� de bloquer la prise d'un territoir
		if (board[inter.getAbscisse()-1][inter.getOrdonnee()-1].getColor() != colo && board[inter.getAbscisse()-1][inter.getOrdonnee()-1].getColor() != null){
			Color badcolo = (board[inter.getAbscisse()-1][inter.getOrdonnee()-1].getColor());
			if (isTerritory(inter, inter.getAbscisse(), inter.getOrdonnee(), board , badcolo) >0) {
				return 50;
			}
		}
		 if(board[inter.getAbscisse()+1][inter.getOrdonnee()+1].getColor() == colo && board[inter.getAbscisse()+1][inter.getOrdonnee()+1].getColor() != null) {
			Color badcolo = (board[inter.getAbscisse()+1][inter.getOrdonnee()+1].getColor());
			if (isTerritory(inter, inter.getAbscisse(), inter.getOrdonnee(), board , badcolo) >0) {
				return 50;
			}
		}
		if(board[inter.getAbscisse()+1][inter.getOrdonnee()-1].getColor() == colo && board[inter.getAbscisse()+1][inter.getOrdonnee()-1].getColor() != null) {
			Color badcolo = (board[inter.getAbscisse()+1][inter.getOrdonnee()-1].getColor());
			if (isTerritory(inter, inter.getAbscisse(), inter.getOrdonnee(), board , badcolo) >0) {
				return 50;
			}
		}
		if(board[inter.getAbscisse()-1][inter.getOrdonnee()+1].getColor() == colo && board[inter.getAbscisse()-1][inter.getOrdonnee()+1].getColor() != null) {
			Color badcolo = (board[inter.getAbscisse()-1][inter.getOrdonnee()+1].getColor());
			if (isTerritory(inter, inter.getAbscisse(), inter.getOrdonnee(), board , badcolo) >0) {
				return 50;
			}
		}
		if(board[inter.getAbscisse()-1][inter.getOrdonnee()].getColor() == colo && board[inter.getAbscisse()-1][inter.getOrdonnee()].getColor() != null) {
			Color badcolo = (board[inter.getAbscisse()-1][inter.getOrdonnee()].getColor());
			if (isTerritory(inter, inter.getAbscisse(), inter.getOrdonnee(), board , badcolo) >0) {
				return 50;
			}
		}
		if(board[inter.getAbscisse()+1][inter.getOrdonnee()].getColor() == colo && board[inter.getAbscisse()+1][inter.getOrdonnee()].getColor() != null) {
			Color badcolo = (board[inter.getAbscisse()+1][inter.getOrdonnee()].getColor());
			if (isTerritory(inter, inter.getAbscisse(), inter.getOrdonnee(), board , badcolo) >0) {
				return 50;
			}
		}
		if(board[inter.getAbscisse()][inter.getOrdonnee()-1].getColor() == colo && board[inter.getAbscisse()][inter.getOrdonnee()-1].getColor() != null) {
			Color badcolo = (board[inter.getAbscisse()][inter.getOrdonnee()-1].getColor());
			if (isTerritory(inter, inter.getAbscisse(), inter.getOrdonnee(), board , badcolo) >0) {
				return 50;
			}
		}
		if(board[inter.getAbscisse()][inter.getOrdonnee()+1].getColor() == colo && board[inter.getAbscisse()][inter.getOrdonnee()+1].getColor() != null) {
			Color badcolo = (board[inter.getAbscisse()][inter.getOrdonnee()+1].getColor());
			if (isTerritory(inter, inter.getAbscisse(), inter.getOrdonnee(), board , badcolo) >0) {
				return 50;
			}

		}
		return 0;
	}
}
