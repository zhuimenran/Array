package com.txb.uf.util;

//UnionFind1 并查集的接口，
public interface UF {

    /**
     * 判断两个节点是否连接
     * @param p 节点对应的id
     * @param q 节点对应的id
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * 把两个节点并起来
     * @param p 节点对应的id
     * @param q 节点对应的id
     */
    void unionElements(int p, int q);

    // 长度
    int getSize();
}
