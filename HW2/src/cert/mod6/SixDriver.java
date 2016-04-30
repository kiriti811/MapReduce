package cert.mod6;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class SixDriver extends Configured implements Tool{

	public static void main(String args[]) throws Exception{
		int test	=	ToolRunner.run(new SixDriver(), args);
		System.exit(test);
	}
	
	
	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Job	job	=	Job.getInstance(getConf(),"test");
		job.setJarByClass(SixDriver.class);
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.setMapperClass(SixMapper.class);
		job.setReducerClass(SixReducer.class);
		job.setOutputKeyClass(SixCustomeKey.class);
		job.setOutputValueClass(Text.class);
		return job.waitForCompletion(true)?0:1;
	}

}
