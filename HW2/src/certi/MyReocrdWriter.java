package certi;

import java.io.IOException;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.io.DataOutputOutputStream;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

public class MyReocrdWriter extends RecordWriter<TextPair, Text>{

	private	FSDataOutputStream	out;
	
	public MyReocrdWriter(FSDataOutputStream fs) {
		// TODO Auto-generated constructor stub
		this.out	=	fs;
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
		out.writeBytes(arg0.toString());
		//out.writeBytes(arg1.toString());
		out.writeBytes("\r\n");
	}

}
