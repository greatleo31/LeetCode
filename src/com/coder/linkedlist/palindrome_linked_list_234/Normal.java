package com.coder.linkedlist.palindrome_linked_list_234;

import java.util.ArrayList;
import java.util.List;

public class Normal {

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
    // 时间复杂度为O(n)，空间复杂度为O(n)

    // 边界处理
    if (head == null) {
      return false;
    }
    // 创建List记录节点
    List<Integer> list = new ArrayList<>();
    ListNode temp = head;
    // 遍历
    while (temp != null) {
      list.add(temp.val);
      temp = temp.next;
    }
    temp = head;
    for (int i = list.size() - 1; i >= 0; i--) {
      if (list.get(i) != head.val)
        return false;
      head = head.next;
    }
    return true;
  }
}