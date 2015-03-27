package daejeon.thread;

public class Consumer extends Thread {
	public void run() {
		while(true) {
			try {
				Bread_test.sp.buy() ;
				this.sleep(2000) ;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
