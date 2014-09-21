/**
 * @createdate: 2014. 9. 13. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;

import util.Point;
import util.UtilEtc.Color;

public class Piece extends Tile {
	private String image = null;

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

	public Piece(String image, Color color) {
		super(image);
		this.myPosition = new Point(0, 0);
		this.color = color;
	}

	public Piece(String image, Color color, int rank, int file) {
		super(image);
		this.myPosition = new Point(rank, file);
		this.color = color;
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

	public Color getColor() {
		return this.color;
	}

	String generateStringInfo(String pieceKind, Point myPosition) {
		return pieceKind + serial + ". Rank: " + (myPosition.getRank() + 17) / 2 + ", File: " + (myPosition.getFile() + 1) / 2;
	}

	public String toString() {
		// return "Piece instance. Rank: " + (myPosition.getRank() + 17) / 2 +
		// "File: " + (myPosition.getFile() + 1) / 2;
		return generateStringInfo("Piece", myPosition);

	}

	public ArrayList<Point> getAvailablePoint() {
		// 널로 리턴하는게 맞나? 일단 이대로 둬 보자. 구현은 자식 클래스에서 하니까...
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
