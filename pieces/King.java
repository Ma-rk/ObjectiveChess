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

	public King(String image, String name, Color color, int serial) {
		super(image, name, color, serial);
	}

	public ArrayList<Point> getAvailablePoint() {
		resetArrays();
		pointsIWantToGo.add(new Point(-2, 0));
		pointsIWantToGo.add(new Point(-2, 2));
		pointsIWantToGo.add(new Point(0, 2));
		pointsIWantToGo.add(new Point(2, 2));
		pointsIWantToGo.add(new Point(2, 0));
		pointsIWantToGo.add(new Point(2, -2));
		pointsIWantToGo.add(new Point(0, -2));
		pointsIWantToGo.add(new Point(-2, -2));
		ArrayList<Point> pointsICanGo = UtilPoint.getAvalablePoints(this, pointsIWantToGo);
		return pointsICanGo;
	}
}
