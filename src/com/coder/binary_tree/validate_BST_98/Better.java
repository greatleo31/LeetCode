package com.coder.binary_tree.validate_BST_98;

import java.util.Deque;
import java.util.LinkedList;

public class Better {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public boolean isValidBST(TreeNode root) {
    // 时间复杂度：O(n),空间复杂度：O(1)
    // 思路：二叉搜索树的中序遍历一定是升序序列，边遍历边判断，用栈

    // 初始化栈
    Deque<TreeNode> stack = new LinkedList<>();
    long preVal = Long.MIN_VALUE;

    // 循环遍历
    while (!stack.isEmpty() || root != null) {
      // push所有左节点进入栈
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      // 若出栈的节点的值小于等于前一个值，则false
      root = stack.pop();
      if (root.val <= preVal) {
        return false;
      }
      // 否则，则遍历右节点
      preVal = root.val;
      root = root.right;
    }
    return true;
  }
}
