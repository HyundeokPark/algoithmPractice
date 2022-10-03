package com.company.programmers.lv2;

import java.util.Arrays;
import java.util.Collections;

public class Lesson12941 {

    public static void main(String[] args) {
        /**
         * A	B	answer
         * [1, 4, 2]	[5, 4, 4]	29
         * [1,2]	[3,4]	10
         */
//        int[] A = {1,4,2};
//        int[] B = {5,4,4};
        int[] A = {1,2};
        int[] B = {3,4};
        Lesson12941 lesson = new Lesson12941();
        System.out.println("answer : "  +lesson.solution(A,B));
    }

    public int solution(int[] A, int[] B){
        /**
         * 1. A,B에서 임의로 한 원소를 뽑아 곱한다.
         * 2. 한번 뽑은 원소는 다시 뽑을 수 없으며, 배열의 길이만큼 '1'을 반복한다.
         * 3. 이때 곱한 결과는 다음 반복문에서 누적해서 더한다.
         * 4. 최종적으로 각 배열의 원소끼리 곱한 결과를 더한 값이 '최소'가 되는 경우를 찾아 그 누적값을 반환하라
         * 5. 각 배열의 원소 1개씩 뽑아 곱하고, 누적된 합의 결과가 최소가 되는 법
         *    : 가장 큰 원소는 가장 작은 원소와 곱한다.
         *    -> 한 배열은 오름차순, 다른 배열은 내림차순으로 정렬 후 같은 인덱스의 원소끼리 곱한다.
         *    -> 효율성에서 떨어진다. 오름차순으로만 정렬, 이후 배열 순회시 인덱스만 바꿔 계산해서 순회한다.
         */
        int answer = 0;
        int length = A.length;

        //정렬한다.
        Arrays.sort(A);
        Arrays.sort(B);

        // 배열의 길이만큼 반복한다.
        for(int i=0; i<length; i++){
            // 각 배열의 원소끼리 곱한 값을 누적하여 더한다.
            answer += multiplyElement(A[i],B[length-(i+1)]);
        }

        return answer;
    }

    public int multiplyElement(int a, int b){
        return a * b;
    }
}
