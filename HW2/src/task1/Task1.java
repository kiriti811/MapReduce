package task1;

import java.net.URI;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.filecache.DistributedCache;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Task1 extends Configured implements Tool{

	public static void main(String[] args) throws Exception {
		System.exit(ToolRunner.run(new Task1(), args));
	}

	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		Job	job	=	Job.getInstance(getConf(),"test");
		job.setJarByClass(Task1.class);
		DistributedCache.addCacheFile(new URI("/user/horton/weather/sfo_weather.csv"), job.getConfiguration());
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.setMapperClass(Task1Mapper.class);
		job.setReducerClass(Task1Reducer.class);
		job.setOutputKeyClass(TextPair.class);
		job.setOutputValueClass(Text.class);
		job.setPartitionerClass(Task1Partitioner.class);
		job.setNumReduceTasks(2);
		return job.waitForCompletion(true)?0:1;
	}
}
