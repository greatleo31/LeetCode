package com.coder.binary_tree.convert_sorted_array_to_BST_108;

class Better {
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

  public TreeNode sortedArrayToBST(int[] nums) {
    // 时间复杂度：O(n)，空间复杂度：O(logn)
    // 思路：应该升序数组恰好就是BST中序遍历的结果，所以中间节点即根节点，确认好根节点，分治创建左右子节点，本质是二分法。但是递归过程类似dfs

    return dfs(nums, 0, nums.length - 1);
  }

  public TreeNode dfs(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }
    // 确认中间节点：[]而非[)
    int mid = left + (right - left) / 2;
    return new TreeNode(nums[mid], dfs(nums, left, mid - 1), dfs(nums, mid + 1, right));

  }
}