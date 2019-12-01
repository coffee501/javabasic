package _thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SleepMethod {
	private static final Lock lock = new ReentrantLock();
	public static void main(String[] args) {
		Thread threadA = new Thread(new Runnable() {
			
			@Override
			public void run() {
				lock.lock();
				try {
					System.out.println("threadA begin sleep");
					Thread.sleep(5000);
					System.out.println("threadA end sleep");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		});
		Thread threadB = new Thread(new Runnable() {
			
			@Override
			public void run() {
				lock.lock();
				try {
					System.out.println("threadB begin sleep");
					Thread.sleep(5000);
					System.out.println("threadB end sleep");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
			}
		});
		threadA.start();
		threadB.start();
	}
}
