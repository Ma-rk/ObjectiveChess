/**
 * @createdate: 2014. 9. 21. 
 * @author    : mark_iMac
 */
package util;

import java.util.ArrayList;

import pieces.Piece;
import pieces.Tile;
import board.ChessBoard;

public class UtilPoint {
	// 넘겨받은 좌표 이동할 수 있는지 판별. 우리편 말이면 false, 나머지는 true.
	public static boolean isAvalablePoint(Piece piece, Point point) {

		int destRank = piece.myPosition.getRank() + point.getRank();
		int destFile = piece.myPosition.getFile() + point.getFile();

		// out of chess board
		if (destRank < 1 || ChessBoard.BOARD_WIDTH - 1 < destRank)
			return false;
		// out of chess board
		if (destFile < 1 || ChessBoard.BOARD_HEIGHT - 1 < destFile)
			return false;

		if (ChessBoard.chessBoard[destRank][destFile].getClass() == Tile.class) {
			return true; // empty tile. can move.
		}

		Piece locatedPiece = (Piece) ChessBoard.chessBoard[destRank][destFile];
		if (locatedPiece.color == piece.color) {
			return false; // same color. can not move.
		}
		return true;
	}

	public static ArrayList<Point> getAvalablePoint(Piece piece, ArrayList<Point> pointsIWantToGo) {
		ArrayList<Point> pointsICanGo = new ArrayList<Point>();
		for (Point point : pointsIWantToGo) {
			if (isAvalablePoint(piece, point)) {
				int rankTo = piece.getCurrentPosition().getRank() + point.getRank();
				int fileTo = piece.getCurrentPosition().getFile() + point.getFile();
				pointsICanGo.add(new Point(rankTo, fileTo));
			}
		}
		return pointsICanGo;
	}

	public static void highlightPoints(ArrayList<Point> pointsICanGo) {
		for (Point pointPosition : pointsICanGo) {
			highlightOnePoint(pointPosition);
		}
	}

	//입력받은 칸 주변의 8개 타일을 검은 타일로 바꾼다.
	private static void highlightOnePoint(Point pointPosition) {
		int currentRank = pointPosition.getRank();
		int currentFile = pointPosition.getFile();

		ChessBoard.chessBoard[currentRank - 1][currentFile] = ChessBoard.tileBlack;
		ChessBoard.chessBoard[currentRank - 1][currentFile + 1] = ChessBoard.tileBlack;
		ChessBoard.chessBoard[currentRank][currentFile + 1] = ChessBoard.tileBlack;
		ChessBoard.chessBoard[currentRank + 1][currentFile + 1] = ChessBoard.tileBlack;
		ChessBoard.chessBoard[currentRank + 1][currentFile] = ChessBoard.tileBlack;
		ChessBoard.chessBoard[currentRank + 1][currentFile - 1] = ChessBoard.tileBlack;
		ChessBoard.chessBoard[currentRank][currentFile - 1] = ChessBoard.tileBlack;
		ChessBoard.chessBoard[currentRank - 1][currentFile - 1] = ChessBoard.tileBlack;
	}
}
