package com.coder.BiSearch.search_2D_matrix_74;

public class Better {
  public boolean searchMatrix(int[][] matrix, int target) {
    // 时间复杂度：O(log(m*n))，空间复杂度：O(1)
    // 思路：将二维数组看作一维数组，进行一次二分查找
    // 找规律：索引9在3*4的二维数组就是第2行，第1列，也就是9/4=2,9%4=1
    // 也就是：row = index / n, col = index % n
    int m = matrix.length;
    int n = matrix[0].length;
    int left = 0;
    int right = m * n - 1;

    while (left <= right) {
      int middle = left + (right - left) / 2;
      int row = middle / n;
      int col = middle % n;
      if (matrix[row][col] == target) {
        return true;
      } else if (matrix[row][col] < target) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    return false;
  }
}
