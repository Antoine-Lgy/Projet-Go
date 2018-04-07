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
	protected Intersection LD = null;
	protected Intersection LG = null;
	protected Intersection Caller = null;
	protected Intersection Called = null;
	

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
	public void setLD(Intersection lD) {
		LD = lD;
	}
	public void setLG(Intersection lG) {
		LG = lG;
	}
	public Intersection getLN() {
		return LN;
	}
	public Intersection getLS() {
		return LS;
	}
	public Intersection getLD() {
		return LD;
	}
	public Intersection getLG() {
		return LG;
	}
	public void setCaller(Intersection caller) {
		Caller = caller;
	}
	public Intersection getCaller() {
		return Caller;
	}
	public void setCalled(Intersection called) {
		Called = called;
	}
	public Intersection getCalled() {
		return Called;
	}
	
	public Intersection Myclone(){
		Intersection interCopy = new Intersection();
		interCopy.bgColor = this.bgColor;
		return interCopy;
	}
}
