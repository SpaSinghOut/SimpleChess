/**
 * 
 */

/**
 * @author spartak
 *
 */
public class Location {
	public int x,y;
	public Location(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Location(Location location){
		x = location.x;
		y = location.y;
	}
	@Override
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
