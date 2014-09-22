/**
 * @createdate: 2014. 9. 21. 
 * @author    : mark_iMac
 */
package util;

import java.util.ArrayList;

import pieces.Piece;
import board.ChessBoard;

public class UtilPoint {
	private static boolean isOnBoard(Point pointTo) {
		if (pointTo.getRank() < 1 || ChessBoard.BOARD_WIDTH - 1 < pointTo.getRank())
			return false; // out of the board.
		if (pointTo.getFile() < 1 || ChessBoard.BOARD_HEIGHT - 1 < pointTo.getFile())
			return false; // out of the board.
		return true;
	}

	private static boolean isEmptyPoint(Point pointTo) {
		if (ChessBoard.chessBoard[pointTo.getRank()][pointTo.getFile()] == null)
			return true; // empty tile.
		else
			return false; // occupied tile.
	}

	private static boolean isSameColor(Piece currentPiece, Point pointTo) {
		Piece locatedPiece = (Piece) ChessBoard.chessBoard[pointTo.getRank()][pointTo.getFile()];
		if (currentPiece.color == locatedPiece.color)
			return true; // same color.
		return false; // different color.
	}

	public static boolean isAvalablePoint(Piece currentPiece, Point pointTo) {
		if (!isOnBoard(pointTo))
			return false;
		if (isEmptyPoint(pointTo))
			return true; // empty tile. can move.
		if (isSameColor(currentPiece, pointTo))
			return false; // same color. can not move.
		else
			return true; // different color. can move.
	}

	public static ArrayList<Point> getAvalablePoints(Piece currentPiece, ArrayList<Point> pointsIWantToGo) {
		ArrayList<Point> pointsICanGo = new ArrayList<Point>();
		for (Point step : pointsIWantToGo) {
			Point pointTo = getPointTo(currentPiece, step);
			if (isAvalablePoint(currentPiece, pointTo))
				pointsICanGo.add(getPointTo(currentPiece, step));
		}
		return pointsICanGo;
	}

	public static boolean isReachablePoint(Piece currentPiece, Point pointTo) {
		if (!isOnBoard(pointTo))
			return false;
		if (isEmptyPoint(pointTo))
			return true; // empty tile. can move.
		return false;
	}

	public static ArrayList<Point> getReachablePoints(Piece currentPiece, ArrayList<Point> pointsIWantToGo) {
		ArrayList<Point> pointsICanReach = new ArrayList<Point>();
		for (Point step : pointsIWantToGo) {
			Point pointTo = getPointTo(currentPiece, step);
			if (isReachablePoint(currentPiece, pointTo))
				pointsICanReach.add(getPointTo(currentPiece, step));
		}
		return pointsICanReach;
	}

	public static boolean isAttackablePoint(Piece currentPiece, Point pointTo) {
		if (!isOnBoard(pointTo))
			return false;
		if (isEmptyPoint(pointTo))
			return false; // empty tile. can not attack.
		if (!isSameColor(currentPiece, pointTo))
			return true; // different color. can attack.
		return false;
	}

	public static ArrayList<Point> getAttackablePoints(Piece currentPiece, ArrayList<Point> pointsIWantToGo) {
		ArrayList<Point> pointsICanReach = new ArrayList<Point>();
		for (Point step : pointsIWantToGo) {
			Point pointTo = getPointTo(currentPiece, step);
			if (isAttackablePoint(currentPiece, pointTo))
				pointsICanReach.add(getPointTo(currentPiece, step));
		}
		return pointsICanReach;
	}

	public static ArrayList<Point> getAvalablePath(Piece currentPiece, ArrayList<Point> directionsIWantToGo) {
		ArrayList<Point> pathsICanGo = new ArrayList<Point>();
		for (Point direction : directionsIWantToGo) {
			Point tempPoint = new Point(currentPiece.getCurrentPosition().getRank(), currentPiece.getCurrentPosition().getFile());
			while (true) {
				tempPoint.movePosition(direction.getRank(), direction.getFile());
				if (!isOnBoard(tempPoint)) {
					break;
				}
				if (isEmptyPoint(tempPoint)) {
					pathsICanGo.add(new Point(tempPoint.getRank(), tempPoint.getFile()));
					continue;
				}
				if (!isSameColor(currentPiece, tempPoint)) {
					pathsICanGo.add(new Point(tempPoint.getRank(), tempPoint.getFile()));
				}
				break;
			}
		}
		return pathsICanGo;
	}

	private static Point getPointTo(Piece piece, Point step) {
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
