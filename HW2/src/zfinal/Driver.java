package zfinal;

import java.net.URI;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.filecache.DistributedCache;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Driver extends Configured implements Tool{

	public static void main(String agrs[]) throws Exception{
		System.exit(ToolRunner.run(new Driver(), agrs));
	}

	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Job	job	=	Job.getInstance(getConf(),"Test");
		job.setJarByClass(Driver.class);
		DistributedCache.addCacheFile(new URI("/"), job.getConfiguration());
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.setMapperClass(Mapper.class);
		job.setReducerClass(Reducer.class);
		job.setPartitionerClass(Partitioner.class);
		job.setNumReduceTasks(2);
		return job.waitForCompletion(true)?0:1;
	}
	
}
