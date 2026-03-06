package com.coder.linkedlist.linked_list_cycle_142;

import java.util.HashSet;

public class Normal {
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode detectCycle(ListNode head) {
    // 时间复杂度：O(n)，空间复杂度O(n)
    // 核心思路：存每一个节点的地址到哈希表，若后续的节点重复出现则存在环

    // 创建哈希表
    HashSet<ListNode> set = new HashSet<>();

    ListNode p = head;
    // 遍历链表存入哈希表
    while (p != null) {
      // 判断是否重复出现在哈希表
      if (!set.contains(p)) {
        set.add(p);
        p = p.next;
        continue;
      }
      return p;
    }
    return null;
  }
}
