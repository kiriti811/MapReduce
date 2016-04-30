package zfinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.filecache.DistributedCache;

import prefinal.TextPair;


public class Mapper extends org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, TextPair, Text>{


	BufferedReader	br	=	null;
	HashMap<String, String> hashMap	=	new	HashMap<String, String>();
	String	line	="";
	@Override
	protected void setup(
			org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, TextPair, Text>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub

	Path[]	path	=	DistributedCache.getLocalCacheFiles(context.getConfiguration());
	for(Path cache: path){
		if(cache.getName().toString().trim().equals("/")){
			
			br	=	new	BufferedReader(new FileReader("/"));
			try{
				while((line=br.readLine())!=null){
					
				}
			}
				catch(Exception ex){
					
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
		// TODO Auto-generated method stub
		super.map(key, value, context);
	}


	
	
	
}
