package cert.mod5;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FiveReducer extends Reducer<FiveCustomeKey, Text, FiveCustomeKey, Text>{

	public void reduce(FiveCustomeKey key,Iterable<Text> value,Context context) throws IOException, InterruptedException{
		
		
		for(Text result:value){
			context.write(key, result);
		}
		
	}
	
}
