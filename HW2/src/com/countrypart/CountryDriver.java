package com.countrypart;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class CountryDriver extends Configured implements Tool {
	public int run(String[] args) throws Exception {
		// getting configuration object and setting job name
		Job partition_job = getJobConfPartition();

		String input1 = args[0];
		// String input2 = args[1];
		String output = args[1];

		FileSystem fs = FileSystem.getLocal(partition_job.getConfiguration());
		Path opPath = new Path(output);
		fs.delete(opPath, true);

		// FileInputFormat.setInputPaths(partition_job, new Path(input1),new
		// Path(input2)); // setting
		FileInputFormat.setInputPaths(partition_job, new Path(input1)); // setting

		// the input
		// files for
		// the job
		FileOutputFormat.setOutputPath(partition_job, new Path(output)); // setting
		// the
		// output
		// files
		// for
		// the
		// job

		partition_job.waitForCompletion(true);

		return 0;

	}

	protected abstract class JobInfo {
		public abstract Class<?> getJarByClass();

		public abstract Class<? extends Mapper> getMapperClass();

		public abstract Class<? extends Reducer> getCombinerClass();

		public abstract Class<? extends Reducer> getReducerClass();

		public abstract Class<?> getOutputKeyClass();

		public abstract Class<?> getOutputValueClass();

	}

	// method to get job configuration for the customized partitioning MapReduce
	// program
	private Job getJobConfPartition() throws Exception {

		JobInfo jobInfo = new JobInfo() {
			@Override
			public Class<? extends Reducer> getCombinerClass() {
				return null;
			}

			@Override
			public Class<?> getJarByClass() {
				return CountryDriver.class;
			}

			@Override
			public Class<? extends Mapper> getMapperClass() {
				return CountryMapper.class;
			}

			public Class<?> getOutputKeyClass() {
				return Text.class;
			}

			public Class<?> getOutputValueClass() {
				return Text.class;
			}

			public Class<? extends Reducer> getReducerClass() {
				return CountryReducer.class;
			}
		};

		Job job = setupJob("CountryPartition", jobInfo);
		job.setPartitionerClass(CountryPartitioner.class);
		// job.setPartitionerClass(HashPartitioner.class);
		job.setInputFormatClass(TextInputFormat.class);

		return job;
	}

	protected Job setupJob(String jobName, JobInfo jobInfo) throws Exception {

		Job job = new Job(new Configuration(), jobName);

		// set the several classes
		job.setJarByClass(jobInfo.getJarByClass());

		// set the mapper class
		job.setMapperClass(jobInfo.getMapperClass());

		// the combiner class is optional, so set it only if it is required by
		// the program
		if (jobInfo.getCombinerClass() != null)
			job.setCombinerClass(jobInfo.getCombinerClass());

		// set the reducer class
		job.setReducerClass(jobInfo.getReducerClass());

		// the number of reducers is set to 3, this can be altered according to
		// the program's requirements
		job.setNumReduceTasks(2);

		// set the type of the output key and value for the Map & Reduce
		// functions
		job.setOutputKeyClass(jobInfo.getOutputKeyClass());
		job.setOutputValueClass(jobInfo.getOutputValueClass());

		return job;
	}

	public static void main(String[] args) throws Exception {
		int res = ToolRunner
				.run(new Configuration(), new CountryDriver(), args);
		System.exit(res);
	}
}
