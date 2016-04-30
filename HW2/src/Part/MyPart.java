package Part;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPart extends Partitioner<Text, Text>{

	@Override
	public int getPartition(Text key, Text value, int numberOfReducers) {
		int	age		=	Integer.parseInt(value.toString().substring(0,value.toString().indexOf("$$$")));
		if(numberOfReducers==0){
			return	0;
		}
		if(age<=20){
			return 0;
		}else if (age> 20 && age<30) {
			return	1%numberOfReducers;
		}
		else{
			return	2%numberOfReducers;
		}
	}

}
