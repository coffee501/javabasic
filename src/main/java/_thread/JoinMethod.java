package _thread;

public class JoinMethod {
	public static void main(String[] args) throws InterruptedException {
		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					System.out.println("threadA end");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					System.out.println("threadB end");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread threadC = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					System.out.println("threadC end");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		threadA.start();
		threadB.start();
		threadC.start();
		System.out.println("wait all thread over!");
		threadA.join();
		threadB.join();
		threadC.join();
		System.out.println("all thread over");
	}
}
