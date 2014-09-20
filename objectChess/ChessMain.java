/**
 * @createdate: 2014. 9. 13. 
 * @author    : mark_iMac
 */
package objectChess;

import pieces.Piece;
import util.EtcUtil.Color;
import board.ChessBoard;

public class ChessMain {

	public static void main(String[] args) {

		Piece currentPiece = null;

		ChessBoard cb = new ChessBoard();

		//
		cb.printCurrentBoard();

		//사용자가 올바른 위치(피스가 있는 위치)를 선택할 때까지 와일을 돈
		while (currentPiece == null) {
			currentPiece = cb.pickPiece();
			if (currentPiece == null) {
				System.out.println("There is no Piece. Select another point.");
			}
		}
		cb.showAvailablePoint(currentPiece);//

	}

}
