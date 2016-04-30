package cert.mod3;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class ThreeMapper extends Mapper<LongWritable, Text, ThreeCustomeKey, LongWritable>{

	public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException{
		ThreeCustomeKey	test	=	new	ThreeCustomeKey();
		StringTokenizer	str	=	new StringTokenizer(value.toString(),",");
		while(str.hasMoreElements()){
			String	company	= 	str.nextToken();
			String	date	=	str.nextToken();
			String	open	= 	str.nextToken();
			String	high	=	str.nextToken();
			String	low		=	str.nextToken();
			String	close	=	str.nextToken();
			long	volume	= 	Long.parseLong(str.nextToken());
			String month	=	"";
			
			SimpleDateFormat	originalDate	=	new SimpleDateFormat("dd-MMM-yyyy");
			SimpleDateFormat	requireDate		=	new	SimpleDateFormat("MM-yyyy");
			String				tempMonth		=	"";	
			try {
			
				
				Date 	tempDate	=	originalDate.parse(date);
				month	=	requireDate.format(tempDate);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			test.setFirst(new Text(company));
			test.setSecond(new Text(month));
			context.write(test, new LongWritable(volume));
		}
		
	}
}
