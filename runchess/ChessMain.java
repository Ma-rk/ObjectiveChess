/**
 * @createdate: 2014. 9. 13. 
 * @author    : mark_iMac
 */
package runchess;

import pieces.Piece;
import util.Point;
import util.UtilEtc;
import util.UtilGetInput;
import util.UtilMessages;
import util.UtilEtc.Color;
import board.ChessBoard;

public class ChessMain {

	public static UtilEtc.Color curentTurn = Color.white;

	public static void main(String[] args) {
		Piece currentPiece = null;
		Point pointToMove = null;
		boolean isGameFinished = false;

		ChessBoard cb = new ChessBoard();

		while (!isGameFinished) { // 게임이 끝나지 않았으면 와일을 계속 돈다

			// 이번 턴에서 사용자 입력을 받는 while에 진입하기 위해 currentPiece과 pointToMove에 null을
			// 대입한다.
			currentPiece = null;
			pointToMove = null;

			UtilEtc.printEnterPoint("MAIN WHILE");

			// 현재 상태의 체스판과 말을 출력한다.
			cb.printCurrentBoard();

			// 이번 턴이 누구 턴인지 안내한다.
			if (ChessMain.curentTurn == Color.black)
				UtilMessages.turnBlack();
			else
				UtilMessages.turnWhite();

			// 사용자가 움직일 말을 선택함.
			// 올바른 위치(피스가 있는 위치)를 선택할 때까지 와일을 돈다
			while (currentPiece == null) {
				currentPiece = cb.pickPieceToMove();
				if (currentPiece == null) {
					UtilMessages.pointHasNoPiece();
				}
			}
			System.out.println(currentPiece.toString());

			// 선택한 말이 움직일 수 있는 자리를 가져온다.
			cb.showAvailablePoint(currentPiece);//

			// 선택한 말이 움직일 수 있는 자리가 표시된 체스판을 출력한다.
			cb.printCurrentBoard();

			// 선택할 말이 움직일 자리를 선택한다.
			// 올바른 위치(이동할 수 있는 자리 또는 먹을 수 있는 자리)를 선택할 때까지 와일을 돈다
			UtilMessages.selectPointToMove();
			while (pointToMove == null) {
				pointToMove = cb.pickPointToMove();
				if (pointToMove == null) {
					UtilMessages.selectHighlightedPoint();
				}
			}

			// 선택한 자리로 말을 옮긴다.
			// 선택한 자리에 상대방의 말이 있으면 말을 먹는다.
			cb.executeMove(currentPiece, pointToMove);

			// 검은 타일로 하이라이트 된 체스판을 원래대로 되돌린다.
			cb.resetBoardToWhiteTile();

			isGameFinished = cb.isGameFinished(ChessMain.curentTurn);

			// 한 턴의 모든 작업이 종료되면 현재 턴을 표시하는 플래그의 값을 바꾼다
			if (ChessMain.curentTurn == Color.black)
				ChessMain.curentTurn = Color.white;
			else
				ChessMain.curentTurn = Color.black;

			UtilEtc.printEscapePoint("MAIN WHILE");
		}
		cb.printCurrentBoard();

		UtilMessages.gameOver();
		UtilMessages.winnerIs(currentPiece);

		UtilGetInput.intPicker.close();
	}
}
