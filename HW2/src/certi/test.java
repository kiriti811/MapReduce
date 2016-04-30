package certi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class test {

	public static void main(String args[]) throws IOException{
		String	line	=	"";
		BufferedReader	br	=null;
		HashMap<String, String> 	hashMap	=	new	HashMap<String, String>();
		br	=	new	BufferedReader(new FileReader("D:\\EliserWorkspace\\HW2\\src\\certi\\custs.csv"));
			while((line	=	br.readLine())	!=	null){
				String[]	input	=	line.split(",");
				int len	=	input.length;
				String value="";
				String		key		=	input[0];
				for(int i = 1 ; i < len  ; i ++){
					value	=	value	+	input[i];
				}
				hashMap.put(key, value);
				System.out.println(key+"KEY"+hashMap.get(key));
				}
		}
		
	
}
