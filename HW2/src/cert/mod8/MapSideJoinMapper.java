package cert.mod8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.filecache.DistributedCache;

public class MapSideJoinMapper extends Mapper<LongWritable,Text,Text,Text>{

	String	line	="";
	
	HashMap<String,String>	department	=	new HashMap<String,String>();
	
	Text	word	=	new	Text();
	
	Text	word1	=	new	Text();
	
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {

		String[]	str	=	value.toString().split("\t");
		
		String	temp	=	"";
		
		try{
			
			temp	=	department.get(str[6]);
			
		}finally{
			
			temp	=	"Not Found";
			
		}
		
		word.set(temp);
		
		word1.set(str[1]	+	"\t"	+	str[2]	+	"\t"	+	str[3]	+	"\t"	+	temp);
	
		context.write(word, word1);
		
	}

	
	
	protected void setup(Context context) throws IOException,
			InterruptedException {
		// TODO Auto-generated method stub
		
		Path[] cacheFiles	=	DistributedCache.getLocalCacheFiles(context.getConfiguration());
		for(Path path:cacheFiles){
			if(path.getName().toString().trim().equals("/input/departments_txt")){
				try{
					
					BufferedReader	br	=	new BufferedReader(new FileReader("/input/departments_txt")); 			
					while((line = br.readLine())!=null)
					{
						String[] temp	=	line.split("\t");
						department.put(temp[0], temp[1]);
					}
				
				}catch(Exception e){

				}
		}
		}
	}
}