/**
 * @createdate: 2014. 9. 20. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;

import util.Point;
import util.EtcUtil.Color;
import util.UtilPoint;

public class King extends Piece {

	public King(String image, Color color) {
		super(image, color);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "King instance. + Rank: " + (myPosition.getRank() + 17) / 2 + "File: " + (myPosition.getFile() + 1) / 2;

	}

	public ArrayList<Point> getAvailablePoint() {

		pointsIWantToGo.add(new Point(-2, 0));
		pointsIWantToGo.add(new Point(-2, 2));
		pointsIWantToGo.add(new Point(0, 2));
		pointsIWantToGo.add(new Point(2, 2));
		pointsIWantToGo.add(new Point(2, 0));
		pointsIWantToGo.add(new Point(2, -2));
		pointsIWantToGo.add(new Point(0, -2));
		pointsIWantToGo.add(new Point(-2, -2));
		ArrayList<Point> pointsICanGo = UtilPoint.getAvalablePoint(this, pointsIWantToGo);

		return pointsICanGo;

	}
}
