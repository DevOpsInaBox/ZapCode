package com.newt;
import java.io.IOException;

public class RunTest {

	public static void testToRun(String jiraUserStory) throws IOException, InterruptedException {
		String test=jiraUserStory.substring(jiraUserStory.indexOf("#")+1, jiraUserStory.lastIndexOf("#"));		
		
		System.out.println("Test to run :: "+test);
		
		if(test.equalsIgnoreCase("ZAP")){
			ProcessBuilder pb = new ProcessBuilder("curl", "http://zaptest:11c2c079bd038a37e06b39c0852776a3@192.168.1.176:8080/jenkins/job/ZAPTest/build?token=a5BaPHazW924e2hma9g652Db28Wru3e4");
			Process p = pb.start();
			System.out.println("Running ZAP TEst "+p.waitFor());
		}
		if(test.equalsIgnoreCase("SKIP")){
			System.out.println("No Tests to run for the current commit");
		}
	} 
}
