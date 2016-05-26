package com.newt;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectJira {

	public static String display(String string) {
		
		StringBuilder responseData=new StringBuilder();
		try {
			
			String urlstr="http://192.168.1.176:8082/rest/api/latest/issue/".concat(string); //JIRA Url
			
			URL url=new URL(urlstr);
			HttpURLConnection httpurlconnection=(HttpURLConnection)url.openConnection();
			String userpassword="c3llZGE6c3llZGE=";
			
			 //Connecting with JIRA Server
		    httpurlconnection.setRequestMethod("GET");
		    httpurlconnection.setRequestProperty("Content-Type", "application/json");
		    httpurlconnection.setRequestProperty("charset", "UTF-8");
		    httpurlconnection.setRequestProperty("Authorization","Basic "+userpassword);
		    
		    //Reading the user stories
		    final BufferedReader reader=new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
			String readLine;
			while ((readLine=reader.readLine())!=null){
				responseData.append(readLine);
				}
			
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}catch (FileNotFoundException e){
				System.out.println("User Story does not exists in JIRA");
			}catch (IOException e) {
				e.printStackTrace();
			}
		return responseData.toString();
		}

}
