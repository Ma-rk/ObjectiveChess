/**
 * @createdate: 2014. 9. 22. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;

import util.Point;
import util.UtilPoint;
import util.UtilEtc.Color;

public class Rook extends Piece {

	public Rook(String image, String name, Color color, int serial) {
		super(image, name, color, serial);
	}

	public ArrayList<Point> getAvailablePoint() {
		resetArrays();
		directionsIWantToGo.add(new Point(-2, 0));
		directionsIWantToGo.add(new Point(0, 2));
		directionsIWantToGo.add(new Point(2, 0));
		directionsIWantToGo.add(new Point(0, -2));
		ArrayList<Point> pathsICanGo = UtilPoint.getAvalablePath(this, directionsIWantToGo);
		return pathsICanGo;
	}
}