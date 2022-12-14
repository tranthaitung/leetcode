package com.demo.leetcode.hackkerrank;

import java.util.HashSet;
import java.util.Set;

public class Bulbs {
    public int solution(int[] a) {
        Set<Integer> missing = new HashSet<>();
        Set<Integer> store = new HashSet<>();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (!store.contains(i + 1) && i + 1 != a[i])
                missing.add(i + 1);
            if (i + 1 < a[i])
                store.add(a[i]);
            else
                missing.remove(a[i]);
            if (missing.isEmpty())
                count++;
        }
        return count;
    }
}
