package com.company.programmers.lv2;

import java.util.Arrays;

public class Lesson64065 {

    public static void main(String[] args) {
        Lesson64065 lesson = new Lesson64065();
        String s = "";
        Arrays.stream(lesson.solution(s)).forEach(System.out::println);
    }

    /**
     * 1. 집합의 순서는 바뀌어도 되나, 이를 통해서 튜플을 확인하는게 굉장히 이상하다. -> 이해가 안된다.
     * 2. 순서가 바뀌어도 되므로, 튜플의 순서를 유추해 내는것이 사실상 불가능하지 않은가?
     * 3. 그저 튜플을 이루는 원소들만 중복제거로 알 수있을것 같다.
     * @param s
     * @return
     */
    public int[] solution(String s) {
        int[] answer = {};
        return answer;
    }

}
