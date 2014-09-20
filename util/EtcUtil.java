/**
 * @createdate: 2014. 9. 16. 
 * @author    : mark_iMac
 */
package util;

import java.util.ArrayList;

import board.ChessBoard;
import pieces.King;
import pieces.Piece;
import pieces.Tile;

public class EtcUtil {
	public static enum Color {
		noColor, black, white;
	}

	public static enum PieceKind {
		wKing("♔"), wRook("♖"), wBishop("♗"), wQueen("♕"), wNnight("♘"), wPawn("♙"), bKing("♚"), bRook("♜"), bBishop("♝"), bQueen("♛"), bNnight("♞"), bPawn("♟");
		private String color;

		PieceKind(String color) {
			System.out.println("Call Enum Constructor " + this);
			this.color = color;
		}

		public String getColor() {
			return this.color;
		}
	}


	public static void printEnterPoint(String methodName) {
		System.out.println("Entered " + methodName + "()");
	}

	// 넘겨받은 좌표 이동할 수 있는지 판별. 우리편 말이면 false, 나머지는 true.
	public static boolean isAvalablePoint(Piece piece, PointPosition point) {

		int destFile = piece.myPosition.getFile() + point.getFile();
		int destRank = piece.myPosition.getRank() + point.getRank();

		// out of chess board
		if (destFile < 1 || ChessBoard.BOARD_HEIGHT - 1 < destFile)
			return false;
		// out of chess board
		if (destRank < 1 || ChessBoard.BOARD_WIDTH - 1 < destRank)
			return false;

		if (ChessBoard.chessBoard[destFile][destRank].getClass() == Tile.class) {
			return true; // empty tile. can move.
		}

		Piece locatedPiece = (Piece) ChessBoard.chessBoard[destFile][destRank];
		if (locatedPiece.color == piece.color) {
			return false; //same color. can not move.
		}
		return true; 
	}

	public static ArrayList<PointPosition> getAvalablePoint(Piece piece, ArrayList<PointPosition> pointsIWantToGo) {
		ArrayList<PointPosition> pointsICanGo = new ArrayList<PointPosition>();
		for (PointPosition point : pointsIWantToGo) {
			if (isAvalablePoint(piece, point)) {
				pointsICanGo.add(point);
			}
		}
		return pointsICanGo;
	}

}