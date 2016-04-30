package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.filecache.DistributedCache;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.codehaus.jackson.map.Module.SetupContext;
import org.junit.Test;

public class Task1Mapper extends Mapper<LongWritable, Text, TextPair, Text> {

	HashMap<String, String> map = new HashMap<String, String>();

	String line = "";

	@Override
	protected void setup(Context context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		Path[] path = DistributedCache.getLocalCacheFiles(context.getConfiguration());
		
		BufferedReader	br	=	null;
		for (Path cache : path) {
			
			if (cache.getName().toString().equals("sfo_weather.csv")) {

				br = new BufferedReader(new FileReader(cache.toString()));
				
				try {

					
					while ((line = br.readLine()) != null) {
						String[] value = line.split(",");
						String key = value[1] + "$$$" + value[2] + "$$$" + value[3];
						String mapValue = value[4] + "$$$" + value[5] + "$$$" + value[6];
						map.put(key, mapValue);
						line = "";
					}

				} catch (Exception e) {

				}

			
			}

		}
	}


	TextPair keyPair = new TextPair("", "");
	Text valuePair = new Text();
	String tempValue	="";
	

	public  void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
		String[]	str	=value.toString().split(",");	
		
		
		String year = str[0];
		String month = str[1];
		String dayOfMonth = str[2];
		String departureTime = str[4];
		String arrivalTime = str[6];
		String uniqueCarrier = str[8];
		String flightNumber =str[9];
		String actualElapsedTime = str[11];
		String arrDelay = str[14];
		String deptDelay = str[15];
		String org = str[16];
		String Dest = str[17];
		if (month.length() < 2) {
			month = "0" + month;
		}
		if (dayOfMonth.length() < 2) {
			dayOfMonth = "0" + dayOfMonth;
		}

		String temp = year + "$$$" + month + "$$$" + dayOfMonth;
		
			String Prcp = "";
			String TMax = "";
			String Rmin = "";
			String test	=	"";
				tempValue = map.get(temp);
			if(null!=tempValue||""!=tempValue){
				if (Dest.equals("SFO")) {
			
				StringTokenizer	str1	=	new	StringTokenizer(tempValue, "$$$");
				while(str1.hasMoreElements()){
					Prcp = str1.nextToken();
					TMax = str1.nextToken();
					Rmin = str1.nextToken();

				}
				
				
				String testDay	=	year +month + dayOfMonth;
				
					keyPair.first.set(new Text(testDay));
					keyPair.second.set(arrDelay);
					valuePair.set(departureTime + "," + arrivalTime + "," + uniqueCarrier + "," + flightNumber + ","
							+ actualElapsedTime + "," + arrDelay + "," + deptDelay + "," + org + "," + Dest + "," + Prcp
							+ "," + TMax + "," + Rmin);
					context.write(keyPair, valuePair);
					tempValue="";
				}

			}

		}
	

}