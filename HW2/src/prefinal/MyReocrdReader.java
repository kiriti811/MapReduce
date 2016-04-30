package prefinal;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.LineRecordReader;

public class MyReocrdReader extends RecordReader<TextPair, Text> {

	LineRecordReader	lin		=	null;
	TextPair			key		=	new	TextPair();
	Text				value	=	new	Text();
	
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
		lin.close();
		
	}

	@Override
	public TextPair getCurrentKey() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return this.key;
	}

	@Override
	public Text getCurrentValue() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public float getProgress() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return lin.getProgress();
	}

	@Override
	public void initialize(InputSplit arg0, TaskAttemptContext arg1)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		lin	=	new	LineRecordReader();
		this.initialize(arg0, arg1);
	}

	@Override
	public boolean nextKeyValue() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		if(!lin.nextKeyValue()){
			key		=	null;
			value	=	null;	
			return false;
		
		}else{
	
			String		str		=	lin.getCurrentValue().toString();
			String[]	str1	=	str.split(",");
			key.setFirst(new Text(str1[1]));
			key.setSecond(new Text(str1[2]));
			value.set(new Text(str1[3]));
			return true;
		}
		
	}

}
