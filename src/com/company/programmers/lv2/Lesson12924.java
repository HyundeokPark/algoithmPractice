package com.company.programmers.lv2;

public class Lesson12924 {

    public static void main(String[] args) {
        Lesson12924 lesson = new Lesson12924();
        int n = 15;
        System.out.println(lesson.solution(n));
    }

    public int solution(int n){
        /**
         * 1. 등차수열의 합 공식을 이용해보자.
         *  -> 등차수열의 합 = n * (i+p[n])/2 (i는 순열의 첫항, n은 마지막항이다, p[n]은 마지막 항의 숫자다.)
         *  -> 문제에서는 연속한 수이므로 등차가 1인 등차수열이다.
         *  -> 즉, 마지막항의 값과 마지막항이 같다.
         *
         * 2. 이것도 뭔가 DFS로 풀수 있을것 같은데?...
         */
        int answer = 0;
        for(int i=1; i<n; i++){
            if(i == 2*i-1){
                answer++;
            }
        }
        return answer;
    }

}
