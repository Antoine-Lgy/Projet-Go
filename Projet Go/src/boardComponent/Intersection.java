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
	protected Intersection prevIntersection = null;

	public Intersection(int abs, int ord, Color _C) {
		this.abscisse = abs;
		this.ordonnee = ord;
		this.bgColor = _C;
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
}
