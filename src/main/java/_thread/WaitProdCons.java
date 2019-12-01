package _thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liujinhong on 2017/4/2.
 * 	������������������һ���ܾ�������⣬ֵ�úú��о�һ��
 * java��wait��notify������ʹ��ʱҲ��Ҫ�ǳ�ע���
 */
public class WaitProdCons {

	public static class Producer extends Thread {
		Queue<Integer> queue;
		int maxsize;

		Producer(Queue<Integer> queue, int maxsize, String name) {
			this.queue = queue;
			this.maxsize = maxsize;
			this.setName(name);
		}

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {

					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

					System.out.println(this.getName() + "��ö��е���");
					// �������ж�һ��Ҫʹ��while������if
					if (queue.size() == maxsize) {
						System.out.println("����������������" + this.getName() + "�ȴ�");
						try {
							queue.wait();
						} catch (Exception e) {
						}
					}
					int num = (int) (Math.random() * 100);
					queue.offer(num);

					System.out.println(this.getName() + "����һ��Ԫ�أ�" + num);
					queue.notifyAll();

					System.out.println(this.getName() + "�˳�һ���������̣�");
				}
			}
		}
	}

	public static class Consumer extends Thread {
		Queue<Integer> queue;
		int maxsize;

		Consumer(Queue<Integer> queue, int maxsize, String name) {
			this.queue = queue;
			this.maxsize = maxsize;
			this.setName(name);
		}

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					try {
						Thread.sleep(500);
					} catch (Exception e) {
					}
					System.out.println(this.getName() + "��ö��е���");
					// �������ж�һ��Ҫʹ��while������if
					if (queue.isEmpty()) {
						System.out.println("����Ϊ�գ�������" + this.getName() + "�ȴ�");
						try {
							queue.wait();
						} catch (Exception e) {
						}
					}
					int num = queue.poll();
					System.out.println(this.getName() + "����һ��Ԫ�أ�" + num);
					queue.notifyAll();

					System.out.println(this.getName() + "�˳�һ�����ѹ��̣�");
				}
			}
		}
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		int maxsize = 2;

		Producer producer = new Producer(queue, maxsize, "Producer");
		Consumer consumer1 = new Consumer(queue, maxsize, "Consumer1");
		Consumer consumer2 = new Consumer(queue, maxsize, "Consumer2");
		Consumer consumer3 = new Consumer(queue, maxsize, "Consumer3");

		producer.start();
		consumer1.start();
		consumer2.start();
		consumer3.start();
	}
}