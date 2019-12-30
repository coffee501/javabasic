package _thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/**
 * tryLock:有返回值。获取到锁位true。可设置获取锁等待时间
 * @author Administrator
 *
 */
public class TryLock {
	private static ReentrantLock tryLock = new ReentrantLock();
	public static void main(String[] args) {

		Thread one = new Thread(new ThreadRun());
		Thread two = new Thread(new ThreadRun());
		one.start();
		two.start();
	}
	private static class ThreadRun implements Runnable {
		@Override
		public void run() {
			try {
				if (tryLock.tryLock(2500, TimeUnit.MILLISECONDS)) {
					System.out.println(
							"获取到锁成功" + Thread.currentThread().getName());
				} else {
					System.out.println(
							"获取锁失败" + Thread.currentThread().getName());
				}
				Thread.sleep(2000);
			} catch (Exception e) {
				e.getMessage();
			} finally {
				tryLock.unlock();
			}

		}
	}
}
