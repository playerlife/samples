package net.fqjj.www;

public class MyRunnable implements Runnable {

	private int account = 0 ;
	private Object obj;

	public MyRunnable() {
	}

	
	// ͬ�������
	public  synchronized void show() {
		
	}
	
	
	// ͬ������
	@Override
	public void run() {
		
		synchronized(obj) {
			
			account += 10;;
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "===" + i);
		}
		
		}
		
	}

	public static void main(String[] args) {

		Runnable obj = new MyRunnable();
		Thread t2 = new Thread(obj, "�µ�");
		t2.start();
		t2.setPriority(Thread.MIN_PRIORITY);
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "===" + i);

			if (i == 5) {
				
				Thread t1 = new Thread(obj, "join�߳�....");
				t1.setPriority(Thread.MAX_PRIORITY);
				t1.start();
			
				try {
					
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}

		}
	}
}
