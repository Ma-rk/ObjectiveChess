/**
 * @createdate: 2014. 9. 13. 
 * @author    : mark_iMac
 */
package board;

import java.util.ArrayList;
import java.util.Scanner;

import pieces.Pawn;
import pieces.Piece;
import pieces.Tile;
import util.EtcUtil;
import util.PointPosition;
import util.EtcUtil.PieceKind;
import util.UtilConv;

public class ChessBoard {
	public final static int BOARD_WIDTH = 17;
	public final static int BOARD_HEIGHT = 17;
	public static Tile[][] chessBoard = new Tile[BOARD_WIDTH][BOARD_HEIGHT];

	static Tile tileWhite = new Tile("□");
	static Tile tileBlack = new Tile("■");
	static Tile tileEmpty = new Tile("  ");

	Pawn b_pawn1 = new Pawn(PieceKind.bPawn.getColor(), EtcUtil.Color.black);
	Pawn b_pawn2 = new Pawn(PieceKind.bPawn.getColor(),  EtcUtil.Color.black);
	Pawn b_bishop1 = new Pawn(PieceKind.bBishop.getColor(),  EtcUtil.Color.black);

	Pawn w_pawn1 = new Pawn(PieceKind.wPawn.getColor(), EtcUtil.Color.white);
	Pawn w_pawn2 = new Pawn(PieceKind.wPawn.getColor(),  EtcUtil.Color.white);
//	Pawn b_pawn1 = new Pawn(PieceKind.bPawn.getColor(), EtcUtil.convToInnerCoordFile(1), EtcUtil.convToInnerCoordRank(7), EtcUtil.Color.black);
//	Pawn b_pawn2 = new Pawn(PieceKind.bPawn.getColor(), EtcUtil.convToInnerCoordFile(2), EtcUtil.convToInnerCoordRank(7), EtcUtil.Color.black);
//	Pawn b_bishop1 = new Pawn(PieceKind.bBishop.getColor(), EtcUtil.convToInnerCoordFile(3), EtcUtil.convToInnerCoordRank(8), EtcUtil.Color.black);
//	
//	Pawn w_pawn1 = new Pawn(PieceKind.wPawn.getColor(), EtcUtil.convToInnerCoordFile(1), EtcUtil.convToInnerCoordRank(2), EtcUtil.Color.white);
//	Pawn w_pawn2 = new Pawn(PieceKind.wPawn.getColor(), EtcUtil.convToInnerCoordFile(2), EtcUtil.convToInnerCoordRank(2), EtcUtil.Color.white);

	public ChessBoard() {
		initailizeBoard();
	}

	private void initailizeBoard() {
		generateEmptyBoard();
		putPieces();
	}

	private void generateEmptyBoard() {
		for (int i = 0; i < BOARD_WIDTH; i++) {
			for (int j = 0; j < BOARD_HEIGHT; j++) {
				if (i % 2 == 0 || j % 2 == 0) {
					chessBoard[i][j] = tileWhite;
				} else {
					chessBoard[i][j] = tileEmpty;
				}
			}
		}
	}

	private void putPieces() {
		b_pawn1.setCurrentPosition(UtilConv.convToInnerFile(1), UtilConv.convToInnerRank(7));
		chessBoard[UtilConv.convToInnerFile(1)][UtilConv.convToInnerRank(7)] = b_pawn1;
		
		b_pawn2.setCurrentPosition(UtilConv.convToInnerFile(1), UtilConv.convToInnerRank(7));
		chessBoard[UtilConv.convToInnerFile(1)][UtilConv.convToInnerRank(7)] = b_pawn2;
		
		chessBoard[1][5] = b_rook1;
		chessBoard[1][5] = b_rook1;
		b_pawn2.setCurrentPosition(UtilConv.convToInnerFile(3), UtilConv.convToInnerRank(8));
		chessBoard[1][5] = b_bishop1;

		chessBoard[13][1] = w_pawn1;
		chessBoard[13][3] = w_pawn2;
	}

	public void printCurrentBoard() {
		int yLine = 8;
		for (int file = 0; file < BOARD_WIDTH; file++) {
			if (file % 2 == 1)
				System.out.print((yLine--) + " ");
			else
				System.out.print("  ");
			for (int rank = 0; rank < BOARD_HEIGHT; rank++) {
				System.out.print(chessBoard[file][rank].getImage());
			}
			System.out.println();
		}
		System.out.println("    1   2   3   4   5   6   7   8 (가로)");
	}

	public Piece pickPiece() {
		Scanner scan = new Scanner(System.in);
		System.out.println("가로 입력(1~8):");
		int file = scan.nextInt();
		System.out.println("세로 입력(1~8):");
		int rank = scan.nextInt();
		scan.close();

		rank = EtcUtil.convToInnerRank(rank);
		file = EtcUtil.convToInnerFile(file);

		Piece piece=null;
		if (!(chessBoard[rank][file].getClass() == Tile.class)) {
			piece = (Piece) chessBoard[rank][file];
		}
		return piece;
	}

	public void showAvailablePoint(Piece currentPiece) {
		EtcUtil.printEnterPoint("showAvailablePoint");
		System.out.println(currentPiece.toString());
		
		ArrayList<PointPosition> pointsICanGo = currentPiece.getAvailablePoint();
		int a = 1;
	}
}
