
package Part;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable, Text, Text, Text>{
	public static Text word1	=	new Text();
	public static Text word		=	new Text();
	public void map(LongWritable key,Text value, Context context) throws IOException, InterruptedException{
		try{
		String[]	data	=	value.toString().split("\t"); 
		String		gender	=	data[3];
		String		age		=	data[2]	+	"$$$"	+	data[4];
		word.set(gender);
		word1.set(age);
		context.write(word,word1);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
