package _thread;

public class InterruptMethod {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
//				while (!Thread.currentThread().isInterrupted()) {
//					System.out.println(Thread.currentThread() + "hello");
//				}
				System.out.println("sleep start");
				try {
					Thread.sleep(2000000);
					System.out.println("sleep end");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		// 启动子线程
		thread.start();
		// 主线程休眠
		Thread.sleep(10);
		System.out.println("main thread interrupted thread");
		// 中断子线程
		thread.interrupt();
		// 等待线程执行完成
		thread.join();
		System.out.println("main is over");

	}
}
