package com.demo.leetcode.codesignal.solutions;

import java.util.ArrayList;
import java.util.List;

public class almostIncreasingSequence {

    public static void main(String[] args) {
        String[] inputArray = new String[]{"aba", "aa", "ad", "vcd", "aba"};
        String longest = "-";

        for( String s: inputArray )
        {
            if( longest.indexOf("-") == s.length() ){
                longest += s.concat("-");
            }
            else if (longest.indexOf("-") < s.length() ) {
                longest = s.concat("-");
            };
        }

    }

}
