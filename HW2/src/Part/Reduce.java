package Part;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text, Text, Text, Text>{

	public void reduce(Text key, Iterable<Text>  value, Context context) 
			throws IOException, InterruptedException {
		
		int	max	=	-1;
		for(Text	pay	:	value){
			
			int	age		=	Integer.parseInt(pay.toString().substring(0,pay.toString().indexOf("$$$")));
			int	salary	=	Integer.parseInt(pay.toString().substring((pay.toString().indexOf("$$$")+3),pay.toString().length()));
			if(salary>max){
				max	=	salary;
			}
		
		}
		String	finalSalary	=	Integer.toString(max);
		context.write(key, new Text(finalSalary));
}
}
