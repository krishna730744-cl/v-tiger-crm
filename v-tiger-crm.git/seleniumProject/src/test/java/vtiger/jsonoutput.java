package vtiger;

import reuseble.jsonExtraction;

public class jsonoutput {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String username=jsonExtraction.jsonextr("username");
		String password=jsonExtraction.jsonextr("password");
		String url1=jsonExtraction.jsonextr("birthdate");
		
		 System.out.println(username);
		 System.out.println(password);
		 System.out.println(url1);
	}

}
