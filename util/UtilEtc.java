/**
 * @createdate: 2014. 9. 16. 
 * @author    : mark_iMac
 */
package util;

public class UtilEtc {
	public static enum Color {
		black, white, noColor;
	}

	public static enum PieceKind {
		wTile("□", "Tile"), bTile("■", "Tile"), wKing("♔", "King"), wRook("♖", "Rook"), wBishop("♗", "Bishopw"), wQueen("♕", "Queen"), wNight("♘",
				"Night"), wPawn("♙", "Pawn"), bKing("♚", "King"), bRook("♜", "Rook"), bBishop("♝", "Bishop"), bQueen("♛", "Queen"), bNight("♞", "Night"), bPawn(
				"♟", "Pawn");
		private String image;
		private String name;

		PieceKind(String image, String name) {
			this.image = image;
			this.name = name;
		}

		public String getImage() {
			return this.image;
		}

		public String getName() {
			return this.name;
		}
	}

	public static void printEnterPoint(String methodName) {
		System.out.println("Entered " + methodName + "()");
	}

	public static void printEscapePoint(String methodName) {
		System.out.println("Escaping " + methodName + "()");
	}
}