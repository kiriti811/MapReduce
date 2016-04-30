package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String[] args) {

		Long test	=	(long) 3.0;
		int		count		=	0;
		Long	avergae		=	0L;
		Long	total		=	0L;
		while(test!=0){
			count	=	count	+	1;
			total	=	total	+	test;
			test	=	test	-	1;
			System.out.println(total);
			System.out.println(count);
		}
		avergae	=	total	/	count;	
		System.out.println("t"+total);
		System.out.println("c"+count);
		System.out.println(avergae);
	}

}
