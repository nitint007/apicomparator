/**
 * 
 */
package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import base.Base;
import comparator.CompareResponses;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author nitinthite
 *
 */
public class CompareURLs extends Base {
	
	CompareResponses compareresponse;
	
	public CompareURLs() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Given("^Provided two files with list of APIs$")
	public void provideTwoFiles() throws Throwable {
		compareresponse = new CompareResponses();
		compareresponse.responseComparator(properties.getProperty("file1"), 
				properties.getProperty("file2"));  
	}

	@When("^If response data is equals$")
	public void ifResponseEqual() throws Throwable {
	  
	}

	@Then("^Should respond result as equal$")
	public void respondAsEqual() throws Throwable {
	    
	}

	@Then("^Should respond result as not equal$")
	public void respondNotEqual() throws Throwable {
	    
	}

	@When("^If one not URL$")
	public void ifNotURL() throws Throwable {
	    
	}

	@Then("^Should respond Invalid URL$")
	public void respondInvalidURL() throws Throwable {
	    
	}

}
