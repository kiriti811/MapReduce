package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String date = "18-Jan-2009";
		SimpleDateFormat	originalDate	=	new SimpleDateFormat("dd-MMM-yyyy");
		SimpleDateFormat	requireDate		=	new	SimpleDateFormat("MM-yyyy");
		String				tempMonth		=	"";	
		try {
		
			
			Date 	test	=	originalDate.parse(date);
			requireDate.format(test);
			
			System.out.println(requireDate.format(test));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
