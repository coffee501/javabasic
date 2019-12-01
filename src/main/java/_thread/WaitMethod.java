package _thread;

import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

public class WaitMethod {
	LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();

	public static void main(String[] args) {
		ThreadBy t1 = new ThreadBy();
		ThreadByOne t3 = new ThreadByOne();
		ThreadByTwo t4 = new ThreadByTwo();
		t3.start();
		testWait(t1);
		testWait(t4);
	}

	@Test
	public static void testWait(Thread t1) {
		synchronized (t1) {
			try {
				// �������߳�t1��
				System.out.println(Thread.currentThread().getName() + " start");
				t1.start();
				// ���̵߳ȴ�t1ͨ��notify()���ѡ�
				System.out.println(Thread.currentThread().getName() + " wait()");
				t1.wait();
				// ����ʹt1�̵߳ȴ������ǵ�ǰִ��wait���̵߳ȴ�
				System.out.println(Thread.currentThread().getName() + " continue");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public static void testWaitByOutTime(Thread t1) {
		synchronized (t1) {
			try {
				// �������߳�t1��
				System.out.println(Thread.currentThread().getName() + " start");
				t1.start();
				// ���̵߳ȴ�t1ͨ��notify()���ѡ�
				System.out.println(Thread.currentThread().getName() + " wait()");
				t1.wait(20000);
				// ����ʹt1�̵߳ȴ������ǵ�ǰִ��wait���̵߳ȴ�
				System.out.println(Thread.currentThread().getName() + " continue");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class ThreadBy extends Thread {
		@Override
		public void run() {
			synchronized (this) {
				try {
					// ʹ��ǰ������ 1 s��ȷ��������� t1.wait(); ִ��֮����ִ�� notify()
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "  ThreadBy call notify()");
				// ���ѵ�ǰ��wait�߳�
				this.notify();
			}
		}
	}

	public static class ThreadByOne extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(10000);
				System.out.println("�߳�ThreadByOne����");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class ThreadByTwo extends Thread {
		@Override
		public void run() {
			synchronized (this) {
				try {
					// ʹ��ǰ������ 1 s��ȷ��������� t1.wait(); ִ��֮����ִ�� notify()
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName() + "  ThreadByTwo");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}
