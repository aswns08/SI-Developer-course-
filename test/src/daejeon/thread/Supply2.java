package daejeon.thread;

public class Supply2 extends Thread{
	public int Bread=10 ;
	static int i=1 ;
	int j=1 ;
	
	//�����带 ��ӹްų� Runnable�������̽��� �����ϸ� run()�޼ҵ带 �������̵�
	public void run() {
		while(true) {
			try{
				Thread.sleep(3000);
				make() ;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void make() {
		Bread=Bread+1 ;
		System.out.println(j+"��° �� ����");
		this.notify();
		j++ ;
	}
	
	public synchronized void buy() {
		Thread t = Thread.currentThread();
		
		while(Bread==0) {
			try {
				System.out.println("********** �� ���ȸ� **********");
				
				wait() ;				
				
				System.out.println("wait�� ������ : " + t.getName());
				System.out.println("������ ����" + t.getState());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		Bread = Bread-1 ;
		System.out.println(t.getName() + " " +i+ " ��° �� �ȸ�");
		i++ ;
	}
}
