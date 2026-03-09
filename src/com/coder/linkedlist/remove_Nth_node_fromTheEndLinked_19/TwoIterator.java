package com.coder.linkedlist.remove_Nth_node_fromTheEndLinked_19;

class TwoIterator {
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

  public ListNode removeNthFromEnd(ListNode head, int n) {
    // 时间复杂度：O(n),空间复杂度：O(1)。但扫描两趟
    // 核心思路：第一次扫描获取链表长度，第二次删除指定节点

    // 第一次遍历
    ListNode p = head;
    int size = 0;
    while (p != null) {
      size++;
      p = p.next;
    }
    // 第二次遍历删除节点
    p = head;
    ListNode q = head;
    for (int i = 0; i < size - n; i++) {
      q = p;
      p = p.next;
    }
    // 删除节点
    // 特殊情况：删除首节点
    if (n == size) {
      return head.next;
    }
    q.next = p.next;
    return head;

  }
}
