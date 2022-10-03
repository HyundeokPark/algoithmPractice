package com.company.programmers.lv1;

import java.util.Arrays;

public class Lesson86491 {
    /**
     * 최소 직사각형
     * 명함들의 가로세로 크기가 주어지고(직사각형), 모든 명함을 포함하는 최소 직사각형 크기를 구한다.
     * 명함은 회전이가능하다. = 명함의 가로세로 길이가 변경이 된다.
     */

    public static void main(String[] args) {

        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int[][] sizes2 ={ {10, 7},{12, 3},{8, 15},{14, 7},{5, 15}};
        int[][] sizes3 ={ {14, 4},{19, 6},{6, 16},{18, 7},{7, 11}};

        System.out.println(solution(sizes));
        System.out.println(solution(sizes2));
        System.out.println(solution(sizes3));

    }
    public static int solution(int[][] sizes) {
        /**

         * 20220901
         * 1. 먼저 sizes 배열로부터 가로/세로를 따로 분리한 배열을 구한다.
         * 2. 그 배열로 부터 가로세로의 최댓값들을 구한다.
         * 3. 최댓값 가로(w),세로(h) 중 더 큰 값을 구한다.
         * 4. 더 큰값의 배열을 기준으로 for문을 돌면서 w,h중 더 큰값을 기준 배열로 옮긴다.
         * 5. 바뀐 배열들의 최댓값을 구하고, 크기를 구해서 반환한다.
         */
        int answer = 0;
        int maxWidth = 0; //최대 폭 (가로)
        int maxHeigth = 0;//최대 높이 (세로)

        int[] maxArr;
        int[] minArr;
        int[] widths = new int[sizes.length]; //폭(가로) 배열
        int[] heights= new int[sizes.length];//높이(세로) 배열

        //1. 먼저 sizes 배열로부터 가로/세로를 따로 분리한 배열을 구한다.
        for(int i=0; i<sizes.length; i++){
            widths[i] = sizes[i][0];
            heights[i] = sizes[i][1];
            //2. 그 배열로 부터 가로세로의 최댓값들을 구한다.
            if(maxWidth<widths[i]){
                maxWidth = widths[i];
            }
            if(maxHeigth<heights[i]){
                maxHeigth=heights[i];
            }
        }

        //3. 최댓값 가로(w),세로(h) 중 더 큰 값을 구한다.
        maxArr = maxHeigth > maxWidth ? heights : widths;
        minArr = maxHeigth > maxWidth ? widths : heights;

        //4. 더 큰값의 배열을 기준으로 for문을 돌면서 w,h중 더 큰값을 기준 배열로 옮긴다.
        for(int i=0; i<sizes.length; i++){
            int currentHeight = heights[i];
            int currentWidth = widths[i];

            maxArr[i] = Math.max(currentHeight,currentWidth);
            minArr[i] = Math.min(currentHeight,currentWidth);
        }
        //5. 바뀐 배열들의 최댓값을 구하고, 크기를 구해서 반환한다.
        answer = Arrays.stream(maxArr).max().getAsInt() *  Arrays.stream(minArr).max().getAsInt();

        return answer;
    }
}

