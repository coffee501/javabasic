package _thread;

public class NotifyMethod {
	private static volatile Object resourceA = new Object();

	public static void main(String[] args) throws InterruptedException {
		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("threadA get reasouA lock");
				synchronized (resourceA) {
					try {
						System.out.println("threadA begin wait");
						resourceA.wait();
						System.out.println("threadA end wait");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		});
		
		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("threadB get reasouB lock");
				synchronized (resourceA) {
					try {
						System.out.println("threadB begin wait");
						resourceA.wait();
						System.out.println("threadB end wait");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
		});
		
		Thread threadC = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (resourceA) {
					System.out.println("theadC begin notify");
					resourceA.notify();
				}
			}
		});
		threadA.start();
		threadB.start();
		
		Thread.sleep(1000);
		
		threadC.start();
		threadA.join();
		threadB.join();
		threadC.join();
		System.out.println("main over");
	}
}
