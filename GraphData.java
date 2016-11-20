package Graph;
/**
 * 
 * @author Jonathan T. Fetzer
 * class: CS 480, Cal Poly Pomona
 * group: Sounds Neat
 *
 */
import java.util.List;

public class GraphData {
	private List<String> x;
	private List<Integer> y;
	private String name = "";
	private String type = "";
	
	GraphData(List<String> x, List<Integer> y, String name, String type){
		this.x = x;
		this.y = y;
		this.name = name;
		this.type = type;
	} // end constructor
	
	public List<String> getX() {
		return x;
	}

	public void setX(List<String> x) {
		this.x = x;
	}

	public List<Integer> getY() {
		return y;
	}

	public void setY(List<Integer> y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
} // end class Crime
