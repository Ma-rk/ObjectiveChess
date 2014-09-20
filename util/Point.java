/**
 * @createdate: 2014. 9. 17. 
 * @author    : mark_iMac
 */
package util;

public class Point {
	private int rank;
	private int file;

	public Point(int rank, int file) {
		this.rank = rank;
		this.file = file;
	}

	public int getRank() {
		return rank;
	}
	
	public int getFile() {
		return file;
	}
	
	Point setPosition(int newRank, int newFile) {
		return new Point(newRank, newFile);
	}
}
