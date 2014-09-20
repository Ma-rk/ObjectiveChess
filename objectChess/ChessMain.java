/**
 * @createdate: 2014. 9. 13. 
 * @author    : mark_iMac
 */
package objectChess;

import pieces.Piece;
import util.Point;
import util.UtilGetInput;
import util.UtilMessages;
import board.ChessBoard;

public class ChessMain {

	public static void main(String[] args) {

		Piece currentPiece = null;
		Point pointToMove =null;
		
		
		ChessBoard cb = new ChessBoard();

		cb.printCurrentBoard();

		//사용자가 올바른 위치(피스가 있는 위치)를 선택할 때까지 와일을 돈
		while (currentPiece == null) {
			currentPiece = cb.pickPieceToMove();
			if (currentPiece == null) {
				UtilMessages.pointHasNoPiece();
			}
		}
		cb.showAvailablePoint(currentPiece);//
		

		cb.printCurrentBoard();
		UtilMessages.selectPointToMove();

		while(pointToMove==null){
			pointToMove = cb.pickPointToMove();
			if (pointToMove == null) {
				UtilMessages.selectHighlightedPoint();
			}
		}
		cb.executeMove(currentPiece, pointToMove);

		
		
		UtilGetInput.intPicker.close();
	}
}
