package se_test0304;

public class StarTest {
	
	public void star() {
		
		System.out.println("1��");
		for(int i=1 ; i<=5 ; i++) {
			for(int j=1 ; j<=i ; j++) {
				System.out.print("��");
			}
			System.out.println();
		}
		
		System.out.println("=============================");
		System.out.println("2��");
		
		
		for(int i=1 ; i<=5 ; i++) {
			for(int j=5 ; j>0 ; j--) {
				if(i>=j) {
					System.out.print("��");				
				}
				else {
					System.out.print("��");					
				}
			}	
			System.out.println();
			
		}
		
		System.out.println("=============================");
		System.out.println("3��");
		
		for(int i=1 ; i<=5 ; i++)
		{
			for(int j=5 ; j>=i ; j--){
				System.out.print("��");				
			}
			System.out.println();
		}
		
		System.out.println("=============================");
		System.out.println("4��");
		

		for(int i=1 ; i<=5 ; i++)
		{
			for(int j=1 ; j<=i ; j++) {
				System.out.print("��");
			}
			
			for(int j=5 ; j>=i ; j--){
				System.out.print("��");				
			}
			System.out.println();
		}
		
		
		
	}
	

	
	

}
