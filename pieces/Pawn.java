/**
 * @createdate: 2014. 9. 13. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;

import board.ChessBoard;
import util.UtilEtc.Color;
import util.Point;
import util.UtilPoint;

public class Pawn extends Piece {

	public Pawn(String image, Color color) {
		super(image, color);
	}

	public String toString() {
		return generateStringInfo("Pawn", myPosition);
	}

	public ArrayList<Point> getAvailablePoint() {


		if (color == Color.black) {
			// 이 객체가 black일 때의 로직(위에서 아래로 공격하는 로직)
			

		} else {
			// 이 객체가 white일 때의 로직 ->아래에서 위로 공격, 이동하는 로직

		}

		ArrayList<Point> pointsICanGo = UtilPoint.getAvalablePoint(this, pointsIWantToGo);
		
		return pointsICanGo;

	}
}
