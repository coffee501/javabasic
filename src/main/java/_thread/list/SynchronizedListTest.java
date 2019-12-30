package _thread.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 将线程不安全的集合转换位线程安全
 * 1.线程安全仅仅指的是如果直接使用它提供的函数
 * 2.如果不是原子操作不保证线程安全
 * 3.迭代线程不安全
 * @author Administrator
 *
 */
public class SynchronizedListTest {
	List<Object> synchronizedList = Collections.synchronizedList(new ArrayList<>());
}
