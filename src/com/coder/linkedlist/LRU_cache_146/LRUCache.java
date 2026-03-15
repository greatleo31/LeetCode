package com.coder.linkedlist.LRU_cache_146;

import java.util.HashMap;

public class LRUCache {
    // 时间复杂度：O(1)，空间复杂度：O(capacity)
    // 思路：满足LRU缓存约束的新数据结构：哈希表+双向链表。也即不能用LinkedHashMap而是手写轮子。具体的：new HashMap<Integer,
    // DeLinkedNode>

    // 创建双向链表类
    class DeLinkedNode {
        // 成员变量
        int key; // 删除LRU节点对应在map的项需要用key都用map.remove()
        int val;
        DeLinkedNode pre;
        DeLinkedNode next;

        // 成员方法
        public DeLinkedNode() {
        };

        public DeLinkedNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    // 创建哈希表+双向链表节点
    private HashMap<Integer, DeLinkedNode> map = new HashMap<Integer, DeLinkedNode>();
    // 理论最大容量
    private int capacity;
    // 实际容量
    private int size;
    // 创建伪头部和伪尾部,重要
    DeLinkedNode head, tail;

    // 成员方法
    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        // 初始化伪头部和伪尾部节点
        head = new DeLinkedNode(); // 方便定位头部添加新节点
        tail = new DeLinkedNode(); // 方便删除尾部LRU节点
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        // 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1。
        DeLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        // 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过
        // capacity ，则应该 逐出 最久未使用的关键字

        // 判断key是否存在
        DeLinkedNode node = map.get(key);
        if (node == null) {
            // 不存在,就插入
            DeLinkedNode newNode = new DeLinkedNode(key, value);
            map.put(key, newNode);
            // 添加到头部
            addToHead(newNode);
            size++;
            // 若插入后：实际容量超过capacity
            if (size > capacity) {
                // 第一步：删除LRU节点，第三步：实际容量减小
                DeLinkedNode tail = removeLastNode();
                // 第二步：删除哈希表对应项
                map.remove(tail.key);
                size--;
            }

        } else {
            // 存在
            node.val = value;
            moveToHead(node);
        }
    }

    private void remove(DeLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(DeLinkedNode node) {
        // 思路：找到伪头部节点，链接即可
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void moveToHead(DeLinkedNode node) {
        // 移动该节点到头部,第一步：删除该节点，第二步：在头部添加该节点
        remove(node);
        addToHead(node);
    }

    private DeLinkedNode removeLastNode() {
        // 根据伪尾部删除尾部节点
        DeLinkedNode ans = tail.pre;
        remove(ans);
        return ans;
    }
}
