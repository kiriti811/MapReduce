package cert.mod4;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class FourPartitioner extends Partitioner<FourCustomeKey, Text>{

	@Override
	public int getPartition(FourCustomeKey key, Text value, int numOfReducers) {
		int partitionValue	=	0;
		partitionValue		=	(key.getFirst().hashCode()	& Integer.MAX_VALUE)	%	numOfReducers;	
		// TODO Auto-generated method stub
		return partitionValue;
	}

}
