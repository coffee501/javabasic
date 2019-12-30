package _thread.lock;

import java.util.concurrent.locks.ReentrantLock;
/**
 * lockInterruptibly�����������߳������ж�
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
				System.out.println("�����߳�" + Thread.currentThread().getName());
				interruptLock.lockInterruptibly();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("�˳��߳�" + Thread.currentThread().getName());
			}
		}
	}
}
