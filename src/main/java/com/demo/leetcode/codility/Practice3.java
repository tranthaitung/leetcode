package com.demo.leetcode.codility;

public class Practice3 {
    public static void main(String[] args) {
//        Example test:   [[1, 1, 2], [2, 0, 0]]
//        OK
//
//        Example test:   [[5, -1], [-3, 2], [0, 4]]
//        OK
//
//        Example test:   [[1, 1, -2], [3, 2, 4], [-1, -2, -2]]
//        WRONG ANSWER (got 4 expected 7)
//
//        Example test:   [[-1, 0], [1, 0]]
//        OK

    }

    public int solution(int[][] A) {
        // write your code in Java SE 8
        long all = sumAll(A);
        int numCol = A[0].length;
        int numRow = A.length;
        int count = 0;
        long area = 0;
        long bigArea = 0;
        for (int r = 0; r < numRow; r++) {
            for (int c = 0; c < numCol; c++) {
                if (c + 1 < numCol) {
                    area += A[r][c] + A[r][c + 1];
                    if (area == all - area) {
                        count++;
                    }
                    bigArea += area;
                }
                area = 0;
            }
            if (bigArea == all - bigArea) {
                count++;
            }
        }
        bigArea = 0;
        for (int c = 0; c < numCol; c++) {
            for (int r = 0; r < numRow; r++) {
                if (r + 1 < numRow) {
                    area += A[r][c] + A[r + 1][c];
                    if (area == all - area) {
                        count++;
                    }
                    bigArea += area;
                }
                area = 0;
            }
            if (bigArea == all - bigArea) {
                count++;
            }
        }

        return count;
    }

    public static long sumAll(int[][] A) {
        int numCol = A[0].length;
        int numRow = A.length;
        long sum = 0;
        for (int r = 0; r < numRow; r++) {
            for (int c = 0; c < numCol; c++) {
                sum += A[r][c];
            }
        }
        return sum;
    }
}
