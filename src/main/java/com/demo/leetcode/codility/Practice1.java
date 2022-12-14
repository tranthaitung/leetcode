package com.demo.leetcode.codility;

import java.util.Arrays;

public class Practice1 {

//https://iq.opengenus.org/minimum-deletions-to-make-string-palindrome/
//    public static void main(String[] args) {
//        System.out.println(minDeletions("ervervige", 0, "ervervige".length() - 1));
//    }

    public static int min(int x, int y)
    {
        return (x < y) ? x : y;
    }

    // Utility function for calculating
// Minimum element to delete
    public static int utility_fun_for_del(String str,
                                          int i, int j)
    {
        if (i >= j)
            return 0;

        // Condition to compare characters
        if (str.charAt(i) == str.charAt(j))
        {

            // Recursive function call
            return utility_fun_for_del(str,
                    i + 1, j - 1);
        }

        // Return value, incrementing by 1
        return 1 + Math.min(utility_fun_for_del(str, i + 1, j),
                utility_fun_for_del(str, i, j - 1));
    }

    // Function to calculate the minimum
// Element required to delete for
// Making string palindrome
    public static int min_ele_del(String str)
    {

        // Utility function call
        return utility_fun_for_del(str, 0,
                str.length() - 1);
    }

    // Driver Code
    public static void main(String[] args)
    {
        String str = "ervervige";

        System.out.println("Minimum element of deletions = " +
                min_ele_del(str));
    }

    public static int minDeletions(String X, int i, int j ) {
        // write your code in Java SE 8
//
//        int len = S.length();
//
//        int table[][] = new int[len][len];
//
//        int idx = 2;
//        while(idx <= len){
//            for (int i = 0; i < len - idx + 1; i++){
//                int j = i + idx -1;
//                if (S.charAt(i) == S.charAt(j)){
//                    table[i][j] = table[i + 1][j -1] + 1;
//                }
//                else {
//                    table[i][j] = Integer.max(table[i][j - 1], table[i + 1][j]);
//                }
//            }
//
//            idx++;
//        }
//
//        return table[0][len -1];

        // base condition
        if (i >= j) {
            return 0;
        }

        // if the last character of the string is the same as the first character
        if (X.charAt(i) == X.charAt(j)) {
            return minDeletions(X, i + 1, j - 1);
        }

        // otherwise, if the last character of the string is different from the
        // first character

        // 1. Remove the last character and recur for the remaining substring
        // 2. Remove the first character and recur for the remaining substring

        // return 1 (for remove operation) + minimum of the two values

        return 1 + Math.min(minDeletions(X, i, j - 1), minDeletions(X, i + 1, j));
    }
}
