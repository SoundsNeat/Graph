package Graph;
/**
 * 
 * @author Jonathan T. Fetzer
 * class: CS 480, Cal Poly Pomona
 * group: Sounds Neat
 *
 */
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GetGraph{
	private String jsonString = "";
	private String layout = "";
	
	GetGraph(CrimeStats city){
		this(city, "bar");
	} // end constructor
	
	GetGraph(CrimeStats city, String graphType) {
		List<String> x = new ArrayList<>();
		x.add("Murders");
		x.add("Rapes");
		x.add("Roberies");
		x.add("Assaults");
		x.add("Thefts");
		x.add("Auto Thefts");
		x.add("Arsons");

		List<Integer> y = new ArrayList<>();
		y.add(city.getNumMurders(city.getCrimeDataYear(city.getCrimeDataYears().length - 1)));
		y.add(city.getNumRapes(city.getCrimeDataYear(city.getCrimeDataYears().length - 1)));
		y.add(city.getNumRobberies(city.getCrimeDataYear(city.getCrimeDataYears().length - 1)));
		y.add(city.getNumAssaults(city.getCrimeDataYear(city.getCrimeDataYears().length - 1)));
		y.add(city.getNumThefts(city.getCrimeDataYear(city.getCrimeDataYears().length - 1)));
		y.add(city.getNumAutoThefts(city.getCrimeDataYear(city.getCrimeDataYears().length - 1)));
		y.add(city.getNumArsons(city.getCrimeDataYear(city.getCrimeDataYears().length - 1)));
		
		String name = city.getCity() + ", " + city.getState();
		String type ;
		if(graphType.equals("bar") || graphType.equals("line")){
			type = graphType;
		} else {
			type = "bar";
		} // end else
		
		ObjectMapper mapper = new ObjectMapper();
		
		GraphData obj = new GraphData(x, y, name, type);
		
		//Object to JSON in file
		//	mapper.writeValue(new File("c:\\file.json"), obj);
	
		//Object to JSON in String
		try{
			jsonString = "[" + mapper.writeValueAsString(obj) + "]";
		} catch(Exception e){
			e.printStackTrace();
		} // end catch
	} // end constructor
		
	public String toJSON(){
		return jsonString;
	}
	
	public String getLayout(){
		return layout;
	}
} // end class
