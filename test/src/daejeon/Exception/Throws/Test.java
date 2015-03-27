package daejeon.Exception.Throws;

public class Test {
	public void test(){
		Throws_test tt= new Throws_test() ;
		try {
			tt.test(0);
		}catch(Exception e) {	
			e.printStackTrace();
			System.out.println("Test클래스에서 호출할때 에러");
		}
		
	}

}
