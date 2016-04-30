package partitionerexample;


public class testMap {
	public static void main(String agrs[]){
	int	max	=	-1;
	String	pay	=	"12$$$12000";
	int	age		=	Integer.parseInt(pay.toString().substring(0,pay.toString().indexOf("$$$")));
	int	salary	=	Integer.parseInt(pay.toString().substring(pay.toString().indexOf("$$$")+3,pay.toString().length()));
	if(salary>max){
		max	=	salary;
	}
	String	finalSalary	=	Integer.toString(max);
	System.out.println(age);
	System.out.println(finalSalary);
	}
}
