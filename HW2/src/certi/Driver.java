package certi;

import java.net.URI;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Driver extends Configured implements Tool{

	
	public static void main(String[] args) throws Exception{
		System.exit(ToolRunner.run(new Driver(), args));
	}
	
	@Override
	public int run(String[] arg0) throws Exception {
		// TODO Auto-generated method stub
		
		Job	job	=	Job.getInstance(getConf(),"Test");
		job.setJarByClass(Driver.class);
		DistributedCache.addCacheFile(new URI("/input/custs"),job.getConfiguration());
		FileInputFormat.setInputPaths(job, new Path(arg0[0]));
		FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
		job.setMapperClass(Mapper.class);
		job.setGroupingComparatorClass(MySort.class);
		job.setReducerClass(Reducer.class);
		job.setOutputKeyClass(TextPair.class);
		job.setOutputValueClass(Text.class);
		job.setPartitionerClass(MyPartitioner.class);
		job.setNumReduceTasks(2);
		//job.setOutputFormatClass(MyFileOutputFormat.class);
		return job.waitForCompletion(true)?0:1;
	}

}
