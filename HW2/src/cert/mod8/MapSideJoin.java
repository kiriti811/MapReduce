package cert.mod8;

import java.net.URI;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.filecache.DistributedCache;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class MapSideJoin extends Configured implements Tool{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.exit(ToolRunner.run(new MapSideJoin(), args));;
	}

	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Job	job	=	Job.getInstance(getConf(), "Map Side Join");
		job.setJarByClass(MapSideJoin.class);
		DistributedCache.addCacheFile(new URI("/input/departments_txt"), job.getConfiguration());
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.setMapperClass(MapSideJoinMapper.class);
		return job.waitForCompletion(true)?0:1;
	}

}
