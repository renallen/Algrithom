package com.bob.sort;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    public List<Integer> list = null;
    public static final boolean isMaxHeap = true;
    public static final boolean isMinHeap = false;
    private boolean flag = true;  //true��ʾ���ѣ�false��ʾ��С��
    public Heap(){
        this.list = new ArrayList<Integer>();
    }
    public Heap(boolean flag){
        this.list = new ArrayList<Integer>();
        this.flag = flag;
    }
    //��ȡ�Ѵ�С
    public int size(){
        return this.list.size();
    }
    //��ȡ�Ѷ�Ԫ��
    public int peek(){
        if(list.size() == 0) return 0;
        return list.get(0);
    }
    //����Ԫ�أ��Ӳ���㿪ʼ���ϵ�����
    public void add(int val){
        this.list.add(val);
        int i = list.size() - 1, index, parent, cur;
        while(i > 0){
            index = (i - 1) / 2;
            parent = list.get(index);
            cur = list.get(i);
            if(flag == true && parent < cur){
                swap(index, i);
            }else if(flag == false && parent > cur){
                swap(index, i);
            }
            i = index;
        }
    }
    /**
     * ���Ѷ�Ԫ��ȡ��,�����µ����ѡ�
     * 1>ȡ���Ѷ�Ԫ��
     * 2>�����һ��Ԫ�طŵ��Ѷ�
     * 3>���µ�����
     */
    public int pop(){
        if(list.size() == 0) return -1;
        int res = list.get(0);
        list.set(0,list.get(list.size() - 1));
        list.remove(list.size()-1);
        int len = list.size() - 1 , i = 0;
        int left , right;
        while(i < len){
            left = (i << 1) + 1;
            right= (i << 1) + 2;
            int maxIndex = i;
            if(flag == true){
                if(left < len && list.get(left) > list.get(maxIndex)) maxIndex = left;
                if(right< len && list.get(right)> list.get(maxIndex)) maxIndex = right;
            }else{
                if(left < len && list.get(left) < list.get(maxIndex)) maxIndex = left;
                if(right< len && list.get(right)< list.get(maxIndex)) maxIndex = right;
            }
            if(maxIndex != i){
                swap(maxIndex,i);
                i = maxIndex;
            }else break;
        }
        return res;
    }
    //����list������λ�õ�Ԫ��
    public void swap(int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j,temp);
    }
    }
