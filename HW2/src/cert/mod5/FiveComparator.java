package cert.mod5;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class FiveComparator extends WritableComparator{

	protected FiveComparator(){
		super(FiveCustomeKey.class,true);
	}

	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		// TODO Auto-generated method stub
		FiveCustomeKey	first	=	(FiveCustomeKey)a;
		FiveCustomeKey	second	=	(FiveCustomeKey)b;
		return super.compare(a, b);
	}
	
}
