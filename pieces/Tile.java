/**
 * @createdate: 2014. 9. 16. 
 * @author    : mark_iMac
 */
package pieces;

import util.UtilEtc.Color;

public class Tile {
	private String image = null;
	protected String name = null;

	private Color color = Color.noColor;

	public Tile(String image, String name, Color color) {
		this.image = image;
		this.name = name;
		this.color = color;
	}

	public String getImage() {
		return image;
	}

	public Color getColor() {
		return this.color;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return "Tile instance. " + image;
	}
}