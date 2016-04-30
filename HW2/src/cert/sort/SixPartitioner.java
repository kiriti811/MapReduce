package cert.sort;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class SixPartitioner extends Partitioner<SixCustomeKey, Text>{

	@Override
	public int getPartition(SixCustomeKey key, Text value, int numOfReducers) {
		int partitionValue	=	0;
		partitionValue		=	(key.getFirst().hashCode()	& Integer.MAX_VALUE)	%	numOfReducers;	
		// TODO Auto-generated method stub
		return partitionValue;
	}

}
