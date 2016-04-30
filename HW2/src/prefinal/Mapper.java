package prefinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;


public class Mapper extends org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, TextPair, Text>{

	
	HashMap<String, String> 	hasMap	=	new	HashMap<String, String>();
	String	line	="";
	BufferedReader	br	=	null;
	
	
	@Override
	protected void setup(
			org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, TextPair, Text>.Context context)
			throws IOException, InterruptedException {
	Path[]	path	=	DistributedCache.getLocalCacheFiles(context.getConfiguration());
	for(Path	cache	:	path){

		if(cache.getName().toString().equals("/")){
			
			br	=	new	BufferedReader(new FileReader(cache.toString()));
			while((line = br.readLine())!=null){
				String[]	str		=	line.split(",");
				String		key		=	str[0];
				String 		value	=	str[1];
				hasMap.put(key, value);
			}
			
		}
		
	}
	}
	
	
	@Override
	protected void map(
			LongWritable key,
			Text value,
			org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, TextPair, Text>.Context context)
			throws IOException, InterruptedException {
	
		String[]	str			=	value.toString().split(",");
		String		day			=	str[0];
		String		month		=	str[1];
		String		year		=	str[2];
		String		date		=	day+month+year;
		String		hasValue	=	hasMap.get(date);
		if(null!=hasValue  || "" != hasValue	||	("").equals(hasValue))
		{
			String keyValue 	=	"";
			String valueVlue	=	"";
		}
		
		
	}

	

	
	
	
	
}
