package _thread.list;

import java.util.concurrent.CopyOnWriteArrayList;
/**
 * 使用读多写少的场景
 * 1.线程安全且读操作无锁的ArrayLis
 * 写操作 实现原理：
 * 1.首先将当前容器复制一份，然后在新副本上执行写操作，结束之后再将原容器的引用指向新容器。
 * 缺点：
 * 1.内存使用过多
 * 2.无法保证实时性
 * @author Administrator
 *
 * @param <E>
 */
public class CopyWriteArrayListTest<E> {
	CopyOnWriteArrayList<E> list = new CopyOnWriteArrayList<E>();
}
