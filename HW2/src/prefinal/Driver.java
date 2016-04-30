package prefinal;

import java.net.URI;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.InputFormat;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Driver extends Configured implements Tool{

	public static void main(String[] args) throws Exception{
		System.exit(ToolRunner.run(new Driver(), args));
	}
	
	@Override
	public int run(String[] arg0) throws Exception {
		Job	job	=	Job.getInstance(getConf(),"Test");
		job.setJarByClass(Driver.class);
		DistributedCache.addCacheFile(new URI(""), job.getConfiguration());
		MultipleInputs.addInputPath(job, new Path(arg0[0]), org.apache.hadoop.mapreduce.lib.input.TextInputFormat.class, Mapper.class);
		job.setMapperClass(Mapper.class);
		job.setReducerClass(Reducer.class);
		job.setOutputKeyClass(TextPair.class);
		job.setOutputValueClass(Text.class);
		return job.waitForCompletion(true)?0:1;
	}

}
