package _thread.advanced;
/**
 * 概念：一个线程读取到另外一个线程的修改值
 * 原因：未同时对共享变量set和get方法加锁（synchronized）
 * 脏读：【数据库定义】：一个事务获取到另外一个事务提交的数据【另外一个事务如果回滚】
 * @author Administrator
 *
 */
public class DirtyRead {
	private String name;
	//设置
	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		try {
			//模拟其他线程修改值
			Thread.sleep(2000);
			this.name = name;
			System.out.printf("【现状态Name值】：%s%n",name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		DirtyRead read = new DirtyRead();
		read.setName("张三");

		Thread thead = new Thread(new Runnable() {
			@Override
			public void run() {
				read.setName("李四");
			}
		}, "Thread");
		thead.start();
		Thread.sleep(1000);
		System.out.printf("【main】获取Name值：%s%n",read.getName());
	}
}
