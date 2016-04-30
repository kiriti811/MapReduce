package prefinal;

import java.io.IOException;

import org.apache.hadoop.io.Text;

public class Reducer extends org.apache.hadoop.mapreduce.Reducer<TextPair, Text, TextPair, Text>{

	@Override
	protected void reduce(
			TextPair arg0,
			Iterable<Text> arg1,
			org.apache.hadoop.mapreduce.Reducer<TextPair, Text, TextPair, Text>.Context arg2)
			throws IOException, InterruptedException {
	
		for(Text str	:	arg1){
			arg2.write(new TextPair(),str);
		}
	
	}

	
	
	
}
