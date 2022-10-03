package com.company.programmers.lv1;

public class Lesson76501 {

    public static void main(String[] args) {
//        solution()
    }
    /**
     *
     * @param absolutes  [4,7,12] [1,2,3]
     * @param signs [true,false,true] [false,false,true]
     * @return 9 0
     */
    public int solution(int[] absolutes, boolean[] signs) {

        /**
         * 20220902
         * 1. for문을 돌면서 signs[i]의 true/false 여부에 따라 answer에 + 혹은 -
         */

        int answer = 0;
        int length = absolutes.length;

        for(int i=0; i<length; i++){
            if(signs[i]){
                answer+=absolutes[i];
            }else{
                answer-=absolutes[i];
            }
        }

        return answer;
    }
}
