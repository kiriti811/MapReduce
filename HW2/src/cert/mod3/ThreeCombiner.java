package cert.mod3;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class ThreeCombiner extends Reducer<ThreeCustomeKey, LongWritable, ThreeCustomeKey, LongWritable>{

	public void reduce(ThreeCustomeKey key,Iterable<LongWritable> values,Context context) throws IOException, InterruptedException{
	
		Text			delimiter	=	new	Text();
		Long			average		=	new	Long(0);	
		Long			total		=	new	Long(0);
		int				count		=	1;
		Text			date		=	new	Text();		
		
		for(LongWritable value: values){
		
		
			
			
			if(key.getFirst()==delimiter	&&	key.getSecond()	==	date){
				total		=	total	+	value.get();
				
			}else{
				delimiter	=	key.getFirst();
				date		=	key.getSecond();
				total		=	value.get();
			}
		
			
		
		}
		average		=	total/count;
		
		context.write(key, new LongWritable(average));
		
	}
}
