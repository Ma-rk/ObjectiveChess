/**
 * @createdate: 2014. 9. 22. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;

import util.Point;
import util.UtilPoint;
import util.UtilEtc.Color;

public class Bishop extends Piece {

	public Bishop(String image, String name, Color color, int serial) {
		super(image, name, color, serial);
	}

	public ArrayList<Point> getAvailablePoints() {
		resetArrays();
		directionsIWantToGo.add(new Point(-2, 2));
		directionsIWantToGo.add(new Point(2, 2));
		directionsIWantToGo.add(new Point(2, -2));
		directionsIWantToGo.add(new Point(-2, -2));
		ArrayList<Point> pathsICanGo = UtilPoint.getAvalablePath(this, directionsIWantToGo);
		return pathsICanGo;
	}
}