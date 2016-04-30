package cert.mod7;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

public class MyCustomRecordWriter extends RecordWriter<Text, Text> {
    private DataOutputStream out;

    public MyCustomRecordWriter(DataOutputStream stream) {
        out = stream;
        try {
            out.writeBytes("results:\r\n");
        }
        catch (Exception ex) {
        }  
    }

    @Override
    public void close(TaskAttemptContext arg0) throws IOException, InterruptedException {
        //close our file
        out.close();
    }

    @Override
    public void write(Text arg0, Text arg1) throws IOException, InterruptedException {
        //write out our key
        out.writeBytes(arg0.toString() + ": ");
        //loop through all values associated with our key and write them with commas between
        out.writeBytes(arg1.toString());
        out.writeBytes("\r\n");  
    }
}
