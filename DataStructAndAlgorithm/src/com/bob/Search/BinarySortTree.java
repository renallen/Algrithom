package com.bob.Search;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySortTree<E> {
    /** 
     * ���ڵ㣬Ϊ���������дget��set���� 
     */  
    static class Entry<E> {  
        E element;  
        Entry<E> parent;  
        Entry<E> left;  
        Entry<E> right;  
  
        public Entry(E element, Entry<E> parent) {  
            this.element = element;  
            this.parent = parent;  
        }  
    }  
	// ���ڵ�  
    private Entry<E> root = null;  
    // ����Ԫ�ظ���  
    private int size = 0;  
    public int size() {  
        return size;  
    }  
  
    public E getRoot() {  
        return root == null ? null : root.element;  
    }  
    /** 
     * �ݹ�ʵ��: ����ָ��Ԫ��element�Ƿ������д��ڣ��������ʧ��ȷ������ӵ�λ��,���ҳɹ�ֱ�ӷ��� 
     * @param t ��ʾ�Ӵ˽ڵ㿪ʼ���²��� 
     * @param f ����t�ĸ��ڵ� 
     * @param p �����ҳɹ�pָ�������Ԫ�ؽڵ㣬���򷵻ز���·���ϵ����һ���ڵ� 
     */  
    private boolean searchBST(Entry<E> t, Object element, Entry<E> f, Entry<E> p) {  
        if (t == null) {  
            p = f;  
            return false;  
        }  
        Comparable<? super E> e = (Comparable<? super E>) element;  
        int cmp = e.compareTo(t.element);  
        if (cmp < 0) {  
            return searchBST(t.left, element, t, p);  
        } else if (cmp > 0) {  
            return searchBST(t.right, element, t, p);  
        } else {  
            p = t;  
            return true;  
        }  
    }  
  
    /** 
     * �ǵݹ�ʵ�� 
     */  
    private boolean searchBST(Object element, Entry[] p) {  
        Comparable<? super E> e = (Comparable<? super E>) element;  
        Entry<E> parent = root;  
        Entry<E> pp = null;  
        // ����parent���ڵ�  
        while (parent != null) {  
            int cmp = e.compareTo(parent.element);  
            pp = parent;  
            if (cmp < 0) {  
                parent = parent.left;  
            } else if (cmp > 0) {  
                parent = parent.right;  
            } else {  
                p[0] = parent;  
                return true;  
            }  
        }  
        p[0] = pp;  
        return false;  
    }  
  
    /** 
     * ���Ȳ��Ҷ���������������Ҳ���ָ��Ԫ�� ����뵽�������� 
     */  
    public boolean add(E element) {  
        Entry<E> t = root;  
        if (t == null) {  
            // ������ڵ�Ϊ��  
            root = new Entry<E>(element, null);  
            size = 1;  
            return false;  
        }  
        Comparable<? super E> e = (Comparable<? super E>) element;  
        Entry[] p = new Entry[1];  
        if (!searchBST(element, p)) {  
            // ����ʧ�ܣ�����Ԫ��  
            Entry<E> s = new Entry<E>(element, p[0]);  
            int cmp = e.compareTo((E) p[0].element);  
            if (cmp < 0) {  
                p[0].left = s;  
            }  
            if (cmp > 0) {  
                p[0].right = s;  
            }  
            size++;  
            return true;  
        }  
        return false;  
    }  
  
    /** 
     * �Ƴ��ڵ㣬ͬʱ����������ʹ֮Ϊ���������� ʵ��ԭ��  
     * ����Ҫɾ���Ľڵ�Ϊp���丸�ڵ�Ϊf����p��f����ڵ� �������������: 
     * 1.��pΪҶ�ӽڵ㣬ֱ��ɾ��  
     * 2.��p��ֻ��һ�����ӻ���һ���Һ��ӣ���ɾ��p��ʹPL����PRΪf�������� 
     * 3.��p��������������Ϊ�գ��ɶ������������ص��֪��ɾ��pǰ����������˶����� 
     * ���Եõ�һ���������У���ɾȥp��Ϊ�˱�������Ԫ�ص����λ�ò��䣬������������ 
     * ��p��ֱ��ǰ��(��ֱ�Ӻ��)���p��Ȼ��ɾ����ֱ��ǰ����ֱ�Ӻ�̡���ֱ��ǰ������ ����������ص��� 
     */  
    public boolean remove(Object o) {  
        Entry[] p = new Entry[1];  
        if (searchBST(o, p)) {  
            deleteEntry(p[0]); // ���ҳɹ���ɾ��Ԫ��  
            return true;  
        }  
        return false;  
    }  
  
    private void deleteEntry(Entry<E> p) {  
        size--;  
        if (p.left != null && p.right != null) { // ���p������������Ϊ�գ��ҵ���ֱ�Ӻ�̣��滻p  
            Entry<E> s = successor(p);  
            p.element = s.element;  
            p = s;  
        }  
        Entry<E> replacement = (p.left != null ? p.left : p.right);  
  
        if (replacement != null) { // �����������������һ��Ϊ��  
            replacement.parent = p.parent;  
            if (p.parent == null) // ���pΪroot�ڵ�  
                root = replacement;  
            else if (p == p.parent.left) // ���p������  
                p.parent.left = replacement;  
            else  
                p.parent.right = replacement; // ���p���Һ���  
  
            p.left = p.right = p.parent = null; // p��ָ�����  
  
        } else if (p.parent == null) { // ���ȫ��ֻ��һ���ڵ�  
            root = null;  
        } else { // ����������Ϊ��,pΪҶ�ӽڵ�  
            if (p.parent != null) {  
                if (p == p.parent.left)  
                    p.parent.left = null;  
                else if (p == p.parent.right)  
                    p.parent.right = null;  
                p.parent = null;  
            }  
        }  
  
    }  
  
    /** 
     * ���������������ʽ������ʱ��t��ֱ�Ӻ�� 
     */  
    static <E> Entry<E> successor(Entry<E> t) {  
        if (t == null)  
            return null;  
        else if (t.right != null) {  
            Entry<E> p = t.right; // ���ң�Ȼ������ֱ����ͷ  
            while (p.left != null)  
                p = p.left;  
            return p;  
        } else { // rightΪ�գ����t��p������������pΪt��ֱ�Ӻ��  
            Entry<E> p = t.parent;  
            Entry<E> ch = t;  
            while (p != null && ch == p.right) {  
                ch = p; // ���t��p�������������������������ֱ�Ӻ��  
                p = p.parent;  
            }  
            return p;  
        }  
    }  
  
    public Iterator<E> itrator() {  
        return new BinarySortIterator();  
    }  
  
    /** 
     * ����������������ĵ����� 
     */  
    private class BinarySortIterator implements Iterator<E> {  
        Entry<E> next;  
        Entry<E> lastReturned;  
  
        public BinarySortIterator() {  
            Entry<E> s = root;  
            if (s != null) {  
                while (s.left != null) {  
                    s = s.left; // �ҵ���������ĵ�һ��Ԫ��  
                }  
            }  
            next = s; // ����next  
        }  
  
        @Override  
        public boolean hasNext() {  
            return next != null;  
        }  
  
        @Override  
        public E next() {  
            Entry<E> e = next;  
            if (e == null)  
                throw new NoSuchElementException();  
            next = successor(e);  
            lastReturned = e;  
            return e.element;  
        }  
  
        @Override  
        public void remove() {  
            if (lastReturned == null)  
                throw new IllegalStateException();  
            // deleted entries are replaced by their successors  
            if (lastReturned.left != null && lastReturned.right != null)  
                next = lastReturned;  
            deleteEntry(lastReturned);  
            lastReturned = null;  
        }  
    }  
  

  
    // just for test  
    public static void main(String[] args) {  
        BinarySortTree<Integer> tree = new BinarySortTree<Integer>();  
        long start=System.currentTimeMillis();
        for(int i=0;i<100000;i++){
        	tree.add(i);
        }
        System.out.println("add time:"+(System.currentTimeMillis()-start));
        System.out.println(tree.remove(400));  
        System.out.println("root=" + tree.getRoot());  
      /*  Iterator<Integer> it = tree.itrator();  
        while (it.hasNext()) {  
            System.out.println(it.next());  
        }  */
        System.out.println(tree.size());  
    }  
  
}
