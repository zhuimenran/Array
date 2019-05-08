package com.txb.uf.util;


/**
 * 并查集 UnionFind3  的优化，主要是
 * 每次合并的时候，根据层级大小判断合并方向
 */
public class UnionFind4 implements UF {

    //parent[i]表示第i个元素指向的节点的位置
    private int[] parent;

    private int[] rank;//rank[i]表示以i为根的集合中所表示树的层数

    public UnionFind4(int size) {
        parent = new int[size];
        rank = new int[size];
        //初始化的时候，每一个节点都指向自己，那么都是一个独立的树，并没有连接的关系
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;//
        }
    }

    //判断两个元素是否所属一个集合，
    //如果这两个元素相连，那么他们肯定执行同一个父节点
    //父节点判断的依据就是元素p的值和坐标相等
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //时间复杂度是O(h)  h 是树的高度
    //查找元素p所对应的集合编号
    private int find(int p) {
        //直到元素p 指向自己，说明这个就是p的根节点。
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    //合并元素p和q所属的集合
    @Override
    public void unionElements(int p, int q) {
        //合并的依据就是，找到这两个元素的根节点，然后把p的根节点下标改为q的根节点
        int rootP = find(p);//p对应的根节点的位置

        int rootQ = find(q);//q对应根节点的位置
        if (rootP == rootQ) {
            return;//值相等，是连接的，也就是已经并过了
        }
        //不相等，根据两个元素所对应的rank不同判断合并方向，rank小的合并到rank多的上去
        if (rank[rootP] < rank[rootQ]) {//说明q根节点中集合个数多，那么让p的根节点指向q的根节点
            parent[rootP] = parent[rootQ];
            //这个时候rank[rooQ]是不需要变化的，因为一个层级底的挂载到一个层级高的节点上去，层级是不会改变的
        } else if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = parent[rootP];
        } else {//层级两个相等，那么就需要有一个层级挂载到另一个层级上，那么这个层级肯定会加一的
            parent[rootP] = parent[rootQ];//p的值变成了q,那么q的层级得加一
            rank[rootQ] += 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
