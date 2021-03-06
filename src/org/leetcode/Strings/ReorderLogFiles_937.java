package org.leetcode.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class ReorderLogFiles_937 {

  public String[] reorderLogFiles(String[] logs) {

    if (logs.length == 0 || logs.length == 1) {
      return logs;
    }

    List<String> list = new ArrayList<>();
    for (String log : logs) {
      list.add(log);
    }

    Comparator<String> comparator = new Comparator<String>() {
      @Override
      public int compare(String s, String t1) {
        String[] charArray1 = s.split("\\s+");
        String[] charArray2 = t1.split("\\s+");

        if (Character.isDigit(charArray1[1].charAt(0)) && !Character
            .isDigit(charArray2[1].charAt(0))) {
          return 1;
        } else if (!Character.isDigit(charArray1[1].charAt(0)) && Character
            .isDigit(charArray2[1].charAt(0))) {
          return -1;
        } else if (!Character.isDigit(charArray1[1].charAt(0)) && !Character
            .isDigit(charArray2[1].charAt(0))) {
          //Both Characters
          int size = Math.min(charArray1.length, charArray2.length);
          for (int i = 1; i < size; i++) {
            if (charArray1[i].equals(charArray2[i])) {
              continue;
            } else {
              return charArray1[i].compareTo(charArray2[i]);
            }
          }
          return charArray1[0].compareTo(charArray2[0]);
        }

        return 0;
      }
    };

    Collections.sort(list, comparator);

    String[] arr = new String[list.size()];

    for (int i = 0; i < list.size(); i++) {
      arr[i] = list.get(i);
    }

    return arr;
  }


  @Test
  public void test1() {
    String[] arr = reorderLogFiles(
        new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo",
            "a2 act car"});
    System.out.println(Arrays.toString(arr));
  }

  @Test
  public void test2() {
    String[] arr = reorderLogFiles(
        new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo",
            "a2 act car"});
    System.out.println(Arrays.toString(arr));

  }

}
