package sampleCodes;


/**This is a class use to demo Java document comment feature
 * 
 *
 * @author Siran
 * @version 1.0.0.0
 */
public class JavaDocComment {
	private String username;
	
	
	/** Create a username with your login username
	 * 
	 * @param username
	 */
	//Constructor
	public JavaDocComment(String username) {
		this.username = username;
	}
	
	
	
	/**Gets the username of the object
	 * 
	 * @return username of the object
	 */
	public String getName() {
		return username;
	}
	

}


