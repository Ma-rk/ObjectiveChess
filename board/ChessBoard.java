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

	public static Tile tileWhite = new Tile("□");
	public static Tile tileBlack = new Tile("■");
	// public static Tile tileEmpty = new Tile("  ");

	//Pawn bPawn1 = new Pawn(PieceKind.bPawn.getColor(), UtilEtc.Color.black);
	//Pawn bPawn2 = new Pawn(PieceKind.bPawn.getColor(), UtilEtc.Color.black);
	King bKing = new King(PieceKind.bKing.getColor(), UtilEtc.Color.black);

	Pawn wPawn1 = new Pawn(PieceKind.wPawn.getColor(), UtilEtc.Color.white);
	Pawn wPawn2 = new Pawn(PieceKind.wPawn.getColor(), UtilEtc.Color.white);
	King wKing = new King(PieceKind.wKing.getColor(), UtilEtc.Color.white);

	ArrayList<Point> pointsICanGo;
	ArrayList<Piece> deadPieces = new ArrayList<Piece>();

	public ChessBoard() {
		initailizeBoard();
	}

	private void initailizeBoard() {
		resetBoardToWhiteTile();
		setupPiececs();
	}

	private void resetBoardToWhiteTile() {
		for (int file = 0; file < BOARD_WIDTH; file++) {
			for (int rank = 0; rank < BOARD_HEIGHT; rank++) {
				if (file % 2 == 0 || rank % 2 == 0) {
					chessBoard[rank][file] = tileWhite;
				}
			}
		}
	}

	private void setupPiececs() {
		putPiece(bKing, 8, 3);
		putPiece(wPawn1, 7, 2);
		putPiece(wKing, 4, 3);
		//putPiece(wPawn2, 7, 2);
		
		
//		putPiece(b_pawn1, 7, 1);
//		putPiece(b_pawn2, 7, 2);
//		putPiece(bKing, 8, 5);
//
//		putPiece(w_pawn1, 2, 1);
//		putPiece(w_pawn2, 7, 4);
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
		Point positionOfPieceToMove = UtilGetInput.getPosition();

		// 선택한 칸이 빈 칸이면 null 리턴
		if (chessBoard[positionOfPieceToMove.getRank()][positionOfPieceToMove.getFile()] == null) {
			return null;
		}
		// 선택한 칸이 타일이면 null 리턴
		if (chessBoard[positionOfPieceToMove.getRank()][positionOfPieceToMove.getFile()].getClass() == Tile.class) {
			return null;

		}

		Piece piece = (Piece) chessBoard[positionOfPieceToMove.getRank()][positionOfPieceToMove.getFile()];

		// 선택한 칸의 말이 자기게 아니면 널 리턴
		if (piece.color != ChessMain.curentTurn) {
			return null;
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
		UtilEtc.printEnterPoint("showAvailablePoint");
		System.out.println(currentPiece.toString());

		pointsICanGo = currentPiece.getAvailablePoint();
		UtilPoint.highlightPoints(pointsICanGo);
	}

	public void executeMove(Piece currentPiece, Point pointToMove) {
		UtilEtc.printEnterPoint("executeMove");

		//이동할 자리에 상대 말이 있으면 먹는다.
		if (chessBoard[pointToMove.getRank()][pointToMove.getFile()] != null) 
			deadPieces.add((Piece) chessBoard[pointToMove.getRank()][pointToMove.getFile()]);

		//체스판의 이동 전 위치를 비운다. 
		chessBoard[currentPiece.getCurrentPosition().getRank()][currentPiece.getCurrentPosition().getFile()] = null;
		
		//체스판의 이동 후 위치에 현재 말을 위치시킨다.
		chessBoard[pointToMove.getRank()][pointToMove.getFile()] = currentPiece;

		//현재 말 내부의 좌표값을 이동 후 위치로 바꾼다.
		currentPiece.setCurrentPosition(pointToMove);
		
		//검은 타일로 하이라이트 된 체스판을 원래대로 되돌린다. 
		resetBoardToWhiteTile();
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
