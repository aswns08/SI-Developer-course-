package daejeon.Exception;

public class TryTest {
	public void test(int number) {
		try {
			int result = 4/number ;
			System.out.println("��� ��� : " + result);
		}catch(Exception e) {
			e.printStackTrace();
			//e.toString();
			//e.getMessage();
		}finally {
			System.out.println("finally������ ���");	//���ܰ� �߻��ϴ��� ���ϴ��� ������ ����Ǵ� ����
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TryTest tt = new TryTest() ;
		tt.test(0); 

	}

}
