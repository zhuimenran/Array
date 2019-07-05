package com.txb.uf.test;



import java.util.ArrayList;
import java.util.Random;

import com.txb.uf.util.UF;
import com.txb.uf.util.UnionFind1;
import com.txb.uf.util.UnionFind2;
import com.txb.uf.util.UnionFind3;
import com.txb.uf.util.UnionFind4;
import com.txb.uf.util.UnionFind5;
import com.txb.uf.util.UnionFind6;

public class Chap11Test {

    public static void main(String[] args) {
        int size = 10000000;
        int num = 10000000;
        UnionFind1 unionFind1 = new UnionFind1(size);
        UnionFind2 unionFind2 = new UnionFind2(size);
        UnionFind3 unionFind3 = new UnionFind3(size);
        UnionFind4 unionFind4 = new UnionFind4(size);
        UnionFind5 unionFind5 = new UnionFind5(size);
        UnionFind6 unionFind6 = new UnionFind6(size);

//        double time = testUF(unionFind1, num);
//        System.out.println("UnionFind1 time " + time);
//        double time = testUF(unionFind2, num);
//        System.out.println("UnionFind2 time " + time);

        double time = testUF(unionFind3, num);
        System.out.println("UnionFind3 time " + time);

        time = testUF(unionFind4, num);
        System.out.println("UnionFind4 time " + time);
        time = testUF(unionFind5, num);
        System.out.println("unionFind5 time " + time);
        time = testUF(unionFind6, num);
        System.out.println("unionFind6 time " + time);
    }

    private static double testUF(UF uf, int num) {
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        //先进行合并
        for (int i = 0; i < num; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        //先进行合并
        for (int i = 0; i < num; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        return (System.currentTimeMillis() - startTime) / 1000.0;
    }


}
