/*Assignment 3 (AccessibilityResults): Lilli Lewis 
 * 10/08/23
 * I used this source https://www.baeldung.com/java-new-custom-exception to create
 *  my custom IncorrectFileNameException. It just so happens that that source created
 *  that same exception, so I used that code for my entire class file and one line in this file.
 * I confirm that the above list of sources is complete AND that I have 
 *  not talked to anyone else about the solution to this problem.*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AccessibilityResults{

	private static ArrayList<AccessibilityTest> results = new ArrayList<AccessibilityTest>();
	
	//constructor
		public AccessibilityResults(String fileName) throws IncorrectFileNameException {
			try {//file might not exist or not be able to be read
				// Read the file and create the ArrayList with the error information 
				if(!fileName.equals("a11yCheckersResults.txt")) {//check for correct file name
					throw new IncorrectFileNameException("This is the wrong file name, please use \"a11yCheckersResults.txt\"");
				}
				
				Scanner input = new Scanner(new File(fileName));//create a Scanner to use on the file
				
				while(input.hasNextLine()) {// load info into results array
					
					Scanner linescanner = new Scanner(input.nextLine());//create a Scanner to use on each line of the file
					
					//initialize Strings to take input from Scanner
					String category = "";
					String google_result = "";
					String wave_result = "";
					String sortsite_result = "";
					String aslint_result = "";
					String test_description = "";
					//Scan each new String into its corresponding variable, first checking to ensure there is a next value
					if(linescanner.hasNext()) {
						category = linescanner.next();
					}
					if(linescanner.hasNext()) {
						google_result = linescanner.next();
					}
					if(linescanner.hasNext()) {
						wave_result = linescanner.next();
					}
					if(linescanner.hasNext()) {
						sortsite_result = linescanner.next();
					}
					if(linescanner.hasNext()) {
						aslint_result = linescanner.next();
					}
					if(linescanner.hasNext()) {//get the first word in the test description
						test_description = linescanner.next();
					}
					while(linescanner.hasNext()) {//to get the rest of the words from the line and save them into the test description, keeping spacing
						test_description = test_description + " " + linescanner.next();
							
					}//while for test description
					//add Strings into an AccessibilityTest, and from there into the results ArrayList
					results.add(new AccessibilityTest(category, google_result, wave_result, sortsite_result, aslint_result, test_description));
					linescanner.close();//close line Scanner
				}//while for file
				input.close();//close input Scanner
			}//try
			catch(FileNotFoundException e){//handle possible exception from opening file
				System.out.println("Error: File not found");	
			}//catch
			catch(NoSuchElementException e) {
				System.out.println("Error: no such element found");
			}//catch
		} // end constructor
		
		
		
		/**
		 * The number of tests in the ArrayList
		 * @param results, an int
		 * @return the number of tests in the ArrayList
		 */
		public int numTests() {
			return results.size();
		}//numTests
		
		
		/**
		 * Uses testDetails as a keyword, searching through the results array test descriptions and printing all 
		 *  instances of the test results with test descriptions containing the keyword 
		 * @param testDetails, a String
		 */
		public void showTestResults(String testDetails) {
			int count = 0;
			testDetails = testDetails.toLowerCase();
			for(int i = 0; i<numTests(); i++) {
				if(results.get(i).getTest_description().toLowerCase().contains(testDetails)){
					System.out.println(results.get(i).toString());
					count++;
				}//if
			}//for
			System.out.println();
			System.out.println("Total tests matching: " + count);
		}//showTestResults
		
		
		/**
		 * Uses keyword as a keyword, searching through the results array categories and printing all 
		 *  instances of the test results with categories containing the keyword 
		 * @param keyword, a String
		 */
		public void showByCategory(String keyword) {
			int count = 0;
			keyword = keyword.toLowerCase();
			for(int i = 0; i<numTests(); i++) {
				if(results.get(i).getCategory().toLowerCase().contains(keyword)){
					System.out.println(results.get(i).toString());
					count++;
				}//if
			}//for
			System.out.println();
			System.out.println("Total tests matching: " + count);
		}//showByCategory
		
		
		/**
		 * Uses keyword as a keyword, searching through the results array categories and counting all 
		 *  instances of the test results with categories containing the keyword 
		 * @param keyword, a String
		 */
		public int showByCategoryCount(String keyword) {
			int count = 0;
			keyword = keyword.toLowerCase();
			for(int i = 0; i<numTests(); i++) {
				if(results.get(i).getCategory().toLowerCase().contains(keyword)){
					count++;
				}//if
			}//for
			return count;
		}//showByCategoryCount
		
		
		/**
		 * Searches through results array and prints instances where all tests failed 
		 * 	(where all results were equal to "notfound")
		 */
		public void showAllFailed() {
			String keyword = "notfound";
			int count = 0;
			for(int i = 0; i<numTests(); i++) {
				AccessibilityTest temp = results.get(i);
				if(temp.getGoogle_result().equals(keyword) &&
						temp.getWave_result().equals(keyword) &&
						temp.getSortsite_result().equals(keyword) &&
						temp.getAslint_result().equals(keyword)){
					System.out.println(temp.toString());
					count++;
				}//if
			}//for
			System.out.println();
			System.out.println("Total tests matching: " + count);
		}//showAllFailed
		
		
		
		/**
		 * Finds the number of instances in the specified category where the specified checker caught the error
		 * @param chName, a String: the name or partial name of a checker
		 * @param category, a String: the name or partial name of a category
		 * @return int, the number of instances in the specified category where the specified checker caught the error
		 */
		public int numPass(String chName, String category) {
			int count = 0;
			chName = chName.toLowerCase();			
			category = category.toLowerCase();
			for(int i = 0; i<numTests(); i++) {
				AccessibilityTest temp = results.get(i);
				if(temp.getCategory().toLowerCase().contains(category)){//in the right category
					if("wave".contains(chName)){
						if(errPaid(temp.getWave_result())){
							count++;
						}//if
					}else if("google".contains(chName)) {
						if(errPaid(temp.getGoogle_result())){
							count++;
						}//if
					}else if("sortsite".contains(chName)) {
						if(errPaid(temp.getSortsite_result())){
							count++;
						}//if
					}else if("aslint".contains(chName)) {
						if(errPaid(temp.getAslint_result())){
							count++;
						}//if
					}else {
						System.out.println("Error: Invalid checker input");
						System.exit(0);
					}//else
				}//if
			}//for
			return count;
		}//numPass
	
	
	
		/**
		 * Tells if the String entered is equal to either error or error_paid
		 * @param str
		 * @return true if String is either error or error_paid
		 */
		public static boolean errPaid(String str) {
			return ((str.equals("error")) || (str.equals("error_paid")));
		}//errPaid
		
		
}//class
