package certi;

import java.io.IOException;

import org.apache.hadoop.io.*;

public class Reducer extends org.apache.hadoop.mapreduce.Reducer<TextPair, Text, TextPair, Text>{

	public void reduce(TextPair key,Iterable<Text> value,Context context)
			throws IOException, InterruptedException {
		for(Text str : value){
			TextPair	keyTemp	=	 new TextPair(key.toString(), str.toString());
			context.write(keyTemp, null);
		}
	}

}
