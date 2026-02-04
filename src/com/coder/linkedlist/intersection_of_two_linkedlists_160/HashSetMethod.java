package com.coder.linkedlist.intersection_of_two_linkedlists_160;

import java.util.HashSet;
import java.util.Set;

public class HashSetMethod {
    // 定义链表节点
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 哈希表算法：将某一个链表全存入哈希表，遍历另外一个判断是否存在于哈希表
        // 时间复杂度:O(m+n)，空间复杂度：O(n)

        // 创建哈希表
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        // 循环存A链表入哈希表
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }

        // 遍历B链表
        temp = headB;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}