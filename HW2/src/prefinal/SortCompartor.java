package prefinal;


import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


public class SortCompartor extends WritableComparator{

	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		// TODO Auto-generated method stub
		TextPair	x	=	(TextPair)a;
		TextPair	y	=	(TextPair)b;
		return		x.getFirst().compareTo(y.getFirst());
		
	}


}
