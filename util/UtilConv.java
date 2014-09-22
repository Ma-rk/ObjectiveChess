/**
 * @createdate: 2014. 9. 21. 
 * @author    : mark_iMac
 */
package util;

public class UtilConv {
	public static int convToInnerFile(int intputFile) {
		return intputFile * 2 - 1;
	}

	public static int convToInnerRank(int intputRank) {
		return 17 - (intputRank * 2);
	}

	public static Point convToInnerCoord(int inputRank, int inputFile) {
		return new Point(convToInnerRank(inputRank), convToInnerFile(inputFile));
	}
}