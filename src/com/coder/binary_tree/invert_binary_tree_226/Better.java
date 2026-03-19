package com.coder.binary_tree.invert_binary_tree_226;

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

  public TreeNode invertTree(TreeNode root) {
    // 时间复杂度：O(n)，空间复杂度：O(n)
    // 思路：递归到每一个子结构进行翻转

    if (root == null) {
      return null;
    }
    TreeNode tmp = invertTree(root.left);
    root.left = invertTree(root.right);
    root.right = tmp;
    return root;
  }
}