package com.coder.linkedlist.merge_K_sorted_lists_23;

import java.util.PriorityQueue;

class Solution {
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  // 时间复杂度：O(knlogk), 空间复杂度：O(k)
  // 思路：存数组的所有链表的头节点进入优先队列，每次弹出最小的节点赋值给头节点组成结果链表。注意：链表是以节点存在而不是以数组整体存在，区分数组和链表

  // 自定义Comparator初始化优先队列
  PriorityQueue<ListNode> pq = new PriorityQueue<>(((o1, o2) -> {
    return o1.val - o2.val;
  }));

  public ListNode mergeKLists(ListNode[] lists) {
    // 存各个链表的头节点进入队列
    for (ListNode node : lists) {
      if (node != null) {
        pq.offer(node);
      }
    }
    // 初始化哨兵节点和当前指针
    ListNode dummy = new ListNode();
    ListNode cur = dummy;
    while (!pq.isEmpty()) {
      ListNode s = pq.poll();
      cur.next = s;
      cur = cur.next;
      s = s.next;
      if (s != null) {
        pq.offer(s);
      }
    }
    return dummy.next;
  }

}
