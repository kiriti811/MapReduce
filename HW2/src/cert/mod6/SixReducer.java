package cert.mod6;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SixReducer extends Reducer<SixCustomeKey, Text, SixCustomeKey, Text>{

	public void reduce(SixCustomeKey key,Iterable<Text> value,Context context) throws IOException, InterruptedException{
		
		
		for(Text result:value){
			context.write(key, result);
		}
		
	}
	
}
