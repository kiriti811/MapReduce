package certi;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;



public class MySort extends WritableComparator{



	protected MySort(){
		super();
	}

	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		// TODO Auto-generated method stub
		TextPair	first	=	(TextPair)a;
		TextPair	second	=	(TextPair)b;
		return first.getFirst().compareTo(second.getFirst());
	}

}
