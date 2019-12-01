package _thread;

public class ThreadLocalTest {
	static ThreadLocal<String> localVariableOne = new ThreadLocal<String>();
	static ThreadLocal<String> localVariableTwo = new ThreadLocal<String>();

	static ThreadLocal<String> localVariableThread = new InheritableThreadLocal<String>();

	private static void print(String str) {
		System.out.println(str + ":" + localVariableOne.get());
		System.out.println(str + ":" + localVariableTwo.get());
		System.out.println(str + ":" + localVariableThread.get());
		localVariableOne.remove();
		localVariableTwo.remove();
	}

	public static void main(String[] args) {
		localVariableThread.set("main thread");

		Thread threadOne = new Thread(new Runnable() {
			@Override
			public void run() {
				localVariableOne.set(Thread.currentThread().getName());
				localVariableTwo.set("Test");
				print("threadOne");
			}
		});

		Thread threadTwo = new Thread(new Runnable() {
			@Override
			public void run() {
				localVariableOne.set(Thread.currentThread().getName());
				print("threadTwo");
			}
		});

		threadOne.start();
		threadTwo.start();
	}
}
