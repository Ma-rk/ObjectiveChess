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
		wKing("♔"), wRook("♖"), wBishop("♗"), wQueen("♕"), wNnight("♘"), wPawn("♙"), bKing("♚"), bRook("♜"), bBishop("♝"), bQueen("♛"), bNnight("♞"), bPawn("♟");
		private String color;

		PieceKind(String color) {
			System.out.println("Call Enum Constructor " + this);
			this.color = color;
		}

		public String getColor() {
			return this.color;
		}
	}


	public static void printEnterPoint(String methodName) {
		System.out.println("Entered " + methodName + "()");
	}
	
	public static void printEscapePoint(String methodName) {
		System.out.println("Escaping " + methodName + "()");
	}



}