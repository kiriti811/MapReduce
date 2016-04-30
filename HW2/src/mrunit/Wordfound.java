package mrunit;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.commons.collections.map.StaticBucketMap;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.junit.Test;


public class Wordfound {
    
    public static class Wordmapper extends Mapper<LongWritable, Text, Text, IntWritable> {
        IntWritable one = new IntWritable(1);
        public void map(LongWritable key,Text value,Context context)throws IOException,InterruptedException{
            String line = value.toString();
            
            StringTokenizer s = new StringTokenizer(line, " ");
            while (s.hasMoreTokens()) {
                String word = s.nextToken();
                context.write(new Text(word), one);
            }
        }
    }
  /*  public static class Wordreducer extends Reducer<Text, IntWritable, Text, IntWritable>{
        public void reduce(Text key,Iterable<IntWritable> values,Context context)throws IOException,InterruptedException{
            int sum = 0;
            IntWritable result = new IntWritable();
            for (IntWritable val : values) {
                sum += val.get();
                result.set(sum);
            }
            String found = key.toString();
            if (found.equals("is")) {
                context.write(key, result); 
            }
        }
    }
    */
    
    
    MapDriver<LongWritable, Text, Text, IntWritable> mapDriver;

    Wordmapper	wordmapper	=	new	Wordmapper();
    
    @Test
    
    public void testMapper() throws IOException {
    	mapDriver	=	MapDriver.newMapDriver(wordmapper);
        mapDriver.withInput(new LongWritable(), new Text("hadoop is bigdata"));
        mapDriver.withInput(new LongWritable(), new Text("hadoop is emerging"));
        mapDriver.withOutput(new Text("hadoop"), new IntWritable(1));
        mapDriver.withOutput(new Text("is"), new IntWritable(1));
        mapDriver.withOutput(new Text("bigdata"), new IntWritable(1));
        mapDriver.withOutput(new Text("hadoop"), new IntWritable(1));
        mapDriver.withOutput(new Text("is"), new IntWritable(1));
        mapDriver.withOutput(new Text("emerging"), new IntWritable(1));
        mapDriver.runTest();
    }
    
    
 /*   
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Configuration conf = new Configuration();
        Job job = new Job(conf,"Wordfound");
        job.setJarByClass(Wordfound.class);
        job.setMapperClass(Wordmapper.class);
        job.setReducerClass(Wordreducer.class);
        //job.setNumReduceTasks(0);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true)? 0:1);

    }*/

}