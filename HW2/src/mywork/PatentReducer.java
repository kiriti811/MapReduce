package mywork;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class PatentReducer extends Reducer<Text,IntWritable,Text,IntWritable>{

	public void reduce(Text key,Iterable<IntWritable> value,Context context) throws IOException, InterruptedException{
	
		int sum		=	0;
		for(IntWritable count	: value){
			sum	=	sum	+ count.get();
		}
		context.write(key,new IntWritable(sum));
	}
}
