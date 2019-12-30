package _thread.lock;

import java.util.concurrent.Semaphore;
/**
 * ���Կ����̵߳�����
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
				// ��ȡ��
				semaphore.acquire();
				System.out.println("��ȡһ����" + Thread.currentThread().getName());
				Thread.sleep(1000);
			} catch (Exception e) {
				e.getMessage();
			} finally {
				// �ͷ���
				semaphore.release();
				System.out.println("�ͷ�һ����" + Thread.currentThread().getName());
			}
		}
	}
}
