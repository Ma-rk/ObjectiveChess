/**
 * @createdate: 2014. 9. 13. 
 * @author    : mark_iMac
 */
package pieces;

import java.util.ArrayList;

import board.ChessBoard;
import util.EtcUtil.Color;
import util.Point;

public class Pawn extends Piece {

	public Pawn(String image, Color color) {
		super(image, color);
	}

	public String toString() {
		return "Pawn instance. Rank: " + (myPosition.getRank() + 17) / 2 + ", File: " + (myPosition.getFile() + 1) / 2;

	}

	public ArrayList<Point> getAvailablePoint() {

		ArrayList<Point> availablePoints = new ArrayList<Point>();

		if (color == Color.black) {
			// 이 객체가 black일 때의 로직(위에서 아래로 공격하는 로직)
			Tile tempTile = ChessBoard.chessBoard[myPosition.getRank() - 1][myPosition.getFile() - 1];
			Piece targetPiece = (Piece) ChessBoard.chessBoard[myPosition.getRank() - 1][myPosition.getFile() - 1];
			if (targetPiece.color == Color.white) {
				availablePoints.add(new Point(myPosition.getRank() - 1, myPosition.getFile() - 1));
			}
			
			targetPiece = (Piece) ChessBoard.chessBoard[myPosition.getRank() + 1][myPosition.getFile() - 1];
			if (targetPiece.color == Color.white) {
				availablePoints.add(new Point(myPosition.getRank() + 1, myPosition.getFile() - 1));
			}
			// 이 객체가 black일 때의 로직(위에서 아래로 이동하는 로직)
		} else {
			// 이 객체가 white일 때의 로직 ->아래에서 위로 공격, 이동하는 로직

		}
		return availablePoints;

	}
}
