package com.coder.linkedlist.add_two_nums_2;

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

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // 时间复杂度：O(n),空间复杂度：O(1)
    // 补充：空间复杂度指算法本身的复杂度，而作为输出载体的空间不计入
    // 核心思路：模拟两数之和，难点在于进位

    // 定义双指针和进位
    ListNode head = null, tail = null;
    int carry = 0;
    // 遍历
    while (l1 != null || l2 != null) {
      // 计算两数之和
      int value1 = (l1 == null) ? 0 : l1.val;
      int value2 = (l2 == null) ? 0 : l2.val;
      int sum = value1 + value2 + carry;
      // 整合输出结果
      if (head == null) {
        head = tail = new ListNode(sum % 10);
      } else {
        tail.next = new ListNode(sum % 10);
        tail = tail.next;
      }
      // 计算是否进位
      carry = sum / 10;
      // 移动
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    // 若超出，则加入进位
    if (carry != 0) {
      tail.next = new ListNode(carry);
    }
    return head;
  }
}
