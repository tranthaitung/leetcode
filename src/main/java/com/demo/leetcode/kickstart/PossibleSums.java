package com.demo.leetcode.kickstart;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class PossibleSums {
    public static final String INPUT_FILES_PATH = "src/main/resources/kickstart/";

    public static void main(String[] args) throws Exception {
        String name = "possibleSums";

        Scanner sc = new Scanner(new File(INPUT_FILES_PATH + name + ".in"));
        PrintWriter pw = new PrintWriter(INPUT_FILES_PATH + name + ".out");

        long startTime = System.currentTimeMillis();

        int testCases = sc.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N, ans = 0;
            N = sc.nextInt(); // number of coins

            int[] coins = new int[N];
            int[] quantityArray = new int[N];

            for (int i = 1; i <= 2; i++) {
                for (int j = 0; j < N; j++) {
                    int value = sc.nextInt();
                    if (i == 1) {
                        coins[j] = value;
                    } else {
                        quantityArray[j] = value;
                    }
                }
            }

            //cal
            Set<Integer> table = new HashSet<>();
            table.add(0); // init for sums

            for (int i = 0; i < coins.length; i++) {
                List<Integer> sums = new ArrayList<>(table);
                for (Integer sum : sums) {
                    for (int quantity = 1; quantity <= quantityArray[i]; quantity++) {
                        table.add(sum + quantity * coins[i]);
                    }
                }
            }
            ans = table.size() - 1;


            pw.printf("Case #" + testCase + ": %d%n", ans);
            pw.flush();
        }

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Execution time: " + estimatedTime);

        pw.close();
        sc.close();
    }
}

/**
 * You have a collection of coins, and you know the values of the coins and the quantity of each type of coin in it.
 * You want to know how many distinct sums you can make from non-empty groupings of these coins.
 * <p>
 * Example
 * <p>
 * For coins = [10, 50, 100] and quantity = [1, 2, 1], the output should be solution(coins, quantity) = 9.
 * <p>
 * Here are all the possible sums:
 * <p>
 * 10
 * 10 + 50
 * 10 + 100
 * 10 + 50 + 100
 * 10 + 50 + 50
 * 10 + 50 + 50 + 100
 * 50
 * 50 + 100
 * 50 + 50
 * 50 + 50 + 100
 * 100
 * <p>
 * As you can see, there are 9 distinct sums that can be created from non-empty groupings of your coins.
 * <p>
 * Input/Output
 * <p>
 * [execution time limit] 3 seconds (java)
 * <p>
 * [input] array.integer coins
 * <p>
 * An array containing the values of the coins in your collection.
 * <p>
 * Guaranteed constraints:
 * 1 ≤ coins.length ≤ 20,
 * 1 ≤ coins[i] ≤ 104.
 * <p>
 * [input] array.integer quantity
 * <p>
 * An array containing the quantity of each type of coin in your collection. quantity[i] indicates the number of coins that have a value of coins[i].
 * <p>
 * Guaranteed constraints:
 * quantity.length = coins.length,
 * 1 ≤ quantity[i] ≤ 105,
 * (quantity[0] + 1) * (quantity[1] + 1) * ... * (quantity[quantity.length - 1] + 1) <= 106.
 * <p>
 * [output] integer
 * <p>
 * The number of different possible sums that can be created from non-empty groupings of your coins.
 */
