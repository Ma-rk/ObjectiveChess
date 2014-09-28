/**
 * @createdate: 2014. 9. 21. 
 * @author    : mark_iMac
 */
package util;

import java.util.Scanner;

public class UtilGetInput {

	public static Scanner intPicker = new Scanner(System.in);

	public static Point getPosition() {
		int coordinate = 0;
		while (coordinate < 11 || 88 < coordinate) {
			System.out.println("좌표를 입력하세요:");
			System.out.println("(가로:세로의 형식으로 11~88의 값을 입력하세요)");
			coordinate = intPicker.nextInt();
		}

		int rank = UtilConv.convToInnerRank(coordinate % 10);
		int file = UtilConv.convToInnerFile(coordinate / 10);

		return new Point(rank, file);
	}
}