package _thread.basic;
/**
 * 演示synchronized
 * 1.synchronized是原子性内置锁
 * 2.java每个对象都可以当作一个同步锁，这些内置使用者看不见的锁称为内部锁，也叫做监视器锁
 * 3.java线程执行代码进入synchronized代码块自动获取内部锁
 * 4.拿到内部锁的线程在正常退出或者抛出异常或者同步快内部调用该内置锁的wait系类方法释放该内置锁
 * 5.内置锁是排他锁，当一个线程获取到这个锁后，其他线程必须等待该线程释放锁后才可以获取该锁
 * @author Administrator
 *
 */
public class SynchronizedDemo {
	// 共享的资源
	private int num = 0;
	// 未使用synchronized，会出现资源获取错误
	public synchronized void printNum(String tag) {
		try {

			if (tag.equals("a")) {
				num = 100;
				System.out.println("tag a, set num over!");
				Thread.sleep(1000);
			} else {
				num = 200;
				System.out.println("tag b, set num over!");
			}
			System.out.println("tag " + tag + ", num = " + num);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// 注意观察run方法输出顺序
	public static void main(String[] args) {

		// 俩个不同的对象
		SynchronizedDemo demo = new SynchronizedDemo();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				demo.printNum("a");
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				demo.printNum("b");
			}
		});

		t1.start();
		t2.start();

	}
}
