package prefinal;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class Partitinoer extends Partitioner<TextPair, Text>{

	@Override
	public int getPartition(TextPair arg0, Text arg1, int arg2) {
		// TODO Auto-generated method stub
		int res	=	(arg0.toString().hashCode() & Integer.MAX_VALUE)%arg2;
		return res;
	}

}
