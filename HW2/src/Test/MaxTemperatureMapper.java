package Test;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import static org.mockito.Mockito.*;
public class MaxTemperatureMapper extends MapReduceBase implements
		Mapper<LongWritable, Text, Text, IntWritable> {
	public void map(LongWritable key, Text value,
			OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		String line = value.toString();
		String year = line.substring(15, 19);
		int airTemperature = Integer.parseInt(line.substring(87, 92));
		output.collect(new Text(year), new IntWritable(airTemperature));
	}
	
	
	
	
	public void ignoresMissingTemperatureRecord() throws IOException {
		MaxTemperatureMapper mapper = new MaxTemperatureMapper();
		Text value = new Text("0043011990999991950051518004+68750+023550FM-12+0382" +	"99999V0203201N00261220001CN9999999N9+99991+99999999999");
		// Temperature ^^^^^
		OutputCollector<Text, IntWritable> output =  mock(OutputCollector.class);
		mapper.map(null, value, output, null);
		verify(output, never()).collect(any(Text.class), any(IntWritable.class));
		}
	
	
	
}