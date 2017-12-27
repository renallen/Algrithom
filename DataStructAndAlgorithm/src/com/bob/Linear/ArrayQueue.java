package com.bob.Linear;

import java.io.Serializable;
import java.util.Arrays;

public class ArrayQueue <T> implements Serializable{
	private static final long serialVersionUID = 7333344126529379197L;  
	  
	  private int DEFAULT_SIZE = 10;  
	  
	  private int capacity;//��������ĳ���  
	  
	  private Object[] elementData;//����һ���������ڱ���˳����е�Ԫ��  
	  
	  private int front = 0;//��ͷ  
	  
	  private int rear = 0;//��β  
	  
	  //��Ĭ�����鳤�ȴ�����˳�����  
	  public ArrayQueue() {  
	    capacity = DEFAULT_SIZE;  
	    elementData = new Object[capacity];  
	  }  
	  
	  //��һ����ʼ��Ԫ��������˳�����  
	  public ArrayQueue(T element) {  
	    this();  
	    elementData[0] = element;  
	    rear++;  
	  }  
	    
	  public ArrayQueue(int initSize) {  
	    elementData = new Object[initSize];  
	  }  
	  
	  /** 
	   * ��ָ�����ȵ�����������˳����� 
	   * @param element ָ��˳������е�һ��Ԫ�� 
	   * @param initSize ָ��˳����еײ�����ĳ��� 
	   */  
	  public ArrayQueue(T element, int initSize) {  
	    this.capacity = initSize;  
	    elementData = new Object[capacity];  
	    elementData[0] = element;  
	    rear++;  
	  }  
	  
	  /** 
	   * @Title: size      
	   * @Description: ��ȡ˳����еĴ�С     
	   * @return 
	   */  
	  public int size() {  
	    return rear - front;  
	  }  
	  
	  /** 
	   * @Title: offer      
	   * @Description: ���     
	   * @param element 
	   */  
	  public void offer(T element) {  
	    ensureCapacity(rear + 1);  
	    elementData[rear++] = element;  
	  }  
	    
	  private void ensureCapacity(int minCapacity) {  
	    //��������ԭ�г���С��Ŀǰ����ĳ���  
	    int oldCapacity = elementData.length;  
	    if (minCapacity > oldCapacity) {  
	      int newCapacity = (oldCapacity * 3) / 2 + 1;  
	      if (newCapacity < minCapacity)  
	        newCapacity = minCapacity;  
	      // minCapacity is usually close to size, so this is a win:  
	      elementData = Arrays.copyOf(elementData, newCapacity);  
	    }  
	  
	  }  
	  
	  /** 
	   * @Title: poll      
	   * @Description: ����     
	   * @return 
	   */  
	  public T poll() {  
	    if (isEmpty()) {  
	      throw new IndexOutOfBoundsException("�ն����쳣");  
	    }  
	    //�������е�front�˵�Ԫ�ص�ֵ  
	    T oldValue = (T) elementData[front];  
	    //�ͷŶ��е�front�˵�Ԫ��  
	    elementData[front++] = null;  
	    return oldValue;  
	  }  
	  
	  /** 
	   * @Title: peek      
	   * @Description: ���ض��ж�Ԫ�أ�����ɾ�����ж�Ԫ��     
	   * @return 
	   */  
	  public T peek() {  
	    if (isEmpty()) {  
	      throw new IndexOutOfBoundsException("�ն����쳣");  
	    }  
	    return (T) elementData[front];  
	  }  
	  
	  /** 
	   * @Title: isEmpty      
	   * @Description: �ж�˳������Ƿ�Ϊ�ն���     
	   * @return 
	   */  
	  public boolean isEmpty() {  
	    return rear == front;  
	  }  
	  
	  /** 
	   * @Title: clear      
	   * @Description: ���˳����� 
	   */  
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
	      StringBuilder sb = new StringBuilder("[");  
	      for (int i = front; i < rear; i++) {  
	        sb.append(elementData[i].toString() + ", ");  
	      }  
	      int len = sb.length();  
	      return sb.delete(len - 2, len).append("]").toString();  
	    }  
	  }  
}
