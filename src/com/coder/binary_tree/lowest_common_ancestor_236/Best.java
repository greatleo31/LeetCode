package com.coder.binary_tree.lowest_common_ancestor_236;

class Best {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // 时间复杂度:O(n)，空间复杂度：O(n)
    // 思路：寻找两节点的公共祖先只有两种情况：一是两节点都在同一个子树里，二是两节点刚好分布在左右子树。后序遍历DFS即可

    // 边界处理
    if (root == null || root == p || root == q) {
      return root;
    }
    // 在左右子树找p或q
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    // 第一种情况：两节点在左右子树，那么当前节点即目标祖先节点
    if (left != null && right != null)
      return root;
    // 第二种情况：两节点在同一个子树
    return left != null ? left : right;
  }
}