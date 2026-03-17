package com.coder.binary_tree.Maximun_depth_of_binary_tree_104;

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

  public int maxDepth(TreeNode root) {
    // 时间复杂度：O(n),空间复杂度：O(height)
    if (root == null) {
      return 0;
    } else {
      int leftHeight = maxDepth(root.left);
      int rightHeight = maxDepth(root.right);
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }
}
