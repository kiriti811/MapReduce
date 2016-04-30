package Day;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxReduce extends Reducer<Text,Text,Text,Text>{

	
	public void reduce(Text	key,Iterable<Text> Values,Context context) throws IOException, InterruptedException{
	
		String sum	=	"";
		
		for(Text count	:	Values){
			
				sum	=	count.toString();
			
		}
		
		context.write(key,new Text(sum));
	}
	
}
