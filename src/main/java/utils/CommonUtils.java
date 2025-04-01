package utils;

import java.util.Date;

public class CommonUtils {
	
	public static final int IMPLICIT_WAITTIME = 10;
	public static final int EXPLICIT_WAITTIME = 30;
	public static final int PAGE_LOAD_TIME = 15;
	public String getEmailWithTimestamp() {
		Date date = new Date();
		return "ajay"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
	
}
