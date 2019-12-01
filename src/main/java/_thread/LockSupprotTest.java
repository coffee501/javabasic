package _thread;

import java.util.concurrent.locks.LockSupport;

public class LockSupprotTest {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("child begin park");
				LockSupport.park();
				System.out.println("child thread unpark");
			}
			
		});
		
		Thread threadOne = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("threadOne begin park");
				while (!Thread.currentThread().isInterrupted()) {
					LockSupport.park(1);
				}
				System.out.println("threadOne unpark");
			}
		});
		thread.start();
		Thread.sleep(1000);
		System.out.println("main thread begin unpark");
		LockSupport.unpark(thread);
		threadOne.start();
		Thread.sleep(1000);
		System.out.println("threadOne interrupt");
		System.out.println(LockSupport.getBlocker(threadOne));
		threadOne.interrupt();
	}
}
