package com.company.programmers.lv1;

import java.util.Arrays;

import java.util.stream.IntStream;

public class Lesson86051 {
    /**
     * 1. 모든원소는 0~9까지 중 일부이며, 서로다르다.
     * 2. 배열 합 구하고 총합에서 빼면 될듯?..
     * [1,2,3,4,6,7,8,0]	14
     * [5,8,4,0,6,7,9]	6
     */
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};

        numbers = new int[]{5, 8, 4, 0, 6, 7, 9};

        System.out.println(solution(numbers));
    }
    public static int solution(int[] numbers){

        int max = IntStream.range(0, 10).sum();

        int sum = Arrays.stream(numbers).sum();

        return max - sum;
    }
}
