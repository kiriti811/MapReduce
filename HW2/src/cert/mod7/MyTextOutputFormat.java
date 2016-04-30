package cert.mod7;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyTextOutputFormat extends FileOutputFormat<Text, Text> {

@Override
public RecordWriter<Text, Text> getRecordWriter(TaskAttemptContext arg0) throws IOException, InterruptedException {
	// TODO Auto-generated method stub
		Path path = FileOutputFormat.getOutputPath(arg0);
	     //create the full path with the output directory plus our filename
	     Path fullPath = new Path(path, "result.txt");

	     //create the file in the file system
	     FileSystem fs = path.getFileSystem(arg0.getConfiguration());
	     FSDataOutputStream fileOut = fs.create(fullPath, arg0);
	     return new MyCustomRecordWriter(fileOut);
}
}
