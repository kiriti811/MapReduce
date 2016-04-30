package task1;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Task1Partitioner extends Partitioner<TextPair, Text>{

	@Override
	public int getPartition(TextPair key, Text value, int numPartitions) {
		// TODO Auto-generated method stub
		int	partionerValue	=	0;
		partionerValue	=	(key.getFirst().hashCode() & Integer.MAX_VALUE) % numPartitions;	
		return partionerValue;
	}

}
