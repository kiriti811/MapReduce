package mywork;

import java.io.IOException;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class NoOfWords extends Configured implements Tool{

	public static void main(String args[]) throws Exception
	{
		int  res	=	ToolRunner.run(new NoOfWords(), args);
		System.exit(res);
	}
	
	public int run(String args[]) throws IOException, ClassNotFoundException, InterruptedException
	{
		Job	job	=	Job.getInstance(getConf(),"NOOFWORDS");
		job.setJarByClass(this.getClass());
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.setMapperClass(NoMap.class);
		job.setCombinerClass(NoReduce.class);
		job.setReducerClass(NoReduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		return job.waitForCompletion(true)? 0 : 1;
	}

}
