package com.coder.binary_tree.symmetric_tree_101;

class Solution {
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

  public boolean isSymmetric(TreeNode root) {
    // 调用方法
    return check(root.left, root.right);
  }

  public boolean check(TreeNode p, TreeNode q) {
    // 递归终止条件
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }

    // 递归体
    return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
  }
}
