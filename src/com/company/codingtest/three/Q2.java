package com.company.codingtest.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Q2 {

    public static void main(String[] args) {
        Q2 q = new Q2();
//        int[][] orders = {{2, 3, 4, 0, 1}, {1, 4, 3, 2, 0}, {4, 1, 0, 2, 3}, {3, 2, 1, 4, 0},
//            {0, 3, 2, 1, 4}};
        int[][] orders = {{2, 1, 0, 3},{3, 2, 0, 1},{3, 0, 2, 1},{2, 3, 0, 1}};
        q.solution(orders);
    }

    public int[] solution(int[][] orders) {
        /**
         * 1.후보들 리스트나 배열을 선언한다.
         * 2. 과반수를 정한다. 홀수 짝수일 때 다르다.
         * 3. 각 orders의 0번째가 1순위 후보다.
         * 4. 1순위 후보가 없으면 다음 배열의 후보에 투표한다.
         * 5. 투표 결과 과반수 이상 득표시 종료한다.
         * 6. 과반수가 동일하면 출석번호가 큰 사람이 당선
         * 7. 아무도 당선이 안되면 제일 득표수가 작은 사람을 후보군에서 제외 시킨다.
         * 8. 탈락자들이 다수면 출석번호가 제일 작은 사람을 탈락 시킨다.
         * 9 당선이 될때까지 진행한다.
         * 10. 당선이 될떄까지 진행된 투표의 횟수와, 당선된 사람의 출석번호를 반환한다.
         */
        int[] answer = {0,0};
        int validCandidateCount = orders[0].length;
        int halfCount = 0;
        if(orders[0].length % 2 == 0){
            halfCount = orders[0].length / 2;
        }else{
            halfCount = (orders[0].length / 2) +1;
        }

//            ? orders[0].length / 2 //짝수
//            : (orders[0].length / 2) + 1; //홀수
        int voteCount = 0;
        Map<Integer, Integer> candidate = new HashMap<>();
        for (int student : orders[0]) {
            candidate.put(student, 0);
        }
        while (validCandidateCount > 1) {
            voteCount++;
            //각 학생들의 최우선 후보에 투표한다.
            //후보들이 없을때 함수가 필요함!
            List<Integer> tmpCandidate = new ArrayList<>();
            for (int[] student : orders) {
                int favoriteCandidate = 0;
                //후보군에서 조사!
                for (int i = 0; i < student.length; i++) {
                    if (candidate.get(student[i]) != -1) {
                        favoriteCandidate = i;
                        break;
                    }
                }
                candidate.put(student[favoriteCandidate], candidate.get(student[favoriteCandidate]) + 1);
                //과반수 넘으면 중단
                if (candidate.get(student[favoriteCandidate]) == halfCount) {
                    tmpCandidate.add(student[favoriteCandidate]);
                }
                //과반수 넘으면 중단
                if (candidate.get(student[favoriteCandidate]) > halfCount) {

                    answer[0] = voteCount;
                    answer[1] = student[favoriteCandidate];
                    return answer;
                }
            }
            //과반수 득표가 2명 이상이면!
            if (tmpCandidate.size() > 1) {
                answer[0] = voteCount;
                answer[1] = tmpCandidate.stream().max(Integer::compareTo).get();
                return answer;
            }
            if(tmpCandidate.size() == 1){
                answer[0] = voteCount;
                answer[1] = tmpCandidate.get(0);
                return answer;
            }
            //작은 사람을 탈락 어차피 제일 작은 애를 줄듯??
            Entry<Integer, Integer> failure = candidate.entrySet().stream().filter((e) -> e.getValue()>0)
                .min(Entry.comparingByValue()).get();

//            Set<Integer,Integer> test = candidate.entrySet();
//            candidate.remove(failure.getKey());
            int minValue = Integer.MAX_VALUE;
            for (int key : candidate.keySet()) {
                if (minValue > candidate.get(key) && candidate.get(key) != -1) {
                    minValue = candidate.get(key);
                }
            }

            for (int key : candidate.keySet()) {
                if (minValue == candidate.get(key)) {
                    candidate.put(key,-1);
                    break;
                }
            }
//            candidate.put(failure.getKey(), -1);
            validCandidateCount--;
            //득표수 초기화
//            candidate = candidate.entrySet().stream().filter((e) -> e.getValue()>0).
             for(int e : candidate.keySet()){
                 if(candidate.get(e) != -1){
                     candidate.put(e,0);
                 }
             }
//            candidate.clear();
        }
        answer[0] = voteCount;
        int number = 0;//Collections.max(candidate.keySet());
        Entry<Integer,Integer> e = candidate.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();
        number = e.getKey();
        answer[1] = number;
        return answer;
    }
}

