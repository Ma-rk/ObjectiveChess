package pieces;

import java.util.ArrayList;
import util.Point;
import util.UtilPoint;
import util.UtilEtc.Color;

public abstract class TypeJump extends Piece{

	public TypeJump(String image, String name, Color color, int serial) {
		super(image, name, color, serial);
	}
	public boolean isAvalablePoint(Piece currentPiece, Point pointTo) {
		if (!UtilPoint.isOnBoard(pointTo))
			return false; // out of board. can not move.
		if (UtilPoint.isEmptyPoint(pointTo))
			return true; // empty tile. can move.
		if (UtilPoint.isSameColor(currentPiece, pointTo))
			return false; // same color. can not move.
		else
			return true; // different color. can move.
	}

	public ArrayList<Point> getAvalablePoints(Piece currentPiece, ArrayList<Point> pointsIWantToGo) {
		ArrayList<Point> pointsICanGo = new ArrayList<Point>();
		for (Point step : pointsIWantToGo) {
			Point pointTo = UtilPoint.getPointTo(currentPiece, step);
			if (isAvalablePoint(currentPiece, pointTo))
				pointsICanGo.add(UtilPoint.getPointTo(currentPiece, step));
		}
		return pointsICanGo;
	}

}