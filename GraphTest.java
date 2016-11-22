package Graph;
/**
 * 
 * @author Jonathan T. Fetzer
 * class: CS 480, Cal Poly Pomona
 * group: Sounds Neat
 *
 */

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GraphTest {

	public static void main(String[] args) throws Exception {
		boolean JSON = false; // example input: {"city":"Pomona","state":"California"}
		CreateCrimeStats cityA = null;
		
		if(JSON){
			ObjectMapper mapper = new ObjectMapper();
	//		replaceAll method prevents mapper.readValue from stripping quotation marks out of JSON format.
			CityState cityState = mapper.readValue((args[0].replaceAll("\"", "\\\"")), CityState.class);
			try {
				cityA = new CreateCrimeStats(cityState.city, cityState.state);
			} catch (IOException e) {
				e.printStackTrace();
			} // end catch
		} else { // example input: Pomona California
			if(args.length < 2) throw new Exception("must provide city and state as arguments, e.g. Pomona California");
			else if(args.length >= 2){ // for inputs such as Los Angeles California
				int i;
				if(args[args.length - 1].equals("York")){
					args[args.length - 1] = args[args.length - 2] + "-" + args[args.length - 1];
					args[args.length - 2] = "";
				}
				for (i = 1; i < args.length - 1; i++) {
					args[0] = args[0] + " " + args[i];
				} // end for i
				args[0] = args[0].trim();
				args[1] = args[i];
//				System.out.println(args[0] + ", " +  args[1]);
//				System.exit(0);
				try {
					cityA = new CreateCrimeStats(args[0], args[1]);
				} catch (IOException e) {
					e.printStackTrace();
				} // end catch
			} // end else if
		} // end else
		
//------------------------Graph---------------------------------
		GetGraph graph = new GetGraph(cityA.crimeStats);
		
		System.out.println(graph.toJSON() + "\n");
		
	} // end method main
	
} // end class
