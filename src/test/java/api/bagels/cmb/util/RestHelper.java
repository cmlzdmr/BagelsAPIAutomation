package api.bagels.cmb.util;

public class RestHelper {
	
	public static final String USERNAME = "cmb";
	public static final String PASSWORD = "bagel";	
	
	public enum Methods{
		POST,GET
	}
	
	public static String getUri() {
		return "https://cmb-bagels-api.herokuapp.com/bagels/";
	}
	
	
}
