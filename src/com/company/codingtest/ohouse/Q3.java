package com.company.codingtest.ohouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q3 {

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        int answer = 0;
        int k =4;

        List<List<Integer>> subArrs  = new ArrayList<>();
        List<Integer> sums = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(sums.size()>=k){
                if(sums.get(k-1) <= nums[i]){
                    continue;
                }
            }
            sums.add(nums[i]);
                for(int j=i+1; j<nums.length; j++){
                    if(sums.size()==k){
                        sums.sort(Comparator.naturalOrder());
                        break;
                    }
                    int prevSum = sums.get(sums.size()-1);
                    sums.add(prevSum + nums[j]);
                }
        }

        sums.sort(Comparator.naturalOrder());

        answer = sums.get(k-1);

        System.out.println("답"+answer);
    }



}
