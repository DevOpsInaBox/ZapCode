package com.newt;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class ReadDescription {

	public static void main(String string) throws IOException, InterruptedException {
		
		//Verify if the comment contains the user stories
		if(string.contains("#")){
			String str=string.substring(string.indexOf("#")+1,string.lastIndexOf("#")); //Getting the user story from the comment
			
			String data=ConnectJira.display(str);		//Passed to connect to JIRA and verify the user stories defined in JIRA.
			
			ObjectMapper objectmapper=new ObjectMapper();
			ObjectReader reader=objectmapper.reader(Object.class);
			
			HashMap<String,Object> JSON=null;
			
			if(data!=null && !data.isEmpty()){
				try {
					JSON=reader.readValue(data);
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(JSON!=null && !JSON.isEmpty()){
				HashMap<String,Object> desc=(HashMap<String, Object>)JSON.get("fields");
				String val=String.valueOf(desc.get("description"));
				RunTest.testToRun(val.toString());
			}
		}else if(string!=null && !string.contains("#")){
			System.out.println("No User Stories defined for the commit");
		}else if (string==null || string.isEmpty()){
			System.out.print("No commit description ");
		}
	}
}
