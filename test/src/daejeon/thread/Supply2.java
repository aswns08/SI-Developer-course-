package daejeon.thread;

public class Supply2 extends Thread{
	public int Bread=10 ;
	static int i=1 ;
	int j=1 ;
	
	//쓰레드를 상속받거나 Runnable인터페이스를 구현하면 run()메소드를 오버라이딩
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
		System.out.println(j+"번째 빵 공급");
		this.notify();
		j++ ;
	}
	
	public synchronized void buy() {
		Thread t = Thread.currentThread();
		
		while(Bread==0) {
			try {
				System.out.println("********** 빵 다팔림 **********");
				
				wait() ;				
				
				System.out.println("wait된 쓰레드 : " + t.getName());
				System.out.println("쓰레드 상태" + t.getState());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		Bread = Bread-1 ;
		System.out.println(t.getName() + " " +i+ " 번째 빵 팔림");
		i++ ;
	}
}
