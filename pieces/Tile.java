/**
 * @createdate: 2014. 9. 16. 
 * @author    : mark_iMac
 */
package pieces;

import util.UtilEtc.Color;

public class Tile {
	private String image = null;

	private Color color = Color.noColor;

	public Tile(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;

	}
	
	public String toString(){
		return "Tile instance. " + image;
		
	}
}
