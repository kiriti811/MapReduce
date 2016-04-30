package cert.mod1;

import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

public class FirstRecordWriter extends RecordWriter<Text, Text> {

	DataOutputStream	out;
	
	public FirstRecordWriter(DataOutputStream	stream) {
		// TODO Auto-generated constructor stub
		this.out	=	stream;
		try{
			this.out.writeBytes("NO DATA");
		}catch(Exception	e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void close(TaskAttemptContext arg0) throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub
		this.out.close();
	}

	@Override
	public void write(Text arg0, Text arg1) throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub

		this.out.writeBytes(arg0.toString());
		this.out.writeBytes(arg1.toString());
		
	}

}
