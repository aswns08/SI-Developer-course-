package se_test0309;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String aa = "aa" ;
		String bb = "aa" ;
		String cc = new String("aa") ;

		System.out.println(aa.equals(bb));	
		System.out.println(aa.equals(cc));	
		System.out.println(aa==bb);		
		System.out.println(bb==cc);		
		System.out.println(aa==cc);		

	}

}
