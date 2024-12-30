/*Assignment 3 (AccessibilityTest): Lilli Lewis 
 * 10/08/23
 * I confirm that the above list of sources is complete (none) AND that I have 
 *  not talked to anyone else about the solution to this problem.*/
public class AccessibilityTest {
	//fields
	private String category;
	private String google_result;
	private String wave_result;
	private String sortsite_result;
	private String aslint_result;
	private String test_description;
	
	//constructor
	public AccessibilityTest(String category, String google_result, String wave_result, String sortsite_result, String aslint_result, String test_description) {
		this.category = category;
		this.google_result = google_result;
		this.wave_result = wave_result;
		this.sortsite_result = sortsite_result; 
		this.aslint_result = aslint_result;
		this.test_description = test_description;
	}//constructor
	
	
	/**
	 * Category accessor method
	 * @return float price
	 */	
	public String getCategory() {
		return category;
	}//getCategory
	
	
	/**
	 * Google result accessor method
	 * @return float price
	 */
	public String getGoogle_result() {
		return google_result;
	}//getGoogle_result
	
	
	/**
	 * WAVE result accessor method
	 * @return float price
	 */
	public String getWave_result() {
		return wave_result;
	}//getWave_result
	
	
	/**
	 * SortSite result accessor method
	 * @return float price
	 */
	public String getSortsite_result() {
		return sortsite_result;
	}//getSortsite_result
	
	
	/**
	 * ASLint result accessor method
	 * @return float price
	 */
	public String getAslint_result() {
		return aslint_result;
	}//getAslint_result
	
	
	/**
	 * Test description accessor method
	 * @return float price
	 */
	public String getTest_description() {
		return test_description;
	}//getTest_description

	
	/**
	 * Overridden toString method
	 * @return String version of AccessibilityTest
	 */
	@Override
	public String toString() {
		return getCategory() + ": " + getTest_description() +
				" Google: " + getGoogle_result() + 
				" WAVE: " + getWave_result() + 
				" Sortsite: " + getSortsite_result() + 
				" ASLint: " + getAslint_result();
	}//toString
	
}//class
