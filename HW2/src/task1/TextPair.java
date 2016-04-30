package task1;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class TextPair implements	WritableComparable<TextPair>{

	Text	first	=	new	Text();
	Text	second	=	new	Text();
	
	
	public TextPair(Text first, Text second) {
		super();
		this.first = first;
		this.second = second;
	}
	
	public TextPair(){
		
		super();
		this.first = new	Text();
		this.second = new	Text();
		
	}
	
	public TextPair(String	first	,String	second) {
		super();
		this.first	=	new	Text(first);
		this.second	=	new	Text(second);
	}
	public Text getFirst() {
		return first;
	}

	public void setFirst(Text first) {
		this.first = first;
	}

	public Text getSecond() {
		return second;
	}

	public void setSecond(Text second) {
		this.second = second;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return first + "," +second;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		first.write(out);
		second.write(out);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		first.readFields(in);
		second.readFields(in);
	}

	

	@Override
	public int compareTo(TextPair o) {
		// TODO Auto-generated method stub
		int	test	=	first.compareTo(o.first);
		if(test!=0){
			return	test;
		}
		if(second.toString().equals("NA")||o.second.toString().equals("NA")){
			return -second.compareTo(o.second);
		}
		else{
			IntWritable	firstArrival	=	new IntWritable(Integer.parseInt(second.toString()));
			IntWritable	laterArrival	=	new IntWritable(Integer.parseInt(o.second.toString()));
			return -firstArrival.compareTo(laterArrival);
		}
	}

	
	
}
