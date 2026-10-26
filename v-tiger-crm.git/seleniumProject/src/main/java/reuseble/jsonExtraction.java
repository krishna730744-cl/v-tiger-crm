package reuseble;

	import java.io.FileReader;

	import org.json.simple.JSONObject;
	import org.json.simple.parser.JSONParser;

	
	public class jsonExtraction {

		public static String jsonextr(String key) throws Exception {
			
			// TODO Auto-generated method stub
			// Step 1: Create JSONParser object
			 JSONParser parser = new JSONParser();
			 // Step 2: Pass JSON file path
			 FileReader reader = new FileReader(
			 "C:\\Users\\user\\eclipse-workspace\\seleniumProject\\src\\main\\resources\\datas1.json");
			 // Step 3: Parse JSON file
			 Object obj = parser.parse(reader);
			 // Step 4: Convert object into JSONObject
			 JSONObject jsonObject = (JSONObject) obj;
			 String value = jsonObject.get(key).toString();
			 // Step 5: Read data using key
			
			return value;



	}

}
