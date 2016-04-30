package Temp;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxReduce extends Reducer<Text,IntWritable,Text,IntWritable>{

	
	public void reduce(Text	key,Iterable<IntWritable> Values,Context context) throws IOException, InterruptedException{
	
		int maxtemp	=	0;
		
		for(IntWritable count	:	Values){
			if(maxtemp<count.get())
			{
				maxtemp	=	count.get();
			}
		}
		
		context.write(key,new  IntWritable(maxtemp));
	}
	
}
