/**
 * @createdate: 2014. 9. 20. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;

import util.Point;
import util.UtilEtc.Color;
import util.UtilPoint;

public class King extends Piece {

	public King(String image, Color color) {
		super(image, color);
	}

	public String toString() {
		return generateStringInfo("King", myPosition);
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
