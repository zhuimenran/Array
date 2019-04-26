package com.txb.array.test;

import com.txb.array.util.Array;
/**
 * Main
 * @author 13125
 *@time 2019.4.24
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array<Integer> arr = new Array<Integer>();
		
		for(int i = 0; i < 10; i ++) {
			arr.add(i, i+1);
		}
		System.out.println(arr);
		arr.add(1,0);
		arr.addFirst(-1);
		arr.remove(2);
		System.out.println(arr);
		arr.removeFirst();
		System.out.println(arr);
		arr.addFirst(-1);
		System.out.println(arr);
		
		Array<Student> stus = new Array<>();
		
		stus.addFirst(new Student("vb",20));
		stus.addFirst(new Student("xdfs",30));
		stus.addFirst(new Student("ewfdvb",20));
		stus.addFirst(new Student("vsdfb",20));
		stus.addFirst(new Student("vdsffhdfb",240));
		
		System.out.println(stus);
	}

}
