package please.run.ibk.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.ws.ProtocolException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import please.run.ibk.controller.ControllerSupport;
@Service
public class RestClient {
	
	
	private static final Logger logger = LoggerFactory.getLogger(RestClient.class);
	
	public static HttpsURLConnection getHttpsURLConnection(String https_url) {
		URL url;
		HttpsURLConnection con = null;
		try {
    		url = new URL(https_url);
    		con = (HttpsURLConnection)url.openConnection();
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return con;
	}
	
	
	
	public String executeRestClientPost(Map<String, Object> request,String url,String clientID){
		
		HttpsURLConnection con=getHttpsURLConnection(url);
		String resul=null;
		con.setDoOutput(true);    		
		try {
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("X-IBM-Client-Id", clientID);

			String input =ControllerSupport.buildJSONResponse(request);
    		OutputStream os = con.getOutputStream();
    		os.write(input.getBytes());
    		os.flush();
    		    		
    		if (con.getResponseCode() != 200) {
    			throw new RuntimeException("Failed : HTTP error code : "
    					+ con.getResponseCode());
    		}
    		
    		BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
    		
    		String output=null;
    		System.out.println("Output from Server .... \n");
    		while ((output = br.readLine()) != null) {
    			System.out.println(output);
    			resul=output;
    		}

    		con.disconnect();    
			
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resul;
	}
}
