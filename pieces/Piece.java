/**
 * @createdate: 2014. 9. 13. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;
import util.Point;
import util.UtilEtc.Color;

public class Piece extends Tile {
	// for all kind of Pieces.
	ArrayList<Point> pointsIWantToGo = new ArrayList<Point>();
	ArrayList<Point> pointsICanGo = new ArrayList<Point>();
	// for only Pawn.
	ArrayList<Point> pointsIWantToAttack = new ArrayList<Point>();
	ArrayList<Point> pointsICanAttack = new ArrayList<Point>();

	public Point myPosition;
	public int moves = -1; // this number will be zero when it initialized.
	public Color color = Color.noColor;
	public int serial = 0;

	public Piece(String image, String name, Color color, int serial) {
		super(image, name, color);
		this.myPosition = new Point(0, 0);
		this.color = color;
		this.serial = serial;
	}

	private void moved() {
		moves++;
	}

	public void setCurrentPosition(int rank, int file) {
		this.myPosition = new Point(rank, file);
		moved();
	}

	public void setCurrentPosition(Point pos) {
		setCurrentPosition(pos.getRank(), pos.getFile());
	}

	public Point getCurrentPosition() {
		return this.myPosition;
	}

	public String toString() {
		return name + serial + ". Rank: " + (myPosition.getRank() + 17) / 2 + ", File: " + (myPosition.getFile() + 1) / 2;
	}

	public ArrayList<Point> getAvailablePoints() {
		return null;
	}

	void resetArrays() {
		pointsIWantToAttack = new ArrayList<Point>();
		pointsICanAttack = new ArrayList<Point>();
		pointsIWantToGo = new ArrayList<Point>();
		pointsICanGo = new ArrayList<Point>();
	}
}