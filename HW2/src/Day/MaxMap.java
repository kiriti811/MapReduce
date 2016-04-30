package Day;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxMap extends Mapper<LongWritable,Text,Text,Text>{

	public static Text one	=	new Text();
	public static Text word	=	new Text();
	
	public void map(LongWritable key,Text Value,Context context) throws IOException, InterruptedException{
		
		StringTokenizer st	=	new	StringTokenizer(Value.toString());
		
		while(st.hasMoreTokens()){
			st.nextToken();
			String year	=	st.nextToken();	
			year	=	year.substring(4,6)+"-"+year.substring(6,8)+"-"+year.substring(0,4);
			st.nextToken();
			st.nextToken();
			st.nextToken();
			double maxTemp	=	Double.parseDouble(st.nextToken());	
			double minTemp	=	Double.parseDouble(st.nextToken());
			if(maxTemp>40.0)
			{
				one.set("Hot Day");
				word.set(year);
				context.write(word,one);
			}
			else if(minTemp<10.0)
			{
				one.set("Cold Day");
				word.set(year);
				context.write(word,one);
			}
			else if(maxTemp==minTemp){
				//
			}
			break;
		}
	}
}
