package _thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class CreateThread {
	@Test
	public void testCreateThread() {
		ExtendThread thread1 = new ExtendThread();
		thread1.start();
		
		ImplRunable thread2 = new ImplRunable();
		new Thread(thread2).start();

		FutureTask<String> futureTask = new FutureTask<String>(new ImplCallable());
		new Thread(futureTask).start();
		try {
			String result = futureTask.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

	/**
	 *	   �̳�Thread
	 * @author Administrator
	 *
	 */
	public static class ExtendThread extends Thread {
		@Override
		public void run() {
			System.out.println("extends Thread");
		}
	}

	/**
	 * 	ʵ��Runnable
	 * @author Administrator
	 *
	 */
	public static class ImplRunable implements Runnable {
		@Override
		public void run() {
			System.out.println("impl Runnable");
		}
	}

	public static class ImplCallable implements Callable<String> {

		@Override
		public String call() throws Exception {
			System.out.println("impl Callable");
			return "impl Callable";
		}

	}
}
