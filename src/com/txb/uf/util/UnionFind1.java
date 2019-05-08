package com.txb.uf.util;


/**
 * 并查集 使用数组实现
 * 两个元素相连的依据就是这两个元素的编号在数组中对应的值是相等的
 */
public class UnionFind1 implements UF {

    private int[] id;//每一个数据所属的集合的编号

    public UnionFind1(int size) {
        id = new int[size];
        //初始化的时候，所有的元素都不相连，那么就没有相等的元素
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    //判断两个元素是否所属一个集合，
    //如果这两个元素对应的值相等，就说明是同一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    private int find(int p) {
        if(p<0||p>id.length){
            throw new IllegalArgumentException("index is illegal");
        }
        return id[p];
    }

    //合并元素p和q所属的集合
    @Override
    public void unionElements(int p, int q) {

        //合并的依据就是，如果这两个元素对应的不相等，则把值改为相同
        //并且需要修改其他和p或者q相等的元素，
        //例如如果p,r，m,n 这四个元素是连接的，那么这四个元素对应的值是相等的
        //q，k, 这两个元素是连接的，那么p,q这两个元素合并后，这六个元素就互相连接了，那么对应的值也就相等了
        //所以，需要遍历整个数组，查找和p 相等的元素，全部改为q对应的值，（或者查找和q相等的元素，改为p对应的值）
        if(find(p)==find(q)){
            return;//值相等，是连接的，也就是已经并过了
        }

        for (int i = 0; i < id.length; i++) {
            if(id[i]==find(p)){
                id[i]=find(q);
            }
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }
}
