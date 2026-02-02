package com.coder.hash_table.group_anagrams_49;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 思路：将每个字符串转为字符数组排序后，作为 HashMap 的 Key。
 * 时间复杂度为nKlogK，空间复杂度为nK,若要缩减时间复杂度可以思考统计字母数法
 */
public class Sort {
  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }

    // Key 为排序后的字符串，Value 为原始字符串列表
    Map<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
      char[] ca = s.toCharArray();
      // 对字符数组进行排序
      Arrays.sort(ca);
      String key = String.valueOf(ca);

      // 如果不存在该 Key，则创建一个新的列表
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(s);
    }

    return new ArrayList<>(map.values());
  }
}
