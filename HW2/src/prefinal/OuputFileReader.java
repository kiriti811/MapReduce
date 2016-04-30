package prefinal;

import java.io.IOException;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Progressable;

public class OuputFileReader extends FileOutputFormat<TextPair, Text>{

	@Override
	public org.apache.hadoop.mapreduce.RecordWriter<TextPair, Text> getRecordWriter(
			TaskAttemptContext arg0) throws IOException, InterruptedException {
		
		
		
		
		
	// TODO Auto-generated method stub
			Path	path		=	FileOutputFormat.getOutputPath(arg0);	
			Path	newPath		=	new	Path(path,"test");
			FileSystem	fs		=	path.getFileSystem(arg0.getConfiguration());
			FSDataOutputStream	out	=	fs.create(newPath,arg0);
			return new MyRecordWriter(out);
		
		
		
		
	}


}
