package pieces;

import java.util.ArrayList;
import util.Point;
import util.UtilPoint;
import util.UtilEtc.Color;

public abstract class TypeCross extends Piece{

	public TypeCross(String image, String name, Color color, int serial) {
		super(image, name, color, serial);
	}
	public ArrayList<Point> getAvalablePath(Piece currentPiece, ArrayList<Point> directionsIWantToGo) {
		ArrayList<Point> pathsICanGo = new ArrayList<Point>();
		for (Point direction : directionsIWantToGo) {
			Point tempPoint = new Point(currentPiece.getCurrentPosition().getRank(), currentPiece.getCurrentPosition().getFile());
			while (true) {
				tempPoint.movePosition(direction.getRank(), direction.getFile());
				if (!UtilPoint.isOnBoard(tempPoint)) {
					break;
				}
				if (UtilPoint.isEmptyPoint(tempPoint)) {
					pathsICanGo.add(new Point(tempPoint.getRank(), tempPoint.getFile()));
					continue;
				}
				if (!UtilPoint.isSameColor(currentPiece, tempPoint)) {
					pathsICanGo.add(new Point(tempPoint.getRank(), tempPoint.getFile()));
				}
				break;
			}
		}
		return pathsICanGo;
	}
}