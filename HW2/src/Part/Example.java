package Part;
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

public class Example extends Configured implements Tool{
	
	public static void main(String args[]) throws Exception
	{
		int res	=	ToolRunner.run(new Example(), args);
		System.exit(res);
	}
	
	
	public int run(String args[]) throws IOException, ClassNotFoundException, InterruptedException {
		Job	job	=	Job.getInstance(getConf(), "Example");
		job.setJarByClass(this.getClass());
		FileInputFormat.setInputPaths(job,new Path(args[0]));
		FileOutputFormat.setOutputPath(job,new Path(args[1]));
		job.setMapperClass(Map.class);
		job.setPartitionerClass(MyPart.class);
		job.setNumReduceTasks(3);
		job.setReducerClass(Reduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		return job.waitForCompletion(true)?0:1;
	}

	
	
}