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
				// 启动“线程t1”
				System.out.println(Thread.currentThread().getName() + " start");
				t1.start();
				// 主线程等待t1通过notify()唤醒。
				System.out.println(Thread.currentThread().getName() + " wait()");
				t1.wait();
				// 不是使t1线程等待，而是当前执行wait的线程等待
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
				// 启动“线程t1”
				System.out.println(Thread.currentThread().getName() + " start");
				t1.start();
				// 主线程等待t1通过notify()唤醒。
				System.out.println(Thread.currentThread().getName() + " wait()");
				t1.wait(20000);
				// 不是使t1线程等待，而是当前执行wait的线程等待
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
					// 使当前线阻塞 1 s，确保主程序的 t1.wait(); 执行之后再执行 notify()
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "  ThreadBy call notify()");
				// 唤醒当前的wait线程
				this.notify();
			}
		}
	}

	public static class ThreadByOne extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(10000);
				System.out.println("线程ThreadByOne运行");
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
					// 使当前线阻塞 1 s，确保主程序的 t1.wait(); 执行之后再执行 notify()
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName() + "  ThreadByTwo");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}
