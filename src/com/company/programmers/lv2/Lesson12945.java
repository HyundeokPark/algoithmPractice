package com.company.programmers.lv2;

import java.math.BigDecimal;

public class Lesson12945 {

    public static void main(String[] args) {
        //32 55
        int n = 3;
        n=5;
        n= 100;
        Lesson12945 lesson = new Lesson12945();

        lesson.solution(n);

    }

    public int solution(int n) {
        /**
         * 1. 피보나치 수열의 값을 구한다.
         * 2. 구해진 수열의 값에 1234567을 나눈 나머지를 반환한다.
         * 3. n번째 수열은 n-1,n-2 번째 수열의 값을 더한 값이다.
         * 4. for문으로 0부터 모든 값을 계산하면 값을 구할 수 있다.
         * 5. int, long형으로도 수열 계산이 범위를 벗어난다.
         */
        int answer = 0;

        //피보나치 수열을 구한다.
        BigDecimal number = this.getNumber(n);

        //구해진 수열의 값에서 나머지를 구한다.
        answer = this.getResult(number).intValue();

        return answer;
    }

    public BigDecimal getNumber(int n){
        /**
         * TODO: 피보나치 수열은 어떻게 구할수 있을까?..
         * 단순한 for문으로는 long형으로도 오버플로우가 난다.. BigDecimal??
         */
        //피보나치 수열
        BigDecimal[] fArr = new BigDecimal[n+1];
        fArr[0] = BigDecimal.ZERO;
        fArr[1] = BigDecimal.ONE;
        // 나이브하게 for문으로 구해보기
        for(int i=2; i<=n; i++){
             fArr[i] = fArr[i-2].add(fArr[i-1]);
        }

        return fArr[n];
    }

    public BigDecimal getResult(BigDecimal number){
        return number.remainder(new BigDecimal(1234567));
    }


}
