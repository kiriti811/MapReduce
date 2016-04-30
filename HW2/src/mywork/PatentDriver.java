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

public class PatentDriver extends Configured implements Tool{

	public static void main(String args[]) throws Exception
	{
		int res	=	ToolRunner.run(new PatentDriver(),args);
		System.exit(res);
	}
	
	public int run(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
		Job	job	=	Job.getInstance(getConf(),"PatentDriver");
		job.setJarByClass(this.getClass());
		FileInputFormat.setInputPaths(job,new Path(args[0]));
		FileOutputFormat.setOutputPath(job,new Path(args[1]));
		job.setMapperClass(PatentMapper.class);
		job.setPartitionerClass(MyPartitioner.class);
		job.setReducerClass(PatentReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setNumReduceTasks(2);
		return job.waitForCompletion(true)?0:1;
	}

}
