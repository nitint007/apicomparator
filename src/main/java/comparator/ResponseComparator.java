/**
 * Package consists class to provide comparison details for URLs provided
 */
package comparator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import base.Base;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

/**
 * @author nitinthite
 * Class to implement methods to compare URL responses for equality
 */
public class ResponseComparator extends Base{
	
	// To make the objects available throughout the class methods and sub packages
	protected RequestSpecification httpRequest;
	protected Response response;
	protected String bodyAsString;
	protected ResponseBody body;
	protected String url1, url2, res1, res2;

	public ResponseComparator() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	// Method comparing two responses
	public void compareResponses(String file1, String file2) throws IOException, ParseException, URISyntaxException, NoSuchElementException {

		try {
			// creates a new file instance
			File f1 = new File(file1.toString());
			File f2 = new File(file2.toString());
			
			Scanner sc1 = new Scanner(f1);  
			Scanner sc2 = new Scanner(f2);
			
			String res1;
			String res2;
			
			while(sc1.hasNextLine() || sc2.hasNextLine()) {  
				
				// To store line content to string
				url1 = sc1.nextLine();
				url2 = sc2.nextLine();
				
				// To store responses received from method
				res1 = getResponse(url1);
				res2 = getResponse(url2);
				
				// To compare and print results for URLS compared
				System.out.println(url1 + (res1 == res2 ? " " : " not ") + " equals " + url2);
			}
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
			throw new RuntimeException("* * * * * Issue with file input");
		}
		catch (ParseException pe) {
			pe.printStackTrace();
			throw new RuntimeException("* * * * * Issue Parsing file");
		}
		catch (URISyntaxException urise) {
			urise.printStackTrace();
			throw new RuntimeException("* * * * * Issue URI syntax");
		}
		catch (NoSuchElementException nsee) {
			nsee.printStackTrace();
			throw new RuntimeException("* * * * * One of file under comparison has no more lines present");
		}
	}

	
	// To fetch response from requested url and reverting respective
	private String getResponse(String url) throws ParseException, URISyntaxException  {
		
		// Method variables and declaring objects
		int actualStatusCode;
		String res;
		
		// Specifying URI to test
		RestAssured.baseURI = url;
		httpRequest = RestAssured.given();

		// Storing response received in response object
		response = httpRequest.request().get();
		
		actualStatusCode = response.getStatusCode();
		
		// Code block for valid responses for further operations
		if (actualStatusCode == 200) {
			
			// Retrieve the body of the Response
			body = response.getBody();

			// To check for sub string presence get the Response body as a String.
			bodyAsString = body.asString();
			
			res = bodyAsString;
		}
		else {
			res = "Invalid";
		}
		return res;
	}
}
