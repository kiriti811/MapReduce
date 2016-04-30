package cert.mod6;

import java.io.IOException;
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
			test.setFirst(new Text(company));
			test.setSecond(new Text(date));
			context.write(test, new Text(open+","+high+","+low+","+close+","+volume));
		}
		
	}
}
