package _thread.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * ���̲߳���ȫ�ļ���ת��λ�̰߳�ȫ
 * 1.�̰߳�ȫ����ָ�������ֱ��ʹ�����ṩ�ĺ���
 * 2.�������ԭ�Ӳ�������֤�̰߳�ȫ
 * 3.�����̲߳���ȫ
 * @author Administrator
 *
 */
public class SynchronizedListTest {
	List<Object> synchronizedList = Collections.synchronizedList(new ArrayList<>());
}
