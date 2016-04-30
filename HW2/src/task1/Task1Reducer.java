package task1;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Task1Reducer extends Reducer<TextPair, Text, TextPair, Text>{

	public void reduce(TextPair	key,Iterable<Text> value,Context	context) throws IOException, InterruptedException{
		
		TextPair	keyPair	=	new	TextPair("","");
		
		for(Text	str	:	value){
			
			String	first	=	key.getFirst().toString();
			
			if(first.substring(4,5).equals("0"))
			{
				first	=	first.substring(0, 4)+","+first.substring(5,6);
			}
			else
			{
				first	=	first.substring(0, 4)+","+first.substring(4,6);
			}
			
			String st	=	key.getFirst().toString();

			Text	sec	=	new	Text();
			
			if(st.substring(6,8).equals("0"))
			{
				sec	=	new Text(st.substring(7,8));
			}
				else
			{
					sec	=	new Text(st.substring(6,8));
			}	

			
			keyPair.setFirst(new Text(first));
			
			keyPair.setSecond(sec);
			
			context.write(keyPair, str);
			
		}
		
	}
	
}
