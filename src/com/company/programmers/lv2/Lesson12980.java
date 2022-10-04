package com.company.programmers.lv2;

public class Lesson12980 {

    public static void main(String[] args) {
        Lesson12980 lesson = new Lesson12980();
        int n = 0;
        System.out.println(lesson.solution(n));

    }

    public int solution(int n) {
        /**
         * 1. K칸 점프 시 K만큼의 연료 소비
         * 2. 현재까지 온거리 X2 좌표로 순간이동 가능, 연료는 소비 되지 않는다.
         * 3. N까지 가기위해 연료소비를 최소로 하고 싶다.
         * 4. 그리디?... 탐욕법?...
         * 5. 2의 배수만큼.. N과 2의 최대 공약수 만큼?
         * 6. 입출력 간의 규칙을 확인해본 결과 N/2의 값이 1이 나올때까지 나눈 후, 그 계산 과정에서 나온 나머지의 횟수와, 1이 나온 횟수를 더하면 된다.
         */
        int ans = 0;
        int a=n;
        while(a>1){
            if(a%2==1){
                ans++;
            }
            a = a/2;
        }
        ans++;

        return ans;
    }
}
