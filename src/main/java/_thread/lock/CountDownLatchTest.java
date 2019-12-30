package _thread.lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	private static CountDownLatch countDown = new CountDownLatch(4);

	public static void main(String[] args) throws InterruptedException {
		Thread one = new Thread(new ThreadRun(), "one");
		Thread two = new Thread(new ThreadRun(), "two");
		Thread three = new Thread(new ThreadRun(), "three");
		Thread four = new Thread(new ThreadRun(), "four");
		one.start();
		two.start();
		three.start();
		four.start();
		countDown.await();
	}
	private static class ThreadRun implements Runnable {
		@Override
		public void run() {
			try {
				// 获取锁
				System.out.println("获取一个锁" + Thread.currentThread().getName());
				countDown.countDown();
			} catch (Exception e) {
				e.getMessage();
			} finally {
				System.out.println("剩余数量" + countDown.getCount());
				System.out.println("释放一个锁" + Thread.currentThread().getName());
			}
		}
	}
}
