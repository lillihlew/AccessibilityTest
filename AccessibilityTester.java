/*Assignment 3 (AccessibilityTester): Lilli Lewis 
 * 10/09/23
 * I confirm that the above list of sources is complete (none) AND that I have 
 *  not talked to anyone else about the solution to this problem.*/
public class AccessibilityTester {
	//I guess these are fields, I'm just using them as constants, so I don't feel the need to make them private
	public static final int NUMCATS = 19; //19 categories, and 1 total row. When I use +1 in the loops, it's to account for the total row.
	public static int NUMCHECKS = 4; //4 types of check, 1 total test column. When I use +1 in the loops, it's to account for the total test column.
	
	/**
	 * Prints a table of the errors in each category, if each checker caught them , 
	 * and the total number of tests possible
	 * @param ar, an AccessibilityResults 
	 */
	public static void extraCredit(AccessibilityResults ar) {
		int arr[][] = new int [NUMCATS+1][NUMCHECKS+1];//make new 2D array to store test results in
		int colSum[] = {0, 0, 0, 0, 0}; //make an array to store the sum of the columns of arr
		//make an array of abbreviations of the categories, to be iterated through in calls to numPass
		String catArr[] = {"cont", "lay","col", "typo", "lang", "title", "head", "list", "table", "image", "multi", "link", "button", "forms", "navig", "keyb", "frame", "CSS", "HTML"};
		for(int i = 0; i<NUMCATS; i++) {//call numPass with every category and test type, storing their values into arr
			arr[i][0] = ar.numPass("goog", catArr[i]);//Google column
			colSum[0] += arr[i][0];//add column value to sum array
			arr[i][1] = ar.numPass("wave", catArr[i]);//WAVE column
			colSum[1] += arr[i][1];//add column value to sum array
			arr[i][2] = ar.numPass("sort", catArr[i]);//SortSite column
			colSum[2] += arr[i][2];//add column value to sum array
			arr[i][3] = ar.numPass("lint", catArr[i]);//ASLint column
			colSum[3] += arr[i][3];//add column value to sum array
			arr[i][4] = ar.showByCategoryCount(catArr[i]);//last column, holding the category count
			colSum[4] += arr[i][4];//add column value to sum array
		}//for
		
		for(int i = 0; i<NUMCHECKS+1; i++) {//store colSum array into last row of arr
			arr[NUMCATS][i] = colSum[i];
		}//for
		
		//make another array with the nice, correctly capitalized, formatted versions of the category names, to be included in the printed table
		String[] categories = {"Content         |", "Layout          |", "Colour/Contrast |", "Typography      |", "Language        |", 
				"Title           |", "Headings        |", "Lists           |", "Tables          |", "Images          |", 
				"Multimedia      |", "Links           |", "Buttons         |", "Forms           |", "Navigation      |", 
				"Keyboard        |", "Frames          |", "CSS             |", "HTML            |", "Total           |"};
		
		System.out.println("Category\t  Google Checker\tWAVE Checker\tSortsite Checker    ASLint\tTotal Number of Tests Possible");//print table header
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		for(int i = 0; i<(NUMCATS); i++) {//print arr
			System.out.print(categories[i] + "\t");
			for(int j=0; j<(NUMCHECKS+1); j++) {
				System.out.print(arr[i][j] + "\t\t      ");//space the numbers according to header spacing
			}//for
			//I used the commented out line below for my answer to the first question in the Report. This line gives the average success in error finding for each category.
			//System.out.print(((((double)arr[i][0] + (double)arr[i][1] + (double)arr[i][2] + (double)arr[i][3])/4)/ (double)arr[i][4]));
			System.out.println();
		}//for
		//customize last line to match format
		System.out.print("Total           |\t"+arr[19][0]+"\t\t      "+arr[19][1]+"\t      "+arr[19][2]+"\t      "+arr[19][3]+"\t      "+arr[19][4]);
	}//extraCredit
	
	
	/*
	 * To the grader,
	 * Since we're supposed to write methods that return a lot of output at testing, the code below is commented both 
	 * in the green // comments and, if you compile and run the code, in the output (or at least, it's split into chunks 
	 * and labeled with the method call in the output.
	 * I don't know if this helps you or not, but I hope it does.
	 * Thank you!
	 */
	public static void main(String[] args) throws IncorrectFileNameException {
		if (args.length!=1) {//guard against incorrect arguments
			System.out.println("Please enter only the name of the file");
			System.exit(0);
		}//if
		AccessibilityResults a11y = new AccessibilityResults(args[0]);//initialize AccessibilityResults with arg0 (a11yCheckersResult.txt)
		System.out.println("Num tests: " + a11y.numTests() + "\n");//test numTests (successful)
		System.out.println("a11y.showTestResults(\"colour\")");
		a11y.showTestResults("colour");//test showTestResults with keyword "colour" (successful)
		System.out.println("\n"+ "\n"+"a11y.showByCategory(\"Key\")");
		a11y.showByCategory("Key");//test showByCategory with keyword "Key" (successful)
		System.out.println("\n"+ "\n"+"a11y.showAllFailed()");
		a11y.showAllFailed();//test showAllFailed (successful)
		System.out.println();
		System.out.println("\nnumPass(\"Goog\",\"\") result: " + a11y.numPass("Goog","")); //test numPass with proper test and no category (successful)
		System.out.println();
		System.out.println("numPass(\"lint\",\"htm\") result: " + a11y.numPass("lint","htm"));//test numPass with proper test and category input (successful)
		System.out.println();
		//test numPass with improper test input (this correctly indicates incorrect checker input and quits the program, so I've commented it out)
		//System.out.println(ally.numPass("wrong","htm"));
		System.out.println("\nextraCredit(a11y)");
		extraCredit(a11y);//run extra credit table
	}//main

}//class
