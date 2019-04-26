package com.txb.array.util;
/**
 * 我的array类
 * @author 13125
 *
 */
//E：数据类型
public class Array<E> {
	
	private E[] data;
	int size;
	
	/**
	 * 构造函数，传入数组的容量构建Array
	 * @param capacity
	 */
	public Array(int capacity) {
		data = (E[]) new Object[capacity];//强制类型转化
		size = 0;
	}
	
	/**
	 * 无参构造函数，默认容量为10
	 */
	public Array() {
		data = (E[]) new Object[10];//强制类型转化
		size = 0;
	}
	
	//实现动态数组
	private void resize(int newcapacity) {
		E[] newdata = (E[]) new Object[newcapacity];
		for(int i = 0; i <size; i++) {
			newdata[i]  = data[i];
		}
		
		data = newdata;
	}
	
	//获得数组的元素个数
	public int getSize() {
		return size;
	}
	
	//获得数组的容量
	public int getCapacity() {
		return data.length;
	}

	//数组是否为空
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}else {
			return false;
		}
	}
	
	//向数组的末尾添加元素
	public void addLast(E e) {
		add(size,e);
	}

	//向数组指定位置添加元素
	public void add(int index,E e) {
		
		//保证index的合理
		if(index<0 || index > size) {
			throw new IllegalArgumentException("out of");
		}
		
		//保证数组有足够的空间
		if(size==data.length) {
					resize(2*data.length);
		}
				
		//移动后续元素
		for(int i  = size-1 ; i >= index; i --) {
			data[i+1] = data[i];
		}
		
		//存入指定元素
		data[index] = e;
		size++;
	}
	
	//向开头添加元素
	public void addFirst(E e) {
		add(0,e);
	}
	
	//to String
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size = %d , capacity = %d\n",  size , data.length));
		res.append("[");
		
		for(int i = 0; i < size; i ++) {
			res.append(data[i]);
			if(i != size-1) {
				res.append(",");
			}
		}
		
		res.append("]");
		
		return res.toString();
	}
	
	//查找给定位置的索引
	public E get(int index) {
		
		if(index < 0||index >= size) {
			throw new IllegalArgumentException("GET fialed");
		}
		return data[index];
	}
	
	public E getFirst() {
		return get(0);
	}
	
	public E getLast() {
		return get(size-1);
	}
	
	//设置给定位置的索引
	public void set(int index,E e) {
		
		if(index < 0||index >= size) {
			throw new IllegalArgumentException("SET fialed");
		}
		
		data[index] = e;
	}
	
	//搜索是否存在给定元素
	public boolean contains(E e) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}
	
	//查找元素所在位置，不存在返回-1
	public int find(E e) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}
	
	//根据索引删除元素，返回删除元素
	public E remove(int index) {
		
		if(index < 0||index >= size) {
			throw new IllegalArgumentException("delete fialed");
		}
		
		E ret = data[index];
		for(int i = index; i < size-1; i++) {
			data[i] = data[i+1];
		}
		
		size--;
		data[size] = null;
		//缩容时可能出现的bug
		if(size==data.length / 4&&data.length / 2!=0) {
			resize(data.length / 2);
		}
		return ret;
	}
	
	//
	public E removeFirst() {
		return remove(0);
	}
	
	//删除最后一个元素
	public E removeLast() {
		return remove(size-1);//size--在remove中实现
	}
	
	//从数组中删除元素e
	public void removeElement(E e) {
		int index = find(e);
		
		if(index!=-1) {
			remove(index);
		}
	}
}
