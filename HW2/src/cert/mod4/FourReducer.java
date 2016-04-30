package cert.mod4;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FourReducer extends Reducer<FourCustomeKey, Text, FourCustomeKey, Text>{

	public void reduce(FourCustomeKey key,Iterable<Text> value,Context context) throws IOException, InterruptedException{
		
		
		for(Text result:value){
			context.write(key, result);
		}
		
	}
	
}
