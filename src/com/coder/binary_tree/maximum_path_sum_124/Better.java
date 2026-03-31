package com.coder.binary_tree.maximum_path_sum_124;

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

  private int ans = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    // 时间复杂度：O(n)，空间复杂度：O(n)
    // 思路：dp的思想，取一个结果变量，边遍历边对上一个遍历节点和当前直径取最大值。遍历通过dfs实现，返回值是单独一条链路时最大值，用于提供父节点作为左子树或右子树的最大链和
    dfs(root);
    return ans;
  }

  public int dfs(TreeNode node) {
    // 边界处理
    if (node == null) {
      return 0;
    }
    int left_value = dfs(node.left); // 左子树最大链和
    int right_value = dfs(node.right); // 右子树最大链和
    // 动态取最大结果值
    ans = Math.max(ans, node.val + left_value + right_value);
    // 返回最大该节点最大链和
    return Math.max(Math.max(left_value, right_value) + node.val, 0);
  }
}
