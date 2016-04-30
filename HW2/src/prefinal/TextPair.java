package prefinal;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class TextPair implements WritableComparable<TextPair>{

	
	public Text getFirst() {
		return first;
	}

	public void setFirst(Text first) {
		this.first = first;
	}

	@Override
	public String toString() {
		return  first + "," + second;
	}

	/**
	 * @param first
	 * @param second
	 */
	public TextPair(Text first, Text second) {
		super();
		this.first = first;
		this.second = second;
	}
	
	public TextPair() {
		super();
		this.first = new Text();
		this.second = new Text();
	}
	
	
	public TextPair(String first, String second) {
		this.first = new Text(first);
		this.second = new Text(second);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextPair other = (TextPair) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}

	public Text getSecond() {
		return second;
	}

	public void setSecond(Text second) {
		this.second = second;
	}

	Text	first	=	new	Text();
	Text	second	=	new	Text();
	
	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.first.readFields(in);
		this.second.readFields(in);
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		this.first.write(out);
		this.second.write(out);
	}

	@Override
	public int compareTo(TextPair arg0) {
		// TODO Auto-generated method stub
		int 	res	=	this.first.compareTo(arg0.first);
		if(res!=0){
			return	res;
		}
		return this.second.compareTo(arg0.second);
	}

}
