package cert.mod4;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;


public class FourCustomeKey implements WritableComparable<FourCustomeKey>{

	private Text	first	=	new	Text();
	private Text	second	=	new	Text();
	
	public FourCustomeKey() {
		// TODO Auto-generated constructor stub
		super();
		this.first	=	new	Text();
		this.second	=	new	Text();
	}
	
	public FourCustomeKey(Text first,Text second) {
		// TODO Auto-generated constructor stub
		super();
		this.first	=	first;
		this.second	=	second;
	}
	
	public FourCustomeKey(String first,String second) {
		// TODO Auto-generated constructor stub
		super();
		this.first	=	new Text(first);
		this.second	=	new	Text(second);
		
	}
	
	@Override
	public String toString() {
		return first + "	" + second ;
	}

	
	

	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		this.first.readFields(arg0);
		this.second.readFields(arg0);
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		this.first.write(arg0);
		this.second.write(arg0);
		
	}

	

	@Override
	public int compareTo(FourCustomeKey o) {
		int res	=	this.first.compareTo(o.first);
		if(res!=0)
			return res;
		return this.second.compareTo(second);
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
		FourCustomeKey other = (FourCustomeKey) obj;
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


}
