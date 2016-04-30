package certi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;

public class Mapper extends org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, TextPair, Text>{
	Text	outputKey	=	new	Text();
	HashMap<String, String> 	hashMap	=	new	HashMap<String, String>();
	BufferedReader		br		=	null;
	String				line	=	"";
	public void map(
			LongWritable key,
			Text value,
			org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, TextPair, Text>.Context context)
			throws IOException, InterruptedException {
			String[]	st			=	value.toString().split(",");
			String		mapKey		=	st[2];
			String		mapValue	=	hashMap.get(mapKey);
			if(null!=mapValue	||	""!=mapValue){
			mapValue	=	mapValue	+","+	st[1]	+","+	st[3]	+","+	st[4]	+","+	st[5]	+","+	st[6]	+","+	st[7]	+","+	st[8];
			context.write(new TextPair(mapKey,st[0]), new Text(mapValue));
			}
	
	}
	protected void setup(
			org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, TextPair, Text>.Context context)
			throws IOException, InterruptedException {
		
		Path[]	path	=	DistributedCache.getLocalCacheFiles(context.getConfiguration());	
		if(path.length>0){
			for(Path	fsPath:	path){
				if(fsPath.getName().toString().trim().matches("custs")){
				try{
					br	=	new	BufferedReader(new FileReader(fsPath.toString()));
					while((line	=	br.readLine())	!=	null){
						String[]	input	=	line.split(",");
						String		key		=	input[0];
						int	len	=	input.length;
						String	value	=	"";
						for(int i	=	1	;	i	<	len	;	i++){
							value	=	value	+	","	+	input[i];
						}
						hashMap.put(key, value);
					}
				}catch(Exception ex){
					
				}
				}
			}
		}
		
	}
	
	

}
