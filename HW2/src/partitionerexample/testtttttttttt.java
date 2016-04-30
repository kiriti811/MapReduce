package partitionerexample;

public class testtttttttttt {
	public static void main(String agrs[]){
		String	pay	=	"1201	gopal	45	Male	50000";
		try{
			String[]	data	=	pay.toString().split("\t"); 
			String		gender	=	data[3];
			String		age		=	data[2]	+	"$$$"	+	data[4];
			System.out.println(gender);
			System.out.println(age);
		}
			catch(Exception ex){
				System.out.println(ex.getMessage());
			}
		}
}
