package com.coder.DP.杨辉三角_118;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Normal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(generate(n));
        sc.close();
    }

    public static List<List<Integer>> generate(int numRows) {
        // 时间复杂度：O(n平方)，空间复杂度：O(1)
        // 关系式：c[i][j]=c[i-1][j-1]+c[i-1][j]
        List<List<Integer>> c = new ArrayList<>(numRows);
        c.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(c.get(i - 1).get(j - 1) + c.get(i - 1).get(j));
            }
            row.add(1);
            c.add(row);
        }
        return c;
    }
}
