package mywork;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartitioner extends Partitioner<Text, IntWritable>{


	@Override
	public int getPartition(Text key, IntWritable value, int numOfReduceTasks) {
		
		

		int country	=	Integer.parseInt(value.toString());
		if(numOfReduceTasks==0){
			return 0;
		}
        if (country>10) {
                        return 0;
        }
        if (country<10)
        {
        	return 2%numOfReduceTasks;
        }
        else  {
                        return 1 % numOfReduceTasks;
        } 

		
		
		
	}

}
