package com.coder.BiSearch.search_2D_matrix_74;

public class BetterButNormal {
  public boolean searchMatrix(int[][] matrix, int target) {
    // 时间复杂度：O(log(n*m))，空间复杂度：O(1)
    // 思路：两次二分查找

    int left = 0;
    int right = matrix.length - 1;

    while (left <= right) {
      int middle = left + (right - left) / 2;
      int size = matrix[middle].length;
      if (matrix[middle][0] > target) {
        right = middle - 1;
      } else if (matrix[middle][size - 1] < target) {
        left = middle + 1;
      } else {
        int left_index = 0;
        int right_index = size - 1;
        while (left_index <= right_index) {
          int middle_index = left_index + (right_index - left_index) / 2;
          if (matrix[middle][middle_index] == target) {
            return true;
          } else if (matrix[middle][middle_index] < target) {
            left_index = middle_index + 1;
          } else {
            right_index = middle_index - 1;
          }
        }
        return false;
      }
    }
    return false;
  }
}
