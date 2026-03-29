package com.coder.binary_tree.path_sum_437;

class Normal {
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

  public int pathSum(TreeNode root, long targetSum) {
    // 时间复杂度：O(n²)，空间复杂度：O（n）
    // 思路：深度优先搜索，一个函数遍历所有节点，一个函数返回以该节点开头时所有可能的情况
    if (root == null) {
      return 0;
    }

    int ret = rootSum(root, targetSum);
    ret += pathSum(root.left, targetSum);
    ret += pathSum(root.right, targetSum);
    return ret;
  }

  public int rootSum(TreeNode root, long targetSum) {
    int ret = 0;

    if (root == null) {
      return 0;
    }
    int val = root.val;
    if (val == targetSum) {
      ret++;
    }

    ret += rootSum(root.left, targetSum - val);
    ret += rootSum(root.right, targetSum - val);
    return ret;
  }
}