package daejeon.Exception.Throws;

public class Test01 {
	public void test(){
		Throws_test tt= new Throws_test() ;
		try {
			tt.test(3);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Test01Ŭ�������� ȣ���Ҷ� ����");
		}
		
	}

}
