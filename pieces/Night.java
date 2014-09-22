/**
 * @createdate: 2014. 9. 22. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;

import util.Point;
import util.UtilPoint;
import util.UtilEtc.Color;

public class Night extends Piece{

	public Night(String image, String name, Color color, int serial) {
		super(image, name, color, serial);
	}

	public ArrayList<Point> getAvailablePoints() {
		resetArrays();
		pointsIWantToGo.add(new Point(-4, 2));
		pointsIWantToGo.add(new Point(-2, 4));
		pointsIWantToGo.add(new Point(2, 4));
		pointsIWantToGo.add(new Point(4, 2));
		pointsIWantToGo.add(new Point(4, -2));
		pointsIWantToGo.add(new Point(2, -4));
		pointsIWantToGo.add(new Point(-2, -4));
		pointsIWantToGo.add(new Point(-4, -2));
		ArrayList<Point> pointsICanGo = UtilPoint.getAvalablePoints(this, pointsIWantToGo);
		return pointsICanGo;
	}
}
