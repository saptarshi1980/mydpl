
public class Test {

	
	public static void main(String [] args){
		
		String a="UMAPADA BANERJEE|030002";
		System.out.println(a.indexOf("|"));
		String name=a.substring(0,a.indexOf("|"));
		String meterNo=a.substring(a.indexOf("|")+1,a.length());
		
		
		System.out.println(name);
		System.out.println(meterNo);
	}
}
