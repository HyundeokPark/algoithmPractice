package com.company.programmers.lv2;

public class Lesson12953 {

    public static void main(String[] args) {
        Lesson12953 lesson = new Lesson12953();
        int[] arr= {};

        System.out.println(lesson.solution(arr));


    }
    public int solution(int[] arr) {
        /**
         * 1. arr로 제공되는 수들의 공배수중 최소 공배수를 구해라
         * 2. 최소공배수를 구하는 함수를 계속 돌리면 되지 않을까?...
         * 3. 사실상 for문으로 O(n)이긴 한데... 흠.. 일단 한번 해보자.
         * 4. 그런데 최소공배수를 어떻게 구하더라?...
         * 5. 이것도 재귀함수로 배울수 있을까?..
         */
        int answer = 0;
        int lcd = this.getLCM(arr[0],arr[1]);

        for(int i=1; i< arr.length-1; i++){
            lcd = this.getLCM(lcd,arr[i+1]);
        }
        answer = lcd;

        return answer;
    }

    /**
     * 최소공배수를 구하자!
     * @param num1
     * @param num2
     * @return
     */
    public int getLCM(int num1, int num2){
        int lcd = 0;
        int max = Math.max(num1,num2);
        int min = Math.min(num1,num2);
        if(max%min==0){
            return max;
        }
        lcd = num1*num2/this.getGCD(num1,num2);
        return lcd;
    }

    public int getGCD(int num1, int num2){
        while(num2!=0){
            int r = num1%num2;
            num1= num2;
            num2= r;
        }
        return num1;
    }

}
