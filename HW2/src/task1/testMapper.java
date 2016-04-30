package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class testMapper extends Mapper<LongWritable, Text, Text, Text> {

	
	  protected void map(LongWritable key, Text value,
	  Mapper<LongWritable, Text, Text, Text>.Context context) throws
	  IOException, InterruptedException { // TODO Auto-generated method stub
	  
	  
	  String[] str = value.toString().split(",");
	  
	  
	  context.write(new Text(str[0]), new Text(str[1])); }
	  
	  }
	 
/*
	HashMap<String, String> map = new HashMap<String, String>();

	String line = "";

	@Override
	protected void setup(Mapper<LongWritable, Text, TextPair, Text>.Context context)
			throws IOException, InterruptedException {

		Path[] path = DistributedCache.getLocalCacheFiles(context.getConfiguration());

		for (Path p : path) {
			if (p.getName().toString().trim().equals("user/horton/weather/sfo_weather.csv")) {

				try {

					BufferedReader br = new BufferedReader(new FileReader(path[0].getName().toString().trim()));
					while ((line = br.readLine()) != null) {
						String[] value = line.split(",");
						String key = value[1] + "$$$" + value[2] + "$$$" + value[3];
						String mapValue = value[4] + "$$$" + value[5] + "$$$" + value[6];
						map.put(key, mapValue);
					}

				} catch (Exception e) {

				}
			}
		}

	}

	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		TextPair keyPair = new TextPair("", "");
		Text valuePair = new Text();
		StringTokenizer st = new StringTokenizer(value.toString(), ",");

		while (st.hasMoreTokens()) {
			String year = st.nextToken();
			String month = st.nextToken();
			String dayOfMonth = st.nextToken();
			st.nextToken();
			String departureTime = st.nextToken();
			st.nextToken();
			String arrivalTime = st.nextToken();
			st.nextToken();
			String uniqueCarrier = st.nextToken();
			String flightNumber = st.nextToken();
			st.nextToken();
			String actualElapsedTime = st.nextToken();
			st.nextToken();
			st.nextToken();
			String arrDelay = st.nextToken();
			String deptDelay = st.nextToken();
			String org = st.nextToken();
			String Dest = st.nextToken();
			String temp = year + "$$$" + month + "$$$" + dayOfMonth;

			String Prcp = "";
			String TMax = "";
			String Rmin = "";
			String tempValue = map.get(temp);
			context.getCounter("help----->", "Am here");
			if (temp == tempValue) {

				String[] str = tempValue.split("$$$");
				Prcp = str[0];
				TMax = str[1];
				Rmin = str[2];

				if (Dest == "SFO") {
					if (month.length() < 2) {
						month = "0" + month;
					}
					if (dayOfMonth.length() < 2) {
						dayOfMonth = "0" + dayOfMonth;
					}
					keyPair.first.set(year + month + dayOfMonth);
					keyPair.second.set(arrDelay);
					valuePair.set(departureTime + "," + arrivalTime + "," + uniqueCarrier + "," + flightNumber + ","
							+ actualElapsedTime + "," + arrDelay + "," + deptDelay + "," + org + "," + Dest + "," + Prcp
							+ "," + TMax + "," + Rmin);
					context.write(keyPair, valuePair);

				}

			}

		}

	}*/

