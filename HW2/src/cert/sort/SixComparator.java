package cert.sort;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


public class SixComparator extends WritableComparator{

	
	protected SixComparator(){
		super(SixCustomeKey.class,true);
	}

	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		SixCustomeKey			first	=	(SixCustomeKey)a;
		SixCustomeKey			second	=	(SixCustomeKey)b;
		// TODO Auto-generated method stub
		int		res		=	first.getFirst().compareTo(second.getFirst());
		if(res	==	0){
			return	first.getSecond().compareTo(second.getSecond());
		}
		return res;
	}

	
}
