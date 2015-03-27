package daejeon.Exception.Throws;

public class Throws_test {
	public void test(int number) throws Exception {
		int result = 4/number ;	//예외가 발생하면 test()메소드를 부른 Test.java로 예외넘어감
		System.out.println("결과 출력 : " +result);
		
	}

}
