package cert.mod7;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FirstReducer extends Reducer<Text, Text, Text, Text>{

	public void reduce(Text key,Iterable<Text> value,Context context) throws IOException, InterruptedException{
		
		
		for(Text result:value){
			context.write(key, result);
		}
		
	}
	
}
