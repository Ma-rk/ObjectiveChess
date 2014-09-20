/**
 * @createdate: 2014. 9. 13. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;

import util.Point;
import util.EtcUtil.Color;

public class Piece extends Tile {
	private String image = null;

	ArrayList<Point> pointsIWantToGo = new ArrayList<Point>();
	ArrayList<Point> pointsICanGo = new ArrayList<Point>();
	public Point myPosition;
	public int moves = 0;
	public Color color = Color.noColor;

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
		return "Piece instance. Rank: " + (myPosition.getRank() + 17) / 2 + "File: " + (myPosition.getFile() + 1) / 2;

	}

	public ArrayList<Point> getAvailablePoint() {

		// 널로 리턴하는게 맞나? 일단 구현은 자식 클래스에서 하니까 이대로 둬 보자...
		return null;

	}
}
