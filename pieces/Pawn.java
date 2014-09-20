/**
 * @createdate: 2014. 9. 13. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;

import board.ChessBoard;
import util.EtcUtil.Color;
import util.PointPosition;

public class Pawn extends Piece {

	public Pawn(String image, Color color) {
		super(image, color);
	}

	public String toString() {
		return "Pawn instance. file: " + (myPosition.getFile() + 1) / 2 + ", rank: " + (myPosition.getRank() + 17) / 2;

	}

	public ArrayList<PointPosition> getAvailablePoint() {

		ArrayList<PointPosition> availablePoints = new ArrayList<PointPosition>();

		if (color == Color.black) {
			// 이 객체가 black일 때의 로직(위에서 아래로 공격하는 로직)
			Tile tempTile = ChessBoard.chessBoard[myPosition.getFile() - 1][myPosition.getRank() - 1];
			Piece targetPiece = (Piece) ChessBoard.chessBoard[myPosition.getFile() - 1][myPosition.getRank() - 1];
			if (targetPiece.color == Color.white) {
				availablePoints.add(new PointPosition(myPosition.getFile() - 1, myPosition.getRank() - 1));
			}
			
			targetPiece = (Piece) ChessBoard.chessBoard[myPosition.getFile() - 1][myPosition.getRank() + 1];
			if (targetPiece.color == Color.white) {
				availablePoints.add(new PointPosition(myPosition.getFile() - 1, myPosition.getRank() + 1));
			}
			// 이 객체가 black일 때의 로직(위에서 아래로 이동하는 로직)
		} else {
			// 이 객체가 white일 때의 로직 ->아래에서 위로 공격, 이동하는 로직

		}
		return availablePoints;

	}
}
