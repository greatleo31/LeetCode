package com.coder.linkedlist.palindrome_linked_list_234;

public class Better {
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

  public boolean isPalindrome(ListNode head) {
    // 时间复杂度为O(n)，空间复杂度为O(1)
    // 核心优化：在于对原链表寻找规律得到算法
    // 落地点：得到链表长度之后，对前半段反转链表

    // 边界处理
    if (head == null) {
      return false;
    }

    ListNode temp = head;
    // 遍历得到链表长度
    int count = 0;
    while (temp != null) {
      count++;
      temp = temp.next;
    }

    // 对半反转链表
    ListNode pre = null;
    ListNode cur = head;
    for (int i = 0; i < count / 2; i++) {
      temp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = temp;
    }

    // 特殊情况：当为奇数，跳过中间那个数
    if (count % 2 != 0) {
      cur = cur.next;
    }
    // 遍历判断
    while (cur != null && pre != null) {
      if (pre.val != cur.val)
        return false;
      cur = cur.next;
      pre = pre.next;
    }
    return true;
  }
}
