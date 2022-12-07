package com.demo.leetcode.kickstart;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Walktober {
    public static final String INPUT_FILES_PATH = "/Users/tungtran/Documents/GitHub/leetcode/src/main/java/com/demo/leetcode/kickstart/";

    public static void main(String[] args) throws Exception {
        String name = "input1";

        Scanner sc = new Scanner(new File(INPUT_FILES_PATH + name + ".in"));
        PrintWriter pw = new PrintWriter(INPUT_FILES_PATH + name + ".out");

        int testCases = sc.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N, M, P, ans = 0;
            N = sc.nextInt(); // number of participant
            M = sc.nextInt(); // number of days
            P = sc.nextInt(); // id

            int[] selectedUser = new int[M];
            int[] maxScores = new int[M];

            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < M; j++) {
                    int score = sc.nextInt();
                    if (i == P) {
                        selectedUser[j] = score;
                    }
                    maxScores[j] = Math.max(maxScores[j], score);
                }
            }

            // cal
            for (int i = 0; i < M; i++) {
                int diff = 0;
                if (selectedUser[i] < maxScores[i]) {
                    diff = maxScores[i] - selectedUser[i];
                }
                if (diff > 0) ans += diff;
            }

            pw.printf("Case #" + testCase + ": %d%n", ans);
            pw.flush();
        }

        pw.close();
        sc.close();
    }
}
