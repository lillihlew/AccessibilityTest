/*Assignment 3 (IncorrectFileNameException): Lilli Lewis 
 * 10/08/23
 * I used this source https://www.baeldung.com/java-new-custom-exception to create
 *  my custom IncorrectFileNameException. It just so happens that that source created
 *  that same exception, so I used that code for this entire file. None of this code is mine.
 * I confirm that the above list of sources is complete AND that I have 
 *  not talked to anyone else about the solution to this problem.*/
public class IncorrectFileNameException extends Exception { 
    private static final long serialVersionUID = 1L; //Eclipse generated this line for me

	public IncorrectFileNameException(String errorMessage) {//I don't use this
        super(errorMessage);
    }
}