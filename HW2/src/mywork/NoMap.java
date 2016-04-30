package mywork;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class NoMap extends Mapper <LongWritable, Text, Text, IntWritable>{

	public static final IntWritable	one		=	new IntWritable(1);
	public static Text			word	=	new Text();
	public void map(LongWritable key,Text value, Context context) throws IOException, InterruptedException {
		
		StringTokenizer st	=	new StringTokenizer(value.toString());
		while(st.hasMoreElements()){
			String temp			=	st.nextToken();
			int length			=	temp.length();
			//conversion of int to String
			String tempLength	=	Integer.toString(length);
			word.set(tempLength);
			context.write(word,one);
		}
	}

}







