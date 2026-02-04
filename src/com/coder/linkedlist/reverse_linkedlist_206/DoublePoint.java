package com.coder.linkedlist.reverse_linkedlist_206;

public class DoublePoint {

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

  public ListNode reverseList(ListNode head) {
    // 迭代+双指针反转链表
    // 时间复杂度：，空间复杂度：

    // 边界处理
    if (head == null) {
      return null;
    }
    // 创建双指针
    ListNode pre = null;
    ListNode cur = head;
    // 遍历
    while (cur != null) {
      // 反转链表
      ListNode temp = cur.next;
      cur.next = pre;
      pre = cur;

      // 遍历
      cur = temp;
    }
    return pre;
  }
}
