package cert.mod5;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class FiveDriver extends Configured implements Tool{

	public static void main(String args[]) throws Exception{
		int test	=	ToolRunner.run(new FiveDriver(), args);
		System.exit(test);
	}
	
	
	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Job	job	=	Job.getInstance(getConf(),"test");
		job.setJarByClass(FiveDriver.class);
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.setMapperClass(FiveMapper.class);
		job.setGroupingComparatorClass(FiveComparator.class);
		
		job.setOutputKeyClass(FiveCustomeKey.class);
		job.setOutputValueClass(Text.class);
		
		
		job.setPartitionerClass(FivePartitioner.class);
		job.setNumReduceTasks(10);
		
		job.setReducerClass(FiveReducer.class);
		return job.waitForCompletion(true)?0:1;
	}

}
