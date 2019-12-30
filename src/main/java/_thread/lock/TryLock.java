package _thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
/**
 * tryLock:�з���ֵ����ȡ����λtrue�������û�ȡ���ȴ�ʱ��
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
							"��ȡ�����ɹ�" + Thread.currentThread().getName());
				} else {
					System.out.println(
							"��ȡ��ʧ��" + Thread.currentThread().getName());
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
