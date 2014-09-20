/**
 * @createdate: 2014. 9. 20. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;

import board.ChessBoard;
import util.EtcUtil;
import util.PointPosition;
import util.EtcUtil.Color;

public class King extends Piece {

	public King(String image, Color color) {
		super(image, color);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "King instance. file: " + (myPosition.getFile() + 1) / 2 + ", rank: " + (myPosition.getRank() + 17) / 2;

	}

	public ArrayList<PointPosition> getAvailablePoint() {

		pointsIWantToGo.add(new PointPosition(0, 2));
		pointsIWantToGo.add(new PointPosition(2, 2));
		pointsIWantToGo.add(new PointPosition(2, 0));
		pointsIWantToGo.add(new PointPosition(2, -2));
		pointsIWantToGo.add(new PointPosition(0, -2));
		pointsIWantToGo.add(new PointPosition(-2, -2));
		pointsIWantToGo.add(new PointPosition(-2, 0));
		pointsIWantToGo.add(new PointPosition(-2, 2));

		ArrayList<PointPosition> pointsICanGo = EtcUtil.getAvalablePoint(this, pointsIWantToGo);
		
		return pointsICanGo;

	}
}
