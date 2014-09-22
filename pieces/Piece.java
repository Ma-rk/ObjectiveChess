/**
 * @createdate: 2014. 9. 13. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;

import util.Point;
import util.UtilEtc.Color;

public class Piece extends Tile {
	// these arrays are for Pawn.
	ArrayList<Point> pointsIWantToReach = new ArrayList<Point>();
	ArrayList<Point> pointsICanReach = new ArrayList<Point>();
	ArrayList<Point> pointsIWantToAttack = new ArrayList<Point>();
	ArrayList<Point> pointsICanAttack = new ArrayList<Point>();
	// these are for King, Knight.
	ArrayList<Point> pointsIWantToGo = new ArrayList<Point>();
	ArrayList<Point> pointsICanGo = new ArrayList<Point>();
	// these are for Bishop, Rook and Queen
	ArrayList<Point> directionsIWantToGo = new ArrayList<Point>();
	ArrayList<Point> directionsICanGo = new ArrayList<Point>();
	
	public Point myPosition;
	public int moves = 0;
	public Color color = Color.noColor;
	public int serial = 0;

	public Piece(String image, String name, Color color, int serial) {
		super(image, name, color);
		this.myPosition = new Point(0, 0);
		this.color = color;
		this.serial = serial;
	}

	public void moved() {
		moves++;
	}

	public void setCurrentPosition(int rank, int file) {
		this.myPosition = new Point(rank, file);
	}

	public void setCurrentPosition(Point pos) {
		this.myPosition = new Point(pos.getRank(), pos.getFile());
	}

	public Point getCurrentPosition() {
		return this.myPosition;
	}

	public String toString() {
		return name + serial + ". Rank: " + (myPosition.getRank() + 17) / 2 + ", File: " + (myPosition.getFile() + 1) / 2;
	}

	public ArrayList<Point> getAvailablePoint() {
		return null;
	}
	
	void resetArrays(){
		pointsIWantToReach = new ArrayList<Point>();
		pointsICanReach = new ArrayList<Point>();
		pointsIWantToAttack = new ArrayList<Point>();
		pointsICanAttack = new ArrayList<Point>();
		pointsIWantToGo = new ArrayList<Point>();
		pointsICanGo = new ArrayList<Point>();
		directionsIWantToGo = new ArrayList<Point>();
		directionsICanGo = new ArrayList<Point>();
	}
}
