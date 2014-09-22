/**
 * @createdate: 2014. 9. 13. 
 * @author    : mark_iMac
 */
package board;

import java.util.ArrayList;
import objectChess.ChessMain;
import pieces.King;
import pieces.Pawn;
import pieces.Piece;
import pieces.Rook;
import pieces.Tile;
import util.Point;
import util.UtilConv;
import util.UtilEtc;
import util.UtilEtc.Color;
import util.UtilEtc.PieceKind;
import util.UtilGetInput;
import util.UtilPoint;

public class ChessBoard {
	public final static int BOARD_WIDTH = 17;
	public final static int BOARD_HEIGHT = 17;
	public static Tile[][] chessBoard = new Tile[BOARD_WIDTH][BOARD_HEIGHT];

	public static Tile tileWhite = new Tile(PieceKind.wTile.getImage(), PieceKind.wTile.getName(), UtilEtc.Color.white);
	public static Tile tileBlack = new Tile(PieceKind.bTile.getImage(), PieceKind.bTile.getName(), UtilEtc.Color.black);

	Pawn bPawn1 = new Pawn(PieceKind.bPawn.getImage(), PieceKind.bPawn.getName(), UtilEtc.Color.black, 1);
	Pawn bPawn2 = new Pawn(PieceKind.bPawn.getImage(), PieceKind.bPawn.getName(), UtilEtc.Color.black, 2);

	Rook bRook1 = new Rook(PieceKind.bRook.getImage(), PieceKind.bRook.getName(), UtilEtc.Color.black, 1);
	Rook bRook2 = new Rook(PieceKind.bRook.getImage(), PieceKind.bRook.getName(), UtilEtc.Color.black, 2);
	King bKing = new King(PieceKind.bKing.getImage(), PieceKind.bKing.getName(), UtilEtc.Color.black, 1);

	Pawn wPawn1 = new Pawn(PieceKind.wPawn.getImage(), PieceKind.wPawn.getName(), UtilEtc.Color.white, 1);
	Pawn wPawn2 = new Pawn(PieceKind.wPawn.getImage(), PieceKind.wPawn.getName(), UtilEtc.Color.white, 2);
	Pawn wPawn3 = new Pawn(PieceKind.wPawn.getImage(), PieceKind.wPawn.getName(), UtilEtc.Color.white, 3);

	Rook wRook1 = new Rook(PieceKind.wRook.getImage(), PieceKind.wRook.getName(), UtilEtc.Color.white, 1);
	King wKing = new King(PieceKind.wKing.getImage(), PieceKind.wKing.getName(), UtilEtc.Color.white, 1);

	ArrayList<Point> pointsICanGo;
	ArrayList<Piece> deadPieces = new ArrayList<Piece>();

	public ChessBoard() {
		initailizeBoard();
	}

	private void initailizeBoard() {
		resetBoardToWhiteTile();
		setupPiececs();
	}

	public void resetBoardToWhiteTile() {
		for (int file = 0; file < BOARD_WIDTH; file++) {
			for (int rank = 0; rank < BOARD_HEIGHT; rank++) {
				if (file % 2 == 0 || rank % 2 == 0) {
					chessBoard[rank][file] = tileWhite;
				}
			}
		}
	}

	private void setupPiececs() {

		putPiece(bPawn1, 6, 4);
		putPiece(bPawn2, 6, 5);
		putPiece(bKing, 6, 6);
		putPiece(bRook1, 6, 7);

		putPiece(wPawn1, 3, 4);
		putPiece(wPawn2, 3, 5);
		putPiece(wKing, 3, 6);
		putPiece(wRook1, 3, 7);

		putPiece(wPawn3, 8, 4);
		// putPiece(wPawn2, 7, 2);
		// putPiece(bKing, 8, 5);
		//
		// putPiece(w_pawn1, 2, 1);
		// putPiece(w_pawn2, 7, 4);
	}

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
				if (chessBoard[rank][file] == null) {
					System.out.print("  ");
				} else {
					System.out.print(chessBoard[rank][file].getImage());
				}
			}
			System.out.println();
		}
		System.out.print("    1   2   3   4   5   6   7   8 (가로)    ");
		for (int numOfDeadPieces = 0; numOfDeadPieces < deadPieces.size(); numOfDeadPieces++) {
			System.out.print(deadPieces.get(numOfDeadPieces).getImage() + " ");
		}
		System.out.println();
	}

	// 이동할 말(자기 말)을 고르는 메소드
	public Piece pickPieceToMove() {
		Point positionOfPickedPiece = UtilGetInput.getPosition();

		// 선택한 칸이 빈 칸이면 null 리턴
		if (chessBoard[positionOfPickedPiece.getRank()][positionOfPickedPiece.getFile()] == null)
			return null;
		// 선택한 칸이 타일이면 null 리턴
		if (chessBoard[positionOfPickedPiece.getRank()][positionOfPickedPiece.getFile()].getClass() == Tile.class)
			return null;

		Piece piece = (Piece) chessBoard[positionOfPickedPiece.getRank()][positionOfPickedPiece.getFile()];

		// 선택한 칸의 말이 자기게 아니면 널 리턴
		if (piece.color != ChessMain.curentTurn)
			return null;

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
		UtilEtc.printEnterPoint("showAvailablePoint");
		System.out.println(currentPiece.toString());

		pointsICanGo = currentPiece.getAvailablePoint();
		UtilPoint.highlightPoints(pointsICanGo);
		UtilEtc.printEscapePoint("showAvailablePoint");
	}

	public void executeMove(Piece currentPiece, Point pointToMove) {
		UtilEtc.printEnterPoint("executeMove");

		// 이동할 자리에 상대 말이 있으면 먹는다.
		if (chessBoard[pointToMove.getRank()][pointToMove.getFile()] != null)
			deadPieces.add((Piece) chessBoard[pointToMove.getRank()][pointToMove.getFile()]);

		// 체스판의 이동 전 위치를 비운다.
		chessBoard[currentPiece.getCurrentPosition().getRank()][currentPiece.getCurrentPosition().getFile()] = null;

		// 체스판의 이동 후 위치에 현재 말을 위치시킨다.
		chessBoard[pointToMove.getRank()][pointToMove.getFile()] = currentPiece;

		// 현재 말 내부의 좌표값을 이동 후 위치로 바꾼다.
		currentPiece.setCurrentPosition(pointToMove);

		// 현재 말의 이동 카운트를 1 증가시킨다.
		currentPiece.moved();
	}

	public boolean isGameFinished(Color curentTurn) {
		UtilEtc.printEnterPoint("isGameFinished");
		Piece cp = null;
		for (int rank = 1; rank < BOARD_HEIGHT; rank += 2) {
			for (int file = 1; file < BOARD_WIDTH; file += 2) {
				if (chessBoard[rank][file] != null) {
					cp = (Piece) chessBoard[rank][file];
					if (cp.getColor() != curentTurn) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
