package mywork;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class PatentMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	public static final IntWritable	one	= new IntWritable(1);
	public static Text word = new Text();
	public void map(LongWritable key,Text Value,Context context) throws IOException, InterruptedException{
		StringTokenizer	st	=	new StringTokenizer(Value.toString());
		while(st.hasMoreElements()){
			word.set(st.nextToken());
			st.nextToken();
			context.write(word, one);
		}
	}

}
