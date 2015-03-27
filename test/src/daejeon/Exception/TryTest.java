package daejeon.Exception;

public class TryTest {
	public void test(int number) {
		try {
			int result = 4/number ;
			System.out.println("결과 출력 : " + result);
		}catch(Exception e) {
			e.printStackTrace();
			//e.toString();
			//e.getMessage();
		}finally {
			System.out.println("finally문에서 출력");	//예외가 발생하던지 안하던지 무조건 실행되는 문장
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TryTest tt = new TryTest() ;
		tt.test(0); 

	}

}
