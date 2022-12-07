package com.demo.leetcode.map;

import com.demo.leetcode.Extension;
import com.demo.leetcode.linkedlist.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapEx {
    // Driver method
    public static void main(String[] args)
    {
        Extension.print("Result " + containsNearbyDuplicate(new int[]{1,2,1,2}, 3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int value = nums[i];
            if (map.containsKey(value) && Math.abs(map.get(value) - i) <= k ){
                return true;
            }
            map.put(nums[i], 1);
        }
        return false;
    }
}
