package com.demo.leetcode.codility;

import java.util.ArrayList;
import java.util.List;

public class Practice2 {
    public static void main(String[] args) {
        System.out.println(solution("There is an animal with four legs", 15));
    }

    public static String solution(String message, int K) {
        if (message.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        String dot = "...";

        String[] words = message.split(" ");
        List<String> notification = new ArrayList<>();

        for (String word : words) {
            K = K - word.length();
            if (K > dot.length()) {
                notification.add(word);
                K--;
            } else {
                break;
            }
        }
        for (String str : notification) {
            result.append(str).append(" ");
        }

        if (K <= dot.length()) {
            result.append(dot);
        }

        return result.toString().trim();
    }
}
