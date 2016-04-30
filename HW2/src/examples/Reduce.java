package examples;

import java.io.IOException;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class Reduce extends Reducer<Text, IntWritable, Text, IntWritable> {
	public void reduce(Text word, Iterable<IntWritable> counts, Context context)
			throws IOException, InterruptedException {
		int sum = 0;
		for (IntWritable count : counts) {
			sum += count.get();
		}
		context.write(word, new IntWritable(sum));
	}
}
