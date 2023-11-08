package GenericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * 
 * @author bgamm
 *
 */

public class JavaUtility {
	/**
	 * This method generates random number within the specified limit
	 * @param limit
	 */
public int generateRandomnum(int limit) {
	Random random=new Random();
	return random.nextInt(limit);
	
}
/**
 * This method generates current time
 * @return
 */
public String getCurrentTime() {
	Date date= new Date();
	SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
	return sdf.format(date);
	
}
}
