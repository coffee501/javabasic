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

		// �������߳�
		thread.start();
		// ���߳�����
		Thread.sleep(10);
		System.out.println("main thread interrupted thread");
		// �ж����߳�
		thread.interrupt();
		// �ȴ��߳�ִ�����
		thread.join();
		System.out.println("main is over");

	}
}
