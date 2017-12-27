package com.bob.Linear;

import java.io.Serializable;
import java.util.Arrays;

public class LoopQueue <T>implements Serializable{
	private static final long serialVersionUID = -3670496550272478781L;  
	  
	  private int DEFAULT_SIZE = 10;  
	  
	  private int capacity;//��������ĳ���  
	  
	  private Object[] elementData;//����һ���������ڱ���ѭ�����е�Ԫ��  
	  
	  private int front = 0;//��ͷ  
	  
	  private int rear = 0;//��β  
	  
	  //��Ĭ�����鳤�ȴ�����ѭ������  
	  public LoopQueue() {  
	    capacity = DEFAULT_SIZE;  
	    elementData = new Object[capacity];  
	  }  
	  
	  //��һ����ʼ��Ԫ��������ѭ������  
	  public LoopQueue(T element) {  
	    this();  
	    elementData[0] = element;  
	    rear++;  
	  }  
	  
	  /** 
	   * ��ָ�����ȵ�����������ѭ������ 
	   * @param element ָ��ѭ�������е�һ��Ԫ�� 
	   * @param initSize ָ��ѭ�����еײ�����ĳ��� 
	   */  
	  public LoopQueue(T element, int initSize) {  
	    this.capacity = initSize;  
	    elementData = new Object[capacity];  
	    elementData[0] = element;  
	    rear++;  
	  }  
	  
	  //��ȡѭ�����еĴ�С  
	  public int size() {  
	    if (isEmpty()) {  
	      return 0;  
	    }  
	    return rear > front ? rear - front : capacity - (front - rear);  
	  }  
	  
	  //�������  
	  public void add(T element) {  
	    if (rear == front && elementData[front] != null) {  
	      throw new IndexOutOfBoundsException("�����������쳣");  
	    }  
	    elementData[rear++] = element;  
	    //���rear�Ѿ���ͷ���Ǿ�תͷ  
	    rear = rear == capacity ? 0 : rear;  
	  }  
	  
	  //�Ƴ�����  
	  public T remove() {  
	    if (isEmpty()) {  
	      throw new IndexOutOfBoundsException("�ն����쳣");  
	    }  
	    //�������е�rear�˵�Ԫ�ص�ֵ  
	    T oldValue = (T) elementData[front];  
	    //�ͷŶ��е�rear�˵�Ԫ��  
	    elementData[front++] = null;  
	    //���front�Ѿ���ͷ���Ǿ�תͷ  
	    front = front == capacity ? 0 : front;  
	    return oldValue;  
	  }  
	  
	  //���ض��ж�Ԫ�أ�����ɾ�����ж�Ԫ��  
	  public T element() {  
	    if (isEmpty()) {  
	      throw new IndexOutOfBoundsException("�ն����쳣");  
	    }  
	    return (T) elementData[front];  
	  }  
	  
	  //�ж�ѭ�������Ƿ�Ϊ�ն���  
	  public boolean isEmpty() {  
	    //rear==front��rear����Ԫ��Ϊnull  
	    return rear == front && elementData[rear] == null;  
	  }  
	  
	  //���ѭ������  
	  public void clear() {  
	    //���ײ���������Ԫ�ظ�Ϊnull  
	    Arrays.fill(elementData, null);  
	    front = 0;  
	    rear = 0;  
	  }  
	  
	  public String toString() {  
	    if (isEmpty()) {  
	      return "[]";  
	    } else {  
	      //���front < rear����ЧԪ�ؾ���front��rear֮���Ԫ��  
	      if (front < rear) {  
	        StringBuilder sb = new StringBuilder("[");  
	        for (int i = front; i < rear; i++) {  
	          sb.append(elementData[i].toString() + ", ");  
	        }  
	        int len = sb.length();  
	        return sb.delete(len - 2, len).append("]").toString();  
	      }  
	      //���front >= rear����ЧԪ��Ϊfront->capacity֮�䡢0->front֮���  
	      else {  
	        StringBuilder sb = new StringBuilder("[");  
	        for (int i = front; i < capacity; i++) {  
	          sb.append(elementData[i].toString() + ", ");  
	        }  
	        for (int i = 0; i < rear; i++) {  
	          sb.append(elementData[i].toString() + ", ");  
	        }  
	        int len = sb.length();  
	        return sb.delete(len - 2, len).append("]").toString();  
	      }  
	    }  
	  }  
	  
	  public static void main(String[] args) {  
	    LoopQueue<String> queue = new LoopQueue<String>("aaaa", 3);  
	    //�������Ԫ��  
	    queue.add("bbbb");  
	    queue.add("cccc");  
	    //��ʱ��������  
	    System.out.println(queue);  
	    //ɾ��һ��Ԫ�غ󣬶��п����ٶ��һ��Ԫ��  
	    queue.remove();  
	    System.out.println("ɾ��һ��Ԫ�غ�Ķ��У�" + queue);  
	    //�ٴ����һ��Ԫ�أ���ʱ��������  
	    queue.add("dddd");  
	    System.out.println(queue);  
	    System.out.println("������ʱ�ĳ��ȣ�" + queue.size());  
	    //ɾ��һ��Ԫ�غ󣬶��п����ٶ��һ��Ԫ��  
	    queue.remove();  
	    //�ٴμ���һ��Ԫ�أ���ʱ��������  
	    queue.add("eeee");  
	    System.out.println(queue);  
	  }  
}
