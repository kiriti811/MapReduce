package examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class readCsv {

	public static void main(String args[]) {
		String csvFile = "C:\\Users\\sai\\Desktop/test.csv";
		BufferedReader br = null;
		String line = "";
		
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				StringTokenizer	variable	=	new StringTokenizer(line,",");
				int count = 0;
				while(variable.hasMoreElements()){
					String temp	=variable.nextToken();
					if(count == 4){
						if(temp=="0" || temp.equals("0")){
							System.out.println("Score" + temp);
						}
						else if(temp=="1" || temp.equals("1")){
							System.out.println("Score" + temp);
						}
						else if(temp=="2" || temp.equals("2")){
							System.out.println("Score" + temp);
						}
						else if(temp=="3" || temp.equals("3")){
							System.out.println("Score" + temp);
						}
						else if(temp=="4" || temp.equals("4")){
							System.out.println("Score" + temp);
						}
						else if(temp=="5" || temp.equals("5")){
							System.out.println("Score" + temp);
						}
						else{
							System.out.println("Score" + temp);
						}
						
					}
					count	=	count	+	1;
				}
				

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	}
}
