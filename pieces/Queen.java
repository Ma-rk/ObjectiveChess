/**
 * @createdate: 2014. 9. 22. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;
import util.Point;
import util.UtilEtc.Color;

public class Queen extends TypeCross {

	public Queen(String image, String name, Color color, int serial) {
		super(image, name, color, serial);
	}

	public ArrayList<Point> getAvailablePoints() {
		resetArrays();
		pointsIWantToGo.add(new Point(-2, 0));
		pointsIWantToGo.add(new Point(0, 2));
		pointsIWantToGo.add(new Point(2, 0));
		pointsIWantToGo.add(new Point(0, -2));
		pointsIWantToGo.add(new Point(-2, 2));
		pointsIWantToGo.add(new Point(2, 2));
		pointsIWantToGo.add(new Point(2, -2));
		pointsIWantToGo.add(new Point(-2, -2));
		ArrayList<Point> pathsICanGo = getAvalablePath(this, pointsIWantToGo);
		return pathsICanGo;
	}
}