package prefinal;

import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

public class MyRecordWriter extends RecordWriter<TextPair, Text> {

	DataOutputStream	out	=	null;
	
	
	
	

	/**
	 * @param out
	 */
	public MyRecordWriter(DataOutputStream out) {
		this.out = out;
		try{
			
			out.writeBytes("/r/t");
		}
		catch(Exception ex){
			
		}
	}

	@Override
	public void close(TaskAttemptContext arg0) throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub
		out.close();
	}

	@Override
	public void write(TextPair arg0, Text arg1) throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub

		out.writeBytes(arg0.first.toString()+","+arg0.second.toString());
		out.writeBytes(arg1.toString());
		out.writeBytes("\r\t");
	}

}
