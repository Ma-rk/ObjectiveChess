/**
 * @createdate: 2014. 9. 13. 
 * @author    : mark_iMac
 */
package board;

import java.util.ArrayList;

import pieces.King;
import pieces.Pawn;
import pieces.Piece;
import pieces.Tile;
import util.EtcUtil;
import util.EtcUtil.PieceKind;
import util.Point;
import util.UtilConv;
import util.UtilGetInput;
import util.UtilPoint;

public class ChessBoard {
	public final static int BOARD_WIDTH = 17;
	public final static int BOARD_HEIGHT = 17;
	public static Tile[][] chessBoard = new Tile[BOARD_WIDTH][BOARD_HEIGHT];

	public static Tile tileWhite = new Tile("□");
	public static Tile tileBlack = new Tile("■");
	public static Tile tileEmpty = new Tile("  ");

	Pawn b_pawn1 = new Pawn(PieceKind.bPawn.getColor(), EtcUtil.Color.black);
	Pawn b_pawn2 = new Pawn(PieceKind.bPawn.getColor(), EtcUtil.Color.black);
	King bKing = new King(PieceKind.bKing.getColor(), EtcUtil.Color.black);

	Pawn w_pawn1 = new Pawn(PieceKind.wPawn.getColor(), EtcUtil.Color.white);
	Pawn w_pawn2 = new Pawn(PieceKind.wPawn.getColor(), EtcUtil.Color.white);

	ArrayList<Point> pointsICanGo;
	ArrayList<Piece> deadPieces = new ArrayList<Piece>();
	
	
	public ChessBoard() {
		initailizeBoard();
	}

	private void initailizeBoard() {
		generateEmptyBoard();
		setupPiececs();
	}

	private void generateEmptyBoard() {
		for (int file = 0; file < BOARD_WIDTH; file++) {
			for (int rank = 0; rank < BOARD_HEIGHT; rank++) {
				if (file % 2 == 0 || rank % 2 == 0) {
					chessBoard[rank][file] = tileWhite;
				} else {
					chessBoard[rank][file] = tileEmpty;
				}
			}
		}
	}

	private void setupPiececs() {
		putPiece(b_pawn1, 7, 1);
		putPiece(b_pawn2, 7, 2);
		putPiece(bKing, 8, 5);

		putPiece(w_pawn1, 2, 1);
		putPiece(w_pawn2, 2, 2);
		putPiece(w_pawn2, 2, 2);
	}

	// b_pawn1.setCurrentPosition(UtilConv.convToInnerCoord(1, 7));
	// chessBoard[UtilConv.convToInnerFile(1)][UtilConv.convToInnerRank(7)] =
	// b_pawn1;
	//
	// b_pawn2.setCurrentPosition(UtilConv.convToInnerCoord(2, 7));
	// chessBoard[UtilConv.convToInnerFile(2)][UtilConv.convToInnerRank(7)] =
	// b_pawn2;
	//
	// //chessBoard[1][5] = b_rook1;
	// // chessBoard[1][5] = b_rook1;
	// b_pawn2.setCurrentPosition(UtilConv.convToInnerFile(3),
	// UtilConv.convToInnerRank(8));
	// chessBoard[1][5] = b_bishop1;
	//
	// chessBoard[13][1] = w_pawn1;
	// chessBoard[13][3] = w_pawn2;

	private void putPiece(Piece piece, int rank, int file) {
		piece.setCurrentPosition(UtilConv.convToInnerCoord(rank, file));
		chessBoard[piece.getCurrentPosition().getRank()][piece.getCurrentPosition().getFile()] = piece;

	}

	public void printCurrentBoard() {
		int yLine = 8;
		for (int rank = 0; rank < BOARD_HEIGHT; rank++) {
			if (rank % 2 == 1)
				System.out.print((yLine--) + " ");
			else
				System.out.print("  ");
			for (int file = 0; file < BOARD_WIDTH; file++) {
				System.out.print(chessBoard[rank][file].getImage());
			}
			System.out.println();
		}
		System.out.println("    1   2   3   4   5   6   7   8 (가로)");
	}

	public Piece pickPieceToMove() {
		Point positionOfPieceToMove = UtilGetInput.getPosition();

		Piece piece = null;
		if (!(chessBoard[positionOfPieceToMove.getRank()][positionOfPieceToMove.getFile()].getClass() == Tile.class)) {
			piece = (Piece) chessBoard[positionOfPieceToMove.getRank()][positionOfPieceToMove.getFile()];
		}
		return piece;
	}

	public Point pickPointToMove() {
		Point pointToMove = UtilGetInput.getPosition();

		for (Point nextPoint : pointsICanGo) {
			if (nextPoint.getRank() == pointToMove.getRank() && nextPoint.getFile() == pointToMove.getFile()) {
				return nextPoint;
			}
		}

		return null;
	}

	public void showAvailablePoint(Piece currentPiece) {
		EtcUtil.printEnterPoint("showAvailablePoint");
		System.out.println(currentPiece.toString());

		pointsICanGo = currentPiece.getAvailablePoint();
		UtilPoint.highlightPoints(pointsICanGo);
	}

	public void executeMove(Piece currentPiece, Point pointToMove) {
		
	}
}
