package certi;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.LineRecordReader;


public class MyRecordReader extends RecordReader<Text, Text> {

	LineRecordReader	line	=	null;
	Text first	=	new	Text();
	Text second	=	new	Text();
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		line.close();
	}

	@Override
	public Text getCurrentKey() throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub
		return first;
	}

	@Override
	public Text getCurrentValue() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return second;
	}

	@Override
	public float getProgress() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return line.getProgress();
	}

	@Override
	public void initialize(InputSplit arg0, TaskAttemptContext arg1)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		line	=	new	LineRecordReader();
		initialize(arg0, arg1);
	}

	@Override
	public boolean nextKeyValue() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		if(!line.nextKeyValue()){
		Text	lineValue	=	line.getCurrentValue();
		first					=	new Text("XYZ");
		second				=	new	Text("ABC");		
		return true;
		}
		else{
			return false;
		}
	}

}
