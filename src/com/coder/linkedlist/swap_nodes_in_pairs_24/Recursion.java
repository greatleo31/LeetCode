package com.coder.linkedlist.swap_nodes_in_pairs_24;

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

  public ListNode swapPairs(ListNode head) {
    // 时间复杂度：O(n),空间复杂度：O(1)
    // 核心思路：递归/每次调用本函数都能够获取以head为头节点链表交换后的头节点

    // 递归的退出条件:只剩下一个或无节点
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = head.next;
    head.next = swapPairs(newHead.next);
    newHead.next = head;
    return newHead;
  }
}
