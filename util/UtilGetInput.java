/**
 * @createdate: 2014. 9. 21. 
 * @author    : mark_iMac
 */
package util;

import java.util.Scanner;

public class UtilGetInput {
	

	public static Scanner intPicker = new Scanner(System.in);
	
	public static Point getPosition(){
		System.out.println("가로 입력(1~8):");
		int file = intPicker.nextInt();
		System.out.println("세로 입력(1~8):");
		int rank = intPicker.nextInt();
		
		rank = UtilConv.convToInnerRank(rank);
		file = UtilConv.convToInnerFile(file);
		
		return new Point(rank, file);
	}

}
