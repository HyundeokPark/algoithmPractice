package com.company.programmers.lv2;

public class Lesson12914 {

    public static void main(String[] args) {
        Lesson12914 lesson = new Lesson12914();
        int n = 4;
        System.out.println(lesson.solution(n));
    }

    public Long solution(int n) {
        /**
         * 1. n번째 칸의 가짓수는 n-1,n-2번째 칸의 합과 같다.
         * 2. 그러므로 시작값 1칸,2칸일때를 미리 구하고
         * 3. 문제에서 주어진 최대 칸의 갯수까지 반복문을 통해 가짓수를 구한다. (배열에 저장)
         * 4. 배열[n]에 해당하는 값에서 1234567을 나눈 나머지를 반환한다.
         * 5. 최댓값 까지 구하지 않아도 n까지만 구해놔도 될듯 하다.
         *      -> 단, 그럴경우 n이 1이나 2로 주어질때 분기처리가 필요하다.
         */
        int[] dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 2001; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }
        return dp[n]*1L;
    }
}
