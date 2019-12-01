package _thread;

public class YieldMethod {
	public static void main(String[] args) {
		new YieldTest();
		new YieldTest();
	}

	public static class YieldTest implements Runnable {

		public YieldTest() {
			Thread t = new Thread(this);
			t.start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 6; i++) {
				if ((i % 5) == 0) {
					System.out.println(Thread.currentThread() + "yield cpu ...");
					Thread.yield();
				}
			}
		}
	}
}
