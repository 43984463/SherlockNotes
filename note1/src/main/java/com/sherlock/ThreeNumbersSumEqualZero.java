package com.sherlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * 传入一个随机数组,找出所有的3个数相加等于0的组合，不可以包含重复的3元组。并且找出的组合中的数字按照从小到大排列。
 * @auther Sherlock
 * @date 2020/4/19 22:15
 * @Description: 解题思路   砝码
 * 3个砝码平衡。
 */
public class ThreeNumbersSumEqualZero {
    public static void main(String[] args) {
        //假设的传入的数组。
        int arr[] = {3, 7, 1, 2, 2, 2, 6, -1, -4,-4, -5, -3, -6, -8};
        ArrayList<ArrayList<Integer>> result = process(arr);
        System.out.println();
        System.out.println(result.toString());
    }

    private static ArrayList<ArrayList<Integer>> process(int[] nums) {
        Arrays.sort(nums);
        Arrays.stream(nums).forEach(System.out::print);
        Set<ArrayList<Integer>> outlist = new HashSet<>();
        ArrayList<ArrayList<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int q = nums[i];
            int w = i + 1;
            int e = nums.length - 1;
            while (w < e) {
                int sum = q + nums[w] + nums[e];
                if (sum < 0) {
                    w++;
                } else if (sum > 0) {
                    e--;
                } else {
                    ArrayList<Integer> inlist = new ArrayList<>(3);
                    inlist.add(q);
                    inlist.add(nums[w]);
                    inlist.add(nums[e]);
                    outlist.add(inlist);
                    w++;
                    e--;
                }
            }

            //最左边的砝码移动到大于0时说明不出再出现满足情况的3元数，退出循环。
            if(q>0){
                break;
            }
        }

        outlist.forEach(item -> returnList.add(item));
        return returnList;
    }
}
