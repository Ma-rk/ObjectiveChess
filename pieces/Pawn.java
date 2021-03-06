/**
 * @createdate: 2014. 9. 13. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;
import util.UtilEtc.Color;
import util.Point;
import util.UtilPoint;

public class Pawn extends Piece {

	public Pawn(String image, String name, Color color, int serial) {
		super(image, name, color, serial);
	}

	public ArrayList<Point> getAvailablePoints() {
		resetArrays();
		if (color == Color.black) { // 이 객체가 black일 때의 로직(위에서 아래로 공격하는 로직)
			// 이동 가능 포인트
			pointsIWantToGo.add(new Point(2, 0));
			if (this.moves == 0)
				pointsIWantToGo.add(new Point(4, 0));
			// 공격 가능 포인트
			pointsIWantToAttack.add(new Point(2, -2));
			pointsIWantToAttack.add(new Point(2, 2));
		} else {// 이 객체가 white일 때의 로직 ->아래에서 위로 공격, 이동하는 로직
			// 이동 가능 포인트
			pointsIWantToGo.add(new Point(-2, 0));
			if (this.moves == 0)
				pointsIWantToGo.add(new Point(-4, 0));
			// 공격 가능 포인트
			pointsIWantToAttack.add(new Point(-2, -2));
			pointsIWantToAttack.add(new Point(-2, 2));
		}
		pointsICanGo = getReachablePoints(this, pointsIWantToGo);
		pointsICanAttack = getAttackablePoints(this, pointsIWantToAttack);
		pointsICanGo.addAll(pointsICanAttack);
		return pointsICanGo;
	}
	
	private boolean isReachablePoint(Piece currentPiece, Point pointTo) {
		if (!UtilPoint.isOnBoard(pointTo))
			return false; // out of board. can not move.
		if (UtilPoint.isEmptyPoint(pointTo))
			return true; // empty tile. can move.
		return false;
	}

	private  ArrayList<Point> getReachablePoints(Piece currentPiece, ArrayList<Point> pointsIWantToGo) {
		ArrayList<Point> pointsICanReach = new ArrayList<Point>();
		for (Point step : pointsIWantToGo) {
			Point pointTo = UtilPoint.getPointTo(currentPiece, step);
			if (isReachablePoint(currentPiece, pointTo))
				pointsICanReach.add(UtilPoint.getPointTo(currentPiece, step));
		}
		return pointsICanReach;
	}

	private boolean isAttackablePoint(Piece currentPiece, Point pointTo) {
		if (!UtilPoint.isOnBoard(pointTo))
			return false;
		if (UtilPoint.isEmptyPoint(pointTo))
			return false; // empty tile. can not attack.
		if (!UtilPoint.isSameColor(currentPiece, pointTo))
			return true; // different color. can attack.
		return false;
	}

	private ArrayList<Point> getAttackablePoints(Piece currentPiece, ArrayList<Point> pointsIWantToGo) {
		ArrayList<Point> pointsICanReach = new ArrayList<Point>();
		for (Point step : pointsIWantToGo) {
			Point pointTo = UtilPoint.getPointTo(currentPiece, step);
			if (isAttackablePoint(currentPiece, pointTo))
				pointsICanReach.add(UtilPoint.getPointTo(currentPiece, step));
		}
		return pointsICanReach;
	}
}