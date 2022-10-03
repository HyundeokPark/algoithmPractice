package com.company.codingtest.three;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Q4 {

    public static void main(String[] args) {
        Q4 q = new Q4();
        String [] students = {"AAALLLAPAA", "AAAAAAAPPP", "ALAAAAPAAA"};
        q.solution(students);
    }

    public int[] solution(String[] students){
        /**
         * 1. 기본 점수 10점
         * 2. 출석 시 +1 (A)
         * 3. 결석 시 -1 3번 -> fail (P) 지각 2번이면 P 니까 p = ll 로 볼수있다.
         *  3-1. 즉 l이 6여도 fail!
         * 4. 지각 시 +0 2번 -> 결석 처리 (L)
         * 5. 출석 점수 계산전 결석 체크
         * 6. 지각 체크
         * 7. 마지막 점수 체크!
         * 8. 이후 점수 순으로 학생들의 인덱스를 출력한다.
         */
        int[] answer = new int[students.length];
        Map<Integer,Integer> indexPoint = new HashMap<>();
        int dafaultPoint = 10;
        for(int i=0; i<students.length; i++){
            // P를 LL로 치환!
            students[i] = students[i].replaceAll("P","LL");
            if(students[i].length()-students[i].replaceAll("L","").length()>=6){
                // 점수 0원!
                indexPoint.put(i+1,0);
                answer[i] = 0;
            } else{
                int addPoint = students[i].length()-students[i].replaceAll("A","").length();
                int subPoint = students[i].length()-students[i].replaceAll("L","").length();
                int tmpPoint = 0;
                tmpPoint = dafaultPoint + addPoint - (subPoint/2);
                tmpPoint = tmpPoint<0 ? 0 : tmpPoint;
//                answer[i] =dafaultPoint;
                indexPoint.put(i+1,tmpPoint);
//                answer[i] = de;
            }
        }
        List<Integer> tmpList = new ArrayList<>();
        indexPoint.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach( e->{
            tmpList.add(e.getKey()-1);
//            answer[e.getKey()-1] = ;
        });
        for(int i=0; i< tmpList.size(); i++){
            answer[i] = tmpList.get(i);
        }
        return answer;
    }

}
