/**
 * 
 */
package comparator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import base.Base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

/**
 * @author nitinthite
 *
 */
public class CompareResponses extends Base {

	public CompareResponses() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	protected static RequestSpecification httpRequest;
	protected Response response;
	protected static String bodyAsString;
	protected static ResponseBody body;
	protected static JSONObject jsonObject;
	protected JSONObject res1, res2;

	public void responseComparator(String file1, String file2) throws IOException {

		boolean result = false;

		try {
			// creates a new file instance
			File f1 = new File(file1.toString());
			File f2 = new File(file2.toString());
			
			long lengthURL = f1.length() > f2.length() ? f1.length() : f2.length();
			System.out.println(lengthURL);

			// Reads the file given
			FileReader filereader1 = new FileReader(f1);
			FileReader filereader2 = new FileReader(f2);
//
//			// creates a buffering character input stream
			BufferedReader bufferreader1 = new BufferedReader(filereader1);
			BufferedReader bufferreader2 = new BufferedReader(filereader2);

			// constructs a string buffer with no characters
			StringBuffer stringbuffer1 = new StringBuffer();
			StringBuffer stringbuffer2 = new StringBuffer();
				
			String linefile1, linefile2, url1, url2;
			while ((linefile1 = bufferreader1.readLine()) != null 
					&& (linefile2 = bufferreader2.readLine()) != null) {
				// appends line to string buffer
				stringbuffer1.append(linefile1);
				stringbuffer2.append(linefile2);

				// line feed
				stringbuffer1.append("\n");
				stringbuffer2.append("\n");
				
				url1 = stringbuffer1.toString();
				System.out.println("File 1 length is: " + url1);

				url2 = stringbuffer2.toString();
				System.out.println("File 2 length is: " + url2);
				
				res1 = getResponse(url1);
				res2 = getResponse(url2);

				System.out.println(url1 + (res1 == res2 ? "" : " not") + " equals " + url2);
//				result = res1 == res2;
			}

		} 
		catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JSONObject getResponse(String url) throws ParseException  {
		int actualStatusCode;

		// Specifying URI to test
		RestAssured.baseURI = url;
		httpRequest = RestAssured.given();

		// Storing response received in response object
		response = httpRequest.request().get().peek();
		System.out.println("Response received for " + url + ": " + response);
		
		actualStatusCode = response.getStatusCode();
		System.out.println("Response code received for " + url + ": " + actualStatusCode);
		
		if (actualStatusCode!=200) {
			
			// Retrieve the body of the Response
			body = response.getBody();

			// To check for sub string presence get the Response body as a String.
			bodyAsString = body.asString();
			
			// To Parse json files
			Object obj = new JSONParser().parse(bodyAsString);
					
			JSONObject jo = (JSONObject) obj; 
			
			System.out.println("Response body received for " + url + ": " + jo);
		}
		else {
			jsonObject = null;
		}

		return jsonObject;

	}

}
