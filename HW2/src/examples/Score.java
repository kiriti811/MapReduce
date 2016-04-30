package examples;

import java.io.IOException;
import java.util.StringTokenizer;

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
import org.apache.hadoop.util.GenericOptionsParser;

public class Score {
	public static class TokenizerMapper extends
			Mapper<LongWritable, Text, Text, IntWritable> {
		private static IntWritable one = new IntWritable(1);
		private Text word = new Text();

		public void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {

			StringTokenizer variable = new StringTokenizer(value.toString(),
					",");
			int count = 0;
			while (variable.hasMoreElements()) {
				String temp = variable.nextToken();
				if (count == 4) {
					if (temp == "0" || temp.equals("0")) {
						System.out.println("Score" + temp);
						word.set(new Text("Dot Ball"));
						context.write(word, one);

					} else if (temp == "1" || temp.equals("1")) {
						System.out.println("Score" + temp);
						word.set(new Text("1 Run"));
						context.write(word, one);

					} else if (temp == "2" || temp.equals("2")) {
						System.out.println("Score" + temp);
						word.set(new Text("2 runs"));
						context.write(word, one);

					} else if (temp == "3" || temp.equals("3")) {
						System.out.println("Score" + temp);
						word.set(new Text("3 runs"));
						context.write(word, one);

					} else if (temp == "4" || temp.equals("4")) {
						System.out.println("Score" + temp);
						word.set(new Text("4 Runs"));
						context.write(word, one);

					} else if (temp == "5" || temp.equals("5")) {
						System.out.println("Score" + temp);
						word.set(new Text("5 Runs"));
						context.write(word, one);

					} else {
						System.out.println("Score" + temp);
						word.set(new Text("Six Runs"));
						context.write(word, one);

					}

				}
				count = count + 1;
			}

		}

	}

	public static class IntSumReducer extends
			Reducer<Text, IntWritable, Text, IntWritable> {
		private IntWritable result = new IntWritable();

		public void reduce(Text key, Iterable<IntWritable> values,
				Context context) throws IOException, InterruptedException {
			int sum = 0;
			for (IntWritable val : values) {
				sum += val.get();
			}
			result.set(sum);
			context.write(key, null);
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		String[] otherArgs = new GenericOptionsParser(conf, args)
				.getRemainingArgs();
		if (otherArgs.length != 2) {
			System.err.println("score");
			System.exit(2);
		}
		@SuppressWarnings("deprecation")
		Job job = new Job(conf);
		job.setJarByClass(Score.class);
		job.setMapperClass(TokenizerMapper.class);
		job.setCombinerClass(IntSumReducer.class);
		job.setReducerClass(IntSumReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}