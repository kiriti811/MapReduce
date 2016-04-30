package cert.sort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


public class SixGroupingComparator extends WritableComparator{

	
	protected SixGroupingComparator(){
		super(SixCustomeKey.class,true);
	}

	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		// TODO Auto-generated method stub
		SixCustomeKey	first	=	(SixCustomeKey)a;
		SixCustomeKey	second	=	(SixCustomeKey)b;
		int	res	=	first.getSecond().compareTo(second.getSecond());
		return res;
	}

	
	
	
	
}
