package com.newt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadCSV {

	public static void main(String[] args) {

    	String urlstr = "http://192.168.1.176:8080/jenkins/job/DevopsSecurityDemo/com.newt$DevopsSecurityDemo/ws/tools/changelog.csv/*view*";
		URL url;
		try {
			url = new URL(urlstr);
			HttpURLConnection  httpURLConnection = (HttpURLConnection)url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			final BufferedReader bufferreader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			String readline;
			while((readline=bufferreader.readLine())!=null){
				String[] comment=readline.split(",");
				ReadDescription.main(comment[5]);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
