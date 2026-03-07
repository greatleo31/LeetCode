package com.coder.linkedlist.merge_two_sorted_links_21;

class IterativeMethod {
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

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // 时间复杂度：O(n+m),空间复杂度：O(1)
    // 核心思路：双指针分别遍历两个链表，比较得到新链表

    // 边界处理
    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }

    // 创建双指针
    ListNode head = new ListNode(-1); // 直接创建新节点方便后续遍历
    ListNode tail = head;
    // 遍历
    while (list1 != null && list2 != null) {
      // 比较判断
      if (list1.val <= list2.val) {
        tail.next = list1;
        tail = list1;
        list1 = list1.next;
      } else {
        tail.next = list2;
        tail = list2;
        list2 = list2.next;
      }
    }

    // 合并后剩下的只有一个
    tail.next = (list1 == null) ? list2 : list1;

    return head.next; // 直接排除首节点
  }
}