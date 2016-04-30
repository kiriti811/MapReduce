package cert.sort;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class SixMapper extends Mapper<LongWritable, Text, SixCustomeKey, Text>{

	public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException{
		SixCustomeKey	test	=	new	SixCustomeKey();
		StringTokenizer	str	=	new StringTokenizer(value.toString(),",");
		while(str.hasMoreElements()){
			String	company	= 	str.nextToken();
			String	date	=	str.nextToken();
			String	open	= 	str.nextToken();
			String	high	=	str.nextToken();
			String	low		=	str.nextToken();
			String	close	=	str.nextToken();
			String	volume	= 	str.nextToken();
			String	finalDate	="";
			SimpleDateFormat	testDate1	=	new	SimpleDateFormat("dd-MMM-yyyy");
			SimpleDateFormat	testDate2	=	new	SimpleDateFormat("yyyyMMdd");
			try {
				Date	newDate	=	testDate1.parse(date);
				finalDate	=	testDate2.format(newDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test.setFirst(new Text(company));
			test.setSecond(new LongWritable(Long.parseLong(finalDate)));
			context.write(test, new Text(open+","+high+","+low+","+close+","+volume));
		}
		
	}
}
