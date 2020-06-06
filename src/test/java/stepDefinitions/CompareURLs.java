/**
 * 
 */
package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import base.Base;
import comparator.ResponseComparator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author nitinthite
 *
 */
public class CompareURLs extends Base {
	
	ResponseComparator compare;
	
	public CompareURLs() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Given("^Provided two files with list of APIs$")
	public void provideTwoFiles() throws Throwable { 
		
		compare = new ResponseComparator();
		compare.compareResponses(properties.getProperty("file1"), 
				properties.getProperty("file2")); 
		
	}

	@When("^If response data is equal$")
	public void ifResponseEqual() throws Throwable {
	  
	}
	
	@When("^If response data not equal$")
	public void ifResponseNotEqual() throws Throwable {
	  
	}
	
	@When("^If one not URL$")
	public void ifNotURL() throws Throwable {
	    
	}

	@Then("^Should respond result as equal$")
	public void respondAsEqual() throws Throwable {
	    
	}

	@Then("^Should respond result as not equal$")
	public void respondNotEqual() throws Throwable {
	    
	}

	@Then("^Should respond Invalid URL$")
	public void respondInvalidURL() throws Throwable {
	    
	}

}
