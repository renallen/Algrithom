package com.bob.Search;


public class Btree <Key extends Comparable<Key>,Value>{
	public static void main(String[] args) 
	  {
	    Btree<String, String> st = new Btree<String, String>();
	 
	    st.put("www.cs.princeton.edu", "128.112.136.12");
	    st.put("www.cs.princeton.edu", "128.112.136.11");
	    st.put("www.princeton.edu",  "128.112.128.15");
	    st.put("www.yale.edu",     "130.132.143.21");
	    st.put("www.simpsons.com",   "209.052.165.60");
	    st.put("www.apple.com",    "17.112.152.32");
	    st.put("www.amazon.com",    "207.171.182.16");
	    st.put("www.ebay.com",     "66.135.192.87");
	    st.put("www.cnn.com",     "64.236.16.20");
	    st.put("www.google.com",    "216.239.41.99");
	    st.put("www.nytimes.com",   "199.239.136.200");
	    st.put("www.microsoft.com",  "207.126.99.140");
	    st.put("www.dell.com",     "143.166.224.230");
	    st.put("www.slashdot.org",   "66.35.250.151");
	    st.put("www.espn.com",     "199.181.135.201");
	    st.put("www.weather.com",   "63.111.66.11");
	    st.put("www.yahoo.com",    "216.109.118.65");
	 
	 
	    System.out.println("cs.princeton.edu: " + st.get("www.cs.princeton.edu"));
	    System.out.println("hardvardsucks.com: " + st.get("www.harvardsucks.com"));
	    System.out.println("simpsons.com:   " + st.get("www.simpsons.com"));
	    System.out.println("apple.com:     " + st.get("www.apple.com"));
	    System.out.println("ebay.com:     " + st.get("www.ebay.com"));
	    System.out.println("dell.com:     " + st.get("www.dell.com"));
	    System.out.println();
	 
	    System.out.println("size:  " + st.size());
	    System.out.println("height: " + st.height());
	    System.out.println(st);
	    System.out.println();
	  }
	//B-树的阶数
	private static final int M=4;
	private Node root;
	private int height;
	private int n;
	private static final class Node{
		private int m;
		private Entry[] children=new Entry[M];
		public Node(int k) {
			m=k;
		}
	}
	private static class Entry 
	  {
	    private Comparable key;
	    private Object val;
	    private Node next;   // helper field to iterate over array entries
	    public Entry(Comparable key, Object val, Node next) 
	    {
	      this.key = key;
	      this.val = val;
	      this.next = next;
	    }
	  }
	
	public Btree() {
		root=new Node(0);
	}
	public boolean isEmpy(){
		return size()==0;
	}
	private int size() {
		return n;
	}
	public int height(){
		return height; 
	}
	public Value get(Key key){
		if(key==null){
			throw new NullPointerException("key must not be null");
		}
		return search(root,key,height);
	}
	private Value search(Node x, Key key, int height) {
		Entry[] children=x.children;
		if(height==0){
			for(int j=0;j<x.m;j++){
				if(eq(key,children[j].key))return (Value)children[j].val;
			}
		}else{
			for(int j=0;j<x.m;j++){
				if(j+1==x.m || less(key,children[j+1].key))return search(children[j].next, key, height-1);
			}
		}
		return null;
	}
	public void put(Key key,Value val){
		if(key==null)throw new NullPointerException("key must not be null");
		Node node=insert(root,key,val,height);
		n++;
		if(node==null)return;
		Node t=new Node(2);
		t.children[0]=new Entry(root.children[0].key, null, root);
		t.children[1] = new Entry(t.children[0].key, null, node);
		root=t;
		height++;
	}
	private Node insert(Node h, Key key, Value val, int height) {
		int j;
	    Entry t = new Entry(key, val, null);
	    // external node外部结点，也是叶子结点，在树的最底层，存的是内容value
	    if (height == 0) 
	    {
	      for (j = 0; j < h.m; j++) 
	      {
	        if (less(key, h.children[j].key)) 
	        {
	          break;
	        }
	      }
	    }
	 
	    // internal node内部结点，存的是next地址
	    else
	    {
	      for (j = 0; j < h.m; j++) 
	      {
	        if ((j+1 == h.m) || less(key, h.children[j+1].key)) 
	        {
	          Node u = insert(h.children[j++].next, key, val, height-1);
	          if (u == null) 
	          {
	            return null;
	          }
	          t.key = u.children[0].key;
	          t.next = u;
	          break;
	        }
	      }
	    }
	 
	    for (int i = h.m; i > j; i--)
	    {
	      h.children[i] = h.children[i-1];
	    }
	    h.children[j] = t;
	    h.m++;
	    if (h.m < M) 
	    {
	      return null;
	    }
	    else  return split(h);//分裂结点
	}
	private Node split(Node h) {
		Node t = new Node(M/2);
	    h.m = M/2;
	    for (int j = 0; j < M/2; j++)
	    {
	      t.children[j] = h.children[M/2+j];     
	    }
	    return t;  
	}
	private boolean less(Comparable key1, Comparable key2) {
		return key1.compareTo(key2)<0;
	}
	private boolean eq(Comparable key, Comparable key2) {
		return key.compareTo(key2)==0;
	}
	
	public String toString() 
	  {
	    return toString(root, height, "") + "\n";
	  }
	 
	  private String toString(Node h, int ht, String indent) 
	  {
	    StringBuilder s = new StringBuilder();
	    Entry[] children = h.children;
	    if (ht == 0) 
	    {
	      for (int j = 0; j < h.m; j++) 
	      {
	        s.append(indent + children[j].key + " " + children[j].val + "\n");
	      }
	    }
	    else {
	      for (int j = 0; j < h.m; j++) {
	        if (j > 0)s.append(indent + "(" + children[j].key + ")\n");
	        s.append(toString(children[j].next, ht-1, indent + "   "));
	      }
	    }
	    return s.toString();
	  }
	
}
