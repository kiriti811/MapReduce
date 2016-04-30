package cert.mod7;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class FirstMapper extends Mapper<Text, Text, Text, Text>{

	public void map(Text key,Text value,Context context) throws IOException, InterruptedException{
		
		context.write(key, value);
	}
}
