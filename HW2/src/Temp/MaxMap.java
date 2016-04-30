package Temp;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxMap extends Mapper<LongWritable,Text,Text,IntWritable>{

	public static IntWritable one	=	new IntWritable(1);
	public static Text word	=	new Text("1991");
	
	public void map(LongWritable key,Text Value,Context context) throws IOException, InterruptedException{
		
		StringTokenizer st	=	new	StringTokenizer(Value.toString());
		
		while(st.hasMoreTokens()){
		
			String year	=	st.nextToken();	
			int	   temp	=	Integer.parseInt(st.nextToken());	
			/*if(length>4){
				String	year	=	tempValue.substring(length-5, length-1); 
				int		temp	=	Integer.parseInt(tempValue.substring(0, length-5));
				one		=	new	IntWritable(temp);
				word.set(year);
				//context.write(word,one);
			}*/
			
			word.set(year);
			one = new IntWritable(temp);
			context.write(word,one);
		}
	}
}
