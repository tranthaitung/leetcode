package com.demo.leetcode.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Arrays {
    public static void main(String[] args)
    {
        //List<List<Integer>> result = threeSum(new int[]{0, 0, 0});
        //int[] range = searchRange(new int[]{5, 7, 7, 7, 7, 8, 10}, 7);
        duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
    }

    public static void duplicateZeros(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == 0){
                int j = arr.length - 1;
                while (j > i){
                    arr[j] = arr[j - 1];
                    j--;
                }
                i++;
            }
        }
    }

    /**
     *\
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int l = binarySearch(nums, target);
        // target does not exist. No need to look for the last position.
        if (l == nums.length || nums[l] != target) return new int[] { -1, -1 };
        // look for the index of target + 1
        int r = binarySearch(nums, target + 1);
        // last position is r - 1.
        return new int[] { l, r - 1 };
    }
    private static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < target) l = m + 1;
            else r = m ;
        }
        return l;
    }



    /**
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        java.util.Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++){
            int left = i + 1;
            int right = nums.length - 1;
            if (nums[right] < 0) break;

            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0){
                    right--;
                }else {
                    if (sum == 0){
                        resultSet.add(java.util.Arrays.asList(nums[i], nums[left], nums[right]));
                    }
                    left++;
                }

            }
        }
        
        return new ArrayList<>(resultSet) ;
    }


}