package com.company.programmers.lv2;

import java.util.Arrays;

public class Lesson12985 {

    public static void main(String[] args) {

    }
    public int solution(int n, int a, int b) {
        /**
         * 1.부전승은 없다. N은 언제나 짝수이다!
         * 2.승자가 다음라운드에서 받게될 번호는, 그 경기의 짝수선수 번호/2 의 값이다.
         * 3.A,B의 다음 라운드 번호가 같아진 순간, A,B가 만났음을 알 수 있다.
         */
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
//        System.out.println("Hello Java");
        while(true){
            answer++;
            if(a%2==0){
                a = a/2;
            }else{
                a = (a+1)/2;
            }
            if(b%2==0){
                b = b/2;
            }else{
                b = (b+1)/2;
            }
            if(a==b){
                break;
            }

            Arrays.d
        }
        StringBuffer s = new StringBuffer();
        s.delete()
        return answer;
    }
}
