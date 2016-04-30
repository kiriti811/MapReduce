package cert.mod5;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class FivePartitioner extends Partitioner<FiveCustomeKey, Text>{

	@Override
	public int getPartition(FiveCustomeKey key, Text value, int numOfReducers) {
		int partitionValue	=	0;
		partitionValue		=	(key.getFirst().hashCode()	& Integer.MAX_VALUE)	%	numOfReducers;	
		// TODO Auto-generated method stub
		return partitionValue;
	}

}
