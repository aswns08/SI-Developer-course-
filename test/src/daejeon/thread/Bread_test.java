package daejeon.thread;

public class Bread_test {
	public static Supply2 sp = new Supply2() ;
	
	public static void main(String[] args) {
		//������ Ŭ������ �ݵ� ����ó�� ���ص���
		sp.start();
		
		try{
			Consumer cs = new Consumer() ;
			Consumer cs1 = new Consumer() ;
			Consumer cs2 = new Consumer() ;
			Consumer cs3 = new Consumer() ;
			
			cs.start();
			cs1.start();
			cs2.start();
			cs3.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}


