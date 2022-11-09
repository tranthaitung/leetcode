package com.demo.leetcode.Arrays;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class IntersectionTwoArrays {

    @PostConstruct
    public void run(){
        int[] num1 = new int[]{4,9,5};
        int[] num2 = new int[]{9,4,9,8,4};
        System.out.println(intersect(num1, num2));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums1) {
            if (hm.containsKey(num)) {
                hm.put(num, hm.get(num) + 1);
            } else {
                hm.put(num, 1);
            }
        }

        for (int num : nums2){
            if (hm.containsKey(num) && hm.get(num) > 0){
                result.add(num);
                hm.put(num, hm.get(num) - 1);
            }
        }

        return listToArray(result);
    }

    private int[] listToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

}
