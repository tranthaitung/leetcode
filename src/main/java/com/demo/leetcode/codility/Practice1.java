package com.demo.leetcode.codility;

import kotlin.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice1 {

//https://iq.opengenus.org/minimum-deletions-to-make-string-palindrome/

    // Driver Code
    public static void main(String[] args)
    {
        String str = "ervervige";
        List<Pair<String, Integer>> testCases = new ArrayList<>();
        testCases.add(new Pair<>("ervervige", 2));
        testCases.add(new Pair<>("aaabab", 0));
        testCases.add(new Pair<>("x", 0));

        for (Pair<String, Integer> test : testCases){
            System.out.println("Minimum element of deletions = " +  minDeletions(test.getFirst()));
        }
    }

    public static int minDeletions(String S) {
        // write your code in Java SE 8

        int len = S.length();

        int[][] table = new int[len][len];

        int idx = 2;
        while(idx <= len){
            for (int i = 0; i < len - idx + 1; i++){
                int j = i + idx -1;
                if (S.charAt(i) == S.charAt(j)){
                    table[i][j] = table[i + 1][j -1] + 1;
                }
                else {
                    table[i][j] = Integer.max(table[i][j - 1], table[i + 1][j]);
                }
            }

            idx++;
        }

        return table[0][len -1];

    }
}
