package cert.mod1;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class FirstMapper extends Mapper<LongWritable, Text, Text, Text>{

	public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException{
		
		StringTokenizer	str	=	new StringTokenizer(value.toString(),",");
		while(str.hasMoreElements()){
			String	company	= 	str.nextToken();
			String	date	=	str.nextToken();
			String	open	= 	str.nextToken();
			String	high	=	str.nextToken();
			String	low	= 	str.nextToken();
			String	close	=	str.nextToken();
			String	volume	= 	str.nextToken();
			context.write(new Text(date), new Text(company+","+date+","+open+","+high+","+low+","+close+","+volume));
		}
		
	}
}
