package com.company.programmers.lv2;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Lesson12981 {

    public static void main(String[] args) {
        Lesson12981 lesson = new Lesson12981();
        int n = 2;
//        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        lesson.solution(n,words);
    }

    public int[] solution(int n, String[] words) {
        /**
         * 1. 끝말잇기에 중복은 허용되지 않는다.
         * 2. 가장먼저 빨리 탈락한 사람의 번호와, 몇번째 차례에 탈락했는지 출력
         * 3. 중복은 Map구조로 확인해보자! 즉, words가 key값이 된다!...
         * 4. 자신의 몇번째에 탈락했는지 알수있는 방법은?.. 나누기,나머지 계산으로 해결할 수 있을것 같다!..
         * 5. 우선 중복글자가 몇번째에 나왔는지는 words의 인덱스로 알수있다.
         * 6. 또한 참여자수는 n명이므로, words인덱스 / n 을하면 몇바퀴째인지 알수있고, 나머지로 몇번째 사람인지 알수있을것이다!
         * 7. 인덱스는 0부터 시작하지만, 사람들의 번호는 1부터 시작한다. 경계값에 주의하자
         * 8. 끝자리가 시작자리가 아니면 또 안된다!.. 이 규칙을 빼먹었다 ㅠ
         */
        int[] answer = {0,0};
        Map<String,Integer> wordsMap = new HashMap<>();
        String lastWord = words[0].substring(0,1);
        for(int i=0; i<words.length; i++){

            if(wordsMap.get(words[i])==null){
                if(words[i].startsWith(lastWord)){
                    wordsMap.put(words[i],0);
                    lastWord = words[i].substring(words[i].length()-1);
                }else{
                    answer[0] = (i+1)%n == 0 ? n : (i+1)%n;//탈락한 사람
                    answer[1] = answer[0] ==n ? ((i+1)/n) : ((i+1)/n)+1; //몇회차에 떨어졌나?
                    return answer;
                }
            }else{
                answer[0] = (i+1)%n == 0 ? n : (i+1)%n;//탈락한 사람
                answer[1] = answer[0] ==n ? ((i+1)/n) : ((i+1)/n)+1; //몇회차에 떨어졌나?
                return answer;
            }
        }

        return answer;


    }



}
