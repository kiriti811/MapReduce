package cert.mod7;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.LineRecordReader;


public class WholeFileRecordReader extends RecordReader<Text, Text> {

	
	private LineRecordReader lineRecordReader = null;
    private Text key = null;
    private Text value = null;
   
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		if(null!=lineRecordReader){
			lineRecordReader.close();
			lineRecordReader	=	null;
		}
		key		=	null;
		value	=	null;
	}

	@Override
	public Text getCurrentKey() throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub
		return this.key;
	}

	@Override
	public Text getCurrentValue() throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public float getProgress() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return lineRecordReader.getProgress();
	}

	@Override
	public void initialize(InputSplit split, TaskAttemptContext context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		lineRecordReader	=	new	LineRecordReader();
		lineRecordReader.initialize(split, context);
	}

	@Override
	public boolean nextKeyValue() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		if(!lineRecordReader.nextKeyValue()){
			key		=	null;
			value	=	null;
			return	false;
		}
		
		Text		line	=	lineRecordReader.getCurrentValue();
		String		str		=	line.toString();
		String[]	arr		=	str.split(",");
		key					=	new	Text(arr[0] +	"#"	 + arr[1]);
		value				=	new	Text(arr[4]);
		return true;
	}

	

}
