/**
 * @createdate: 2014. 9. 21. 
 * @author    : mark_iMac
 */
package util;

import java.util.ArrayList;

import pieces.Piece;
import board.ChessBoard;

public class UtilPoint {
	public static boolean isOnBoard(Point pointTo) {
		if (pointTo.getRank() < 1 || ChessBoard.BOARD_WIDTH - 1 < pointTo.getRank())
			return false; // out of the board.
		if (pointTo.getFile() < 1 || ChessBoard.BOARD_HEIGHT - 1 < pointTo.getFile())
			return false; // out of the board.
		return true;
	}

	public static boolean isEmptyPoint(Point pointTo) {
		if (ChessBoard.chessBoard[pointTo.getRank()][pointTo.getFile()] == null)
			return true; // empty tile.
		else
			return false; // occupied tile.
	}

	public static boolean isSameColor(Piece currentPiece, Point pointTo) {
		Piece locatedPiece = (Piece) ChessBoard.chessBoard[pointTo.getRank()][pointTo.getFile()];
		if (currentPiece.color == locatedPiece.color)
			return true; // same color.
		return false; // different color.
	}

	public static Point getPointTo(Piece piece, Point step) {
		int rankTo = piece.getCurrentPosition().getRank() + step.getRank();
		int fileTo = piece.getCurrentPosition().getFile() + step.getFile();
		return new Point(rankTo, fileTo);
	}

	public static void highlightPoints(ArrayList<Point> pointsICanGo) {
		for (Point pointPosition : pointsICanGo) {
			highlightOnePoint(pointPosition);
		}
	}

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
