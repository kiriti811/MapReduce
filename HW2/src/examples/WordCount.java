package examples;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
public class WordCount extends Configured implements Tool {
public static void main( String[] args) throws  Exception {
    int res  = ToolRunner .run( new WordCount(), args);
    System .exit(res);
 }
public int run( String[] args) throws  Exception {
	Job job  = Job .getInstance(getConf(), " wordcount ");
	job.setJarByClass( this .getClass());
	FileInputFormat.setInputPaths(job,  new Path(args[ 0]));
    FileOutputFormat.setOutputPath(job,  new Path(args[ 1]));
    job.setMapperClass( Map .class);
    job.setCombinerClass(Reduce.class);
    job.setReducerClass( Reduce .class);
    
    job.setOutputKeyClass( Text .class);
    job.setOutputValueClass( IntWritable .class);
    return job.waitForCompletion( true)  ? 0 : 1;
}
}
