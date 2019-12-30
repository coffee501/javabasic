package _thread.lock;

import java.util.concurrent.Semaphore;
/**
 * 可以控制线程的数量
 * @author Administrator
 *
 */
public class SemaphoreTest {
	private static Semaphore semaphore = new Semaphore(1);

	public static void main(String[] args) {
		Thread one = new Thread(new ThreadRun(), "one");
		Thread two = new Thread(new ThreadRun(), "two");
		Thread three = new Thread(new ThreadRun(), "three");
		Thread four = new Thread(new ThreadRun(), "four");
		one.start();
		two.start();
		three.start();
		four.start();
	}
	private static class ThreadRun implements Runnable {
		@Override
		public void run() {
			try {
				// 获取锁
				semaphore.acquire();
				System.out.println("获取一个锁" + Thread.currentThread().getName());
				Thread.sleep(1000);
			} catch (Exception e) {
				e.getMessage();
			} finally {
				// 释放锁
				semaphore.release();
				System.out.println("释放一个锁" + Thread.currentThread().getName());
			}
		}
	}
}
