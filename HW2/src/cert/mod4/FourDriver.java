package cert.mod4;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class FourDriver extends Configured implements Tool{

	public static void main(String args[]) throws Exception{
		int test	=	ToolRunner.run(new FourDriver(), args);
		System.exit(test);
	}
	
	
	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Job	job	=	Job.getInstance(getConf(),"test");
		job.setJarByClass(FourDriver.class);
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.setMapperClass(FourMapper.class);
		job.setOutputKeyClass(FourCustomeKey.class);
		job.setOutputValueClass(Text.class);
		job.setPartitionerClass(FourPartitioner.class);
		job.setNumReduceTasks(10);
		job.setReducerClass(FourReducer.class);
		return job.waitForCompletion(true)?0:1;
	}

}