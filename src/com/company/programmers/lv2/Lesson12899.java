package com.company.programmers.lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Lesson12899 {

    public static void main(String[] args) {
        System.out.println(solution(1));
    }

    /**
     * 20220908 ref solved
     * 1. 파라미터를 3으로 나눈다.
     * 2. 나머지 값이 0일 경우 4로, 나머지는 그대로 마지막 자릿수부터 채운다.
     * 3. 1~2과정을 1에서 나온 몫에 대해 반복한다.
     * 4. 언제까지? 몫이 0이 될때까지!...
     * 5. 단, 3으로 나누어 떨어지면 몫-1을 해줘야 한다.
     * 6. 왜? 계산식에 의하면 3의배수가 되는 숫자에 한해서 이상한 계산이 나오게 된다.
     * 7. 3진법이므로, 3의 배수가 될때마다 자릿수가 올라가서, 반복문을 한번 더 돌게 된다.
     * 8. 그럴때 몫-1로 보정해주면 우리가 예상한대로 124 계산법과 맞게 나온다!
     * @param number
     */
    public static String solution(int number){
        int portion=number; //while 문 초기에 걸리지 않기 위한 초기값
        int remainder=0;
        StringBuilder answer = new StringBuilder();
        //String answer="";

        while(portion>0){
            //나머지가 0이면 4로 매핑, 이외의 경우니 1,2는 그대로 사용한다.
            remainder = number%3 == 0  ? 4 : number%3;
            answer.insert(0,remainder);

            portion = number/3;

            if(remainder==4){
                portion--;
            }
            number = portion;
        }
        return answer.toString();
    }
}
