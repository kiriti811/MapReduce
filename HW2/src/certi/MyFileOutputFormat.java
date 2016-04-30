package certi;

import java.io.IOException;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyFileOutputFormat extends FileOutputFormat<TextPair, Text> {

	@Override
	public org.apache.hadoop.mapreduce.RecordWriter<TextPair, Text> getRecordWriter(
			TaskAttemptContext arg0) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		
/*		Path	testPath			=	FileOutputFormat.getOutputPath(arg0);
		Path	testNewPAth			=	new	Path(testPath,"test");
		FileSystem			fs1		=	testPath.getFileSystem(arg0.getConfiguration());	
		FSDataOutputStream	out1	=	fs1.create(testNewPAth,arg0);*/			
		
		
		
		Path	path			=	FileOutputFormat.getOutputPath(arg0);
		Path	newPath			=	new	Path(path,"result.txt");
		FileSystem	fullPath	=	path.getFileSystem(arg0.getConfiguration());
		FSDataOutputStream	fs	=	fullPath.create(newPath, arg0);
		return new MyReocrdWriter(fs);
	}

	

}
