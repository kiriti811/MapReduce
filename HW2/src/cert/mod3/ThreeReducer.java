package cert.mod3;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ThreeReducer extends Reducer<ThreeCustomeKey, LongWritable, ThreeCustomeKey, LongWritable>{

	public void reduce(ThreeCustomeKey key,Iterable<LongWritable> value,Context context) throws IOException, InterruptedException{
		
		
		for(LongWritable result:value){
			context.write(key, result);
		}
		
	}
	
}
