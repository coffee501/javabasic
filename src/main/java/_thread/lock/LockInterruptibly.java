package _thread.lock;

import java.util.concurrent.locks.ReentrantLock;
/**
 * lockInterruptibly：允许其他线程设置中断
 * @author Administrator
 *
 */
public class LockInterruptibly {
	private static ReentrantLock interruptLock = new ReentrantLock();
	public static void main(String[] args) {
		Thread one = new Thread(new ThreadRun());
		Thread two = new Thread(new ThreadRun());
		one.start();
		two.start();
		one.interrupt();
	}

	private static class ThreadRun implements Runnable {
		@Override
		public void run() {
			try {
				System.out.println("进入线程" + Thread.currentThread().getName());
				interruptLock.lockInterruptibly();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("退出线程" + Thread.currentThread().getName());
			}
		}
	}
}
