/**
 * @createdate: 2014. 9. 13. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;

import util.PointPosition;
import util.EtcUtil.Color;

public class Piece extends Tile {
	private String image = null;

	ArrayList<PointPosition> pointsIWantToGo = new ArrayList<PointPosition>();
	ArrayList<PointPosition> pointsICanGo = new ArrayList<PointPosition>();
	public PointPosition myPosition;
	public int moves = 0;
	public Color color = Color.noColor;

	public Piece(String image, Color color) {
		super(image);
		this.myPosition = new PointPosition(0, 0);
		this.color = color;
	}
	public Piece(String image, Color color, int file, int rank) {
		super(image);
		this.myPosition = new PointPosition(file, rank);
		this.color = color;
	}

	public Piece setCurrentPosition(int file, int rank) {
		Piece instanceWithNewPosition = new Piece(this.image, this.color, file, rank);
		return instanceWithNewPosition; 
	}

	public String toString() {
		return "Piece instance. File: " + (myPosition.getFile() + 1) / 2 + ", Rank: " + (myPosition.getRank() + 17) / 2;

	}

	public ArrayList<PointPosition> getAvailablePoint() {

		// 널로 리턴하는게 맞나? 일단 구현은 자식 클래스에서 하니까 이대로 둬 보자...
		return null;

	}
}
