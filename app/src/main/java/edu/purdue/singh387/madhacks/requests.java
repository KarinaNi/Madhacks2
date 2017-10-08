package edu.purdue.singh387.madhacks;

import android.content.Context;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class requests{
	private final String USER_AGENT = "Dalvik/2.1.0";

	public static void main(String[] args) throws Exception {
		requests http = new requests();
	}
	public String helper(String key[][],String url)
        {
            String finalURL = url+"?";
            for(String row[]:key)
            {
                finalURL=finalURL+row[0]+"="+row[1]+"&";
            }
            finalURL=finalURL.substring(0, finalURL.length()-1);
            return finalURL;
        }

	public String get(String key[][], String urlStart) throws Exception {
		URL url = new URL(helper(key,urlStart));
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("accept", "application/json");
		int responseCode = con.getResponseCode();
		// System.out.println("\nSending 'GET' request to URL : " + url);
		// System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		// System.out.println(response.toString());
		in.close();
		return response.toString();
	}

	public String send(String key[][], String urlStart, String filename) throws Exception {
		URL url = new URL(helper(key,urlStart));
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("accept", "application/json");

		File file = new File(filename);

        byte[] b = new byte[(int) file.length()];
        try {
               FileInputStream fileInputStream = new FileInputStream(file);
               fileInputStream.read(b);
          } catch (FileNotFoundException e) {
                      System.out.println("File Not Found.");
                      e.printStackTrace();
          }
          catch (IOException e1) {
                   System.out.println("Error Reading The File.");
                    e1.printStackTrace();
          }

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.write(b);
		wr.flush();
		wr.close();
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		if (responseCode == 200) {
			System.out.println("works");
		} else {
			System.out.println("Insufficient success");
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		System.out.println(response.toString());

		return response.toString();
	}
}
