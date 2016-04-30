package cert.mod7;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class FirstDriver extends Configured implements Tool{

	public static void main(String args[]) throws Exception{
		int test	=	ToolRunner.run(new FirstDriver(), args);
		System.exit(test);
	}
	
	
	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Job	job	=	Job.getInstance(getConf(),"test");
		job.setJarByClass(FirstDriver.class);
		job.setInputFormatClass(WholeFileInputFormat.class);
		job.setOutputFormatClass(MyTextOutputFormat.class);
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.setMapperClass(FirstMapper.class);
		job.setReducerClass(FirstReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		return job.waitForCompletion(true)?0:1;
	}

}
