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

	public Pawn(String image, Color color, int serial) {
		super(image, color);
		this.serial = serial;
	}

	public String toString() {
		return generateStringInfo("Pawn", myPosition);
	}

	public ArrayList<Point> getAvailablePoint() {
		resetArrays();
		if (color == Color.black) { // 이 객체가 black일 때의 로직(위에서 아래로 공격하는 로직)
			// 이동 가능 포인트
			pointsIWantToReach.add(new Point(2, 0));
			if (this.moves == 0)
				pointsIWantToReach.add(new Point(4, 0));

			// 공격 가능 포인트
			pointsIWantToAttack.add(new Point(2, -2));
			pointsIWantToAttack.add(new Point(2, 2));
		} else {// 이 객체가 white일 때의 로직 ->아래에서 위로 공격, 이동하는 로직
			// 이동 가능 포인트
			pointsIWantToReach.add(new Point(-2, 0));
			if (this.moves == 0)
				pointsIWantToReach.add(new Point(-4, 0));

			// 공격 가능 포인트
			pointsIWantToAttack.add(new Point(-2, -2));
			pointsIWantToAttack.add(new Point(-2, 2));
		}
		pointsICanReach = UtilPoint.getReachablePoints(this, pointsIWantToReach);
		pointsICanAttack = UtilPoint.getAttackablePoints(this, pointsIWantToAttack);
		pointsICanReach.addAll(pointsICanAttack);
		return pointsICanReach;
	}
}