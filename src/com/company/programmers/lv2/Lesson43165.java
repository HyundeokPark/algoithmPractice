package com.company.programmers.lv2;

/**
 * numbers	target	return
 * [1, 1, 1, 1, 1]	3	5
 * [4, 1, 2, 1]	4	2
 * 입출력 예 설명
 */
public class Lesson43165 {
   static int count = 0;
    public static void main(String[] args) {
        Lesson43165 lessson = new Lesson43165();
        int[] numbers = {4,1,2,1};
        int target = 2;
        System.out.println(lessson.solution(numbers,target));
    }


    public int solution(int[] numbers, int target) {
        int answer = 0;
        this.dfs(0,numbers,target,0);
        answer=count;
        return answer;
    }

    public void dfs(int index, int[] numbers, int target, int sum){
        //배열의 끝까지 돌았다면 누적 합계를 확인한다.
        if(index == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        //더하는 경우, 빼는 경우 모두를 확인해야 한다,(완전탐색)
        dfs(index+1, numbers,target,sum+numbers[index]); //더하는 경우
        dfs(index+1, numbers,target,sum-numbers[index]); //빼는 경우

    }
}
