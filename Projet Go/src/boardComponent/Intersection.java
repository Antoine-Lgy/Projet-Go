/**
 * 
 */
package boardComponent;

import java.awt.Color;

/**
 * @author Antoine
 *
 */
public class Intersection {
	
	/**
	 * @param args
	 */
	protected int abscisse;
	protected int ordonnee;
	protected Color bgColor;
	protected Color bord = Color.GRAY;
	protected Intersection prevIntersection = null;
	protected Intersection LN = null;
	protected Intersection LS = null;
	protected Intersection LE = null;
	protected Intersection LO = null;
	protected Intersection LNE = null;
	protected Intersection LSE = null;
	protected Intersection LNO = null;
	protected Intersection LSO = null;
	public boolean bCalled = false;
	public boolean inEnsMC = false;
	public boolean inEnsNULL = false;
	

	public Intersection(int abs, int ord, Color _C) {
		this.abscisse = abs;
		this.ordonnee = ord;
		this.bgColor = _C;
	}
	public Intersection(){
		this.bgColor = bord;
	}
	
	public int getAbscisse() {
		return abscisse;
	}
	public int getOrdonnee() {
		return ordonnee;
	}
	public Color getColor() {
		return bgColor;
	}
	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}
	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}
	public void setColor(Color _C) {
		this.bgColor = _C;
	}
	public void setPrevIntersection(Intersection intersection) {
		this.prevIntersection = intersection;
	}
	public Intersection getPrevIntersection() {
		return prevIntersection;
	}
	public void setLN(Intersection lN) {
		LN = lN;
	}
	public void setLS(Intersection lS) {
		LS = lS;
	}
	public void setLD(Intersection lE) {
		LE = lE;
	}
	public void setLG(Intersection lO) {
		LO = lO;
	}
	public Intersection getLN() {
		return LN;
	}
	public Intersection getLS() {
		return LS;
	}
	public Intersection getLE() {
		return LE;
	}
	public Intersection getLO() {
		return LO;
	}
	public void setLNE(Intersection lNE) {
		LNE = lNE;
	}
	public void setLNO(Intersection lNO) {
		LNO = lNO;
	}
	public void setLSE(Intersection lSE) {
		LSE = lSE;
	}
	public void setLSO(Intersection lSO) {
		LSO = lSO;
	}
	public Intersection getLNO() {
		return LNO;
	}
	public Intersection getLNE() {
		return LNE;
	}
	public Intersection getLSE() {
		return LSE;
	}
	public Intersection getLSO() {
		return LSO;
	}
	
	public Intersection Myclone(){
		Intersection interCopy = new Intersection();
		interCopy.bgColor = this.bgColor;
		return interCopy;
	}
}
