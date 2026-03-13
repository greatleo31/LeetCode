package com.coder.linkedlist.sorted_list_148;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Normal {
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

  public ListNode sortList(ListNode head) {
    // 时间复杂度：O(nlogn),空间复杂度：O(n)
    // 核心思路：提取值，排序，创建新节点

    ListNode p = head;
    List<Integer> list = new ArrayList<>();
    while (p != null) {
      list.add(p.val);
      p = p.next;
    }
    Collections.sort(list);
    // 创建新链表
    ListNode newHead = new ListNode(-1);
    p = newHead;
    for (int num : list) {
      p.next = new ListNode(num);
      p = p.next;
    }
    return newHead.next;
  }
}
