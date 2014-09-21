/**
 * @createdate: 2014. 9. 21. 
 * @author    : mark_iMac
 */
package util;

import pieces.Piece;

public class UtilMessages {
	public static void selectPointToMove() {
		System.out.println("말을 이동할 좌표를 선택하세요.");
	}

	public static void pointHasNoPiece() {
		System.out.println("Wrong choice. Select another point.");
	}

	public static void selectHighlightedPoint() {
		System.out.println("You must pick Highlighted point. Select again.");
	}

	public static void turnBlack() {
		System.out.println("Black turn. Pick a black piece.");
	}

	public static void turnWhite() {
		System.out.println("White turn. Pick a pick piece.");
	}
	
	public static void gameOver() {
		System.out.println("G A M E   O V E R.");
	}
	
	public static void winnerIs(Piece piece) {
		System.out.println("Winner is " + piece.getColor().toString());
	}
}
