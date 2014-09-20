/**
 * @createdate: 2014. 9. 17. 
 * @author    : mark_iMac
 */
package util;

public class PointPosition {
	private int file;
	private int rank;

	public PointPosition(int file, int rank) {
		this.file = file;
		this.rank = rank;
	}

	public int getFile() {
		return file;
	}

	public int getRank() {
		return rank;
	}
	
	PointPosition setPosition(int newFile, int newRank) {
		return new PointPosition(newFile, newRank);
	}
}
