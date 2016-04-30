package cert.sort;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.RecordReader;
import org.apache.hadoop.mapred.*;

public class SixRecordReader implements RecordReader<LongWritable, Text> {

	private LineRecordReader lineReader;
	private LongWritable linekey;
	private Text value;

	public SixRecordReader(JobConf conf, FileSplit split) throws IOException {

		lineReader = new LineRecordReader(conf, split);
		linekey = lineReader.createKey();
		value = lineReader.createValue();
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		lineReader.close();
	}

	@Override
	public LongWritable createKey() {
		// TODO Auto-generated method stub
		return new LongWritable();
	}

	@Override
	public Text createValue() {
		// TODO Auto-generated method stub
		return new Text("");
	}

	@Override
	public long getPos() throws IOException {
		// TODO Auto-generated method stub
		return lineReader.getPos();
	}

	@Override
	public float getProgress() throws IOException {
		// TODO Auto-generated method stub
		return lineReader.getProgress();
	}

	@Override
	public boolean next(LongWritable key, Text value) throws IOException {
		// TODO Auto-generated method stub
		boolean appended, isNextLineAvailable;
		boolean retval;
		byte space[] = { ' ' };
		isNextLineAvailable = false;
		do {
			appended = false;
			retval = lineReader.next(this.linekey, this.value);
			if (retval) {
				if (this.value.toString().length() > 0) {
					byte[] rawline = this.value.getBytes();
					int rawlinelen = this.value.getLength();
					value.append(rawline, 0, rawlinelen);
					value.append(space, 0, 1);
					appended = true;
				}
				isNextLineAvailable = true;
			}
		} while (appended);

		return isNextLineAvailable;

	}
}
